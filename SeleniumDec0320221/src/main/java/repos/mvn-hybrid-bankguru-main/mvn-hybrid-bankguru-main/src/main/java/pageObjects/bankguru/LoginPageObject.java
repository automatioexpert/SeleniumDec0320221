package pageObjects.bankguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.bankguru.LoginPageUI;

public class LoginPageObject extends BasePage {
  WebDriver driver;
  
  public LoginPageObject(WebDriver driver) {
    this.driver = driver;
  }
  
  public ManagerPageObject loginToSystem(String userName, String password) {
    waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
    senkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
    
    waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
    senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    
    waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
    clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    return PageGeneratorManager.getManagerPageObject(driver);
  }
}
