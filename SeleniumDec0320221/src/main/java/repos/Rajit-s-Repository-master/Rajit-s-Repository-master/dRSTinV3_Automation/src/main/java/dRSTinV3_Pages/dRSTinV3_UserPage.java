package dRSTinV3_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dRSTinV3_baseclass.baseclass;

public class dRSTinV3_UserPage extends baseclass{
	
	
	
	@FindBy(xpath ="//table[@class ='table table-hover dataTable no-footer']//input[@value = '16']/following-sibling::td[@class='p-2 d-flex justify-content-center']//a[contains(text(),'Remove')]")
	
	WebElement Remove1;
	
	@FindBy(xpath = "//button[@class='btn btn-default text-red waves-effect waves-light']")
	
	WebElement WarningNobutton;
	
	@FindBy(xpath = "//div[@class='col-sm-12 col-md-3 heading heading-md p-2 pl-4']")
	WebElement ManageUserPageTitle;
	
	@FindBy(xpath = "//td[@class='p-2 username sorting_1'][contains(text(),'ap')]")
	WebElement apusername;
	
	@FindBy(xpath = "//div[@class='col-sm-12']//tr[@id='userlist50']//a[contains(text(),'Edit')]")
	WebElement apedit;
	
	
	@FindBy(xpath = "//td[@class='p-2 username sorting_1'][contains(text(),'Guest')]")
	
	WebElement guestusername;
	
	@FindBy(xpath = "//div[@class='col-sm-12']//tr[@id='userlist3']//a[contains(text(),'Edit')]")
	WebElement guestedit;
	
	@FindBy(xpath = "//div[@class='modal fade show']")
	WebElement warningmodalforuserremoval;
	
	@FindBy(xpath = "//button[@class='btn btn-brand btn-mid-sm float-right']")
	WebElement Addnewuserbutton;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement Adduser_Fullnamefield;
	
	@FindBy (xpath = "//input[@id='useremail']")
	WebElement Addduser_emailfield;
	
	@FindBy(xpath = "//input[@id='userphone']")
	WebElement Adduser_phonefield;
	
	@FindBy(xpath = "//input[@id='userremark']")
	WebElement Adduser_remarksfield;
	
	@FindBy(xpath = "//input[@id='userdesignation']")
	WebElement Adduser_designationfield;
	
	@FindBy(xpath = "//input[@id='userid']")
	WebElement Adduser_loginidfield;
	
	@FindBy(xpath = "//input[@id='userpassword']")
	WebElement Adduser_passwordfield;
	
	@FindBy(xpath = "//div[contains(text(),'Administrator')]")
	WebElement Adduser_groupselection_Admin;
	
	@FindBy(xpath = "//div[contains(text(),'Perm 1')]")
	WebElement Adduser_groupselection_nonadmin;
	
	@FindBy(xpath = "//button[@class='btn btn-brand btn-mid w-50 saveBtn createUserBtn']")
	WebElement Savenewuserbutton;
	
	
	public dRSTinV3_UserPage() throws Exception{
		
		PageFactory.initElements(driver, this);
		
	
	}
	
	
	public boolean userremove() throws Exception {
		
		Remove1.click();
		Thread.sleep(2000);
		boolean wpagetitle = warningmodalforuserremoval.isDisplayed();
		WarningNobutton.click();
		//boolean title = ManageUserPageTitle.isEnabled();
		
		if(wpagetitle = true)
		{
			
			System.out.println("Title>>>>>>>>>>" + wpagetitle);
			
			WarningNobutton.click();
			
			return wpagetitle;
		
		}
		
		else
			
			return wpagetitle;
		
	}
	
	
	public void Addnonadminuser() throws Exception {
		
		Thread.sleep(2000);
		
		Addnewuserbutton.click();
		Adduser_Fullnamefield.sendKeys("Firstname");
		Addduser_emailfield.sendKeys("email");
		Adduser_loginidfield.sendKeys("username");
		Adduser_passwordfield.sendKeys("password");
		
		//Adduser_designationfield.sendKeys("RRR");
		Adduser_groupselection_Admin.click();
		
		Savenewuserbutton.click();
		
		driver.findElement(By.xpath("//td[@class='p-2 username sorting_1'][contains(text(),'AzD')]")).isDisplayed();
		
		
		
		
		
	}
		
		
	public void useredit() {
		
		if(apusername.isDisplayed())
		{
			
			apedit.click();
	
	}
		
		else if (guestusername.isDisplayed())
		{
			
		guestedit.click();
		
		}
	
	}
	
	

}
