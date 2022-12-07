package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LoginPage extends Base{

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginBtn;
	
	public WebElement emailAddressTextField() {
		return emailAddressField;
	}
	
	public WebElement passwordField() {
		return passwordField;
	}
	
	public WebElement loginButton() {
		return loginBtn;
	}

}
