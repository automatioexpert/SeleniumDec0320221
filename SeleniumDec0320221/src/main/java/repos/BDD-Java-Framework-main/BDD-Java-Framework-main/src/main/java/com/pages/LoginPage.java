package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By locators
	
	private By userName = By.id("email");
	private By password = By.id("passwd");
	private By loginButton = By.id("SubmitLogin");
	private By forgetPasswordLink = By.linkText("Forgot your password?111");
	
	//2. Constructor of the Page Class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page Actions
	
	public String getLoginPageTitle()	{
		return driver.getTitle();
	}
	
	public boolean validateForgotPasswordLink() {
		return driver.findElement(forgetPasswordLink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public AccountPage doLogin(String un, String pwd) {
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new AccountPage(driver);
	}
}
