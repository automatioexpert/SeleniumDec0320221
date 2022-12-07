package org.qa.sharif.testcases;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.qa.sharif.commonutils.AppConfig;
import org.qa.sharif.driver.DriverProvider;
import org.qa.sharif.pageobjectrepisotory.CurrencyExchangeCalculatorPage;
import org.qa.sharif.pageobjectrepisotory.CurrencyTable;
import org.qa.sharif.reporter.ReportManager;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;


public class BaseTestClass extends ReportManager {
    private final String baseUrl = AppConfig.getBaseUrl();
    public WebDriver driver;
    public CurrencyExchangeCalculatorPage currencyExchangeCalculatorPage;
    public CurrencyTable currencyTable;
    public SoftAssert softVerify;

    @BeforeClass
    public void init() {
        driver = DriverProvider.getDriver();
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void methodInit(Method m) {
        log = LogManager.getLogger(this.getClass().getName() + ":" + m.getName());
    }

    @AfterSuite
    public void exit() {
        DriverProvider.quitDriver();
    }

    public void reportLog(String message) {
        test.log(Status.INFO, message);
        log.info(message);
    }


}
