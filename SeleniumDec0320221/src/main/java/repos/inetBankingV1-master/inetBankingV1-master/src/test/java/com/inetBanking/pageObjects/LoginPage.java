package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement btnReset;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
    private WebElement welcomePageMessage;
	
	@FindBy(xpath = "//img[@src='/logo.png']")
	WebElement Logo;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickReset() {
		btnReset.click();
	}
	
	public String getMessage(){
        return welcomePageMessage.getText();
    }
	public boolean LogoPresent() {
		return Logo.isDisplayed();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
