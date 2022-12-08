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

package org.openqa.grid.web.servlet;

import static org.openqa.selenium.json.Json.MAP_TYPE;

import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.common.exception.GridConfigurationException;
import org.openqa.grid.internal.BaseRemoteProxy;
import org.openqa.grid.internal.GridRegistry;
import org.openqa.grid.internal.RemoteProxy;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * entry point for the registration API the grid provides. The {@link RegistrationRequest} sent to
 * http://hub:port/grid/register will be used to create a RemoteProxy and add it to the grid.
 */
public class RegistrationServlet extends RegistryBasedServlet {
  private static final long serialVersionUID = -8670670577712086527L;
  private static final Logger log = Logger.getLogger(RegistrationServlet.class.getName());
  private static final Json JSON = new Json();

  public RegistrationServlet() {
    this(null);
  }

  public RegistrationServlet(GridRegistry registry) {
    super(registry);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    process(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    process(request, response);
  }

  protected void process(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String requestJsonString;

    try (BufferedReader rd = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
      requestJsonString = CharStreams.toString(rd);
    }
    log.fine("getting the following registration request  : " + requestJsonString);

    // getting the settings from the registration
    Map<String, Object> json = JSON.toType(requestJsonString, MAP_TYPE);

    if (!(json.get("configuration") instanceof Map)) {
      // bad request. there must be a configuration for the proxy
      throw new GridConfigurationException("No configuration received for proxy.");
    }

    final RegistrationRequest registrationRequest;
    if (isV2RegistrationRequestJson(json)) {
      // Se2 compatible request
      @SuppressWarnings("unchecked") GridNodeConfiguration nodeConfiguration =
        mapV2Configuration((Map<String, Object>) json.get("configuration"));
      registrationRequest = new RegistrationRequest(nodeConfiguration);
      // get the "capabilities" and "id" from the v2 json request
      considerV2Json(registrationRequest.getConfiguration(), json);
    } else {
      // Se3 compatible request.
      registrationRequest = RegistrationRequest.fromJson(requestJsonString);
    }

    final RemoteProxy proxy = BaseRemoteProxy.getNewInstance(registrationRequest, getRegistry());

    reply(response, "ok");

    // Thread safety reviewed
    new Thread(() -> {
      getRegistry().add(proxy);
      log.fine("proxy added " + proxy.getRemoteHost());
    }).start();
  }

  /**
   * @deprecated because V3 node configuration data structure is internally different than V2.
   * That said V2 nodes do need to be able to register with a V3 hub.
   */
  @Deprecated
  private GridNodeConfiguration mapV2Configuration(Map<String, Object> json) {
    // servlets should result in a parse error since the type changed from String to
    // List<String> with V3. So, we need to save it off and then parse normally.
    Object servlets = json.get("servlets");
    // V3 beta versions send a V2 RegistrationRequest which specifies servlets as a List<String>
    // When this is the case, we don't need to remove it for parsing.
    if (servlets != null && servlets instanceof String) {
      json.remove("servlets");
    }

    // if a JsonSyntaxException happens here, so be it. We won't be able to map the request
    // to a grid node configuration anyhow.
    // It's entirely possible that there's a less elegant way of doing thing, but I'm not sure what
    // it is.
    // TODO: Don't be this horrible
    GridNodeConfiguration pendingConfiguration =
        GridNodeConfiguration.loadFromJSON(JSON.toJson(json));

    // add the servlets that were saved off
    if (servlets != null && servlets instanceof String &&
        (pendingConfiguration.servlets == null || pendingConfiguration.servlets.isEmpty())) {
      pendingConfiguration.servlets = Lists.newArrayList(servlets.toString().split(","));
    }

    return pendingConfiguration;
  }

  /**
   * @deprecated because V3 does not have separate "capabilities": { } object in the serialized json
   * representation of the RegistrationRequest. That said V2 nodes do need to be able to register
   * with a V3 hub.
   */
  @Deprecated
  private boolean isV2RegistrationRequestJson(Map<String, Object> json) {
    return json.containsKey("capabilities") && json.containsKey("configuration");
  }

  /**
   * @deprecated because V3 does not have separate "capabilities": { } object and "id": "value"
   * in the serialized json representation of the RegistrationRequest. That said V2 nodes do need
   * to be able to register with a V3 hub.
   */
  @Deprecated
  private void considerV2Json(GridNodeConfiguration configuration, Map<String, Object> json) {
    // Backwards compatible with Selenium 2.x remotes which might send a
    // registration request with the json field "id". 3.x remotes will include the "id" with the
    // "configuration" object. The presence of { "id": "value" } should always override
    // { "configuration": { "id": "value" } }
    if (json.get("id") instanceof String) {
      configuration.id = json.get("id").toString();
    }

    // Backwards compatible with Selenium 2.x remotes which send a registration request with the
    // json object "capabilities". 3.x remotes will include the "capabilities" object with the
    // "configuration" object. The presence of { "capabilities": [ {...}, {...} ] } should always
    // override { "configuration": { "capabilities": [ {...}, {...} ] } }
    if (json.get("capabilities") instanceof Collection) {
      configuration.capabilities.clear();
      @SuppressWarnings("unchecked") Collection<Map<String, Object>> capabilities =
          (Collection<Map<String, Object>>) json.get("capabilities");
      capabilities.stream().map(MutableCapabilities::new).forEach(configuration.capabilities::add);
      configuration.fixUpCapabilities();
    }
  }

  protected void reply(HttpServletResponse response, String content) throws IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.setStatus(200);
    response.getWriter().print(content);
  }
}
