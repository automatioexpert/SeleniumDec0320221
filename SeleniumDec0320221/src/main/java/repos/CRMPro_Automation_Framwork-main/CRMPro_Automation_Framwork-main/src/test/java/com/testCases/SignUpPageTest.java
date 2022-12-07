package com.testCases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.listeners.Listener;
import com.pageObject.LandingPage;
import com.pageObject.SignUpPage;
import com.utils.TestUtil;

public class SignUpPageTest extends BasePage{
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
    Logger log;
	
    public LandingPage landingPage;
    public SignUpPage signUpPage;
     
    public SignUpPageTest() {
		super();
	}
    
    @BeforeMethod(alwaysRun = true)	//this method will be executed before every @test method
    @Parameters(value={"browser"})
	public void setUP(String browser) {
    	log = LogManager.getLogger(SignUpPageTest.class.getName());
    	
    	String browserName = null;
    	basePage=new BasePage();	
        prop = basePage.initializeProperties();
		
		if (browser == null) {
			prop.setProperty("browser", browser);
		}else {
			browserName = browser;		
		}
		driver = basePage.initializeBrowser(browserName);
		log.info("****************************** Browser is launched *****************************************");
		
        log.debug("Browser got launched");
    	driver.get(prop.getProperty("url"));
    	log.debug("Navigated to application URL");
    	
    	landingPage=new LandingPage();
		signUpPage=landingPage.clickOnSignUpLink();
		TestUtil.multipleChildWinows();
	}
    
    @Test(priority=1)
	public void loginPageTitleTest() {
        log.info("****************************** Starting Test Case loginPageTitleTest *****************************************");
    	
    	Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in SignUpPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo Started loginPageTitleTest Method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("SignUpPage Test");
   		
		String title = signUpPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM - CRM Pro for customer relationship management, sales, and support", "Home Page Title does not Matche");
    			
		System.out.println(title); 
		
		log.info("****************************** Ending Test Case loginPageTitleTest *****************************************");
	}
		
	@Test(priority=2)
	public void verifyCRMLogo() {
        log.info("****************************** Starting Test Case verifyCRMLogo *****************************************");
    	
    	Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in SignUpPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo Started verifyCRMLogo Method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("SignUpPage Test");
   		
   		Boolean b = landingPage.validateCRMImage();
		Assert.assertTrue(b);	
		
		log.info("****************************** Ending Test Case verifyCRMLogo *****************************************");
	}
	
	@AfterMethod(alwaysRun = true) //--this method will be executed after every test method
	public void tearDown() {
    	driver.close();
		if (driver != null) {
			driver.quit();
		}
	log.info("****************************** Browser is Closed *****************************************");
  }
}
