package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.LogOutPage;
import com.inetBanking.utilites.Reporting;

public class TC_LogOutTest_007 extends BaseClass {
	Reporting rep;
	LogOutPage logout;

	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
	}

	@Test(priority = 1, description = "Validation of Logout On Bank Home Page")
	public void BankLogoutValidation() throws Exception {

		logout = new LogOutPage();
		logout.LogOut();
		isAlertPresent();

		isAlertPresent();
		//captureScreen(driver, "LogOutTest");
		rep.test.assignAuthor("Hassen").assignCategory("Log Out Test");
	}

	@AfterMethod
	public void logOutFromApp() {
		try {
			LogOutPage.isPageVisible();
		} catch (NoSuchElementException | TimeoutException e) {
			logout.LogOut();
		}
	}

	@Test
	@Override
	public void verifyLinks() {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		super.verifyLinks();
	}

	@Test(priority = 3)
	public void verifyLinkActive() {
		rep.test.assignAuthor("Hassen").assignCategory("Login Test");
		super.verifyLinkActive();
	}

}
