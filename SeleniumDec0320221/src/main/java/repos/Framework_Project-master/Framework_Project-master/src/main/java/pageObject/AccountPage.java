package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class AccountPage extends Base{
	
	public AccountPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Edit your account information')]")
	private WebElement editAccountLink;
	
	public WebElement editYourAccountInformation() {
		return editAccountLink;		
	}
}
