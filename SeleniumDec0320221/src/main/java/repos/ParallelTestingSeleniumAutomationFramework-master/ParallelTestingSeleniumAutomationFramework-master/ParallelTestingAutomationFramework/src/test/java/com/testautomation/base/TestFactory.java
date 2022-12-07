package com.testautomation.base;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testautomation.extentreports.ExtentManager;
import com.testautomation.listener.ITestListenerImpl;
import com.testautomation.utilities.Configuration;
import com.testautomation.utilities.ExcelHandler;
import com.testautomation.utilities.PropertiesFileReader;
import com.testautomation.utilities.TestDataHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFactory {
	
	private static final Logger logger = LogManager.getLogger(TestFactory.class);
	
	public static WebDriver getDriver() {
		WebDriver driver = null;
		PropertiesFileReader configData = new PropertiesFileReader();
		Properties config = null;
		try {
			config = configData.getPropertyForConfig();

			switch (config.get("TestExecutionEnvironment").toString()) {
			case "LOCAL":
				if (config.get("Browser").equals("Chrome")) {
					// WebDriverManager.chromedriver().setup();
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
					logger.info("Lunched chrome browser ");
				} else if (config.get("Browser").equals("IE")) {
					WebDriverManager.iedriver().setup();
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capabilities.setCapability("ignoreZoomSetting", true);
					capabilities.setCapability("requireWindowFocus", true);// to move mouse manually
					driver = new InternetExplorerDriver();
				} else if (config.get("Browser").equals("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				break;

			case "GRID":
				break;

			default:
				logger.info("Invalid browser environment selected . . .");
			}
			driver.manage().window().maximize();
			driver.get(configData.getPropertyValue("app.url"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public void testHandler(String testStatus, WebDriver driver, ExtentTest extenttest, Throwable throwable,
			String testDataPath, String sheetName, String testCaseId) {

		switch (testStatus) {
		case "FAIL":
			throwable.printStackTrace();
			String screenShotForFail = null;
			try {
				screenShotForFail = ExtentManager.captureScreenShot(driver);
				extenttest.addScreenCaptureFromPath(screenShotForFail);
			} catch (IOException e) {
				e.printStackTrace();
			}
			extenttest.fail(MarkupHelper.createLabel("Test Case is failed : ", ExtentColor.RED));
			extenttest.fail(throwable.fillInStackTrace());
			driver.quit();
			if (testCaseId != null) {
				ExcelHandler.UpdateTestResultsToExcel(ExcelHandler.getValidExcelPath(testDataPath), sheetName,
						testStatus, testCaseId);
				logger.info("Updated test case status for " + testCaseId);
			}
			Assert.fail();
			break;

		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
			String screenShotForPass = null;
			try {
				screenShotForPass = ExtentManager.captureScreenShot(driver);
				extenttest.addScreenCaptureFromPath(screenShotForPass);
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.quit();
			if (testCaseId != null) {
				ExcelHandler.UpdateTestResultsToExcel(ExcelHandler.getValidExcelPath(testDataPath), sheetName,
						testStatus, testCaseId);
				logger.info("Updated test case status for " + testCaseId);
			}
			break;

		case "SKIP":
			break;

		default:
			break;
		}
	}

}