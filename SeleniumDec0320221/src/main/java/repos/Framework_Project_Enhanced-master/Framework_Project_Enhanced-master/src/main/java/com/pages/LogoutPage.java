package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategy;

public final class LogoutPage extends BasePage{
	
	private final By LogoutButton=By.xpath("//a[contains(text(),'Logout')]");

	public LandingPage clickLogout() {
		click(LogoutButton, WaitStrategy.CLICKABLE, "Logout Button");
		return new LandingPage();
	}
}
