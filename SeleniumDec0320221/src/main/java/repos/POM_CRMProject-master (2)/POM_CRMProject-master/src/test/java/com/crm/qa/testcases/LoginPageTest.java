/**
 * 
 */
package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author anand acharya
 *
 */
public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest(){
		super(); //call test base constructor class
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		log.info("******************************** browser is opened ***************************************");
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitle(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** loginPageTitle ***************************************");
		extentTest = extent.startTest("loginPageTitle");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** loginPageTitle ***************************************");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** crmLogoImageTest ***************************************");
		extentTest = extent.startTest("crmLogoImageTest");
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** crmLogoImageTest ***************************************");
	}
	
	@Test(priority=3)
	public void loginTest(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** loginTest***************************************");
		extentTest = extent.startTest("loginTest");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** loginTest ***************************************");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			String screenshotPath = getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test case SKIPPED is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test case PASS is "+result.getName());
		}
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
		log.info("******************************** browser is closed ***************************************");
	}
	
}
