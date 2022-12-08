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

import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Objects;


/**
 * Class to manage options specific to {@link EdgeDriver}.
 *
 * <p>Example usage:
 * <pre><code>
 * EdgeOptions options = new EdgeOptions()
 *
 * // For use with EdgeDriver:
 * EdgeDriver driver = new EdgeDriver(options);
 *
 * // For use with RemoteWebDriver:
 * EdgeOptions options = new EdgeOptions();
 * RemoteWebDriver driver = new RemoteWebDriver(
 *     new URL("http://localhost:4444/wd/hub"), options);
 * </code></pre>
 */
public class EdgeOptions extends MutableCapabilities {

  public EdgeOptions() {
    setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
  }

  @Override
  public EdgeOptions merge(Capabilities extraCapabilities) {
    super.merge(extraCapabilities);
    return this;
  }

  /**
   * Sets the page load strategy for  Edge
   *
   * Supported values are "normal", "eager" and "none"
   *
   * @param strategy strategy for page load: normal, eager or none
   */
  public void setPageLoadStrategy(String strategy) {
    setCapability(PAGE_LOAD_STRATEGY, Objects.requireNonNull(strategy));
  }

  public EdgeOptions setProxy(Proxy proxy) {
    setCapability(CapabilityType.PROXY, proxy);
    return this;
  }
}
