/**
 * 
 */
package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

/**
 * @author anand acharya
 *
 */
public class SignInPage extends TestBase {

	//PageFactor OR
	@FindBy(id="createAccountSubmit")
	WebElement createAccount;
	
	//initilaizie
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public RegisterAccount clickCreateAccount(){
		createAccount.click();
		return new RegisterAccount();
	}
}
