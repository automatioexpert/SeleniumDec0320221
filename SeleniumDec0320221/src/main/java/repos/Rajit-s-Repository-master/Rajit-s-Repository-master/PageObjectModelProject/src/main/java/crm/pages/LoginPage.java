package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.baseclass.baseclass;

public class LoginPage extends baseclass{
	
	@FindBy(xpath = "//span[@class='icon icon-xs mdi-chart-bar']")
	
	WebElement logintag;
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement LoginButton;
	
	@FindBy(xpath = "//input[@name = 'email']")
	WebElement emailfield;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement passwordfield;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	WebElement HomeClick;
	
	 
	 Actions act = new Actions(driver);
	
	// Initialization
	public LoginPage() throws Exception{
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public HomePage validatelogin(String uid , String password) throws Exception {
		
		 
		logintag.click();
		
		emailfield.sendKeys(uid);
		passwordfield.sendKeys(password);
		loginbutton.click();
		HomeClick.click();
		
		return new HomePage();
	}

}
