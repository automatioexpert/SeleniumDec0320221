package com.inetBanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilites.Reporting;

public class TC_LoginTest_001 extends BaseClass {
	LoginPage lp;
	Reporting rep;

	@Test(priority = 0)
	public void loginCorrectUsernameAndPasswordValidation() {
		driver.get(baseURL);
		logger.info("URL is opened");

		lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter username");

		lp.setPassword(password);
		logger.info("Enter password");

		lp.clickSubmit();
	}

	@Test(priority = 1,description = "Validation of Tittle On e-Banking Home Page")
	public void verifyHomepageTitle() throws IOException {		
		boolean title=driver.getTitle().equals("Guru99 Bank Manager HomePage123");

		if (title==true) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
//			Reporting.TakeScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
	}
	
	@Test(priority = 2, description = "Validation of Logo On Bank Home Page")
	public void BankLogoValidation() throws Exception {
		
		boolean LogTest = lp.LogoPresent();
		Assert.assertTrue(LogTest, "Logo is not present in e-banking Application");
		
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
	}

	/*
	 * @Test(priority = 2) public void BankLogoValidation() {
	 * 
	 * //boolean img =
	 * driver.findElement(By.xpath("//img[@src='/logo.png']")).isDisplayed();
	 * boolean img=driver.getPageSource().contains("Demo Site");
	 * 
	 * if (img == true) { Assert.assertTrue(true); } else {
	 * Assert.assertFalse(false); } Reporting rep = new Reporting();
	 * rep.test.assignAuthor("Hassen").assignCategory("Login Test"); }
	 */
	
	@Test(priority = 3)
	public void loginNoUserIDValidation() throws IOException {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		
		driver.get(baseURL);
		logger.info("URL is opened");

		lp =new LoginPage(driver);
		lp.setUserName(" ");
		logger.info("Enter Empty username");

		lp.setPassword(password);
		logger.info("Enter password");

		lp.clickSubmit();
		
		isAlertPresent();
		closeAlertAndGetText();
		
	}
	@Test(priority = 4)
	public void loginNoPasswordValidation() throws IOException {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		
		driver.get(baseURL);
		logger.info("URL is opened");

		lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter username");

		lp.setPassword(" ");
		logger.info("Enter Empty password");

		lp.clickSubmit();
		
		isAlertPresent();
		closeAlertAndGetText();
			
	}
	@Test(priority = 5)
	public void loginNoUseNameNoPasswordValidation() throws IOException {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		
		driver.get(baseURL);
		logger.info("URL is opened");

		lp =new LoginPage(driver);
		lp.setUserName(" ");
		logger.info("Enter Empty username");

		lp.setPassword(" ");
		logger.info("Enter Empty password");

		lp.clickSubmit();
		
		isAlertPresent();
		closeAlertAndGetText();		
		
	}
	
	@Test(priority = 6)
	public void loginButtonClickValidation() throws IOException {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		
		driver.get(baseURL);
		logger.info("URL is opened");

		lp =new LoginPage(driver);
		
		lp.clickSubmit();
		
		isAlertPresent();
		closeAlertAndGetText();		
		
	}
	@Test(priority = 7)
	public void loginResetButtonClickValidation() throws IOException {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		
		driver.get(baseURL);
		logger.info("URL is opened");

		lp =new LoginPage(driver);
		
		lp.clickReset();
		
		isAlertPresent();	
		
	}
	/*
	 * @Test(priority = 8)
	 * 
	 * @Override public void validateInvalidLinks() { super.validateInvalidLinks();
	 * rep.test.assignAuthor("Hassen").assignCategory("Login Test"); }
	 * 
	 * @Test(priority = 9)
	 * 
	 * @Override public void verifyURLStatus(String URL) {
	 * super.verifyURLStatus(URL);
	 * rep.test.assignAuthor("Hassen").assignCategory("Login Test"); }
	 */
	@Test(priority = 8)
	public void verifyLinks() {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		super.verifyLinks();
		}
	@Test(priority = 9)
	public void verifyLinkActive() {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		super.verifyLinkActive();
		}
}
