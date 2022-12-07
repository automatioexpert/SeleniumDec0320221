package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CameraPhotoPageObject extends BasePage {
  WebDriver driver;
  
  public CameraPhotoPageObject(WebDriver driver) {
    this.driver = driver;
  }
}
