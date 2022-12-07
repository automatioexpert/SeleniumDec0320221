package com.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class LoginPage extends BasePage{

	//Load PageFactory(OR - Object Repository)
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up']")
	WebElement signUpBtn;

	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement freeCRMLogo;

	//Initializing PageFactory
	public LoginPage() {
		PageFactory.initElements(getDriver(), this); //this --> points to current class object.
	}

	public String validateLoginPageTitle() {
		return getDriver().getTitle();
	}

	public Boolean validateCRMImage() {
		return freeCRMLogo.isDisplayed();
	}

	public LandingPage login(String uname , String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();

		return new LandingPage(); //LandingPage is the landing page for LoginPage
	}
}

