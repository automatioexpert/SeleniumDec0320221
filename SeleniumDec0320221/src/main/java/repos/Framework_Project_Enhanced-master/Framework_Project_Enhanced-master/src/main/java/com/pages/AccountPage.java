package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategy;

public final class AccountPage extends BasePage {
	
	private final By AccountDropDown=By.xpath("//span[contains(text(),'My Account')]");
	private final By linkLogout=By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li//a[contains(text(),'Logout')]");	
	private final By editAccountLink=By.xpath("//a[contains(text(),'Edit your account information')]");
	
	public AccountPage clickeditYourAccountInformation() {
		click(editAccountLink, WaitStrategy.CLICKABLE, "Edit Account Informations");
		return this;		
	}
	
	public AccountPage clickDropDown() {
		click(AccountDropDown, WaitStrategy.PRESENCE, "clickDropDown ");
		return this;
	}
	
	public LogoutPage clickLogout() {		
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout button");
		return new LogoutPage();
	}
}
