package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategy;

public final class LandingPage extends BasePage{
	
	private final By myAccountDropDown=By.xpath("//span[contains(text(),'My Account')]");
	private final By loginOption=By.xpath("//a[contains(text(),'Login')]");
	
	public LandingPage myAccountDropDown() {
		click(myAccountDropDown, WaitStrategy.PRESENCE, "Click myAccountDropDown");
		return this;		
	}
		
	public LoginPage loginOption() {
		click(loginOption, WaitStrategy.CLICKABLE, "LoginButton");
		return new LoginPage();
	}	
}
