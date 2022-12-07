package com.inetBanking.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.ChangePasswordPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_ChangePasswordTest_006 extends BaseClass {
	private String oldPassword = "1!";
	private String newPassword = "123456!";
	private String currentPassword = oldPassword;
	// TODO generator of Strings
	private String incorrectPassword = "abc";

	@Test()
	public void changePasswordIncorrect() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);

		ChangePasswordPage ch = new ChangePasswordPage(driver);
		ch.changePassword();

		changePasswordToNew(incorrectPassword, newPassword);
		Assert.assertTrue(isAlertPresent());
		Assert.assertTrue(ch.isPageVisible());
	}

	@Test(priority = 1)
	public void changePasswordCorrect() {
		ChangePasswordPage ch = new ChangePasswordPage(driver);
		ch.changePassword();

		changePasswordToNew(oldPassword, newPassword);
		Assert.assertTrue(isAlertPresent());
		currentPassword = newPassword;

		Assert.assertTrue(ch.isPageVisible());

	}

	@Test(priority = 2, dependsOnMethods = { "changePasswordCorrect" })
	public void logInWithNewPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);

		Assert.assertEquals(lp.getMessage(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@AfterClass
	public void changePasswordBack() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);

		changePasswordToNew(newPassword, oldPassword);
		currentPassword = oldPassword;

		isAlertPresent();
	}

	private void changePasswordToNew(String oldPass, String newPass) {
		ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
		changePasswordPage.fillInChangePasswordForm(oldPass, newPass);
	}

	public boolean isAlertPresent() {
		boolean isPresent = false;
		try {
			Alert alert = driver.switchTo().alert();
			isPresent = true;
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No alert found.");
		}
		return isPresent;
	}

}
