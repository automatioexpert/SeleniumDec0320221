package dRSTinV3_Pages;

//import static org.junit.Assume.assumeTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dRSTinV3_baseclass.baseclass;

public class dRSTinV3_Homepage extends baseclass{
	
	
	@FindBy(xpath = "//i[@class='fas fa-cog']")
	
	WebElement SettingsButton;
	
	@FindBy(xpath = "//a[@class='dropdown-item usermanagement waves-effect waves-light']")
	
	WebElement ManageUserlink;
	
	@FindBy(xpath = "//a[@class='dropdown-item groupmanagement waves-effect waves-light']")
	WebElement ManageGroupslink;
	
	//AdvanceQueryNavigationxpath
	
	@FindBy (xpath = "//body[@class='background']/nav[@class='navbar navbar-expand-lg navbar-dark px-1 py-0 header']"
			+ "/div[@id='navbarSupportedContent-333']/ul[@class='navbar-nav mr-auto dark-gray-text']/li[2]/a[1]")
	
	WebElement QueryButton;
	
	@FindBy
	(xpath = "//a[@class='dropdown-item AdvanceQueryPanel waves-effect waves-light']")
	
	WebElement AdvanceQueryoption;
	
	@FindBy(xpath = "//div[@class='col-md-6 p-2']")
	
	WebElement AdvanceQueryPagetitle;
	
	//ManageDatasetNavigation
	
	@FindBy(xpath = "//i[@class = 'fas fa-cog']")
	WebElement Clickonsettingsbutton;
	
	@FindBy(xpath = "//a[contains(text(),' Manage Datasets')]")
	WebElement ManageDatasetdropdown;
	
	@FindBy(xpath = "//div[@class = 'col-sm-12 col-md-3 heading heading-md p-2 pl-4']")
	WebElement DatasetPageHeadertitle;

	
	//Initialization
	
	public dRSTinV3_Homepage() throws Exception{
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public dRSTinV3_UserPage NavigatetoUser() throws Exception {
		
		SettingsButton.click();
		ManageUserlink.click();
		
		return new dRSTinV3_UserPage();
		
		
	}
	
	
   public dRSTinV3_AdvanceQueryPage NavigatetoAdvanceQueryPage() throws Exception {
		
		QueryButton.click();
		AdvanceQueryoption.click();
		String AdvanceQueryPageheader = AdvanceQueryPagetitle.getText();
		
		Assert.assertEquals(AdvanceQueryPageheader, "Advance Query Panel");
		
		return new dRSTinV3_AdvanceQueryPage();
		
   }
   
   public dRSTinV3_DBEventCreation NavigatetoManageDatasetPage() throws Exception {
	   
	   
	   Clickonsettingsbutton.click();
	   ManageDatasetdropdown.click();
	   String DatasetPagetitleActual = DatasetPageHeadertitle.getText();
	   String DatasetPagetitleExpected = "Manage Datasets";
	   
	   Assert.assertEquals(DatasetPagetitleActual, DatasetPagetitleExpected);
	   
	   return new dRSTinV3_DBEventCreation();
	   
	   
	   
	   
   }
	
	
		
		
	
	
}



