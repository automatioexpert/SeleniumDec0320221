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

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.grid.web.servlet.console.ConsoleServlet;
import org.openqa.testing.FakeHttpServletResponse;
import org.seleniumhq.jetty9.server.handler.ContextHandler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class DisplayHelpServletTest extends BaseServletTest {

  @Before
  public void setUp() throws ServletException {
    servlet = new DisplayHelpServlet() {
      @Override
      public ServletContext getServletContext() {
        final ContextHandler.Context servletContext = new ContextHandler().getServletContext();
        servletContext.setInitParameter(DisplayHelpServlet.HELPER_TYPE_PARAMETER, "standalone");
        servletContext.setInitParameter(ConsoleServlet.CONSOLE_PATH_PARAMETER, "/wd/hub");
        return servletContext;
      }
    };
    servlet.init();
  }

  @Test
  public void testGetHelpPageForStandalone() throws IOException, ServletException {
    assertEquals(servlet.getInitParameter(DisplayHelpServlet.HELPER_TYPE_PARAMETER), "standalone");
    assertEquals(servlet.getInitParameter(ConsoleServlet.CONSOLE_PATH_PARAMETER), "/wd/hub");

    FakeHttpServletResponse response = sendCommand("GET", "/");
    assertEquals(HttpServletResponse.SC_OK, response.getStatus());

    String body = response.getBody();
    assertNotNull(body);
    assertThat(body, containsString("Whoops! The URL specified routes to this help page."));
    assertThat(body, containsString("\"type\": \"Standalone\""));
    assertThat(body, containsString("\"consoleLink\": \"\\u002fwd\\u002fhub\""));
  }

  @Test
  public void testGetHelpPageAsset() throws IOException, ServletException {
    FakeHttpServletResponse response = sendCommand("GET", "/assets/displayhelpservlet.css");
    assertEquals(HttpServletResponse.SC_OK, response.getStatus());
    assertNotNull(response.getBody());
    assertTrue(response.getBody().contains("#help-heading #logo"));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testNoSuchAsset() throws IOException, ServletException {
    // will result in a call to sendError ..
    // FakeHttpServlet will then turn that into an UnsupportedOperationException
    sendCommand("GET", "/assets/foo.bar");
  }

}
