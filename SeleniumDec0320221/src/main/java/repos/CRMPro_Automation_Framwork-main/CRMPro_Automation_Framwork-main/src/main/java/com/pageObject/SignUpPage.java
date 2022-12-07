package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.utils.ElementUtils;

public class SignUpPage extends BasePage {

	By CRMLog = By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']");
	@CacheLookup
		
	@FindBy(xpath="//select[@id='payment_plan_id']") 
	
	private WebElement edition;
	
	@FindBy(xpath="//div[@id='editionText']") 
	@CacheLookup 
	private WebElement selectEditionAbove;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement FirstName;

	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement LastName;

	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement Email;

	@FindBy(xpath="//input[@placeholder='Confirm Email']")
	WebElement ConfirmEmail;

	@FindBy(xpath="//input[@placeholder='Username']") 
	WebElement Username;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//form[@id='multipleForm']//div//span") 
	@CacheLookup 
	private WebElement allFieldsAreRequired;
	
	@FindBy(xpath="//input[@name='agreeTerms']")
	WebElement agreeTerms;
	
	@FindBy(xpath="//div[@class='myButton']")
	WebElement myButton;
	
	@FindBy(xpath="//a[normalize-space()='Forgot Password?']")
	WebElement ForgotPassword;
	
	public SignUpPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateLoginPageTitle() {
		return getDriver().getTitle();
	}

	public Boolean validateCRMImage() {
		ElementUtils.waitForElementPresence(getDriver(), CRMLog, 5);
		return getDriver().findElement(CRMLog).isDisplayed();
	}
}
