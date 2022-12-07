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

import com.base.BasePage;
import com.pageObject.LandingPage;
import com.pageObject.LoginPage;

public class LoginPageTest extends BasePage{
	public WebDriver driver;
	public Properties prop;
    Logger log;
    
	LoginPage loginPage;
	LandingPage landingPage;
		
	//Initializing PageFactory
	public LoginPageTest() {
		super();   //Call the Constructor of the Super class - TestBase
	}
	
	@BeforeMethod(alwaysRun = true)	//this method will be executed before every @test method
    @Parameters(value={"browser"})
	public void setUP(String browser) {
    	log = LogManager.getLogger(LandingPageTest.class.getName());
    	
    	String browserName = null;
		prop = initializeProperties();
		if (browser == null) {
			prop.setProperty("browser", browser);
		}else {
			browserName = browser;		
		}
		driver = initializeBrowser(browserName);
		loginPage = new LoginPage();	
	}
				
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.", "Home Page Title does not Matche");
    			
		System.out.println(title); 
	}
		
	@Test(priority=2)
	public void CRMLogoImageTest() {
		Boolean b = loginPage.validateCRMImage();
		Assert.assertTrue(b);
	}
		
	@Test(priority=3)
	public void loginTest() {
		landingPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
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
