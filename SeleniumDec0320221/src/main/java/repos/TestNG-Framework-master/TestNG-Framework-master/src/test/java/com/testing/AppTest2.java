package com.testing;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.driver.Driver;
import com.pageobjects.HomePage;
import com.pageobjects.MenuPage;
import com.reporting.ExtentReporting;
import com.utils.JsonUtils;
import com.utils.SeleniumUtils;

/**
 * Unit test for simple App.
 */
public class AppTest2 {

	WebDriver driver;
	ExtentReporting ex;
	JsonUtils jsonData;
	SeleniumUtils sel;
	Driver d;
	String browserName;

	HomePage hp;
	MenuPage mp;

	@BeforeTest
	public void beforeTest() throws ClassNotFoundException {
		jsonData = new JsonUtils("AppTest2");
		d = new Driver();
		driver = d.getDriver();
		ex = new ExtentReporting("AppTest2");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = d.getWebdriver(jsonData.getConfigData("browser"));
		browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase();
		sel = new SeleniumUtils(driver, ex);
		// Page Objects
		hp = new HomePage(driver, sel, ex);
		mp = new MenuPage(driver, sel, ex);

		driver.manage().window().maximize();
		driver.get(jsonData.getConfigData("url"));
	}

	@Test
	public void TC_001() throws Exception {
		ex.createTestCase("Toolsqa Demo site TC001", "Kaushik", "Regression", browserName);
		ex.logTestSteps(Status.INFO, "Sucessfully opened the website.. and automation is started...");
		hp.navigateToMenusPage("Alerts");

		String streetAddress = "Seidengasse 44, 1070 Wien, Austria";
		mp.verifyMenuPage();
		mp.enterStreetAddress(streetAddress);
		String menuName = "Avocado Crush Burrito";
		mp.selectMenu(menuName);
		String items = "HOT: Mango & Chili Salsa";
		ArrayList<String> extras = new ArrayList<String>();
		extras.add("Extra Tomaten-Paprika Mix");
		extras.add("Extra Cheeeese");
		extras.add("Nachos mit Creme Fraiche");
		mp.selectMenuItems(items, extras);
		Assert.assertTrue(true);
	}

	@Test
	public void TC_002() throws IOException {
		ex.createTestCase("ClubKitchen TC002", "Rakesh", "Sanity Suite", browserName);
		ex.logTestSteps(Status.INFO, "Sucessfully opened 2nd website");
		hp.navigateToMenusPage("Widgets");
		Assert.assertTrue(true);
		ex.logTestStepWithScreenshot(driver, Status.WARNING, "Test Excersie 2");
	}

	@AfterMethod
	public void endDriver(ITestResult res, Method m) throws IOException {
		
		if(ITestResult.FAILURE == res.getStatus())
			ex.logTestStepWithScreenshot(driver, Status.FAIL, m.getName()+" case failed due to:\n"+ res.getThrowable());
		else if(ITestResult.SKIP == res.getStatus())
			ex.logTestStepWithScreenshot(driver, Status.SKIP, m.getName()+" case Skipped due to: \n"+ res.getThrowable());
		ex.closeTest();
		driver.close();
	}

	@AfterTest
	public void afterTest() throws IOException {
		
		if(driver!= null)
			driver.quit();
	}
}
