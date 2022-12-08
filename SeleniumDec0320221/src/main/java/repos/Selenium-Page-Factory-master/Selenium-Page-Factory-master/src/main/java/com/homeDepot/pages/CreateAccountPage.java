package com.homeDepot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.homeDepot.base.Base;

public class CreateAccountPage extends Base {

	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='email']")
	WebElement email;

	@FindBy(xpath="//input[@id='password-input-field']")
	WebElement password;

	@FindBy(xpath="//input[@id='zipCode']")
	WebElement zipcode;

	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;

	@FindBy(xpath="//div[@class='button' and @data-automation-id='registrationVerifyPhoneCheckBox']")
	WebElement phonecheckbox;

	@FindBy(xpath="//div[@class='button' and @data-automation-id='registrationIsProCheckBox']")
	WebElement loyaltycheckbox;

	@FindBy(xpath="//button[@class='bttn-outline bttn-outline--primary u--marginNormal-top' and @data-automation-id='registrationSignInButton']")
	WebElement signinbtn;

	public void infoForRegistration(String e, String p, String zp, String pn) {
		email.sendKeys(e);
		password.sendKeys(p);
		zipcode.sendKeys(zp);
		phone.sendKeys(pn);
		phonecheckbox.click();
		loyaltycheckbox.click();
		signinbtn.click();
	}
}
