package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage {
  WebDriver driver;
  
  public ProductReviewPageObject(WebDriver driver) {
    this.driver = driver;
  }
  
  public String getReviewSuccessMessage() {
    waitForElementVisible(driver, ProductReviewPageUI.REVIEW_SUCCESS_MESSAGE);
    return getTextElement(driver, ProductReviewPageUI.REVIEW_SUCCESS_MESSAGE);
  }
  
  public void selectToRatingRadioButton(String radioButtonID) {
    waitForElementClickable(driver, ProductReviewPageUI.RATING_RADIO_BUTTON_BY_ID, radioButtonID);
    checkTheCheckboxOrRadio(driver, ProductReviewPageUI.RATING_RADIO_BUTTON_BY_ID, radioButtonID);
  }
}
