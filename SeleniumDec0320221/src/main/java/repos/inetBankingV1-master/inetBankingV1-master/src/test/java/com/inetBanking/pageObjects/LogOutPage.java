package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement lnkLogout;
	
	public LogOutPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void LogOut() {
		
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", lnkLogout);
    	
		//lnkLogout.click();
	}
	public static boolean isPageVisible() {
        return false;
    }
}
