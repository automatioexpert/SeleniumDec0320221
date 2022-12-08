package dRSTinV3_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
//import org.sikuli.script.SikuliException;
import org.testng.Assert;

import dRSTinV3_baseclass.baseclass;

public class dRSTinV3_AdvanceQueryPage extends baseclass{
	
	
	
	
	@FindBy
	(xpath = "//a[@id = 'function-tab']")
	WebElement FunctiontabinAdvanceQuery;
	
	@FindBy (xpath = "//div[@class='row m-0 w-100 filter-fld-clone']//select[@id='simpleqryfld']")
	WebElement Filterfieldvalue;
	
	@FindBy (xpath = "//div[@class='col-sm-12 col-md-2 simpleqryopt px-2']//select[@id='simpleqryopt']")
	WebElement FilterOperatorValue;
	
	@FindBy(xpath = "//div[@class='col-sm-12 col-md-3 simpleqryval px-1']//input[@id='simpleqryval']")
	WebElement FilterValueField;
	
	@FindBy(xpath = "//button[@class='btn btn-brand btn-mid advanceqryquery-submit-btn waves-effect waves-light']")
	WebElement FilterSubmitButton;
	
	@FindBy(xpath = "//div[@class='col-md-6 p-2']")
	
	WebElement AdvanceQueryPagetitle;
	
	public  dRSTinV3_AdvanceQueryPage() throws Exception{
		
		PageFactory.initElements(driver, this);
	}
	
	
//	public void DraganEvent() throws SikuliException, Exception {
//		
//		Screen screen = new Screen();
//		Pattern dataset = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581493550801.PNG");
//		Pattern canvas = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581493560850.PNG");
//		
//		Pattern filterfunction = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581426637410.png");
//		screen.dragDrop(dataset, canvas);
//		Thread.sleep(4000);
		//FunctiontabinAdvanceQuery.click();
		//screen.dragDrop(filterfunction, canvas);
		
	//}
	

	
	public void PerformaFunction(String a , String b, String c) throws Exception {
		
		System.out.println(a + b + c);
		
//		Screen screen = new Screen();
//		Pattern dataset = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581493550801.PNG");
//		Pattern canvas = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581493560850.PNG");
//		
//		Pattern filterfunction = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581426637410.png");
//		screen.dragDrop(dataset, canvas);
//		Thread.sleep(4000);
//		FunctiontabinAdvanceQuery.click();
//		screen.dragDrop(filterfunction, canvas);
//		Filterfieldvalue.click();
//		Filterfieldvalue.sendKeys(a);
//		Filterfieldvalue.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//		FilterOperatorValue.click();
//		FilterOperatorValue.sendKeys(b);
//		FilterOperatorValue.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//		FilterValueField.click();
//		FilterValueField.sendKeys(c);
//		FilterValueField.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//		FilterSubmitButton.click();
		
		
		
		
		
		
		
		
	}
	
}


