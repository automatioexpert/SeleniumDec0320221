package crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.baseclass.baseclass;
import crm.util.utility;

public class contactpage extends baseclass{
	
	

	@FindBy(xpath = "//div[@class = 'ui header item mb5 light-black']") WebElement contactpageheader;
	@FindBy(xpath = "//div[@class = 'ui fitted read-only checkbox']//label") WebElement checkboxclick;
	@FindBy(xpath = "//div[@name= 'view']") WebElement viewclick;
	
	
	
	public contactpage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public void Clickoncheckbox() throws Exception {
		
		boolean checkboxdisplayed =  viewclick.isDisplayed();
		if(checkboxdisplayed = true) {
			
			utility.clickElement(viewclick, "CheckboxClicked", "CheckboxClick Validation", "CheckboxClicked");
		}
	}
	
	

}
