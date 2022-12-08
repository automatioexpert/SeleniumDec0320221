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

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.WaitingConditions.elementTextToContain;
import static org.openqa.selenium.WaitingConditions.elementTextToEqual;
import static org.openqa.selenium.WaitingConditions.newWindowIsOpened;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.testing.Driver.CHROME;
import static org.openqa.selenium.testing.Driver.FIREFOX;
import static org.openqa.selenium.testing.Driver.HTMLUNIT;
import static org.openqa.selenium.testing.Driver.IE;
import static org.openqa.selenium.testing.Driver.MARIONETTE;
import static org.openqa.selenium.testing.Driver.SAFARI;
import static org.openqa.selenium.testing.TestUtilities.catchThrowable;
import static org.openqa.selenium.testing.TestUtilities.getEffectivePlatform;
import static org.openqa.selenium.testing.TestUtilities.isChrome;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.testing.Ignore;
import org.openqa.selenium.testing.JUnit4TestBase;
import org.openqa.selenium.testing.NeedsFreshDriver;
import org.openqa.selenium.testing.NeedsLocalEnvironment;
import org.openqa.selenium.testing.NoDriverAfterTest;
import org.openqa.selenium.testing.NotYetImplemented;
import org.openqa.selenium.testing.SwitchToTopAfterTest;
import org.openqa.selenium.testing.drivers.SauceDriver;
import org.openqa.selenium.testing.drivers.WebDriverBuilder;

import java.util.Set;

public class PageLoadingTest extends JUnit4TestBase {

  private WebDriver localDriver;

  private void initLocalDriver(String strategy) {
    removeDriver();
    if (localDriver != null) {
      localDriver.quit();
    }
    Capabilities caps = new ImmutableCapabilities(CapabilityType.PAGE_LOAD_STRATEGY, strategy);
    localDriver = new WebDriverBuilder().get(caps);
  }

  @Test
  @Ignore(CHROME)
  @NotYetImplemented(value = SAFARI)
  @NeedsLocalEnvironment
  public void testNoneStrategyShouldNotWaitForPageToLoad() {
    initLocalDriver("none");

    String slowPage = appServer.whereIs("sleep?time=5");

    long start = System.currentTimeMillis();
    localDriver.get(slowPage);
    long end = System.currentTimeMillis();

    long duration = end - start;
    // The slow loading resource on that page takes 6 seconds to return,
    // but with 'none' page loading strategy 'get' operation should not wait.
    assertTrue("Took too long to load page: " + duration, duration < 1000);
  }

  @Test
  @NotYetImplemented(SAFARI)
  @Ignore(CHROME)
  @NeedsLocalEnvironment
  public void testNoneStrategyShouldNotWaitForPageToRefresh() {
    initLocalDriver("none");

    String slowPage = appServer.whereIs("sleep?time=5");

    localDriver.get(slowPage);
    // We discard the element, but want a check to make sure the page is loaded
    new WebDriverWait(localDriver, 10).until(presenceOfElementLocated(By.tagName("body")));

    long start = System.currentTimeMillis();
    localDriver.navigate().refresh();
    long end = System.currentTimeMillis();

    long duration = end - start;
    // The slow loading resource on that page takes 6 seconds to return,
    // but with 'none' page loading strategy 'refresh' operation should not wait.
    assertTrue("Took too long to load page: " + duration, duration < 1000);
  }

  @Test
  @Ignore(IE)
  @Ignore(CHROME)
  @NotYetImplemented(value = SAFARI)
  @NeedsLocalEnvironment
  public void testEagerStrategyShouldNotWaitForResources() {
    initLocalDriver("eager");

    String slowPage = appServer.whereIs("slowLoadingResourcePage.html");

    long start = System.currentTimeMillis();
    localDriver.get(slowPage);
    // We discard the element, but want a check to make sure the GET actually
    // completed.
    new WebDriverWait(localDriver, 10).until(presenceOfElementLocated(By.id("peas")));
    long end = System.currentTimeMillis();

    // The slow loading resource on that page takes 6 seconds to return. If we
    // waited for it, our load time should be over 6 seconds.
    long duration = end - start;
    assertTrue("Took too long to load page: " + duration, duration < 5 * 1000);
  }

  @Test
  @Ignore(IE)
  @Ignore(CHROME)
  @NotYetImplemented(SAFARI)
  @NeedsLocalEnvironment
  public void testEagerStrategyShouldNotWaitForResourcesOnRefresh() {
    initLocalDriver("eager");

    String slowPage = appServer.whereIs("slowLoadingResourcePage.html");

    localDriver.get(slowPage);
    // We discard the element, but want a check to make sure the GET actually completed.
    new WebDriverWait(localDriver, 10).until(presenceOfElementLocated(By.id("peas")));

    long start = System.currentTimeMillis();
    localDriver.navigate().refresh();
    // We discard the element, but want a check to make sure the refresh actually completed.
    new WebDriverWait(localDriver, 10).until(presenceOfElementLocated(By.id("peas")));
    long end = System.currentTimeMillis();

    // The slow loading resource on that page takes 6 seconds to return. If we
    // waited for it, our load time should be over 6 seconds.
    long duration = end - start;
    assertTrue("Took too long to refresh page: " + duration, duration < 5 * 1000);
  }

  @Test
  @Ignore(CHROME)
  public void testEagerStrategyShouldWaitForDocumentToBeLoaded() {
    initLocalDriver("eager");

    String slowPage = appServer.whereIs("sleep?time=3");

    localDriver.get(slowPage);

    // We discard the element, but want a check to make sure the GET actually completed.
    new WebDriverWait(localDriver, 10).until(presenceOfElementLocated(By.tagName("body")));
  }

  @Test
  public void testNormalStrategyShouldWaitForDocumentToBeLoaded() {
    driver.get(pages.simpleTestPage);
    assertThat(driver.getTitle(), equalTo("Hello WebDriver"));
  }

  @Test
  public void testShouldFollowRedirectsSentInTheHttpResponseHeaders() {
    driver.get(pages.redirectPage);
    assertThat(driver.getTitle(), equalTo("We Arrive Here"));
  }

  @Test
  public void testShouldFollowMetaRedirects() {
    driver.get(pages.metaRedirectPage);
    wait.until(titleIs("We Arrive Here"));
  }

  @Test
  @Ignore(value = CHROME, issue = "https://bugs.chromium.org/p/chromedriver/issues/detail?id=2239")
  public void testShouldBeAbleToGetAFragmentOnTheCurrentPage() {
    driver.get(pages.xhtmlTestPage);
    driver.get(pages.xhtmlTestPage + "#text");
    wait.until(presenceOfElementLocated(By.id("id1")));
  }

  @Test
  @Ignore(MARIONETTE)
  public void testShouldReturnWhenGettingAUrlThatDoesNotResolve() {
    try {
      // Of course, we're up the creek if this ever does get registered
      driver.get("http://www.thisurldoesnotexist.comx/");
    } catch (IllegalStateException e) {
      if (!isIeDriverTimedOutException(e)) {
        throw e;
      }
    }
  }

  @Test
  @Ignore(IE)
  @Ignore(value = SAFARI)
  @NeedsFreshDriver
  public void testShouldThrowIfUrlIsMalformed() {
    assumeFalse("Fails in Sauce Cloud", SauceDriver.shouldUseSauce());
    Throwable t = catchThrowable(() -> driver.get("www.test.com"));
    assertThat(t, instanceOf(WebDriverException.class));
  }

  @Test
  @Ignore(IE)
  @NotYetImplemented(value = SAFARI)
  @NeedsFreshDriver
  public void testShouldThrowIfUrlIsMalformedInPortPart() {
    assumeFalse("Fails in Sauce Cloud", SauceDriver.shouldUseSauce());
    Throwable t = catchThrowable(() -> driver.get("http://localhost:3001bla"));
    assertThat(t, instanceOf(WebDriverException.class));
  }

  @Test
  @Ignore(MARIONETTE)
  public void testShouldReturnWhenGettingAUrlThatDoesNotConnect() {
    // Here's hoping that there's nothing here. There shouldn't be
    driver.get("http://localhost:3001");
  }

  @Test
  @Ignore(value = IE,
      reason = "change in test web server causes IE to return resource 404 page instead of custom HTML")
  public void testShouldReturnURLOnNotExistedPage() {
    String url = appServer.whereIs("not_existed_page.html");
    driver.get(url);
    assertEquals(url, driver.getCurrentUrl());
  }

  @SwitchToTopAfterTest
  @Test
  public void testShouldBeAbleToLoadAPageWithFramesetsAndWaitUntilAllFramesAreLoaded() {
    driver.get(pages.framesetPage);

    driver.switchTo().frame(0);
    WebElement pageNumber = driver.findElement(By.xpath("//span[@id='pageNumber']"));
    assertThat(pageNumber.getText().trim(), equalTo("1"));

    driver.switchTo().defaultContent().switchTo().frame(1);
    pageNumber = driver.findElement(By.xpath("//span[@id='pageNumber']"));
    assertThat(pageNumber.getText().trim(), equalTo("2"));
  }

  @NeedsFreshDriver
  @NoDriverAfterTest
  @Test
  @NotYetImplemented(value = HTMLUNIT,
      reason = "HtmlUnit: can't execute JavaScript before a page is loaded")
  @Ignore(value = SAFARI, reason = "Hanging")
  public void testShouldDoNothingIfThereIsNothingToGoBackTo() {
    assumeFalse(
        "chromedriver does not disable popup blocker on Android: "
        + "https://code.google.com/p/chromedriver/issues/detail?id=1021",
        isChrome(driver) && getEffectivePlatform(driver).is(ANDROID));
    Set<String> currentWindowHandles = driver.getWindowHandles();
    ((JavascriptExecutor) driver).executeScript(
        "window.open('" + pages.formPage + "', 'newWindow')");
    wait.until(newWindowIsOpened(currentWindowHandles));
    driver.switchTo().window("newWindow");
    wait.until(titleIs("We Leave From Here"));
    String originalTitle = driver.getTitle();
    driver.get(pages.blankPage);
    wait.until(not(titleIs(originalTitle)));
    driver.navigate().back();
    wait.until(titleIs(originalTitle));
    driver.navigate().back(); // Nothing to go back to, must stay.
    assertThat(driver.getTitle(), equalTo(originalTitle));
  }

  @Test
  public void testShouldBeAbleToNavigateBackInTheBrowserHistory() {
    driver.get(pages.formPage);

    wait.until(visibilityOfElementLocated(By.id("imageButton"))).submit();
    wait.until(titleIs("We Arrive Here"));

    driver.navigate().back();
    wait.until(titleIs("We Leave From Here"));
  }

  @Test
  public void testShouldBeAbleToNavigateBackInTheBrowserHistoryInPresenceOfIframes() {
    driver.get(pages.xhtmlTestPage);

    wait.until(visibilityOfElementLocated(By.name("sameWindow"))).click();
    wait.until(titleIs("This page has iframes"));

    driver.navigate().back();
    wait.until(titleIs("XHTML Test Page"));
  }

  @Test
  public void testShouldBeAbleToNavigateForwardsInTheBrowserHistory() {
    driver.get(pages.formPage);

    wait.until(visibilityOfElementLocated(By.id("imageButton"))).submit();
    wait.until(titleIs("We Arrive Here"));

    driver.navigate().back();
    wait.until(titleIs("We Leave From Here"));

    driver.navigate().forward();
    wait.until(titleIs("We Arrive Here"));
  }

  @Test
  @Ignore(IE)
  @NotYetImplemented(value = SAFARI, reason = "does not support insecure SSL")
  public void testShouldBeAbleToAccessPagesWithAnInsecureSslCertificate() {
    // TODO(user): Set the SSL capability to true.
    driver.get(appServer.whereIsSecure("simpleTest.html"));

    shortWait.until(titleIs("Hello WebDriver"));
  }

  @Test
  public void testShouldBeAbleToRefreshAPage() {
    driver.get(pages.xhtmlTestPage);

    driver.navigate().refresh();

    assertThat(driver.getTitle(), equalTo("XHTML Test Page"));
  }

  /**
   * @see <a href="http://code.google.com/p/selenium/issues/detail?id=208"> Issue 208</a>
   *
   *      This test often causes the subsequent test to fail, in Firefox, on Linux, so we need a new
   *      driver after it.
   * @see <a href="http://code.google.com/p/selenium/issues/detail?id=2282">Issue 2282</a>
   */
  @NoDriverAfterTest
  @Test
  @Ignore(IE)
  @Ignore(MARIONETTE)
  public void testShouldNotHangIfDocumentOpenCallIsNeverFollowedByDocumentCloseCall() {
    driver.get(pages.documentWrite);

    // If this command succeeds, then all is well.
    WebElement body = wait.until(visibilityOfElementLocated(By.tagName("body")));
    wait.until(elementTextToContain(body, "world"));
  }

  // Note: If this test ever fixed/enabled on Firefox, check if it also needs @NoDriverAfterTest OR
  // if @NoDriverAfterTest can be removed from some other tests in this class.
  @NoDriverAfterTest
  @Test
  @Ignore(FIREFOX)
  @NotYetImplemented(SAFARI)
  @NeedsLocalEnvironment
  public void testPageLoadTimeoutCanBeChanged() {
    testPageLoadTimeoutIsEnforced(2);
    testPageLoadTimeoutIsEnforced(3);
  }

  @NoDriverAfterTest
  @Test
  @Ignore(FIREFOX)
  @NotYetImplemented(SAFARI)
  @NeedsLocalEnvironment
  public void testCanHandleSequentialPageLoadTimeouts() {
    long pageLoadTimeout = 2;
    long pageLoadTimeBuffer = 10;
    driver.manage().timeouts().pageLoadTimeout(2, SECONDS);
    assertPageLoadTimeoutIsEnforced(pageLoadTimeout, pageLoadTimeBuffer);
    assertPageLoadTimeoutIsEnforced(pageLoadTimeout, pageLoadTimeBuffer);
  }

  @NoDriverAfterTest // Subsequent tests sometimes fail on Firefox.
  @Test
  @NeedsLocalEnvironment
  public void testShouldTimeoutIfAPageTakesTooLongToLoad() {
    try {
      testPageLoadTimeoutIsEnforced(2);
    } finally {
      driver.manage().timeouts().pageLoadTimeout(300, SECONDS);
    }

    // Load another page after get() timed out but before test HTTP server served previous page.
    driver.get(pages.xhtmlTestPage);
    wait.until(titleIs("XHTML Test Page"));
  }

  @NoDriverAfterTest // Subsequent tests sometimes fail on Firefox.
  @Test
  @NotYetImplemented(value = SAFARI)
  @Ignore(value = FIREFOX, travis = true)
  @Ignore(HTMLUNIT)
  @Ignore(value = CHROME, issue = "https://code.google.com/p/chromedriver/issues/detail?id=1125")
  @NeedsLocalEnvironment
  public void testShouldTimeoutIfAPageTakesTooLongToLoadAfterClick() {
    driver.manage().timeouts().pageLoadTimeout(2, SECONDS);

    driver.get(appServer.whereIs("page_with_link_to_slow_loading_page.html"));
    WebElement link = wait.until(visibilityOfElementLocated(By.id("link-to-slow-loading-page")));

    long start = System.currentTimeMillis();
    try {
      link.click();
      fail("I should have timed out");
    } catch (RuntimeException e) {
      long end = System.currentTimeMillis();

      assertThat(e, is(instanceOf(TimeoutException.class)));

      int duration = (int) (end - start);
      assertThat(duration, greaterThan(2000));
      assertThat(duration, lessThan(5000));
    } finally {
      driver.manage().timeouts().pageLoadTimeout(300, SECONDS);
    }

    // Load another page after get() timed out but before test HTTP server served previous page.
    driver.get(pages.xhtmlTestPage);
    wait.until(titleIs("XHTML Test Page"));
  }

  @NoDriverAfterTest // Subsequent tests sometimes fail on Firefox.
  @Test
  @NeedsLocalEnvironment
  public void testShouldTimeoutIfAPageTakesTooLongToRefresh() {
    // Get the sleeping servlet with a pause of 5 seconds
    String slowPage = appServer.whereIs("sleep?time=5");

    driver.get(slowPage);

    driver.manage().timeouts().pageLoadTimeout(2, SECONDS);

    long start = System.currentTimeMillis();
    try {
      driver.navigate().refresh();
      fail("I should have timed out");
    } catch (RuntimeException e) {
      long end = System.currentTimeMillis();

      assertThat(e, is(instanceOf(TimeoutException.class)));

      int duration = (int) (end - start);
      assertThat(duration, greaterThan(2000));
      assertThat(duration, lessThan(4000));
    } finally {
      driver.manage().timeouts().pageLoadTimeout(300, SECONDS);
    }

    // Load another page after get() timed out but before test HTTP server served previous page.
    driver.get(pages.xhtmlTestPage);
    wait.until(titleIs("XHTML Test Page"));
  }

  @NoDriverAfterTest // Subsequent tests sometimes fail on Firefox.
  @Test
  @Ignore(CHROME)
  @NotYetImplemented(value = SAFARI)
  @NotYetImplemented(HTMLUNIT)
  @NeedsLocalEnvironment
  public void testShouldNotStopLoadingPageAfterTimeout() {
    try {
      testPageLoadTimeoutIsEnforced(1);
    } finally {
      driver.manage().timeouts().pageLoadTimeout(300, SECONDS);
    }

    new WebDriverWait(driver, 30)
        .ignoring(StaleElementReferenceException.class)
        .until(elementTextToEqual(By.tagName("body"), "Slept for 11s"));
  }

  @After
  public void quitDriver() {
    if (this.localDriver != null) {
      this.localDriver.quit();
      this.localDriver = null;
    }
  }

  /**
   * Sets given pageLoadTimeout to the {@link #driver} and asserts that attempt to navigate to a
   * page that takes much longer (10 seconds longer) to load results in a TimeoutException.
   * <p>
   * Side effects: 1) {@link #driver} is configured to use given pageLoadTimeout,
   * 2) test HTTP server still didn't serve the page to browser (some browsers may still
   * be waiting for the page to load despite the fact that driver responded with the timeout).
   */
  private void testPageLoadTimeoutIsEnforced(long webDriverPageLoadTimeout) {
    // Test page will load this many seconds longer than WD pageLoadTimeout.
    long pageLoadTimeBuffer = 10;
    driver.manage().timeouts().pageLoadTimeout(webDriverPageLoadTimeout, SECONDS);
    assertPageLoadTimeoutIsEnforced(webDriverPageLoadTimeout, pageLoadTimeBuffer);
  }

  private void assertPageLoadTimeoutIsEnforced(long webDriverPageLoadTimeout,
                                               long pageLoadTimeBuffer) {
    long start = System.currentTimeMillis();
    try {
      driver.get(appServer.whereIs(
          "sleep?time=" + (webDriverPageLoadTimeout + pageLoadTimeBuffer)));
      fail("I should have timed out after " + webDriverPageLoadTimeout + " seconds");
    } catch (RuntimeException e) {
      long end = System.currentTimeMillis();

      assertThat(e, is(instanceOf(TimeoutException.class)));

      long duration = end - start;
      assertThat(duration, greaterThan(webDriverPageLoadTimeout * 1000));
      assertThat(duration, lessThan((webDriverPageLoadTimeout + pageLoadTimeBuffer) * 1000));
    }
  }
}
