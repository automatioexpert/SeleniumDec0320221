package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
  WebDriver driver;
  
  public RegisterPageObject(WebDriver driver) {
    this.driver = driver;
  }
  
  public String getRegisterSuccessMessage() {
    waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
  }

}
