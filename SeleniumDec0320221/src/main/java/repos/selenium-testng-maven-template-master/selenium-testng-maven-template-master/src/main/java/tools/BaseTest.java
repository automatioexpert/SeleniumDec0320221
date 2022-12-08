package tools;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import pages.google.GoogleLandingPage;

public abstract class BaseTest {

  private WebDriver driver;

  public void setUp(@Optional("local-ff") String browser) {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    driver = DriverFactory.getInstance().getDriver(browser);
  }

  public void tearDown() {
    driver.quit();
    driver = null;
  }

  /**
   * This method is protected to restrict changing the driver instance.
   *
   * @return instance of {@link WebDriver}
   */
  protected WebDriver getDriver() {
    return driver;
  }


  protected GoogleLandingPage getGoogleLandingPage() {
    getDriver().get(Config.getInstance().getUrl());

    return new GoogleLandingPage(getDriver());
  }
}
