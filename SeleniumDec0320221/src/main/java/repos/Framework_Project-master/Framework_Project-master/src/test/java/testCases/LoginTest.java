package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.AccountPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	Logger log;
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	@Test(priority=1)
	public void login() {
		
		LandingPage landingPage = new LandingPage();
		landingPage.myAccountDropDown().click();
		log.debug("Clicked on my Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on my Login option");
		
		LoginPage loginPage=new LoginPage();
		loginPage.emailAddressTextField().sendKeys(prop.getProperty("email"));
		log.debug("Email got entered");
		loginPage.passwordField().sendKeys(prop.getProperty("password"));
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		
		AccountPage account=new AccountPage();
		Assert.assertTrue(account.editYourAccountInformation().isDisplayed());
		account.editYourAccountInformation().click();
		log.debug("Clicked on edit Account inforamtion link");
	}
	@Test(priority=2, dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
		
		LandingPage landingPage = new LandingPage();
		landingPage.myAccountDropDown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		Thread.sleep(3000);
	
		LoginPage loginPage = new LoginPage();
		loginPage.emailAddressTextField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		
		AccountPage accountPage = new AccountPage();
		
		String acutualResult = null;
		
		try {
			if(accountPage.editYourAccountInformation().isDisplayed()) {
			   log.debug("User got logged in");
			   acutualResult = "Success";
			}
			
		}catch(Exception e) {
			log.debug("User didn't log in");
			acutualResult = "Failure";
		}
		
		if(acutualResult.equals(expectedResult)) {
			log.info("Login Test got passed");
			Assert.assertEquals(acutualResult, expectedResult);
			
		}else {
			log.error("Login Test got failed");
		} 
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"arun.selenium@gmail.com","Second@123","Success"},{"dummy@test.com","1234","Failure"}};
		return data;
	}
}