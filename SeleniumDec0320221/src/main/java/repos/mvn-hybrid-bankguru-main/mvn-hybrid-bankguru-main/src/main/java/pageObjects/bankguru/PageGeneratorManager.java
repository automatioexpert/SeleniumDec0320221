package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.ManagerPageObject;

public class PageGeneratorManager {
  public static LoginPageObject getLoginPageObject(WebDriver driver){
    return new LoginPageObject(driver);
  }
  
  public static ManagerPageObject getManagerPageObject(WebDriver driver){
    return new ManagerPageObject(driver);
  }
  
}
