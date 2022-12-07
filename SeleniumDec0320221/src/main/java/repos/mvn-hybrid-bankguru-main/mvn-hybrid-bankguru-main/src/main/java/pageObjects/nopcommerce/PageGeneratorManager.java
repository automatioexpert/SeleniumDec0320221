package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
  public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
    return new RegisterPageObject(driver);
  }
  
  public static LoginPageObject getLoginPageObject(WebDriver driver) {
    return new LoginPageObject(driver);
  }
  
  public static HomePageObject getHomePageObject(WebDriver driver) {
    return new HomePageObject(driver);
  }
  
  public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
    return new MyAccountPageObject(driver);
  }
  
  public static CameraPhotoPageObject getCameraPhotoPageObject(WebDriver driver) {
    return new CameraPhotoPageObject(driver);
  }
  
  public static ProductReviewPageObject getProductReviewPageObject(WebDriver driver) {
    return new ProductReviewPageObject(driver);
  }
  
  public static SearchPageObject getSearchPageObject(WebDriver driver) {
    return new SearchPageObject(driver);
  }
  
  public static NotebooksPageObject getNotebooksPageObject(WebDriver driver) {
    return new NotebooksPageObject(driver);
  }
}
