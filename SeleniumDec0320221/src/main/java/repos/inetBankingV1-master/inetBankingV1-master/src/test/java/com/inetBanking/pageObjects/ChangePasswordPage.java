package com.inetBanking.pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class ChangePasswordPage {
	WebDriver ldriver;

	public ChangePasswordPage(WebDriver rdriver) {
		PageFactory.initElements(rdriver, ldriver);
	}

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	@CacheLookup
	WebElement lnkChangePassword;

	@FindBy(name = "oldpassword")
	@CacheLookup
	WebElement oldPassword;

	@FindBy(name = "newpassword")
	@CacheLookup
	WebElement newPassword;

	@FindBy(name = "confirmpassword")
	@CacheLookup
	WebElement confirmPassword;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement btnSubmit;

	public void changePassword() {
		lnkChangePassword.click();
	}

	public void fillInChangePasswordForm(String oldPass, String newPass) {
		oldPassword.sendKeys(oldPass);
		newPassword.sendKeys(newPass);
		confirmPassword.sendKeys(newPass);
		btnSubmit.click();
	}

	public boolean isPageVisible() {
		try {
			BaseClass base = new BaseClass();
			base.waitForElement(oldPassword);
			return oldPassword.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
