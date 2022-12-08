package crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.baseclass.baseclass;

public class HomePage extends baseclass{
	
	
	@FindBy(xpath = "//a[contains(text(),'S w R')]")
	WebElement Usertab;
	
	@FindBy(xpath ="//div[@class='ui header item mb5 light-black']")
	WebElement usern;
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement homepagenavigationverification;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]") WebElement contactsClick;
	
	
	public HomePage() throws Exception{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String Userdetails() {
		
		Usertab.click();
		return usern.getText();	
		
		
	}
	
	public String usernamedisplayedinHomepage() {
		
		String Username = homepagenavigationverification.getText();
		
		return Username;
		
		
		
		
	}
	
	public contactpage contactpageNavigation() throws IOException {
		
		contactsClick.click();
		return new contactpage();
		
		
	}

}
