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

package org.openqa.grid.internal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.grid.common.SeleniumProtocol;
import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class TestSessionTest {

  @Test
  public void testIsOrphanedSe1() throws Exception {

    GridRegistry registry = DefaultGridRegistry.newInstance(new Hub(new GridHubConfiguration()));
    try {
      Map<String, Object> ff = new HashMap<>();
      ff.put(CapabilityType.APPLICATION_NAME, "FF");
      RemoteProxy p1 =
          RemoteProxyFactory.getNewBasicRemoteProxy(ff, "http://machine1:4444", registry);
      registry.add(p1);

      final HashMap<String, Object> capabilities = new HashMap<>();
      TestSlot testSlot = new TestSlot(p1, SeleniumProtocol.Selenium, "", capabilities);
      final TestClock timeSource = new TestClock();
      TestSession testSession = new TestSession(testSlot, capabilities, timeSource);
      testSession.setExternalKey(new ExternalSessionKey("testKey"));
      assertFalse(testSession.isOrphaned());
      timeSource.ensureElapsed(TestSession.MAX_IDLE_TIME_BEFORE_CONSIDERED_ORPHANED);
      assertTrue(testSession.isOrphaned());

    } finally {
      registry.stop();
    }
  }

  @Test
  public void testIsOrphanedWebDriver() throws Exception {

    GridRegistry registry = DefaultGridRegistry.newInstance(new Hub(new GridHubConfiguration()));
    try {
      Map<String, Object> ff = new HashMap<>();
      ff.put(CapabilityType.APPLICATION_NAME, "FF");
      RemoteProxy p1 =
          RemoteProxyFactory.getNewBasicRemoteProxy(ff, "http://machine1:4444", registry);
      registry.add(p1);

      final HashMap<String, Object> capabilities = new HashMap<>();
      TestSlot testSlot = new TestSlot(p1, SeleniumProtocol.WebDriver, "", capabilities
      );
      final TestClock timeSource = new TestClock();
      TestSession testSession = new TestSession(testSlot, capabilities, timeSource);
      testSession.setExternalKey(new ExternalSessionKey("testKey"));
      assertFalse(testSession.isOrphaned());
      timeSource.ensureElapsed(TestSession.MAX_IDLE_TIME_BEFORE_CONSIDERED_ORPHANED);
      assertFalse(testSession.isOrphaned());

    } finally {
      registry.stop();
    }
  }


  public static class TestClock extends Clock {

    private long time = 17;

    public void ensureElapsed(long requiredElapsed) {
      time += (requiredElapsed + 1);
    }

    @Override
    public Instant instant() {
      return Instant.ofEpochMilli(time);
    }

    @Override
    public ZoneId getZone() {
      return ZoneId.systemDefault();
    }

    @Override
    public Clock withZone(ZoneId zone) {
      return this;
    }
  }
}
