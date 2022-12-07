package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LandingPage extends Base{
		
	public LandingPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccountDropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	public WebElement myAccountDropDown() {
		return myAccountDropDown;		
	}
		
	public WebElement loginOption() {
		return loginOption;
	}	

}
