package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class NotebooksPageObject extends BasePage {
  WebDriver driver;
  
  public NotebooksPageObject(WebDriver driver) {
    this.driver = driver;
  }
}
