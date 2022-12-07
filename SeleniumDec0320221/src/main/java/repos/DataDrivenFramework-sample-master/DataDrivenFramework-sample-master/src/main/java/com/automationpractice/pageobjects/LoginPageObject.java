package com.automationpractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automationpractice.utility.ConfigReader;
import com.automationpractice.utility.Log;

public class LoginPageObject {
	
	public LoginPageObject(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 
				Integer.parseInt(ConfigReader.getProperty("webDriverWaitTime"))), this);
	}
	
	@FindBy(name = "email_create")
	private WebElement createAccountEmail;
	
	@FindBy(name ="SubmitCreate")
	private WebElement createAccount_Button;
	
	@FindBy(name ="email")
	private WebElement registeredEmail;
	
	@FindBy(name ="passwd")
	private WebElement password;
	
	@FindBy(xpath ="//button[@name='SubmitLogin']")
	private WebElement login_Button;
	
	public void enterEmailToCreateAccount(String email) {
		Log.info("Entering from Login Page");
		createAccountEmail.sendKeys(email);
	}
	
	public void clickOnCreateAccountButton() {
		createAccount_Button.click();
	}

	public void enterEmailToSignin(String email) {
		registeredEmail.clear();
		registeredEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		login_Button.click();
	}
	
}
