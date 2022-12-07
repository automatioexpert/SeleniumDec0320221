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
public class RegisterAccount extends TestBase {

	@FindBy(id="ap_customer_name")
	WebElement yourName;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="ap_password_check")
	WebElement reenterPassword;
	
	@FindBy(id="continue")
	WebElement createAccountBtn;
	
	public RegisterAccount(){
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public void createNewAccount(String name, String emailid, String pass, String repass){
		yourName.sendKeys(name);
		email.sendKeys(emailid);
		password.sendKeys(pass);
		reenterPassword.sendKeys(repass);
		createAccountBtn.click();
	
	}
	
}
