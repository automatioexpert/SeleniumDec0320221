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

package org.openqa.selenium.remote.server.rest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.server.StubHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@RunWith(JUnit4.class)
public class ResultConfigTest {
  private Logger logger = Logger.getLogger(ResultConfigTest.class.getName());
  private static final SessionId dummySessionId = new SessionId("Test");

  @Test
  public void testShouldNotAllowNullToBeUsedAsTheUrl() {
    try {
      new ResultConfig(null, StubHandler.class, null, logger);
      fail("Should have failed");
    } catch (IllegalArgumentException e) {
      exceptionWasExpected();
    }
  }

  @Test
  public void testShouldNotAllowNullToBeUsedForTheHandler() {
    try {
      new ResultConfig("/cheese", null, null, logger);
      fail("Should have failed");
    } catch (IllegalArgumentException e) {
      exceptionWasExpected();
    }
  }

  @Test
  public void testShouldSetNamedParametersOnHandler() {
    ResultConfig config = new ResultConfig("/foo/:bar", NamedParameterHandler.class, null, logger
    );
    Command command = new Command(dummySessionId, "foo", ImmutableMap.of("bar", "fishy"));
    NamedParameterHandler handler = new NamedParameterHandler();
    config.populate(handler, command);

    assertThat(handler.getBar(), is("fishy"));
  }

  @SuppressWarnings({"ThrowableResultOfMethodCallIgnored"})
  @Test
  public void testShouldGracefullyHandleNullInputs() {
    ResultConfig config = new ResultConfig("/foo/:bar", StubHandler.class, null, logger
    );
    assertNull(config.getRootExceptionCause(null));
  }

  @SuppressWarnings({"ThrowableInstanceNeverThrown"})
  @Test
  public void testCanPeelNestedExceptions() {
    RuntimeException runtime = new RuntimeException("root of all evils");
    InvocationTargetException invocation = new InvocationTargetException(runtime,
        "Got Runtime Exception");
    WebDriverException webdriverException = new WebDriverException("Invocation problems",
        invocation);
    ExecutionException execution = new ExecutionException("General WebDriver error",
        webdriverException);

    ResultConfig config = new ResultConfig("/foo/:bar", StubHandler.class, null, logger
    );
    Throwable toClient = config.getRootExceptionCause(execution);
    assertEquals(toClient, runtime);
  }

  @SuppressWarnings({"ThrowableInstanceNeverThrown"})
  @Test
  public void testDoesNotPeelTooManyLayersFromNestedExceptions() {
    RuntimeException runtime = new RuntimeException("root of all evils");
    NoSuchElementException noElement = new NoSuchElementException("no soup for you", runtime);
    InvocationTargetException invocation = new InvocationTargetException(noElement);
    UndeclaredThrowableException undeclared = new UndeclaredThrowableException(invocation);

    ResultConfig config = new ResultConfig("/foo/:bar", StubHandler.class, null, logger
    );
    Throwable toClient = config.getRootExceptionCause(undeclared);
    assertEquals(noElement, toClient);
  }

  private void exceptionWasExpected() {
  }

  public static class NamedParameterHandler implements RestishHandler<Void> {

    private String bar;

    public String getBar() {
      return bar;
    }

    @SuppressWarnings({"UnusedDeclaration"})
    public void setBar(String bar) {
      this.bar = bar;
    }

    @Override
    public Void handle() {
      return null;
    }
  }

}
