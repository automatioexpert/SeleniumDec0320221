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
import org.testng.annotations.DataProvider;
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
public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	Logger log = Logger.getLogger(ContactsPageTest.class);
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		log.info("******************************** browser is opened ***************************************");
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();	
	}
	
	@Test(priority=2)
	public void verifyContactPageLabel(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** verifyContactPageLabel ***************************************");
		extentTest = extent.startTest("verifyContactPageLabel");
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing on the page");
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** verifyContactPageLabel ***************************************");
	}
	
	@Test(priority=3)
	public void selectSingleName(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** selectSingleName ***************************************");
		extentTest = extent.startTest("selectSingleName");
		contactsPage.selectContactsByName("testa 123");
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** selectSingleName ***************************************");
	}
	
	@Test(priority=4)
	public void selectMultipleName(){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** selectMultipleName ***************************************");
		extentTest = extent.startTest("selectMultipleName");
		contactsPage.selectContactsByName("testa 1");
		contactsPage.selectContactsByName("testb 2");
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** selectMultipleName ***************************************");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		log.info("******************************** starting test case ***************************************");
		log.info("******************************** validateCreateNewContact ***************************************");
		extentTest = extent.startTest("validateCreateNewContact");
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		log.info("******************************** ending test case ***************************************");
		log.info("******************************** validateCreateNewContact ***************************************");
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
