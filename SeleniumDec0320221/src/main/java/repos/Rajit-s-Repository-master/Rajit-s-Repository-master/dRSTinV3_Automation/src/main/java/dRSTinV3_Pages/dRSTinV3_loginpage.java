package dRSTinV3_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dRSTinV3_baseclass.baseclass;

public class dRSTinV3_loginpage extends baseclass{
	
	

	@FindBy(xpath = "//input[@id='loginid']")
	WebElement logininputfield;
	
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordinputfield;
	
	@FindBy(xpath = "//button[@class='btn btn-brand btn-xl login_btn waves-effect waves-light']")
	WebElement signinbutton;
	
	@FindBy(xpath = "//img[@class='header_logo']")
	WebElement HeaderLogo;
	
	
	public dRSTinV3_loginpage () throws Exception{
		
		PageFactory.initElements(driver, this);
	}
	
	public dRSTinV3_Homepage login (String uname , String pwd ) throws Exception {
		
		logininputfield.sendKeys(uname);
		
		passwordinputfield.sendKeys(pwd);
		
		signinbutton.click();
		
		HeaderLogo.isDisplayed();
		
		
		return new dRSTinV3_Homepage();
		
	}
	
	
	
	

}
