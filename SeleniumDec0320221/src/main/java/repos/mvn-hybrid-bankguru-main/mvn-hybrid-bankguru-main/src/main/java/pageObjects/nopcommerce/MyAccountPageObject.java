package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
  WebDriver driver;
  
  public MyAccountPageObject(WebDriver driver) {
    this.driver = driver;
  }
  
  public boolean isAddressInfoDisplayByClass(WebDriver driver, String className, String value) {
    waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_ADDRESS_INFO_FIELD, className, value);
    return isElementDisplayed(driver, MyAccountPageUI.DYNAMIC_ADDRESS_INFO_FIELD, className, value);
  }
}
