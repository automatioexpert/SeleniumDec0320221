package com.LW.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	
	
	@FindBy(id="cn-accept-cookie")
	private WebElement accept_cookie ;
	
	@FindBy(xpath="//a[.=\"Create Free Account\"]")
	private WebElement CreateFreeAccount ;
	
	@FindBy(id="username")
	private WebElement UsernameField;
	
	@FindBy(id="reg_mobile")
	private WebElement MobileField;
	
	
	@FindBy(id="reg_email")
	private WebElement emailField;
	
	@FindBy(id="reg_password")
	private WebElement PasswordField;
	
	@FindBy(id="con_password")
	private WebElement ConfpasswordField;
	
	
	@FindBy(id="recaptcha-anchor")
	private WebElement recaptcha;
	
	public CreateAccount(WebDriver driver) 
	   {
		PageFactory.initElements(driver, this);	
		}
	
	public void Details() 
	{
		accept_cookie.click();
		CreateFreeAccount .click();
		UsernameField.sendKeys("SanjayQA");
		MobileField.sendKeys("9988552255");
		emailField.sendKeys("sanjay@gmail.com");
		PasswordField.sendKeys("Abhaymm123");
		ConfpasswordField.sendKeys("Abhaymm123");
		recaptcha.click();
		

}
	}
