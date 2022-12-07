package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
  WebDriver driver;
  
  public HomePageObject(WebDriver driver) {
    this.driver = driver;
  }
}
