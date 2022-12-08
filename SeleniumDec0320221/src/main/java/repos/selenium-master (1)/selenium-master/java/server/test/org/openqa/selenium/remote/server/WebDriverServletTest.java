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

package org.openqa.selenium.remote.server;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.openqa.selenium.remote.server.WebDriverServlet.ACTIVE_SESSIONS_KEY;
import static org.openqa.selenium.remote.server.WebDriverServlet.NEW_SESSION_PIPELINE_KEY;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.ErrorCodes;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.testing.FakeHttpServletRequest;
import org.openqa.testing.FakeHttpServletResponse;
import org.openqa.testing.UrlInfo;
import org.seleniumhq.jetty9.server.handler.ContextHandler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

@RunWith(JUnit4.class)
public class WebDriverServletTest {

  private static final String BASE_URL = "http://localhost:4444";
  private static final String CONTEXT_PATH = "/wd/hub";

  private ActiveSessions testSessions;
  private WebDriverServlet driverServlet;
  private WebDriver driver;

  @Before
  public void setUp() {
    testSessions = new ActiveSessions(1, MINUTES);
    driver = Mockito.mock(WebDriver.class);

    InMemorySession.Factory factory = new InMemorySession.Factory(
        new DriverProvider() {
          @Override
          public Capabilities getProvidedCapabilities() {
            return new ImmutableCapabilities();
          }

          @Override
          public boolean canCreateDriverInstanceFor(Capabilities capabilities) {
            return true;
          }

          @Override
          public WebDriver newInstance(Capabilities capabilities) {
            return driver;
          }
        });

    NewSessionPipeline pipeline = NewSessionPipeline.builder()
        .add(factory)
        .create();

    ContextHandler.Context context = new ContextHandler().getServletContext();
    context.setAttribute(ACTIVE_SESSIONS_KEY, testSessions);
    context.setAttribute(NEW_SESSION_PIPELINE_KEY, pipeline);
    context.setInitParameter("webdriver.server.session.timeout", "18");
    context.setInitParameter("webdriver.server.browser.timeout", "2");

    // Override log methods for testing.
    driverServlet = new WebDriverServlet() {
      @Override
      public void log(String msg) {
      }

      @Override
      public void log(String message, Throwable t) {
      }

      @Override
      public ServletContext getServletContext() {
        return context;
      }

      @Override
      public String getInitParameter(String name) {
        return context.getInitParameter(name);
      }
    };
    driverServlet.init();
  }

  @Test
  public void navigateToUrlCommandHandler() throws IOException, ServletException {
    final SessionId sessionId = createSession();

    WebDriver driver = testSessions.get(sessionId).getWrappedDriver();

    JsonObject json = new JsonObject();
    json.addProperty("url", "http://www.google.com");
    FakeHttpServletResponse response = sendCommand("POST",
        String.format("/session/%s/url", sessionId), json);

    assertEquals(HttpServletResponse.SC_OK, response.getStatus());

    verify(driver).get("http://www.google.com");
  }

  @Test
  public void reportsBadRequestForMalformedCrossDomainRpcs()
      throws IOException, ServletException {
    FakeHttpServletResponse response = sendCommand("POST", "/xdrpc", new JsonObject());

    assertEquals(HttpServletResponse.SC_BAD_REQUEST, response.getStatus());
    assertEquals("Missing required parameter: method\r\n", response.getBody());
  }

  @Test
  public void handlesWellFormedAndSuccessfulCrossDomainRpcs()
      throws IOException, ServletException {
    final SessionId sessionId = createSession();

    WebDriver driver = testSessions.get(sessionId).getWrappedDriver();

    JsonObject json = new JsonObject();
    json.addProperty("method", "POST");
    json.addProperty("path", String.format("/session/%s/url", sessionId));
    JsonObject data = new JsonObject();
    data.addProperty("url", "http://www.google.com");
    json.add("data", data);
    FakeHttpServletResponse response = sendCommand("POST", "/xdrpc", json);

    verify(driver).get("http://www.google.com");
    assertEquals(HttpServletResponse.SC_OK, response.getStatus());
    assertEquals("application/json; charset=utf-8",
        response.getHeader("content-type"));

    JsonObject jsonResponse = new JsonParser().parse(response.getBody()).getAsJsonObject();
    assertEquals(ErrorCodes.SUCCESS, jsonResponse.get("status").getAsInt());
    assertEquals(sessionId.toString(), jsonResponse.get("sessionId").getAsString());
    assertTrue(jsonResponse.get("value").isJsonNull());
  }

  @Test
  public void doesNotRedirectForNewSessionsRequestedViaCrossDomainRpc()
      throws IOException, ServletException {
    JsonObject json = new JsonObject();
    json.addProperty("method", "POST");
    json.addProperty("path", "/session");
    JsonObject caps = new JsonObject();
    caps.addProperty(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
    caps.addProperty(CapabilityType.VERSION, true);
    JsonObject data = new JsonObject();
    data.add("desiredCapabilities", caps);
    json.add("data", data);
    FakeHttpServletResponse response = sendCommand("POST", "/xdrpc", json);

    assertEquals(HttpServletResponse.SC_OK, response.getStatus());
    assertEquals("application/json; charset=utf-8",
        response.getHeader("content-type"));

    JsonObject jsonResponse = new JsonParser().parse(response.getBody()).getAsJsonObject();
    assertEquals(ErrorCodes.SUCCESS, jsonResponse.get("status").getAsInt());
    assertFalse(jsonResponse.get("sessionId").isJsonNull());

    JsonObject value = jsonResponse.get("value").getAsJsonObject();
    // values: browsername, version, remote session id.
    assertEquals(value.toString(), 3, value.entrySet().size());
    assertEquals(BrowserType.FIREFOX, value.get(CapabilityType.BROWSER_NAME).getAsString());
    assertTrue(value.get(CapabilityType.VERSION).getAsBoolean());
  }

  @Test
  public void handlesInvalidCommandsToRootOfDriverService()
      throws IOException, ServletException {
    // Command path will be null in servlet API when request is to the context root (e.g. /wd/hub).
    FakeHttpServletResponse response = sendCommand("POST", null, new JsonObject());

    // An Unknown Command has an HTTP status code of 404. Fact.
    assertEquals(404, response.getStatus());

    JsonObject jsonResponse = new JsonParser().parse(response.getBody()).getAsJsonObject();
    assertEquals(ErrorCodes.UNKNOWN_COMMAND, jsonResponse.get("status").getAsInt());

    JsonObject value = jsonResponse.get("value").getAsJsonObject();
    assertNotNull(value.get("message").getAsString());
  }

  private SessionId createSession() throws IOException, ServletException {
    JsonObject caps = new JsonObject();
    caps.add("desiredCapabilities", new JsonObject());
    FakeHttpServletResponse response = sendCommand("POST", "/session", caps);

    assertEquals(HttpServletResponse.SC_OK, response.getStatus());

    Response resp = new Json().toType(response.getBody(), Response.class);

    String sessionId = resp.getSessionId();
    assertNotNull(sessionId);
    assertFalse(sessionId.isEmpty());
    return new SessionId(sessionId);
  }

  private FakeHttpServletResponse sendCommand(String method, String commandPath,
      JsonObject parameters) throws IOException, ServletException {
    FakeHttpServletRequest request = new FakeHttpServletRequest(method, createUrl(commandPath));
    if (parameters != null) {
      request.setBody(parameters.toString());
    }

    FakeHttpServletResponse response = new FakeHttpServletResponse();

    driverServlet.service(request, response);
    return response;
  }

  private static UrlInfo createUrl(String path) {
    return new UrlInfo(BASE_URL, CONTEXT_PATH, path);
  }

//  @Test
//  public void timeouts() throws IOException, ServletException {
//    assertEquals(2000, driverServlet.getIndividualCommandTimeoutMs());
//    assertEquals(18000, driverServlet.getInactiveSessionTimeout());
//  }

}
