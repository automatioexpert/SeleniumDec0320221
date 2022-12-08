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

package org.openqa.selenium.support;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.TickingClock;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageFactoryTest {

  private WebDriver driver;

  @Test
  public void shouldProxyElementsInAnInstantiatedPage() {
    PublicPage page = new PublicPage();

    assertThat(page.q, is(nullValue()));
    assertThat(page.list, is(nullValue()));

    PageFactory.initElements(driver, page);

    assertThat(page.q, is(notNullValue()));
    assertThat(page.list, is(notNullValue()));
  }

  @Test
  public void shouldInsertProxiesForPublicWebElements() {
    PublicPage page = PageFactory.initElements(driver, PublicPage.class);

    assertThat(page.q, is(notNullValue()));
    assertThat(page.list, is(notNullValue()));
  }

  @Test
  public void shouldProxyElementsFromParentClassesToo() {
    ChildPage page = new ChildPage();

    PageFactory.initElements(driver, page);

    assertThat(page.q, is(notNullValue()));
    assertThat(page.list, is(notNullValue()));
    assertThat(page.submit, is(notNullValue()));
  }

  @Test
  public void shouldProxyRenderedWebElementFields() {
    PublicPage page = PageFactory.initElements(driver, PublicPage.class);

    assertThat(page.rendered, is(notNullValue()));
  }

  @Test
  public void shouldProxyPrivateElements() {
    PrivatePage page = new PrivatePage();

    PageFactory.initElements(driver, page);

    assertThat(page.getField(), is(notNullValue()));
    assertThat(page.getList(), is(notNullValue()));
  }

  @Test
  public void shouldUseAConstructorThatTakesAWebDriverAsAnArgument() {
    driver = mock(WebDriver.class);

    ConstructedPage page = PageFactory.initElements(driver, ConstructedPage.class);

    assertThat(driver, equalTo(page.driver));
  }

  @Test
  public void shouldNotDecorateFieldsWhenTheFieldDecoratorReturnsNull() {
    PublicPage page = new PublicPage();
    // Assign not-null values
    WebElement q = mock(WebElement.class);
    page.q = q;

    PageFactory.initElements((loader, field) -> null, page);

    assertThat(page.q, equalTo(q));
  }

  @Test
  public void triesToDecorateNonWebElements() {
    NonWebElementsPage page = new NonWebElementsPage();
    // Assign not-null values

    PageFactory.initElements((loader, field) -> new Integer(5), page);

    assertThat(page.num, equalTo(new Integer(5)));
  }

  @Test
  public void shouldNotDecorateListsOfWebElementsThatAreNotAnnotated() {
    UnmarkedListPage page = new UnmarkedListPage();

    PageFactory.initElements(driver, page);

    assertThat(page.elements, is(nullValue()));
  }

  @Test
  public void shouldNotDecorateListsThatAreTypedButNotWebElementLists() {
    UnmarkedListPage page = new UnmarkedListPage();

    PageFactory.initElements(driver, page);

    assertThat(page.objects, is(nullValue()));
  }

  @Test
  public void shouldNotDecorateUnTypedLists() {
    UnmarkedListPage page = new UnmarkedListPage();

    PageFactory.initElements(driver, page);

    assertThat(page.untyped, is(nullValue()));
  }

  @Test
  public void shouldComplainWhenMoreThanOneFindByAttributeIsSet() {
    GrottyPage page = new GrottyPage();

    try {
      PageFactory.initElements((WebDriver) null, page);
      fail("Should not have allowed page to be initialised");
    } catch (IllegalArgumentException e) {
      // this is expected
    }
  }

  @Test
  public void shouldComplainWhenMoreThanOneFindByShortFormAttributeIsSet() {
    GrottyPage2 page = new GrottyPage2();

    try {
      PageFactory.initElements((WebDriver) null, page);
      fail("Should not have allowed page to be initialised");
    } catch (IllegalArgumentException e) {
      // this is expected
    }
  }

  @Test(expected = TimeoutException.class)
  public void shouldNotThrowANoSuchElementExceptionWhenUsedWithAFluentWait() {
    driver = mock(WebDriver.class);
    when(driver.findElement(Mockito.<By>any())).thenThrow(new NoSuchElementException("because"));

    TickingClock clock = new TickingClock();
    Wait<WebDriver> wait = new WebDriverWait(driver, clock, clock, 1, 1001);

    PublicPage page = new PublicPage();
    PageFactory.initElements(driver, page);
    WebElement element = page.q;

    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static class PublicPage {

    @FindBy(name = "q")
    public WebElement q;

    @FindBy(name = "q")
    public List<WebElement> list;

    public WebElement rendered;
  }

  public static class ChildPage extends PublicPage {

    public WebElement submit;
  }

  public static class ConstructedPage {

    public WebDriver driver;

    public ConstructedPage(WebDriver driver) {
      this.driver = driver;
    }
  }

  public static class PrivatePage {

    private WebElement allMine = null;

    @FindBy(name = "q")
    private List<WebElement> list = null;

    public WebElement getField() {
      return allMine;
    }

    public List<WebElement> getList() {
      return list;
    }
  }

  public static class GrottyPage {

    @FindBy(how = How.XPATH, using = "//body", id = "cheese")
    private WebElement one;
  }

  public static class GrottyPage2 {

    @FindBy(xpath = "//body", id = "cheese")
    private WebElement two;
  }

  public static class UnmarkedListPage {
    private List<WebElement> elements;
    private List<Object> objects;
    @SuppressWarnings("rawtypes")
    private List untyped;  // This list deliberately left untyped
  }

  public static class NonWebElementsPage {

    public Integer num;
  }
}
