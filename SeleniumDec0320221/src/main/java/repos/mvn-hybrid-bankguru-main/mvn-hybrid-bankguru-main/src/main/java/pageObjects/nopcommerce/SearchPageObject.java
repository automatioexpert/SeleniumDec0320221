package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.SearchPageUI;

public class SearchPageObject extends BasePage {
  WebDriver driver;
  
  public SearchPageObject(WebDriver driver) {
    this.driver = driver;
  }
  
  public String getMessageAtSearchResults() {
    waitForElementVisible(driver, SearchPageUI.SEARCH_RESULTS_MESSAGE);
    return getTextElement(driver, SearchPageUI.SEARCH_RESULTS_MESSAGE);
  }
  
  public void clickToSearchButton() {
    waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
    clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
  }
  
  public int getProductsSizeDisplayed() {
    return getElementsSize(driver, SearchPageUI.PRODUCT_TITLE);
  }
}
