package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategy;

public final class LoginPage extends BasePage{

	private final By textboxemail=By.xpath("//input[@id='input-email']");
	private final By textboxPassword=By.xpath("//input[@id='input-password']");
	private final By buttonLogin =By.xpath("//input[@type='submit']");
	
	public LoginPage enterEmailAddress(String email) {
		sendKeys(textboxemail, WaitStrategy.PRESENCE, email, "E-mail Address");
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		sendKeys(textboxPassword, WaitStrategy.PRESENCE, password, "Password");
		return this;
	}
	
	public AccountPage clicklogin() {
		click(buttonLogin, WaitStrategy.CLICKABLE, "Login Button");
		return new AccountPage();
	}
}
