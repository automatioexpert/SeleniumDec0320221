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

package org.openqa.grid.internal.utils.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;
import org.openqa.grid.internal.cli.StandaloneCliOptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandaloneConfigurationTest {

  @Test
  public void testDefaults() {
    StandaloneConfiguration sc = new StandaloneConfiguration();
    assertEquals(StandaloneConfiguration.DEFAULT_ROLE, sc.role);
    assertEquals(StandaloneConfiguration.DEFAULT_BROWSER_TIMEOUT, sc.browserTimeout);
    assertEquals(StandaloneConfiguration.DEFAULT_DEBUG_TOGGLE, sc.debug);
    assertEquals(StandaloneConfiguration.DEFAULT_TIMEOUT, sc.timeout);
    assertEquals(StandaloneConfiguration.DEFAULT_PORT, sc.port);
    assertEquals(null, sc.host);
    assertNull(sc.jettyMaxThreads);
    assertNull(sc.log);
  }

  @Test
  public void testConstructorEqualsDefaultConfig() {
    StandaloneConfiguration actual = new StandaloneConfiguration();
    StandaloneConfiguration expected =
      StandaloneConfiguration.loadFromJson(StandaloneConfiguration.DEFAULT_STANDALONE_CONFIG_FILE, StandaloneConfiguration.class);

    assertEquals(expected.role, actual.role);
    assertEquals(expected.browserTimeout, actual.browserTimeout);
    assertEquals(expected.debug, actual.debug);
    assertEquals(expected.timeout, actual.timeout);
    assertEquals(expected.jettyMaxThreads, actual.jettyMaxThreads);
    assertEquals(expected.log, actual.log);
    assertEquals(expected.port, actual.port);
    assertEquals(null, actual.host);
  }

  @Test
  public void commandLineParsing() {
    String[] args = "-timeout 32123 -browserTimeout 456".split(" ");
    StandaloneConfiguration sc = new StandaloneCliOptions().parse(args).toConfiguration();
    assertEquals(32123, sc.timeout.intValue());
    assertEquals(456, sc.browserTimeout.intValue());
  }

  @Test
  public void testSetTimeout() {
    StandaloneConfiguration sc = new StandaloneConfiguration();
    sc.timeout = 123;
    assertEquals(123, sc.timeout.intValue());
  }

  @Test
  public void testSetBrowserTimeout() {
    StandaloneConfiguration sc = new StandaloneConfiguration();
    sc.browserTimeout = 1233;
    assertEquals(1233, sc.browserTimeout.intValue());
  }

  @Test
  public void testIsMergeAble() {
    StandaloneConfiguration sc = new StandaloneConfiguration();

    // can't merge null onto null
    assertFalse(sc.isMergeAble(String.class,null, null));

    // test with Character
    assertTrue(sc.isMergeAble(Character.class,'a','a'));
    assertTrue(sc.isMergeAble(Character.class, 'a', 'b'));
    assertTrue(sc.isMergeAble(Character.class, 'a', null));
    assertFalse(sc.isMergeAble(Character.class, null, 'b'));

    // test with Integer
    assertTrue(sc.isMergeAble(Integer.class,1, 1));
    assertTrue(sc.isMergeAble(Integer.class,1, 2));
    assertTrue(sc.isMergeAble(Integer.class,1, null));
    assertFalse(sc.isMergeAble(Integer.class,null, 2));

    // test with Boolean
    assertTrue(sc.isMergeAble(Boolean.class, true, true));
    assertTrue(sc.isMergeAble(Boolean.class, true, false));
    assertTrue(sc.isMergeAble(Boolean.class, true, null));
    assertFalse(sc.isMergeAble(Boolean.class, null, false));

    // test with String
    assertTrue(sc.isMergeAble(String.class, "a", "a"));
    assertTrue(sc.isMergeAble(String.class, "a", "b"));
    assertTrue(sc.isMergeAble(String.class, "a", null));
    assertFalse(sc.isMergeAble(String.class, null, "b"));

    // test with Collections
    assertTrue(sc.isMergeAble(List.class,
                              Arrays.asList("a", "b"),
                              Arrays.asList("b", "c")));
    assertTrue(sc.isMergeAble(List.class,
                              Arrays.asList("a", "b"),
                              Arrays.asList("a", "b")));
    assertTrue(sc.isMergeAble(List.class, Arrays.asList("b", "c"), Collections.emptyList()));
    assertTrue(sc.isMergeAble(List.class, Arrays.asList("b", "c"), null));
    assertFalse(sc.isMergeAble(List.class, Collections.emptyList(), Arrays.asList("b", "c")));
    assertFalse(sc.isMergeAble(List.class, null, Arrays.asList("b", "c")));

    // test with Maps
    Map<String, Integer> map = new ImmutableMap.Builder<String, Integer>()
      .put("one", 1).put("two", 2).build();
    Map<String, Integer> map2 = new ImmutableMap.Builder<String, Integer>()
      .put("three", 3).put("four", 4).build();
    assertTrue(sc.isMergeAble(Map.class, map, map));
    assertTrue(sc.isMergeAble(Map.class, map, map2));
    assertTrue(sc.isMergeAble(Map.class, map, null));

    Map<String, Integer> map3 = new HashMap<>();
    map3.put("five", 5);
    assertTrue(sc.isMergeAble(Map.class, map3, new HashMap<>()));

    assertFalse(sc.isMergeAble(Map.class, new ImmutableMap.Builder<String, Integer>().build(), map3));
    assertFalse(sc.isMergeAble(Map.class, null, map3));
  }

  @Test
  public void testMergeWithRealValues() {
    StandaloneConfiguration sc = new StandaloneConfiguration();
    StandaloneConfiguration other = new StandaloneConfiguration();
    other.browserTimeout = 5000;
    other.debug = true;
    other.jettyMaxThreads = 1000;
    other.log = "foo.log";
    other.port = 4321;
    other.role = "wd";
    other.timeout = 4200;
    sc.merge(other);

    assertEquals(other.browserTimeout, sc.browserTimeout);
    assertEquals(other.jettyMaxThreads, sc.jettyMaxThreads);
    assertEquals(other.timeout, sc.timeout);
    // these values are merge protected
    assertNotEquals(other.debug, sc.debug);
    assertNotEquals(other.port, sc.port);
    assertNotEquals(other.log, sc.log);
    assertNotEquals(other.role, sc.role);
  }
}
