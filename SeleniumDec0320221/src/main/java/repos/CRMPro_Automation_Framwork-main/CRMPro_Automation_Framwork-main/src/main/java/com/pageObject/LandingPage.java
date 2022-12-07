package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.utils.ElementUtils;

public class LandingPage extends BasePage {

	By crmLog = By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']");
	@CacheLookup

	By userNameLabel = By.xpath("//input[@name='username']");
	@CacheLookup

	By userPasswordLabel = By.xpath("//input[@name='password']");
	@CacheLookup

	By loginBtn = By.xpath("//input[@type='submit']");
	
	By signUpLink = By.cssSelector("li:nth-child(2) > a");

	By pricingLink = By.xpath("//a[contains(text(),'Pricing')]");

	By featuresLink = By.xpath("//a[contains(text(),'Features')]");

	By customersLink = By.xpath("//a[contains(text(),'Customers')]");

	By contactLink = By.xpath("//a[contains(text(),'Contact')]");	

    By mouseLink = By.xpath ("//span[@class='mouse']");

	By interactionChat = By.xpath("//div[@class='intercom-lightweight-app-launcher-icon intercom-lightweight-app-launcher-icon-open']");
	
	By carouselRightBtn = By.xpath("//button[@class='right carousel-control skrollable skrollable-between']");
	
	By carouselLeftBtn = By.xpath("//button[@class='left carousel-control skrollable skrollable-between']");
	
	By forgetPassword = By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	By goTopArrow = By.xpath("//a[normalize-space()='Go Top']");
	
	By footer = By.cssSelector("body section[id='footer'] div div div:nth-child(1)\"))");

	public LandingPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String validateHomePageTitle() {
		return getDriver().getTitle();
	}

	public Boolean validateCRMImage() {
		ElementUtils.waitForElementPresence(getDriver(), crmLog, 5);
		return getDriver().findElement(crmLog).isDisplayed();
	}

	public WebElement verifyUserName() {
		return ElementUtils.waitForElementPresence(getDriver(), userNameLabel, 30);
	}
	
	public WebElement verifyLoginBtn() {
		return ElementUtils.waitToBeClickable(getDriver(), loginBtn, 30);
	}

	public WebElement verifyUserPassword() {
		return ElementUtils.waitForElementPresence(getDriver(), userPasswordLabel, 30);
	}

	public WebElement verifyclickMouseLink() {
		return ElementUtils.waitForElementPresence(getDriver(), mouseLink, 30);
	}
	
	public WebElement verifyclickCarouselRightBtn() {
		return ElementUtils.waitForElementPresence(getDriver(), carouselRightBtn, 30);
	}
	
	public WebElement verifyclickCarouselLeftBtn() {
		return ElementUtils.waitForElementPresence(getDriver(), carouselLeftBtn, 30);
	}
	
	public WebElement verifyChatIcon() {
		return ElementUtils.waitForElementPresence(getDriver(), interactionChat, 30);
	}	
	
	public WebElement verifySignUpLink() {
		return ElementUtils.waitForElementPresence(getDriver(), signUpLink, 30);		
	}

	public SignUpPage clickOnSignUpLink() {		
		verifySignUpLink().click();		
		return new SignUpPage();
	}
	
	public WebElement verifyPricingLink() {
		return ElementUtils.waitForElementPresence(getDriver(), pricingLink, 30);		
	}

	public void clickOnPricingLink() {
		verifyPricingLink().click();				
	}

	public void clickOnFeaturesLink() {
		
	}

	public void clickOnCustomersLink() {
		
	}

	public void clickOnContactsLink() {
			
	}
	
	public WebElement clickforgetPasswordLink() {
		return ElementUtils.waitForElementPresence(getDriver(), forgetPassword, 30);		
	}	
	
	public WebElement clickGoTopBtn() {
	   return ElementUtils.waitForElementPresence(getDriver(), goTopArrow, 30);	
	}	
	
	public WebElement verifyFoorter() {
		return ElementUtils.waitForElementPresence(getDriver(), footer, 30);		
	}
}
