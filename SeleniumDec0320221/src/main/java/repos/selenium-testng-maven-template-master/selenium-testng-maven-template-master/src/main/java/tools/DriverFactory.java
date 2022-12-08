package tools;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

  private DriverFactory() {
  }

  private static DriverFactory instance = new DriverFactory();

  public static DriverFactory getInstance() {
    return instance;
  }

  public WebDriver getDriver(String browser) {
    DesiredCapabilities capabilities;

    if (browser.equals("local-ff")) {
      setupGecko();
      FirefoxOptions firefoxOptions = new FirefoxOptions();
      return new FirefoxDriver(firefoxOptions);
    }

    if (browser.equals("local-chrome")) {
      ChromeOptions chromeOptions = new ChromeOptions();
      capabilities = DesiredCapabilities.chrome();
      capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
          UnexpectedAlertBehaviour.DISMISS);
      chromeOptions.merge(capabilities);
      return new ChromeDriver(chromeOptions);
    }

    if (browser.equals("local-safari")) {
      SafariOptions safariOptions = new SafariOptions();
      capabilities = DesiredCapabilities.safari();
      capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
          UnexpectedAlertBehaviour.DISMISS);
      safariOptions.merge(capabilities);
      return new SafariDriver(safariOptions);
    }

    switch (browser) {
      case "firefox":
      default:
        setupGecko();
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
            UnexpectedAlertBehaviour.DISMISS);
        break;
      case "chrome":
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
            UnexpectedAlertBehaviour.DISMISS);
        break;
      case "safari":
        capabilities = DesiredCapabilities.safari();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
            UnexpectedAlertBehaviour.DISMISS);
        break;
    }

    WebDriver driver = new RemoteWebDriver(getGridHubUrl(), capabilities);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

    return driver;
  }

  public WebDriver getDriver() {
    return getDriver("local-ff");
  }

  private void setupGecko() {
    WebDriverManager driverManager = FirefoxDriverManager.firefoxdriver();
    driverManager.setup();
    System.out
        .println(String.format("FF driver version : %s", driverManager.getDownloadedVersion()));
  }

  private URL getGridHubUrl() {
    URL hub = null;
    try {
      hub = new URL(Config.getInstance().getProperty("gridhub"));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return hub;
  }
}
