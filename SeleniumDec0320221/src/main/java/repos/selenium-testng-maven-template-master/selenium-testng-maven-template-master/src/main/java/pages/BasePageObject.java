package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class BasePageObject extends BasePage {

  protected WebElement container;

  public BasePageObject(WebElement element) {
    super(((WrapsDriver) element).getWrappedDriver());
    container = element;
  }
}
