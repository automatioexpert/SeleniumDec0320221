/**
 * 
 */
package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

/**
 * @author anand acharya
 *
 */
public class HomePage extends TestBase {

	
	//Page Factory - OR
	@FindBy(name="field-keywords")
	WebElement search;
	
	@FindBy(xpath="//div[@id='nav-tools']//a[@id='nav-link-yourAccount']")
	WebElement signInHover;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']/a")
	WebElement signInBtn;
	
	//Initialize the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String verifyTitle(){
		return driver.getTitle();
	}
	
	public void enterSearch(){
		search.sendKeys("preparing for interview");
	}
	
	public SignInPage clickSignIn(){
		Actions action = new Actions(driver);
		action.moveToElement(signInHover).build().perform();
		signInBtn.click();
		return new SignInPage();
	}
}
