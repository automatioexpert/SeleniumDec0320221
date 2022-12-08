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

package org.openqa.selenium.chrome;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.remote.service.DriverService;

/**
 * {@link DriverCommandExecutor} that understands ChromeDriver specific commands.
 *
 * @see <a href="https://chromium.googlesource.com/chromium/src/+/master/chrome/test/chromedriver/client/command_executor.py">List of ChromeWebdriver commands</a>
 */
class ChromeDriverCommandExecutor extends DriverCommandExecutor {

  private static final ImmutableMap<String, CommandInfo> CHROME_COMMAND_NAME_TO_URL = ImmutableMap.of(
      ChromeDriverCommand.LAUNCH_APP,
      new CommandInfo("/session/:sessionId/chromium/launch_app", HttpMethod.POST),
      ChromeDriverCommand.GET_NETWORK_CONDITIONS,
      new CommandInfo("/session/:sessionId/chromium/network_conditions", HttpMethod.GET),
      ChromeDriverCommand.SET_NETWORK_CONDITIONS,
      new CommandInfo("/session/:sessionId/chromium/network_conditions", HttpMethod.POST),
      ChromeDriverCommand.DELETE_NETWORK_CONDITIONS,
      new CommandInfo("/session/:sessionId/chromium/network_conditions", HttpMethod.DELETE)
  );

  public ChromeDriverCommandExecutor(DriverService service) {
    super(service, CHROME_COMMAND_NAME_TO_URL);
  }
}
