package org.qa.sharif.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qa.sharif.commonutils.AppConfig;
import java.util.concurrent.TimeUnit;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browser;
        if (System.getProperty("browser") == null) {
            browser = AppConfig.getDefaultBrowser();
        } else {
            browser = System.getProperty("browser");
        }

        if (driver == null) {
            if (browser.equalsIgnoreCase("CHROME")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("FIREFOX")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException(browser + " is not currently covered by automation");
            }

            driver.manage().timeouts().pageLoadTimeout(AppConfig.getDefaultPageTimeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(AppConfig.getDefaultElementTimeOut(), TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(AppConfig.getDefaultScriptTimeout(), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
