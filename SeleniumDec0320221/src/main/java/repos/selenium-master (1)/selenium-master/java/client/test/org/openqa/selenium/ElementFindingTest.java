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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeFalse;
import static org.openqa.selenium.testing.Driver.CHROME;
import static org.openqa.selenium.testing.Driver.IE;
import static org.openqa.selenium.testing.Driver.MARIONETTE;
import static org.openqa.selenium.testing.Driver.SAFARI;
import static org.openqa.selenium.testing.TestUtilities.catchThrowable;
import static org.openqa.selenium.testing.TestUtilities.isOldIe;

import org.junit.Test;
import org.openqa.selenium.testing.Ignore;
import org.openqa.selenium.testing.JUnit4TestBase;
import org.openqa.selenium.testing.NeedsFreshDriver;
import org.openqa.selenium.testing.NotYetImplemented;
import org.openqa.selenium.testing.SwitchToTopAfterTest;
import org.openqa.selenium.testing.TestUtilities;

import java.util.List;

public class ElementFindingTest extends JUnit4TestBase {

  // By.id positive

  @Test
  public void testShouldBeAbleToFindASingleElementById() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.id("linkId"));
    assertThat(element.getAttribute("id"), is("linkId"));
  }

  @Test
  public void testShouldBeAbleToFindASingleElementByNumericId() {
    driver.get(pages.nestedPage);
    WebElement element = driver.findElement(By.id("2"));
    assertThat(element.getAttribute("id"), is("2"));
  }

  @Test
  @Ignore(value = CHROME,
      reason = "Need to recompile drivers with atoms from 6c55320d3f0eb23de56270a55c74602fc8d63c8a")
  @Ignore(IE)
  public void testShouldBeAbleToFindASingleElementByIdWithNonAlphanumericCharacters() {
    driver.get(pages.nestedPage);
    WebElement element = driver.findElement(By.id("white space"));
    assertThat(element.getText(), is("space"));
    WebElement element2 = driver.findElement(By.id("css#.chars"));
    assertThat(element2.getText(), is("css escapes"));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsById() {
    driver.get(pages.nestedPage);
    List<WebElement> elements = driver.findElements(By.id("test_id"));
    assertThat(elements.size(), is(2));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsByNumericId() {
    driver.get(pages.nestedPage);
    List<WebElement> elements = driver.findElements(By.id("2"));
    assertThat(elements.size(), is(8));
  }

  @Test
  @Ignore(value = CHROME,
      reason = "Need to recompile drivers with atoms from 6c55320d3f0eb23de56270a55c74602fc8d63c8a")
  @Ignore(IE)
  public void testShouldBeAbleToFindMultipleElementsByIdWithNonAlphanumericCharacters() {
    driver.get(pages.nestedPage);
    List<WebElement> elements = driver.findElements(By.id("white space"));
    assertThat(elements.size(), is(2));
    List<WebElement> elements2 = driver.findElements(By.id("css#.chars"));
    assertThat(elements2.size(), is(2));
  }

  // By.id negative

  @Test
  public void testShouldNotBeAbleToLocateByIdASingleElementThatDoesNotExist() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.id("nonExistentButton")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testShouldNotBeAbleToLocateByIdMultipleElementsThatDoNotExist() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.id("nonExistentButton"));
    assertThat(elements.size(), is(0));
  }

  @Test
  public void testFindingASingleElementByEmptyIdShouldThrow() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.id("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @Ignore(value = MARIONETTE, reason = "https://bugzilla.mozilla.org/show_bug.cgi?id=1204504")
  public void testFindingMultipleElementsByEmptyIdShouldReturnEmptyList() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.id(""));
    assertThat(elements.size(), is(0));
  }

  @Test
  public void testFindingASingleElementByIdWithSpaceShouldThrow() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.id("nonexistent button")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingMultipleElementsByIdWithSpaceShouldReturnEmptyList() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.id("nonexistent button"));
    assertThat(elements.size(), is(0));
  }

  // By.name positive

  @Test
  public void testShouldBeAbleToFindASingleElementByName() {
    driver.get(pages.formPage);
    WebElement element = driver.findElement(By.name("checky"));
    assertThat(element.getAttribute("value"), is("furrfu"));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsByName() {
    driver.get(pages.nestedPage);
    List<WebElement> elements = driver.findElements(By.name("checky"));
    assertThat(elements.size(), greaterThan(1));
  }

  @Test
  public void testShouldBeAbleToFindAnElementThatDoesNotSupportTheNameProperty() {
    driver.get(pages.nestedPage);
    WebElement element = driver.findElement(By.name("div1"));
    assertThat(element.getAttribute("name"), is("div1"));
  }

  // By.name negative

  @Test
  public void testShouldNotBeAbleToLocateByNameASingleElementThatDoesNotExist() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.name("nonExistentButton")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testShouldNotBeAbleToLocateByNameMultipleElementsThatDoNotExist() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.name("nonExistentButton"));
    assertThat(elements.size(), is(0));
  }

  @Test
  public void testFindingASingleElementByEmptyNameShouldThrow() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.name("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingMultipleElementsByEmptyNameShouldReturnEmptyList() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.name(""));
    assertThat(elements.size(), is(0));
  }

  @Test
  public void testFindingASingleElementByNameWithSpaceShouldThrow() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.name("nonexistent button")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingMultipleElementsByNameWithSpaceShouldReturnEmptyList() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.name("nonexistent button"));
    assertThat(elements.size(), is(0));
  }

  // By.tagName positive

  @Test
  public void testShouldBeAbleToFindASingleElementByTagName() {
    driver.get(pages.formPage);
    WebElement element = driver.findElement(By.tagName("input"));
    assertThat(element.getTagName().toLowerCase(), is("input"));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsByTagName() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.tagName("input"));
    assertThat(elements.size(), greaterThan(1));
  }

  // By.tagName negative

  @Test
  public void testShouldNotBeAbleToLocateByTagNameASingleElementThatDoesNotExist() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.tagName("nonExistentButton")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testShouldNotBeAbleToLocateByTagNameMultipleElementsThatDoNotExist() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.tagName("nonExistentButton"));
    assertThat(elements.size(), is(0));
  }

  @Test
  public void testFindingASingleElementByEmptyTagNameShouldThrow() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.tagName("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testFindingMultipleElementsByEmptyTagNameShouldThrow() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.tagName("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingASingleElementByTagNameWithSpaceShouldThrow() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.tagName("nonexistent button")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingMultipleElementsByTagNameWithSpaceShouldReturnEmptyList() {
    driver.get(pages.formPage);
    List<WebElement> elements = driver.findElements(By.tagName("nonexistent button"));
    assertThat(elements.size(), is(0));
  }

  // By.className positive

  @Test
  public void testShouldBeAbleToFindASingleElementByClass() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.className("extraDiv"));
    assertThat(element.getText(), startsWith("Another div starts here."));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsByClassName() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.className("nameC"));
    assertThat(elements.size(), greaterThan(1));
  }

  @Test
  public void testShouldFindElementByClassWhenItIsTheFirstNameAmongMany() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.className("nameA"));
    assertThat(element.getText(), is("An H2 title"));
  }

  @Test
  public void testShouldFindElementByClassWhenItIsTheLastNameAmongMany() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.className("nameC"));
    assertThat(element.getText(), is("An H2 title"));
  }

  @Test
  public void testShouldFindElementByClassWhenItIsInTheMiddleAmongMany() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.className("nameBnoise"));
    assertThat(element.getText(), is("An H2 title"));
  }

  @Test
  public void testShouldFindElementByClassWhenItsNameIsSurroundedByWhitespace() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.className("spaceAround"));
    assertThat(element.getText(), is("Spaced out"));
  }

  @Test
  public void testShouldFindElementsByClassWhenItsNameIsSurroundedByWhitespace() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.className("spaceAround"));
    assertThat(elements.size(), is(1));
    assertThat(elements.get(0).getText(), is("Spaced out"));
  }

  // By.className negative

  @Test
  public void testShouldNotFindElementByClassWhenTheNameQueriedIsShorterThanCandidateName() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.className("nameB")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingASingleElementByEmptyClassNameShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.className("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testFindingMultipleElementsByEmptyClassNameShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.className("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingASingleElementByCompoundClassNameShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.className("a b")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @Ignore(MARIONETTE)
  @NotYetImplemented(SAFARI)
  public void testFindingMultipleElementsByCompoundClassNameShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.className("a b")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testFindingASingleElementByInvalidClassNameShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.className("!@#$%^&*")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @Ignore(MARIONETTE)
  @NotYetImplemented(SAFARI)
  public void testFindingMultipleElementsByInvalidClassNameShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.className("!@#$%^&*")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  // By.xpath positive

  @Test
  public void testShouldBeAbleToFindASingleElementByXPath() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.xpath("//h1"));
    assertThat(element.getText(), is("XHTML Might Be The Future"));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsByXPath() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.xpath("//div"));
    assertThat(elements.size(), is(13));
  }

  @Test
  public void testShouldBeAbleToFindManyElementsRepeatedlyByXPath() {
    driver.get(pages.xhtmlTestPage);
    String xpathString = "//node()[contains(@id,'id')]";
    assertThat(driver.findElements(By.xpath(xpathString)).size(), is(3));

    xpathString = "//node()[contains(@id,'nope')]";
    assertThat(driver.findElements(By.xpath(xpathString)).size(), is(0));
  }

  @Test
  public void testShouldBeAbleToIdentifyElementsByClass() {
    driver.get(pages.xhtmlTestPage);
    WebElement header = driver.findElement(By.xpath("//h1[@class='header']"));
    assertThat(header.getText(), is("XHTML Might Be The Future"));
  }

  @Test
  public void testShouldBeAbleToFindAnElementByXPathWithMultipleAttributes() {
    driver.get(pages.formPage);
    WebElement element = driver.findElement(
        By.xpath("//form[@name='optional']/input[@type='submit' and @value='Click!']"));
    assertThat(element.getTagName().toLowerCase(), is("input"));
    assertThat(element.getAttribute("value"), is("Click!"));
  }

  @Test
  public void testFindingALinkByXpathShouldLocateAnElementWithTheGivenText() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.xpath("//a[text()='click me']"));
    assertThat(element.getText(), is("click me"));
  }

  @Test
  public void testFindingALinkByXpathUsingContainsKeywordShouldWork() {
    driver.get(pages.nestedPage);
    WebElement element = driver.findElement(By.xpath("//a[contains(.,'hello world')]"));
    assertThat(element.getText(), containsString("hello world"));
  }

  @Test
  @Ignore(IE)
  @Ignore(MARIONETTE)
  @NotYetImplemented(SAFARI)
  public void testShouldBeAbleToFindElementByXPathWithNamespace() {
    driver.get(pages.svgPage);
    WebElement element = driver.findElement(By.xpath("//svg:svg//svg:text"));
    assertThat(element.getText(), is("Test Chart"));
  }

  @Test
  @Ignore(IE)
  @NotYetImplemented(SAFARI)
  @Ignore(CHROME)
  public void testShouldBeAbleToFindElementByXPathInXmlDocument() {
    driver.get(pages.simpleXmlDocument);
    WebElement element = driver.findElement(By.xpath("//foo"));
    assertThat(element.getText(), is("baz"));
  }

  // By.xpath negative

  @Test
  public void testShouldThrowAnExceptionWhenThereIsNoLinkToClick() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.xpath("//a[@id='Not here']")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathIsSyntacticallyInvalidInDriverFindElement() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.xpath("this][isnot][valid")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathIsSyntacticallyInvalidInDriverFindElements() {
    assumeFalse("Ignoring xpath error test in IE6", TestUtilities.isIe6(driver));

    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.xpath("this][isnot][valid")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathIsSyntacticallyInvalidInElementFindElement() {
    driver.get(pages.formPage);
    WebElement body = driver.findElement(By.tagName("body"));
    Throwable t = catchThrowable(() -> body.findElement(By.xpath("this][isnot][valid")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathIsSyntacticallyInvalidInElementFindElements() {
    assumeFalse("Ignoring xpath error test in IE6", TestUtilities.isIe6(driver));

    driver.get(pages.formPage);
    WebElement body = driver.findElement(By.tagName("body"));
    Throwable t = catchThrowable(() -> body.findElements(By.xpath("this][isnot][valid")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathReturnsWrongTypeInDriverFindElement() {
    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.xpath("count(//input)")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathReturnsWrongTypeInDriverFindElements() {
    assumeFalse("Ignoring xpath error test in IE6", TestUtilities.isIe6(driver));

    driver.get(pages.formPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.xpath("count(//input)")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathReturnsWrongTypeInElementFindElement() {
    driver.get(pages.formPage);

    WebElement body = driver.findElement(By.tagName("body"));
    Throwable t = catchThrowable(() -> body.findElement(By.xpath("count(//input)")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testShouldThrowInvalidSelectorExceptionWhenXPathReturnsWrongTypeInElementFindElements() {
    assumeFalse("Ignoring xpath error test in IE6", TestUtilities.isIe6(driver));

    driver.get(pages.formPage);
    WebElement body = driver.findElement(By.tagName("body"));
    Throwable t = catchThrowable(() -> body.findElements(By.xpath("count(//input)")));
    assertThat(t, instanceOf(InvalidSelectorException.class));
  }

  // By.cssSelector positive

  @Test
  public void testShouldBeAbleToFindASingleElementByCssSelector() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.cssSelector("div.content"));
    assertThat(element.getTagName().toLowerCase(), is("div"));
    assertThat(element.getAttribute("class"), is("content"));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsByCssSelector() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.cssSelector("p"));
    assertThat(elements.size(), greaterThan(1));
  }

  @Test
  public void testShouldBeAbleToFindASingleElementByCompoundCssSelector() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.cssSelector("div.extraDiv, div.content"));
    assertThat(element.getTagName().toLowerCase(), is("div"));
    assertThat(element.getAttribute("class"), is("content"));
  }

  @Test
  public void testShouldBeAbleToFindMultipleElementsByCompoundCssSelector() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.cssSelector("div.extraDiv, div.content"));
    assertThat(elements.size(), greaterThan(1));
    assertThat(elements.get(0).getAttribute("class"), is("content"));
    assertThat(elements.get(1).getAttribute("class"), is("extraDiv"));
  }

  @Test
  @Ignore(value = IE, reason = "IE supports only short version option[selected]")
  public void testShouldBeAbleToFindAnElementByBooleanAttributeUsingCssSelector() {
    driver.get(appServer.whereIs("locators_tests/boolean_attribute_selected.html"));
    WebElement element = driver.findElement(By.cssSelector("option[selected='selected']"));
    assertThat(element.getAttribute("value"), is("two"));
  }

  @Test
  public void testShouldBeAbleToFindAnElementByBooleanAttributeUsingShortCssSelector() {
    driver.get(appServer.whereIs("locators_tests/boolean_attribute_selected.html"));
    WebElement element = driver.findElement(By.cssSelector("option[selected]"));
    assertThat(element.getAttribute("value"), is("two"));
  }

  @Test
  public void testShouldBeAbleToFindAnElementByBooleanAttributeUsingShortCssSelectorOnHtml4Page() {
    driver.get(appServer.whereIs("locators_tests/boolean_attribute_selected_html4.html"));
    WebElement element = driver.findElement(By.cssSelector("option[selected]"));
    assertThat(element.getAttribute("value"), is("two"));
  }

  // By.cssSelector negative

  @Test
  public void testShouldNotFindElementByCssSelectorWhenThereIsNoSuchElement() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.cssSelector(".there-is-no-such-class")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testShouldNotFindElementsByCssSelectorWhenThereIsNoSuchElement() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.cssSelector(".there-is-no-such-class"));
    assertThat(elements.size(), is(0));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testFindingASingleElementByEmptyCssSelectorShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.cssSelector("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testFindingMultipleElementsByEmptyCssSelectorShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.cssSelector("")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testFindingASingleElementByInvalidCssSelectorShouldThrow() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.cssSelector("//a/b/c[@id='1']")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testFindingMultipleElementsByInvalidCssSelectorShouldThrow() {
    assumeFalse("Ignoring test for lack of error in CSS in IE6", TestUtilities.isIe6(driver));
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElements(By.cssSelector("//a/b/c[@id='1']")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  // By.linkText positive

  @Test
  public void testShouldBeAbleToFindALinkByText() {
    driver.get(pages.xhtmlTestPage);
    WebElement link = driver.findElement(By.linkText("click me"));
    assertThat(link.getText(), is("click me"));
  }

  @Test
  public void testShouldBeAbleToFindMultipleLinksByText() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.linkText("click me"));
    assertThat(elements.size(), is(2));
  }

  @Test
  public void testShouldFindElementByLinkTextContainingEqualsSign() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.linkText("Link=equalssign"));
    assertThat(element.getAttribute("id"), is("linkWithEqualsSign"));
  }

  @Test
  public void testShouldFindMultipleElementsByLinkTextContainingEqualsSign() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.linkText("Link=equalssign"));
    assertEquals(1, elements.size());
    assertThat(elements.get(0).getAttribute("id"), is("linkWithEqualsSign"));
  }

  @Test
  public void findsByLinkTextOnXhtmlPage() {
    assumeFalse("Old IE doesn't render XHTML pages, don't try loading XHTML pages in it",
                isOldIe(driver));

    driver.get(appServer.whereIs("actualXhtmlPage.xhtml"));
    String linkText = "Foo";
    WebElement element = driver.findElement(By.linkText(linkText));
    assertThat(element.getText(), is(linkText));
  }

  @Test
  public void testLinkWithFormattingTags() {
    driver.get(pages.simpleTestPage);
    WebElement elem = driver.findElement(By.id("links"));

    WebElement res = elem.findElement(By.partialLinkText("link with formatting tags"));
    assertThat(res.getText(), is("link with formatting tags"));
  }

  @Test
  @NotYetImplemented(SAFARI)
  public void testDriverCanGetLinkByLinkTestIgnoringTrailingWhitespace() {
    driver.get(pages.simpleTestPage);
    WebElement link = driver.findElement(By.linkText("link with trailing space"));
    assertThat(link.getAttribute("id"), is("linkWithTrailingSpace"));
    assertThat(link.getText(), is("link with trailing space"));
  }

  // By.linkText negative

  @Test
  public void testShouldNotBeAbleToLocateByLinkTextASingleElementThatDoesNotExist() {
    driver.get(pages.xhtmlTestPage);
    Throwable t = catchThrowable(() -> driver.findElement(By.linkText("Not here either")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @Test
  public void testShouldNotBeAbleToLocateByLinkTextMultipleElementsThatDoNotExist() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.linkText("Not here either"));
    assertThat(elements.size(), is(0));
  }

  // By.partialLinkText positive

  @Test
  public void testShouldBeAbleToFindMultipleElementsByPartialLinkText() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.partialLinkText("ick me"));
    assertThat(elements.size(), is(2));
  }

  @Test
  public void testShouldBeAbleToFindASingleElementByPartialLinkText() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.partialLinkText("anon"));
    assertThat(element.getText(), containsString("anon"));
  }

  @Test
  public void testShouldFindElementByPartialLinkTextContainingEqualsSign() {
    driver.get(pages.xhtmlTestPage);
    WebElement element = driver.findElement(By.partialLinkText("Link="));
    assertThat(element.getAttribute("id"), is("linkWithEqualsSign"));
  }

  @Test
  public void testShouldFindMultipleElementsByPartialLinkTextContainingEqualsSign() {
    driver.get(pages.xhtmlTestPage);
    List<WebElement> elements = driver.findElements(By.partialLinkText("Link="));
    assertThat(elements.size(), is(1));
    assertThat(elements.get(0).getAttribute("id"), is("linkWithEqualsSign"));
  }

  // Misc tests

  @Test
  public void testDriverShouldBeAbleToFindElementsAfterLoadingMoreThanOnePageAtATime() {
    driver.get(pages.formPage);
    driver.get(pages.xhtmlTestPage);
    WebElement link = driver.findElement(By.linkText("click me"));
    assertThat(link.getText(), is("click me"));
  }

  // You don't want to ask why this is here
  @Test
  public void testWhenFindingByNameShouldNotReturnById() {
    driver.get(pages.formPage);

    WebElement element = driver.findElement(By.name("id-name1"));
    assertThat(element.getAttribute("value"), is("name"));

    element = driver.findElement(By.id("id-name1"));
    assertThat(element.getAttribute("value"), is("id"));

    element = driver.findElement(By.name("id-name2"));
    assertThat(element.getAttribute("value"), is("name"));

    element = driver.findElement(By.id("id-name2"));
    assertThat(element.getAttribute("value"), is("id"));
  }

  @Test
  public void testShouldBeAbleToFindAHiddenElementsByName() {
    driver.get(pages.formPage);
    WebElement element = driver.findElement(By.name("hidden"));
    assertThat(element.getAttribute("name"), is("hidden"));
  }

  @Test
  public void testShouldNotBeAbleToFindAnElementOnABlankPage() {
    driver.get("about:blank");
    Throwable t = catchThrowable(() -> driver.findElement(By.tagName("a")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @NeedsFreshDriver
  @Test
  public void testShouldNotBeAbleToLocateASingleElementOnABlankPage() {
    // Note we're on the default start page for the browser at this point.
    Throwable t = catchThrowable(() -> driver.findElement(By.id("nonExistantButton")));
    assertThat(t, instanceOf(NoSuchElementException.class));
  }

  @SwitchToTopAfterTest
  @Test
  public void testAnElementFoundInADifferentFrameIsStale() {
    driver.get(pages.missedJsReferencePage);
    driver.switchTo().frame("inner");
    WebElement element = driver.findElement(By.id("oneline"));
    driver.switchTo().defaultContent();
    Throwable t = catchThrowable(element::getText);
    assertThat(t, instanceOf(StaleElementReferenceException.class));
  }

  @SwitchToTopAfterTest
  @Test
  @NotYetImplemented(SAFARI)
  public void testAnElementFoundInADifferentFrameViaJsCanBeUsed() {
    driver.get(pages.missedJsReferencePage);

    driver.switchTo().frame("inner");
    WebElement first = driver.findElement(By.id("oneline"));

    driver.switchTo().defaultContent();
    WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
        "return frames[0].document.getElementById('oneline');");


    driver.switchTo().frame("inner");

    WebElement second = driver.findElement(By.id("oneline"));

    assertEquals(first, element);
    assertEquals(second, element);
  }

}
