package commons;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.bankguru.BasePageUI;
import pageUIs.nopcommerce.RegisterPageUI;
import pageUIs.nopcommerce.SearchPageUI;

public class BasePage {
  
  public void openPageUrl(WebDriver driver, String pageUrl) {
    driver.get(pageUrl);
  }
  
  protected String getTile(WebDriver driver) {
    return driver.getTitle();
  }
  
  protected String getCurrentUrl(WebDriver driver) {
    return driver.getCurrentUrl();
  }
  
  protected String getPageSource(WebDriver driver) {
    return driver.getPageSource();
  }
  
  public Set<Cookie> getAllCookies(WebDriver driver) {
    return driver.manage().getCookies();
  }
  
  public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
    for (Cookie cookie : allCookies) {
      driver.manage().addCookie(cookie);
    }
  }
  
  protected void backToPage(WebDriver driver) {
    driver.navigate().back();
  }
  
  protected void ForwardToPage(WebDriver driver) {
    driver.navigate().forward();
  }
  
  public void refreshToPage(WebDriver driver) {
    driver.navigate().refresh();
  }
  
  protected Alert waitAlertPresence(WebDriver driver) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.alertIsPresent());
  }
  
  protected void acceptAlert(WebDriver driver) {
    waitAlertPresence(driver).accept();
  }
  
  protected void cancelAlert(WebDriver driver) {
    waitAlertPresence(driver).dismiss();
  }
  
  protected String getTextAlert(WebDriver driver) {
    return waitAlertPresence(driver).getText();
  }
  
  protected void getTextAlert(WebDriver driver, String textValue) {
    waitAlertPresence(driver).sendKeys(textValue);
  }
  
  protected void switchToWindowByID(WebDriver driver, String parentID) {
    Set<String> allWindows = driver.getWindowHandles();
    for (String runWindow : allWindows) {
      if (!runWindow.equals(parentID)) {
        driver.switchTo().window(runWindow);
        break;
      }
    }
  }
  
  protected void switchToWindowByTitle(WebDriver driver, String title) {
    Set<String> allWindows = driver.getWindowHandles();
    for (String runWindows : allWindows) {
      driver.switchTo().window(runWindows);
      String currentWin = driver.getTitle();
      if (currentWin.equals(title)) {
        break;
      }
    }
  }
  
  protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
    Set<String> allWindows = driver.getWindowHandles();
    for (String runWindows : allWindows) {
      if (!runWindows.equals(parentID)) {
        driver.switchTo().window(runWindows);
        driver.close();
      }
    }
    driver.switchTo().window(parentID);
  }
  
  public By getByXpath(String locatorType) {
    return By.xpath(locatorType);
  }
  
  private By getByLocator(String locatorType) {
    By by = null;
    if (locatorType.toLowerCase().startsWith("id=")) {
      by = By.id(locatorType.substring(3));
    } else if (locatorType.toLowerCase().startsWith("class=")) {
      by = By.className(locatorType.substring(6));
    } else if (locatorType.toLowerCase().startsWith("name=")) {
      by = By.name(locatorType.substring(5));
    } else if (locatorType.toLowerCase().startsWith("css=")) {
      by = By.cssSelector(locatorType.substring(4));
    } else if (locatorType.toLowerCase().startsWith("xpath=")) {
      by = By.xpath(locatorType.substring(6));
    }
    return by;
  }
  
  private String getDynamicLocatorType(String locatorType, String... dynamicValues) {
    if (locatorType.toLowerCase().startsWith("xpath=")) {
      locatorType = String.format(locatorType, (Object[]) dynamicValues);
    }
    return locatorType;
  }
  
  protected WebElement getWebElement(WebDriver driver, String locatorType) {
    return driver.findElement(getByLocator(locatorType));
  }
  
  protected WebElement getWebElement(WebDriver driver, String locatorType, String... dynamicValues) {
    return driver.findElement(getByLocator(getDynamicLocatorType(locatorType, dynamicValues)));
  }
  
  protected List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
    return driver.findElements(getByLocator(locatorType));
  }
  
  protected List<WebElement> getListWebElement(WebDriver driver, String locatorType, String... dynamicValues) {
    return driver.findElements(getByLocator(getDynamicLocatorType(locatorType, dynamicValues)));
  }
  
  protected void clickToElement(WebDriver driver, String locatorType) {
    getWebElement(driver, locatorType).click();
  }
  
  protected void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
    getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)).click();
  }
  
  protected void senkeyToElement(WebDriver driver, String locatorType, String textValue) {
    WebElement element = getWebElement(driver, locatorType);
    element.clear();
    element.sendKeys(textValue);
  }
  
  protected void senkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
    WebElement element = getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues));
    element.clear();
    element.sendKeys(textValue);
  }
  
  protected void selectItemInDropdown(WebDriver driver, String locatorType, String textItem) {
    Select select = new Select(getWebElement(driver, locatorType));
    select.selectByVisibleText(textItem);
  }
  
  protected void selectItemInDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
    Select select = new Select(getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)));
    select.selectByVisibleText(textItem);
  }
  
  protected String getSelectedItemInDropdown(WebDriver driver, String locatorType) {
    Select select = new Select(getWebElement(driver, locatorType));
    return select.getFirstSelectedOption().getText();
  }
  
  protected String getSelectedItemInDropdown(WebDriver driver, String locatorType, String... dynamicValues) {
    Select select = new Select(getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)));
    return select.getFirstSelectedOption().getText();
  }
  
  protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
    Select select = new Select(getWebElement(driver, locatorType));
    return select.isMultiple();
  }
  
  protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
    getWebElement(driver, parentLocator).click();
    sleepInSecond(1);
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
    for (WebElement item : allItems) {
      if (item.getText().trim().equals(expectedItem)) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
        sleepInSecond(1);
        item.click();
        break;
      }
    }
  }
  
  public void sleepInSecond(long second) {
    try {
      Thread.sleep(second * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  protected String getAttributeValue(WebDriver driver, String locatorType, String attributeName) {
    return getWebElement(driver, locatorType).getAttribute(attributeName);
  }
  
  protected String getAttributeValue(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
    return getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)).getAttribute(attributeName);
  }
  
  protected String getTextElement(WebDriver driver, String locatorType) {
    return getWebElement(driver, locatorType).getText();
  }
  
  protected String getTextElement(WebDriver driver, String locatorType, String... dynamicValues) {
    return getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)).getText();
  }
  
  protected String getCssValue(WebDriver driver, String locatorType, String propertyName) {
    return getWebElement(driver, locatorType).getCssValue(propertyName);
  }
  
  protected String getHexaColorFromRGBA(String rgbaValue) {
    return Color.fromString(rgbaValue).asHex();
  }
  
  protected int getElementsSize(WebDriver driver, String locatorType) {
    return getListWebElement(driver, locatorType).size();
  }
  
  protected int getElementsSize(WebDriver driver, String locatorType, String... dynamicValues) {
    return getListWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)).size();
  }
  
  protected void checkTheCheckboxOrRadio(WebDriver driver, String locatorType) {
    WebElement item = getWebElement(driver, locatorType);
    if (!item.isSelected()) item.click();
  }
  
  protected void checkTheCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
    WebElement item = getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues));
    if (!item.isSelected()) item.click();
  }
  
  protected void uncheckTheCheckbox(WebDriver driver, String locatorType) {
    WebElement item = getWebElement(driver, locatorType);
    if (item.isSelected()) item.click();
  }
  
  protected void uncheckTheCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
    WebElement item = getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues));
    if (item.isSelected()) item.click();
  }
  
  protected boolean isElementDisplayed(WebDriver driver, String locatorType) {
    try {
      return getWebElement(driver, locatorType).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  
  protected boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
    return getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)).isDisplayed();
  }
  
  protected boolean isElementUndisplayed(WebDriver driver, String locatorType) {
    overrideImplicitlyGlobalTimeout(driver, GlobalConstants.SHORT_TIME);
    
    List<WebElement> elements = getListWebElement(driver, locatorType);
    
    overrideImplicitlyGlobalTimeout(driver, GlobalConstants.LONG_TIME);
    
    if (elements.size() == 0) {
      return true;
    } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
      return true;
    }
    
    return false;
  }
  
  protected boolean isElementSelected(WebDriver driver, String locatorType) {
    return getWebElement(driver, locatorType).isSelected();
  }
  
  protected boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValues) {
    return getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)).isSelected();
  }
  
  protected boolean isElementEnabled(WebDriver driver, String locatorType) {
    return getWebElement(driver, locatorType).isEnabled();
  }
  
  protected boolean isElementEnabled(WebDriver driver, String locatorType, String... dynamicValues) {
    return getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)).isEnabled();
  }
  
  protected void switchToIframeFrame(WebDriver driver, String locatorType) {
    driver.switchTo().frame(getWebElement(driver, locatorType));
  }
  
  protected void switchToDefaultContent(WebDriver driver) {
    driver.switchTo().defaultContent();
  }
  
  protected void hoverMouseToElement(WebDriver driver, String locatorType) {
    Actions actions = new Actions(driver);
    actions.moveToElement(getWebElement(driver, locatorType)).perform();
  }
  
  protected void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValues) {
    Actions actions = new Actions(driver);
    actions.moveToElement(getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues))).perform();
  }
  
  protected void scrollToBottomPage(WebDriver driver) {
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }
  
  protected void highlightElement(WebDriver driver, String locatorType) {
    WebElement element = getWebElement(driver, locatorType);
    String originalStyle = element.getAttribute("style");
    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
    sleepInSecond(1);
    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
  }
  
  protected void clickToElementByJS(WebDriver driver, String locatorType) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locatorType));
  }
  
  protected void scrollToElement(WebDriver driver, String locatorType) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
  }
  
  protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
  }
  
  protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove, String... dynamicValues) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)));
  }
  
  protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        try {
          return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
        } catch (Exception e) {
          return true;
        }
      }
    };
    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
      }
    };
    return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
  }
  
  public boolean isPageLoadedSuccess(WebDriver driver) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    ExpectedCondition<Boolean> jsQueryLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0)");
      }
    };
    return explicitWait.until(jsQueryLoad);
  }
  
  protected String getElementValidationMessage(WebDriver driver, String locatorType) {
    return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
  }
  
  protected boolean isImageLoaded(WebDriver driver, String locatorType) {
    boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
    return status;
  }
  
  protected boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
    boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues)));
    return status;
  }
  
  protected WebElement waitForElementVisible(WebDriver driver, String locatorType) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
  }
  
  protected WebElement waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocatorType(locatorType, dynamicValues))));
  }
  
  protected List<WebElement> waitForAllElementVisible(WebDriver driver, String locatorType) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
  }
  
  protected List<WebElement> waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocatorType(locatorType, dynamicValues))));
  }
  
  protected Boolean waitForElementInvisible(WebDriver driver, String locatorType) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
  }
  
  protected Boolean waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocatorType(locatorType, dynamicValues))));
  }
  
  protected Boolean waitForElementAllInvisible(WebDriver driver, String locatorType) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
  }
  
  protected Boolean waitForElementAllInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicLocatorType(locatorType, dynamicValues))));
  }
  
  protected WebElement waitForElementClickable(WebDriver driver, String locatorType) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
  }
  
  protected WebElement waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
    WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
    return explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocatorType(locatorType, dynamicValues))));
  }
  
  public void overrideImplicitlyGlobalTimeout(WebDriver driver, long timeOut) {
    driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
  }
  
  // BankGuru
  public void openManagerTabByText(WebDriver driver, String tabName) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_MANAGER_TAB_BY_TEXT, tabName);
    clickToElement(driver, BasePageUI.DYNAMIC_MANAGER_TAB_BY_TEXT, tabName);
  }
  
  public void enterToTextboxByLabel(WebDriver driver, String textboxLabel, String value) {
    if (textboxLabel.equals("Date of Birth")) {
      removeAttributeInDOM(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_LABEL, "type", textboxLabel);
    }
    waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_LABEL, textboxLabel);
    senkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_LABEL, value, textboxLabel);
  }
  
  public void enterToTextareaByLabel(WebDriver driver, String textareaLabel, String value) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTAREA_BY_LABEL, textareaLabel);
    senkeyToElement(driver, BasePageUI.DYNAMIC_TEXTAREA_BY_LABEL, value, textareaLabel);
  }
  
  public void clickToButtonByValue(WebDriver driver, String buttonValue) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
    clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
  }
  
  public void selectToRadioButton(WebDriver driver, String radioButtonValue) {
    waitForElementClickable(driver, BasePageUI.RADIO_BUTTON, radioButtonValue);
    checkTheCheckboxOrRadio(driver, BasePageUI.RADIO_BUTTON, radioButtonValue);
  }
  
  public void selectItemInDropdownByName(WebDriver driver, String dropdownName, String valueItem) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
    selectItemInDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, valueItem, dropdownName);
  }
  
  public String getRowValueByRowName(WebDriver driver, String rowName) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_ROW_VALUE_BY_ROW_NAME, rowName);
    return getTextElement(driver, BasePageUI.DYNAMIC_ROW_VALUE_BY_ROW_NAME, rowName);
  }
  
  public boolean isFieldEnabledByLabel(WebDriver driver, String textboxLabel) {
    return isElementEnabled(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_LABEL, textboxLabel);
  }
  
  public String getSuccessMessageAtTableID(WebDriver driver, String tableID) {
    waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE_AT_TABLE_ID, tableID);
    return getTextElement(driver, BasePageUI.SUCCESS_MESSAGE_AT_TABLE_ID, tableID);
  }
  
  private long longTime = GlobalConstants.LONG_TIME;
  
  // Nopcommerce
  public void clickToButtonByText(WebDriver driver, String buttonText) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
    clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
  }
  
  public String getErrorMessageAtFieldByID(WebDriver driver, String fieldID) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_AT_FIELD_BY_ID, fieldID);
    return getTextElement(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_AT_FIELD_BY_ID, fieldID);
  }
  
  public void openPageInAreaByText(WebDriver driver, String areaName, String pageName) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_IN_AREA_BY_TEXT, areaName, pageName);
    clickToElement(driver, BasePageUI.DYNAMIC_PAGE_IN_AREA_BY_TEXT, areaName, pageName);
  }
  
  public void enterToTextboxByID(WebDriver driver, String textboxID, String value) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
    senkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
  }
  
  public void enterToTextareaByID(WebDriver driver, String textareaID, String value) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTAREA_BY_ID, textareaID);
    senkeyToElement(driver, BasePageUI.DYNAMIC_TEXTAREA_BY_ID, value, textareaID);
  }
  
  public String getSummaryErrorMessage(WebDriver driver) {
    waitForElementVisible(driver, RegisterPageUI.SUMMARY_ERROR_MESSAGE);
    return getTextElement(driver, RegisterPageUI.SUMMARY_ERROR_MESSAGE);
  }
  
  public boolean isHeaderLinkDisplayedByText(WebDriver driver, String linkText) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_IN_AREA_BY_TEXT, "header", linkText);
    return isElementDisplayed(driver, BasePageUI.DYNAMIC_PAGE_IN_AREA_BY_TEXT, "header", linkText);
  }
  
  public String getTexboxValueByID(WebDriver driver, String textboxID) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
    return getAttributeValue(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
  }
  
  public void clickToRadioButtonByLabel(WebDriver driver, String radioButtonLabel) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabel);
    checkTheCheckboxOrRadio(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabel);
  }
  
  public boolean isRadioButtonSelectedByLabel(WebDriver driver, String radioButtonLabel) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabel);
    return isElementSelected(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabel);
  }
  
  public String getSelectedValueInDropdownByName(WebDriver driver, String dropdownName) {
    waitForElementVisible(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
    return getSelectedItemInDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
  }
  
  public void openMenuPage(WebDriver driver, String menuPageName) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
    clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
  }
  
  public void openSubMenuPage(WebDriver driver, String menuPageName, String subMenuPageName) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
    hoverMouseToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
    
    waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, subMenuPageName);
    clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, subMenuPageName);
  }
  
  public void clickToProductTitleByText(WebDriver driver, String productTitle) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_PRODUCT_TITLE, productTitle);
    clickToElement(driver, BasePageUI.DYNAMIC_PRODUCT_TITLE, productTitle);
  }
  
  public void clickToReviewLinkByText(WebDriver driver, String linkText) {
    waitForElementClickable(driver, BasePageUI.REVIEW_LINK_BY_TEXT, linkText);
    clickToElement(driver, BasePageUI.REVIEW_LINK_BY_TEXT, linkText);
  }
  
  public boolean isProductReviewDisplay(WebDriver driver, String text) {
    waitForElementVisible(driver, BasePageUI.PRODUCT_REVIEW_TITLE, text);
    return isElementDisplayed(driver, BasePageUI.PRODUCT_REVIEW_TITLE, text);
  }
  
  public String getBarNotificationContent(WebDriver driver) {
    waitForElementVisible(driver, BasePageUI.BAR_NOTIFICATION_CONTENT);
    return getTextElement(driver, BasePageUI.BAR_NOTIFICATION_CONTENT);
  }
  
  public void closeBarNotification(WebDriver driver) {
    waitForElementClickable(driver, BasePageUI.BAR_NOTIFICATION_CLOSE_BUTTON);
    clickToElement(driver, BasePageUI.BAR_NOTIFICATION_CLOSE_BUTTON);
  }
  
  public void clickToCheckboxByLabel(WebDriver driver, String checkboxLabel) {
    waitForElementClickable(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabel);
    checkTheCheckboxOrRadio(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabel);
  }
  
  public boolean ísProductNameSorted(WebDriver driver, String sortBy) {
    List<WebElement> productNameElements = getListWebElement(driver, BasePageUI.PRODUCT_NAME);
    List<String> productNameTexts = new ArrayList<String>();
    
    for (WebElement productName : productNameElements) {
      productNameTexts.add(productName.getText());
    }
  
    List<String> productNameTextClone = new ArrayList<String>(productNameTexts);
    Collections.sort(productNameTextClone);
    
    if (sortBy.equals("DESC")) Collections.reverse(productNameTextClone);
    
    return productNameTexts.equals(productNameTextClone);
  }
  
  public boolean ísProductPriceSorted(WebDriver driver, String sortBy) {
    List<WebElement> productPriceElements = getListWebElement(driver, BasePageUI.PRODUCT_PRICE);
    List<Float> productPriceTexts = new ArrayList<Float>();

    for (WebElement productPrice : productPriceElements) {
      System.out.println(Float.parseFloat(productPrice.getText().replaceAll("[^0-9.-]+","")));
      productPriceTexts.add(Float.parseFloat(productPrice.getText().replaceAll("[^0-9.-]+","")));
    }
    
    System.out.println("************* Actual **********");
  
    for (Float productPrice : productPriceTexts) {
      System.out.println(productPrice);
    }
    
    List<Float> productPriceTextClone = new ArrayList<Float>(productPriceTexts);
    Collections.sort(productPriceTextClone);
    
    if (sortBy.equals("HighToLow")) Collections.reverse(productPriceTextClone);
    
    System.out.println("************* Expect **********");
  
    for (Float productPrice : productPriceTextClone) {
      System.out.println(productPrice);
    }
    
    return productPriceTexts.equals(productPriceTextClone);
  }
  
  public boolean ísProductsSizeDisplayed(WebDriver driver, int numberPerPage) {
    System.out.println("Size = " +getElementsSize(driver, BasePageUI.PRODUCT_NAME));
    return getElementsSize(driver, BasePageUI.PRODUCT_NAME) <= numberPerPage;
  }
  
  public void openPagingByPageNumber(WebDriver driver, String pageNumber) {
    waitForElementClickable(driver, BasePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
    clickToElement(driver, BasePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
  }
  
  public boolean isPageNumberActive(WebDriver driver, String pageNumber) {
    waitForElementVisible(driver, BasePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
    return isElementDisplayed(driver, BasePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
  }
  
  public boolean isPageNumberDisplayed(WebDriver driver, String pageNumber) {
    waitForElementVisible(driver, BasePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
    return isElementDisplayed(driver, BasePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
  }
  
  public boolean isPagingUnDisplay(WebDriver driver) {
    overrideImplicitlyGlobalTimeout(driver, GlobalConstants.SHORT_TIME);
    
    waitForElementInvisible(driver, BasePageUI.PAGINATION_PAGE );
    List<WebElement> elements = getListWebElement(driver, BasePageUI.PAGINATION_PAGE);
    
    overrideImplicitlyGlobalTimeout(driver, GlobalConstants.LONG_TIME);
    
    if(elements.size() == 0) return true;
    if (elements.size() > 0 && !elements.get(0).isDisplayed()) return true;
    return false;
  }
}
