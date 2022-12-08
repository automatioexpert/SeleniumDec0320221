package pagefiles_SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.testBase;

public class UserInfoPage extends testBase {

	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement lastname;

	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement postcode;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement cont;

	
	public UserInfoPage() throws Exception
	{
		
		PageFactory.initElements(getDriver(),this);
	}
	
	
	public void sendFirstName(String fname) throws Exception 
	{
		firstname.sendKeys(fname);
	}
	
	public void sendLastName(String lname) throws Exception
	{
		lastname.sendKeys(lname);
	}
	
	public void sendPostCode( String pcode) throws Exception
	{
		postcode.sendKeys(pcode);
	}
	
	public void clickContinue()
	{
		cont.click();
	}
}
