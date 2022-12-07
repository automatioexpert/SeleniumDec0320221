package com.LW.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	
	@FindBy(xpath="//a[.=\"Log In\"]")
	private WebElement login;

	public Logout(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void Setlogout() throws InterruptedException
	{
		
		SignOut.click();
	}
		public void logins() throws InterruptedException
		{
				
		login.click();
		Thread.sleep(1000);
	}
	
}


