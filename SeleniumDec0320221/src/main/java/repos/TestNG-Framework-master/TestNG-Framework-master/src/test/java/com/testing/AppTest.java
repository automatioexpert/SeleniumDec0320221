package com.testing;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pageobjects.ElementsPage;
import com.pageobjects.FormsPage;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.driver.Driver;
import com.pageobjects.HomePage;
import com.pageobjects.MenuPage;
import com.reporting.ExtentReporting;
import com.utils.JsonUtils;
import com.utils.LoggersUtils;
import com.utils.SeleniumUtils;

/**
 * Unit test for simple App.
 */
public class AppTest {

	WebDriver driver;
	ExtentReporting extentReporting;
	JsonUtils jsonData;
	SeleniumUtils seleniumUtils;
	Driver d;
	
	HomePage homePage;
	ElementsPage elementsPage;
	FormsPage formsPage;

	@BeforeClass
	public void beforeClass() {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-ss");
		    System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	
	@BeforeTest
	public void beforeTest() throws ClassNotFoundException {
		jsonData = new JsonUtils("AppTest");
		d = new Driver();
		driver = d.getDriver();
		LoggersUtils.getInstance(AppTest.class);
		extentReporting = new ExtentReporting("AppTest");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = d.getWebdriver(jsonData.getConfigData("browser"));
		LoggersUtils.getLog().info("Test input");
		seleniumUtils = new SeleniumUtils(driver, extentReporting);
		// Page Objects
		homePage = new HomePage(driver, seleniumUtils, extentReporting);
		elementsPage = new ElementsPage(driver, seleniumUtils, extentReporting);
		formsPage = new FormsPage(driver, seleniumUtils, extentReporting);

		driver.manage().window().maximize();
		driver.get(jsonData.getConfigData("url"));
	}

	@Test(description = "Select Elements Menu")
	public void TC_001() throws Exception {
		JSONObject data = jsonData.getTestDataJsonObject();
		extentReporting.createTestCase("Tools QA TC001");
		
		extentReporting.logTestSteps(Status.INFO, "Sucessfully opened the website");
		homePage.navigateToMenusPage("Elements");
		Assert.assertTrue(elementsPage.validateHeader());
	}

	@Test
	public void TC_002() throws IOException {
		extentReporting.createTestCase("Open Forms Link TC002");
		extentReporting.logTestSteps(Status.PASS, "Sucessfully opened 2nd website");
		homePage.navigateToMenusPage("Forms");
		Assert.assertTrue(formsPage.validateHeader());
		extentReporting.logTestStepWithScreenshot(driver, Status.WARNING, "Test Excersie");
	}

	@AfterMethod
	public void endDriver(ITestResult res, Method m) throws IOException {
		
		if(ITestResult.FAILURE == res.getStatus())
			extentReporting.logTestStepWithScreenshot(driver, Status.FAIL, m.getName()+" case failed due to:\n"+ res.getThrowable());
		else if(ITestResult.SKIP == res.getStatus())
			extentReporting.logTestStepWithScreenshot(driver, Status.SKIP, m.getName()+" case Skipped due to: \n"+ res.getThrowable());
		extentReporting.closeTest();
		driver.close();
	}

	@AfterTest
	public void afterTest() throws IOException {
		
		if(driver!= null)
			driver.quit();
	}
}
