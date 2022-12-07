package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import reportConfig.VerificationFailures;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
  protected WebDriver driver;
  protected final Log log;
  
  protected BaseTest() {
    log = LogFactory.getLog(getClass());
  }
  
  public WebDriver getDriver() {
    return this.driver;
  }
  
  public WebDriver getBrowserDriver(String browserName, String appUrl){
    if (browserName.equals("firefox")){
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
      
    } else if( browserName.equals("chrome")){
      WebDriverManager.chromedriver().setup();
      File file = new File(GlobalConstants.PROJECT_PATH + "/browserExtensions/extension_1_6_6_0.crx");
      ChromeOptions options = new ChromeOptions();
      options.addExtensions(file);
      options.addArguments("--disable-infobars");
      options.addArguments("--disable-notification");
      options.addArguments("--disable-geolocation");
      
      Map<String, Object> prefs = new HashMap<String, Object>();
      prefs.put("credentials_enable_service", false);
      prefs.put("profile.password_manager_enabled", false);
      options.setExperimentalOption("prefs", prefs);
      
      driver = new ChromeDriver(options);
    }
  
    driver.manage().timeouts().implicitlyWait(GlobalConstants.SHORT_TIME, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(appUrl);
    return driver;
  }
  
  protected int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(999);
  }
  
  protected boolean verifyTrue(boolean condition) {
    boolean pass = true;
    try {
      Assert.assertTrue(condition);
      log.info(" -------------------------- PASSED -------------------------- ");
    } catch (Throwable e) {
      pass = false;
      log.info(" -------------------------- FAILED -------------------------- ");
      VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
      Reporter.getCurrentTestResult().setThrowable(e);
    }
    return pass;
  }
  
  protected boolean verifyFalse(boolean condition) {
    boolean pass = true;
    try {
      Assert.assertFalse(condition);
      log.info(" -------------------------- PASSED -------------------------- ");
    } catch (Throwable e) {
      pass = false;
      log.info(" -------------------------- FAILED -------------------------- ");
      VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
      Reporter.getCurrentTestResult().setThrowable(e);
    }
    return pass;
  }
  
  protected boolean verifyEquals(Object actual, Object expected) {
    boolean pass = true;
    try {
      Assert.assertEquals(actual, expected);
      log.info(" -------------------------- PASSED -------------------------- ");
    } catch (Throwable e) {
      pass = false;
      log.info(" -------------------------- FAILED -------------------------- ");
      VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
      Reporter.getCurrentTestResult().setThrowable(e);
    }
    return pass;
  }
  
  protected void cleanBrowserAndDriver() {
    String cmd = "";
    try {
      String osName = System.getProperty("os.name").toLowerCase();
      log.info("OS name = " + osName);
      
      String driverInstanceName = driver.toString().toLowerCase();
      log.info("Driver instance name = " + osName);
      
      if (driverInstanceName.contains("chrome")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
        } else {
          cmd = "pkill chromedriver";
        }
      } else if (driverInstanceName.contains("internetexplorer")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
        }
      } else if (driverInstanceName.contains("firefox")) {
        if (osName.contains("windows")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
        } else {
          cmd = "pkill geckodriver";
        }
      } else if (driverInstanceName.contains("edge")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
        } else {
          cmd = "pkill msedgedriver";
        }
      } else if (driverInstanceName.contains("opera")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
        } else {
          cmd = "pkill operadriver";
        }
      } else if (driverInstanceName.contains("safari")) {
        if (osName.contains("mac")) {
          cmd = "pkill safaridriver";
        }
      }
      
      if (driver != null) {
        driver.manage().deleteAllCookies(); // IE browser
        driver.quit();
        System.out.println("Close driver instance");
      }
    } catch (Exception e) {
      log.info(e.getMessage());
    } finally {
      try {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        System.out.println("Run command line");
        
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
