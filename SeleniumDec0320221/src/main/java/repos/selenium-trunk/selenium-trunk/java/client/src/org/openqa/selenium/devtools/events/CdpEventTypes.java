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

package org.openqa.selenium.devtools.events;

import com.google.common.base.Joiner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.internal.Require;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.logging.EventType;
import org.openqa.selenium.logging.HasLogEvents;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Consumer;

import static org.openqa.selenium.json.Json.MAP_TYPE;

public class CdpEventTypes {

  private static final WeakHashMap<WebDriver, Set<String>> PINNED_SCRIPTS = new WeakHashMap<>();
  private static final Json JSON = new Json();

  private CdpEventTypes() {
    // Utility class.
  }

  public static EventType<ConsoleEvent> consoleEvent(Consumer<ConsoleEvent> handler) {
    Require.nonNull("Handler", handler);

    return new EventType<ConsoleEvent>() {
      public void consume(ConsoleEvent event) {
        handler.accept(event);
      }

      @Override
      public void initializeLogger(HasLogEvents loggable) {
        Require.precondition(loggable instanceof HasDevTools, "Loggable must implement HasDevTools");

        DevTools tools = ((HasDevTools) loggable).getDevTools();
        tools.createSession();

        tools.send(tools.getDomains().runtime().enable());
        tools.addListener(
          tools.getDomains().runtime().consoleAPICalled(),
          event -> {
            consume(new ConsoleEvent(event.getType(), event.getTimestamp(), event.getArgs()));
          });
      }
    };
  }

  public static EventType<Void> domMutation(Consumer<DomMutationEvent> handler) {
    String script = Joiner.on("\n").join(new String[]{
      "(function() {",
      "const observer = new MutationObserver((mutations) => {",
      "  for (const mutation of mutations) {",
      "    switch (mutation.type) {",
      "      case \"attributes\":",
      // Don't report our own attribute has changed.
      "        if (mutation.attributeName == 'data-__webdriver_id') {",
      "          break;",
      "        }",
      "        const curr = mutation.target.getAttribute(mutation.attributeName);",
      "        var id = mutation.target.dataset.__webdriver_id",
      "        if (!id) {",
      "          id = Math.random().toString(36).substring(2) + Date.now().toString(36);",
      "          mutation.target.dataset.__webdriver_id = id;",
      "        }",
      "        const json = JSON.stringify({",
      "          \"target\": id,",
      "          \"name\": mutation.attributeName,",
      "          \"value\": curr,",
      "          \"oldValue\": mutation.oldValue",
      "        });",
      "        __webdriver_attribute(json);",
      "        break;",
      "      default:",
      "        break;",
      "    }",
      "  }",
      "});",
      "observer.observe(document, {",
      "  \"attributes\": true,",
      "  \"attributeOldValue\": true,",
      "  \"characterData\": true,",
      "  \"characterDataOldValue\": true,",
      "  \"childList\": true,",
      "  \"subtree\": true",
      "});",
      "})();"
    });

    return new EventType<Void>() {
      @Override
      public void consume(Void event) {
        handler.accept(null);
      }

      @Override
      public void initializeLogger(HasLogEvents loggable) {
        Require.precondition(loggable instanceof WebDriver, "Loggable must be a WebDriver");
        Require.precondition(loggable instanceof HasDevTools, "Loggable must implement HasDevTools");

        DevTools tools = ((HasDevTools) loggable).getDevTools();
        tools.createSession();

        WebDriver driver = (WebDriver) loggable;
        Set<String> scripts = PINNED_SCRIPTS.computeIfAbsent(driver, ignored -> new HashSet<>());
        if (!scripts.contains(script)) {
          // Pin the script
          tools.send(tools.getDomains().runtime().enable());
          tools.send(tools.getDomains().runtime().addBinding("__webdriver_attribute"));

          tools.send(tools.getDomains().page().enable());
          tools.send(tools.getDomains().page().addScriptToEvaluateOnNewDocument(script));

          // And add the script to the current page
          ((JavascriptExecutor) driver).executeScript(script);

          scripts.add(script);
        }

        tools.addListener(
          tools.getDomains().runtime().bindingCalled(),
          bindingCalled -> {
            Map<String, Object> values = JSON.toType(bindingCalled.getPayload(), MAP_TYPE);
            String id = (String) values.get("target");

            List<WebElement> elements = driver.findElements(By.cssSelector(String.format("*[data-__webdriver_id='%s']", id)));

            if (!elements.isEmpty()) {
              DomMutationEvent event = new DomMutationEvent(
                elements.get(0),
                String.valueOf(values.get("name")),
                String.valueOf(values.get("value")),
                String.valueOf(values.get("oldValue")));
              handler.accept(event);
            }
          }
        );
      }
    };
  }

}
