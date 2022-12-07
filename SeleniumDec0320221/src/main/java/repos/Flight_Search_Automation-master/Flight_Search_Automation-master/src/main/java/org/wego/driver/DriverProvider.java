package org.wego.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.wego.utility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browser;
        if (System.getProperty("browser") == null) {
            browser = ApplicationConfig.getDefaultBrowser();
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

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ApplicationConfig.getDefaultPageTimeout()));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ApplicationConfig.getDefaultImplicitWait()));
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
