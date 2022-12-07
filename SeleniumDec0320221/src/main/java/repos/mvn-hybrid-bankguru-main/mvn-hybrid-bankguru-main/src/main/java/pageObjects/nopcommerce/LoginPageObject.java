package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.LoginPageUI;


public class LoginPageObject extends BasePage {
  WebDriver driver;
  
  public LoginPageObject(WebDriver driver) {
    this.driver = driver;
  }
  
  public HomePageObject loginToSystem(String email, String password) {
    waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
    senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
  
    waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
    senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
  
    waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
    clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    return PageGeneratorManager.getHomePageObject(driver);
  }
}
