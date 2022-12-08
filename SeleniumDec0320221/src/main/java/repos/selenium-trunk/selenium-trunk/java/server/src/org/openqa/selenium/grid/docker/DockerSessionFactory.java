// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.grid.docker;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.docker.Container;
import org.openqa.selenium.docker.Docker;
import org.openqa.selenium.docker.Image;
import org.openqa.selenium.docker.Port;
import org.openqa.selenium.grid.data.CreateSessionRequest;
import org.openqa.selenium.grid.node.ActiveSession;
import org.openqa.selenium.grid.node.SessionFactory;
import org.openqa.selenium.internal.Require;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.Dialect;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.ProtocolHandshake;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.tracing.AttributeKey;
import org.openqa.selenium.remote.tracing.EventAttribute;
import org.openqa.selenium.remote.tracing.EventAttributeValue;
import org.openqa.selenium.remote.tracing.Span;
import org.openqa.selenium.remote.tracing.Status;
import org.openqa.selenium.remote.tracing.Tracer;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.openqa.selenium.docker.ContainerInfo.image;
import static org.openqa.selenium.remote.Dialect.W3C;
import static org.openqa.selenium.remote.http.Contents.string;
import static org.openqa.selenium.remote.http.HttpMethod.GET;
import static org.openqa.selenium.remote.tracing.Tags.EXCEPTION;

public class DockerSessionFactory implements SessionFactory {

  private static final Logger LOG = Logger.getLogger(DockerSessionFactory.class.getName());

  private final Tracer tracer;
  private final HttpClient.Factory clientFactory;
  private final Docker docker;
  private final Image image;
  private final Capabilities stereotype;

  public DockerSessionFactory(
      Tracer tracer,
      HttpClient.Factory clientFactory,
      Docker docker,
      Image image,
      Capabilities stereotype) {
    this.tracer = Require.nonNull("Tracer", tracer);
    this.clientFactory = Require.nonNull("HTTP client", clientFactory);
    this.docker = Require.nonNull("Docker command", docker);
    this.image = Require.nonNull("Docker image", image);
    this.stereotype = ImmutableCapabilities.copyOf(
        Require.nonNull("Stereotype", stereotype));
  }

  @Override
  public boolean test(Capabilities capabilities) {
    return stereotype.getCapabilityNames().stream()
        .map(name -> Objects.equals(stereotype.getCapability(name), capabilities.getCapability(name)))
        .reduce(Boolean::logicalAnd)
        .orElse(false);
  }

  @Override
  public Optional<ActiveSession> apply(CreateSessionRequest sessionRequest) {
    LOG.info("Starting session for " + sessionRequest.getCapabilities());
    int port = PortProber.findFreePort();
    URL remoteAddress = getUrl(port);
    HttpClient client = clientFactory.createClient(remoteAddress);

    try (Span span = tracer.getCurrentContext().createSpan("docker_session_factory.apply")) {
      Map<String, EventAttributeValue> attributeMap = new HashMap<>();
      attributeMap.put(AttributeKey.LOGGER_CLASS.getKey(),
                       EventAttribute.setValue(this.getClass().getName()));
      LOG.info("Creating container, mapping container port 4444 to " + port);
      Container container = docker.create(image(image).map(Port.tcp(4444), Port.tcp(port)));
      container.start();

      attributeMap.put("docker.image", EventAttribute.setValue(image.toString()));
      attributeMap.put("container.port", EventAttribute.setValue(port));
      attributeMap.put("container.id", EventAttribute.setValue(container.getId().toString()));
      attributeMap.put("docker.server.url", EventAttribute.setValue(remoteAddress.toString()));

      LOG.info(String.format("Waiting for server to start (container id: %s)", container.getId()));
      try {
        waitForServerToStart(client, Duration.ofMinutes(1));
        span.addEvent("Container started. Docker server ready.", attributeMap);
      } catch (TimeoutException e) {
        span.setAttribute("error", true);
        span.setStatus(Status.CANCELLED);

        EXCEPTION.accept(attributeMap, e);
        attributeMap.put(AttributeKey.EXCEPTION_MESSAGE.getKey(),
                         EventAttribute.setValue("Unable to connect to docker server. Stopping container: " + e.getMessage()));
        span.addEvent(AttributeKey.EXCEPTION_EVENT.getKey(), attributeMap);

        container.stop(Duration.ofMinutes(1));
        container.delete();
        LOG.warning(String.format(
            "Unable to connect to docker server (container id: %s)", container.getId()));
        return Optional.empty();
      }
      LOG.info(String.format("Server is ready (container id: %s)", container.getId()));

      Command command = new Command(
          null,
          DriverCommand.NEW_SESSION(sessionRequest.getCapabilities()));
      ProtocolHandshake.Result result;
      Response response;
      try {
        result = new ProtocolHandshake().createSession(client, command);
        response = result.createResponse();
        attributeMap.put(AttributeKey.DRIVER_RESPONSE.getKey(), EventAttribute.setValue(response.toString()));
      } catch (IOException | RuntimeException e) {
        span.setAttribute("error", true);
        span.setStatus(Status.CANCELLED);

        EXCEPTION.accept(attributeMap, e);
        attributeMap.put(AttributeKey.EXCEPTION_MESSAGE.getKey(),
                         EventAttribute.setValue("Unable to create session. Stopping and  container: " + e.getMessage()));
        span.addEvent(AttributeKey.EXCEPTION_EVENT.getKey(), attributeMap);

        container.stop(Duration.ofMinutes(1));
        container.delete();
        LOG.log(Level.WARNING, "Unable to create session: " + e.getMessage(), e);
        return Optional.empty();
      }

      SessionId id = new SessionId(response.getSessionId());
      Capabilities capabilities = new ImmutableCapabilities((Map<?, ?>) response.getValue());

      Dialect downstream = sessionRequest.getDownstreamDialects().contains(result.getDialect()) ?
                           result.getDialect() :
                           W3C;
      attributeMap.put(AttributeKey.DOWNSTREAM_DIALECT.getKey(), EventAttribute.setValue(downstream.toString()));
      attributeMap.put(AttributeKey.DRIVER_RESPONSE.getKey(), EventAttribute.setValue(response.toString()));

      span.addEvent("Docker driver service created session", attributeMap);
      LOG.info(String.format(
          "Created session: %s - %s (container id: %s)",
          id,
          capabilities,
          container.getId()));
      return Optional.of(new DockerSession(
          container,
          tracer,
          client,
          id,
          remoteAddress,
          capabilities,
          downstream,
          result.getDialect()));
    }
  }

  private void waitForServerToStart(HttpClient client, Duration duration) {
    Wait<Object> wait = new FluentWait<>(new Object())
        .withTimeout(duration)
        .ignoring(UncheckedIOException.class);

    wait.until(obj -> {
      HttpResponse response = client.execute(new HttpRequest(GET, "/status"));
      LOG.fine(string(response));
      return 200 == response.getStatus();
    });
  }

  private URL getUrl(int port) {
    try {
      return new URL(String.format("http://localhost:%s/wd/hub", port));
    } catch (MalformedURLException e) {
      throw new SessionNotCreatedException(e.getMessage(), e);
    }
  }
}