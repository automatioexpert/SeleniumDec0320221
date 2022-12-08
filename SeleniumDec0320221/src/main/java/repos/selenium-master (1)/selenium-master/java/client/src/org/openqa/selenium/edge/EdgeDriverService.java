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
package org.openqa.selenium.edge;

import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
* Manages the life and death of a MicrosoftWebDriver server.
*
*/
public class EdgeDriverService extends DriverService{

  /**
  * System property that defines the location of the MicrosoftWebDriver executable that will be used by
  * the {@link #createDefaultService() default service}.
  */
  public static final String EDGE_DRIVER_EXE_PROPERTY = "webdriver.edge.driver";

  /**
  * System property that defines the default location where MicrosoftWebDriver output is logged.
  */
  public static final String EDGE_DRIVER_LOG_PROPERTY = "webdriver.edge.logfile";

  /**
  * Boolean system property that defines whether the MicrosoftWebDriver executable should be started
  * with verbose logging.
  */
  public static final String EDGE_DRIVER_VERBOSE_LOG_PROPERTY = "webdriver.edge.verboseLogging";

  public EdgeDriverService(File executable, int port, ImmutableList<String> args,
      ImmutableMap<String, String> environment) throws IOException {
      super(executable, port, args, environment);
  }

  /**
  * Configures and returns a new {@link EdgeDriverService} using the default configuration. In
  * this configuration, the service will use the MicrosoftWebDriver executable identified by the
  * {@link #EDGE_DRIVER_EXE_PROPERTY} system property. Each service created by this method will
  * be configured to use a free port on the current system.
  *
  * @return A new EdgeDriverService using the default configuration.
  */
  public static EdgeDriverService createDefaultService() {
    return new Builder().build();
  }

  @AutoService(DriverService.Builder.class)
  public static class Builder extends DriverService.Builder<
     EdgeDriverService, EdgeDriverService.Builder> {

    @Override
    public int score(Capabilities capabilites) {
      int score = 0;

      if (BrowserType.EDGE.equals(capabilites.getBrowserName())) {
        score++;
      }

      return score;
    }

    @Override
    protected File findDefaultExecutable() {
      return findExecutable("MicrosoftWebDriver", EDGE_DRIVER_EXE_PROPERTY,
          "https://github.com/SeleniumHQ/selenium/wiki/MicrosoftWebDriver",
          "http://go.microsoft.com/fwlink/?LinkId=619687");
    }

    @Override
    protected ImmutableList<String> createArgs() {
      ImmutableList.Builder<String> argsBuilder = ImmutableList.builder();
      argsBuilder.add(String.format("--port=%d", getPort()));

      if (Boolean.getBoolean(EDGE_DRIVER_VERBOSE_LOG_PROPERTY)) {
        argsBuilder.add("--verbose");
      }

      return argsBuilder.build();
    }

    @Override
    protected EdgeDriverService createDriverService(File exe, int port,
                    ImmutableList<String> args,
                    ImmutableMap<String, String> environment) {
      try {
        EdgeDriverService service = new EdgeDriverService(exe, port, args, environment);

        if (getLogFile() != null) {
          service.sendOutputTo(new FileOutputStream(getLogFile()));
        } else {
          String logFile = System.getProperty(EDGE_DRIVER_LOG_PROPERTY);
          if (logFile != null) {
            service.sendOutputTo(new FileOutputStream(logFile));
          }
        }

        return service;
      } catch (IOException e) {
        throw new WebDriverException(e);
      }
    }
  }
}
