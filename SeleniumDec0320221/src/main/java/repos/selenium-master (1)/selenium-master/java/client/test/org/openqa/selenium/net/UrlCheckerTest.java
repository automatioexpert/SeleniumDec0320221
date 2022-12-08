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
package org.openqa.selenium.net;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.net.PortProber.findFreePort;

import org.junit.After;
import org.junit.Test;
import org.seleniumhq.jetty9.server.Request;
import org.seleniumhq.jetty9.server.Server;
import org.seleniumhq.jetty9.server.handler.AbstractHandler;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlCheckerTest {

  private final UrlChecker urlChecker = new UrlChecker();
  int port = findFreePort();
  Server server = buildServer();

  private Server buildServer() {
    Server server = new Server(port);
    server.setHandler(new AbstractHandler() {
      @Override
      public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse)
        throws IOException {
        httpServletResponse.setStatus(200);
        httpServletResponse.getWriter().println("<h1>Working</h1>");
        request.setHandled(true);
      }
    });
    return server;
  }

  ExecutorService executorService = Executors.newSingleThreadExecutor();

  @Test
  public void testWaitUntilAvailableIsTimely() throws Exception {
    long delay = 200L;

    executorService.submit(() -> {
      Thread.sleep(delay);
      server.start();
      return null;
    });

    long start = currentTimeMillis();
    urlChecker.waitUntilAvailable(10, TimeUnit.SECONDS, new URL("http://localhost:" + port + "/"));
    long elapsed = currentTimeMillis() - start;
    assertThat(elapsed, lessThan(UrlChecker.CONNECT_TIMEOUT_MS + 100L)); // threshold
  }

  @Test
  public void testWaitUntilUnavailableIsTimely() throws Exception {
    long delay = 200L;
    server.start();
    urlChecker.waitUntilAvailable(10, TimeUnit.SECONDS, new URL("http://localhost:" + port + "/"));

    executorService.submit(() -> {
      Thread.sleep(delay);
      server.stop();
      return null;
    });

    long start = currentTimeMillis();
    urlChecker.waitUntilUnavailable(10, TimeUnit.SECONDS, new URL("http://localhost:" + port + "/"));
    long elapsed = currentTimeMillis() - start;
    assertThat(elapsed, lessThan(UrlChecker.CONNECT_TIMEOUT_MS + delay + 200L)); // threshold
    System.out.println(elapsed);
  }

  @After
  public void cleanup() throws Exception {
    server.stop();
    server.join();
    executorService.shutdown();
  }
}
