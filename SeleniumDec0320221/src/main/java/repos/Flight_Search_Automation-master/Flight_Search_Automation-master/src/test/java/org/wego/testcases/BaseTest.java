package org.wego.testcases;

import com.aventstack.extentreports.Status;

import org.testng.annotations.AfterSuite;

import org.wego.driver.DriverProvider;
import org.wego.reporter.ReportManager;
import org.wego.utility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;


public class BaseTest extends ReportManager {

    private final String baseUrl = ApplicationConfig.getBaseUrl();
    public WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverProvider.getDriver();
        driver.get(baseUrl);
    }


    @AfterSuite
    public void exit() {
        DriverProvider.quitDriver();
    }

    public void reportLog(String message) {
        if (test != null) {
            test.log(Status.INFO, message);
        }

    }
}
