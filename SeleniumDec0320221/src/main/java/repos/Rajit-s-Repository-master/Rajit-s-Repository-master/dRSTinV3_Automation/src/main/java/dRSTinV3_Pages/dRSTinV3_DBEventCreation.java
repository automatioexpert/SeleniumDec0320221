package dRSTinV3_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dRSTinV3_baseclass.baseclass;

public class dRSTinV3_DBEventCreation extends baseclass{
	
	@FindBy(xpath = "//i[@class = 'fas fa-cog']")
	WebElement Clickonsettingsbutton;
	
	@FindBy(xpath = "//a[contains(text(),' Manage Datasets')]")
	WebElement ManageDatasetdropdown;
	
	@FindBy(xpath = "//button[@class='btn btn-brand btn-mid-sm float-right addNewDataSetBtn']")
	WebElement AddnewDatasetbutton;
	
	@FindBy(xpath = "//div[@id='datapill-datapreview']//p")
	WebElement DatasetCreationPageTitle;
	
	@FindBy(xpath = "//input[@id='DatasetNameFld']")
	WebElement Datasetnamefield;
	
	@FindBy(xpath = "//div[contains(text(),'MySQL')]")
	WebElement ClickOnMysQLFile;
	
	public  dRSTinV3_DBEventCreation() throws Exception{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void NavigatetoEventCreationPage() throws Exception {
		
		AddnewDatasetbutton.click();
		
		Thread.sleep(2000);
		
		String ActualTitle = DatasetCreationPageTitle.getText();
		
		
		
		System.out.println("Actual EventCreation PageTitle >>>>>>>>>>>>" + ActualTitle);
		
		String ExpectedTitle = "New Dataset";
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
	}
	
	public void DBsuccessfulEventCreation(String DTSTN ,String HN , String DN, String DBN , String UN, String PWD ) throws Exception {
		
		AddnewDatasetbutton.click();
		Thread.sleep(2000);
		Datasetnamefield.sendKeys(DTSTN);
		ClickOnMysQLFile.click();
		
		
		
		
	}
	

}
