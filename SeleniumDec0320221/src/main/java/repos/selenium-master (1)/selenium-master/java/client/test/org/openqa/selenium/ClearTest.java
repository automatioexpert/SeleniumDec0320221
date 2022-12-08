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

package org.openqa.selenium;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.testing.Driver.CHROME;
import static org.openqa.selenium.testing.Driver.FIREFOX;
import static org.openqa.selenium.testing.Driver.HTMLUNIT;
import static org.openqa.selenium.testing.Driver.IE;
import static org.openqa.selenium.testing.Driver.MARIONETTE;
import static org.openqa.selenium.testing.Driver.SAFARI;
import static org.openqa.selenium.testing.TestUtilities.catchThrowable;

import org.junit.Test;
import org.openqa.selenium.testing.JUnit4TestBase;
import org.openqa.selenium.testing.NotYetImplemented;

public class ClearTest extends JUnit4TestBase {

  @Test
  public void testWritableTextInputShouldClear() {
    driver.get(pages.readOnlyPage);
    WebElement element = driver.findElement(By.id("writableTextInput"));
    element.clear();
    assertEquals("", element.getAttribute("value"));
  }

  @Test
  public void testTextInputShouldNotClearWhenDisabled() {
    driver.get(pages.readOnlyPage);
    WebElement element = driver.findElement(By.id("textInputnotenabled"));
    assertEquals(false, element.isEnabled());
    Throwable t = catchThrowable(element::clear);
    assertThat(t, instanceOf(InvalidElementStateException.class));
  }

  @Test
  public void testTextInputShouldNotClearWhenReadOnly() {
    driver.get(pages.readOnlyPage);
    WebElement element = driver.findElement(By.id("readOnlyTextInput"));
    Throwable t = catchThrowable(element::clear);
    assertThat(t, instanceOf(InvalidElementStateException.class));
  }

  @Test
  public void testWritableTextAreaShouldClear() {
    driver.get(pages.readOnlyPage);
    WebElement element = driver.findElement(By.id("writableTextArea"));
    element.clear();
    assertEquals("", element.getAttribute("value"));
  }

  @Test
  public void testTextAreaShouldNotClearWhenDisabled() {
    driver.get(pages.readOnlyPage);
    WebElement element = driver.findElement(By.id("textAreaNotenabled"));
    Throwable t = catchThrowable(element::clear);
    assertThat(t, instanceOf(InvalidElementStateException.class));
  }

  @Test
  public void testTextAreaShouldNotClearWhenReadOnly() {
    driver.get(pages.readOnlyPage);
    WebElement element = driver.findElement(By.id("textAreaReadOnly"));
    Throwable t = catchThrowable(element::clear);
    assertThat(t, instanceOf(InvalidElementStateException.class));
  }

  @Test
  public void testContentEditableAreaShouldClear() {
    driver.get(pages.readOnlyPage);
    WebElement element = driver.findElement(By.id("content-editable"));
    element.clear();
    assertEquals("", element.getText());
  }

  @Test
  public void shouldBeAbleToClearNoTypeInput() {
    shouldBeAbleToClearInput(By.name("no_type"), "input with no type");
  }

  @Test
  public void shouldBeAbleToClearNumberInput() {
    shouldBeAbleToClearInput(By.name("number_input"), "42");
  }

  @Test
  public void shouldBeAbleToClearEmailInput() {
    shouldBeAbleToClearInput(By.name("email_input"), "admin@localhost");
  }

  @Test
  public void shouldBeAbleToClearPasswordInput() {
    shouldBeAbleToClearInput(By.name("password_input"), "qwerty");
  }

  @Test
  public void shouldBeAbleToClearSearchInput() {
    shouldBeAbleToClearInput(By.name("search_input"), "search");
  }

  @Test
  public void shouldBeAbleToClearTelInput() {
    shouldBeAbleToClearInput(By.name("tel_input"), "911");
  }

  @Test
  public void shouldBeAbleToClearTextInput() {
    shouldBeAbleToClearInput(By.name("text_input"), "text input");
  }

  @Test
  public void shouldBeAbleToClearUrlInput() {
    shouldBeAbleToClearInput(By.name("url_input"), "http://seleniumhq.org/");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(FIREFOX)
  @NotYetImplemented(MARIONETTE)
  @NotYetImplemented(IE)
  @NotYetImplemented(HTMLUNIT)
  @NotYetImplemented(SAFARI)
  public void shouldBeAbleToClearRangeInput() {
    shouldBeAbleToClearInput(By.name("range_input"), "42");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(FIREFOX)
  @NotYetImplemented(MARIONETTE)
  @NotYetImplemented(IE)
  @NotYetImplemented(SAFARI)
  public void shouldBeAbleToClearCheckboxInput() {
    shouldBeAbleToClearInput(By.name("checkbox_input"), "Checkbox");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(FIREFOX)
  @NotYetImplemented(MARIONETTE)
  @NotYetImplemented(HTMLUNIT)
  @NotYetImplemented(SAFARI)
  public void shouldBeAbleToClearColorInput() {
    shouldBeAbleToClearInput(By.name("color_input"), "#00ffff");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(HTMLUNIT)
  public void shouldBeAbleToClearDateInput() {
    shouldBeAbleToClearInput(By.name("date_input"), "2017-11-22");
  }

  @Test
  public void shouldBeAbleToClearDatetimeInput() {
    shouldBeAbleToClearInput(By.name("datetime_input"), "2017-11-22T11:22");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(HTMLUNIT)
  public void shouldBeAbleToClearDatetimeLocalInput() {
    shouldBeAbleToClearInput(By.name("datetime_local_input"), "2017-11-22T11:22");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(HTMLUNIT)
  public void shouldBeAbleToClearTimeInput() {
    shouldBeAbleToClearInput(By.name("time_input"), "11:22");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(HTMLUNIT)
  public void shouldBeAbleToClearMonthInput() {
    shouldBeAbleToClearInput(By.name("month_input"), "2017-11");
  }

  @Test
  @NotYetImplemented(CHROME)
  @NotYetImplemented(HTMLUNIT)
  public void shouldBeAbleToClearWeekInput() {
    shouldBeAbleToClearInput(By.name("week_input"), "2017-W47");
  }

  private void shouldBeAbleToClearInput(By locator, String oldValue) {
    driver.get(appServer.whereIs("inputs.html"));
    WebElement element = driver.findElement(locator);
    assertEquals(oldValue, element.getAttribute("value"));
    element.clear();
    assertEquals("", element.getAttribute("value"));
  }

}
