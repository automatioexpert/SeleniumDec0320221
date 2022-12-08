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

package org.openqa.selenium.htmlunit;

import static org.openqa.selenium.remote.CapabilityType.SUPPORTS_JAVASCRIPT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.StandardSeleniumTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    StandardSeleniumTests.class,
})
public class JavascriptEnabledHtmlUnitDriverTests {

  // Used by the reflection-based supplier
  public static class HtmlUnitDriverForTest extends HtmlUnitDriver {
    public HtmlUnitDriverForTest(Capabilities capabilities) {
      super(tweak(capabilities));
    }

    public HtmlUnitDriverForTest(Capabilities desiredCapabilities, Capabilities requiredCapabilities) {
      super(tweak(desiredCapabilities), tweak(requiredCapabilities));
    }

    private static Capabilities tweak(Capabilities capabilities) {
      MutableCapabilities caps = new MutableCapabilities(capabilities);
      caps.setCapability(SUPPORTS_JAVASCRIPT, true);
      return caps;
    }
  }
}
