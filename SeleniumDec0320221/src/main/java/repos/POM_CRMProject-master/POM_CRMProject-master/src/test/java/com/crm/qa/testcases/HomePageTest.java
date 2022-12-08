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
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author anand acharya
 *
 */
public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	Logger log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("******************************** browser is opened ***************************************");
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** verifyHomePageTitleTest ***************************************");
		extentTest = extent.startTest("verifyHomePageTitleTest");
		String homePageTitle = homePage.verifyHomePageTitle();
		log.info("Home page title is: "+homePageTitle);
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** verifyHomePageTitleTest ***************************************");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** verifyUserNameTest ***************************************");
		extentTest = extent.startTest("verifyUserNameTest");
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** verifyUserNameTest ***************************************");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** verifyContactsLinkTest ***************************************");
		extentTest = extent.startTest("verifyContactsLinkTest");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** verifyContactsLinkTest ***************************************");
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
