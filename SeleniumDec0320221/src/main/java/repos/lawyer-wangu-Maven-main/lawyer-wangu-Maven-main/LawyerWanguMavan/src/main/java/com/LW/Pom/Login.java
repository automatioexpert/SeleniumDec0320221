package com.LW.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	
	
	@FindBy(id="cn-accept-cookie")
	private WebElement accept_cookie ;
	
	@FindBy(xpath="//a[.=\"Log In\"]")
	private WebElement login;
	
	
	
	@FindBy(name="login_username")
	private WebElement untbx;
	@FindBy(name="login_password")
	private WebElement pwtxb;
	@FindBy(id="login_button")
	private WebElement lgbtn;
	
	
	
	@FindBy(xpath="//div[@id=\"logo\"]")
	private WebElement logo;
	
	//(//a[@title="Lawyer Wangu"])[1]
	

	public Login(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	
	
	public void setLogin(String un, String pw) {
		
		if (accept_cookie.isDisplayed()) {
			accept_cookie.click();
		}else
		{
			login.click();
		}
		login.click();
		untbx.sendKeys(un);
		pwtxb.sendKeys(pw);
		lgbtn.click();
		logo.click();
		
		
		
		}

}
