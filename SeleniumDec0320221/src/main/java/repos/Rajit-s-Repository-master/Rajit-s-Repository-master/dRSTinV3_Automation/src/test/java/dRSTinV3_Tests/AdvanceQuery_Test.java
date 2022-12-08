package dRSTinV3_Tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
//import org.sikuli.script.SikuliException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dRSTinV3_Pages.dRSTinV3_AdvanceQueryPage;
import dRSTinV3_Pages.dRSTinV3_Homepage;
import dRSTinV3_Pages.dRSTinV3_UserPage;
import dRSTinV3_Pages.dRSTinV3_loginpage;
import dRSTinV3_baseclass.baseclass;
import dRSTinV3_util.reader;



public class AdvanceQuery_Test extends baseclass{
	
	dRSTinV3_loginpage loginpage;
	dRSTinV3_Homepage  homepage;
	dRSTinV3_AdvanceQueryPage advancequery;
	
	
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
	
	
	
	
	
	
	public AdvanceQuery_Test() throws Exception {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		initialization();
		
		loginpage = new dRSTinV3_loginpage();
		homepage = new dRSTinV3_Homepage();
		advancequery = new dRSTinV3_AdvanceQueryPage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		advancequery = homepage.NavigatetoAdvanceQueryPage();
		
	}
	
	@DataProvider
	public Iterator<Object[]> testdataforfilter() {
		
		ArrayList<Object[]> filtertestdata = reader.getdata();
		
		return filtertestdata.iterator();
		
		
		
	}
	
//	@Test(description = "Verify that the user is able to drag an event in the advance query panel", enabled = false)
//	public void EventDrag() throws Exception {
//		advancequery.DraganEvent();
//		
//		
//	}
	
	@Test(dataProvider = "testdataforfilter")
	public void PerformAdvanceQueryFilterFunction(String Field , String Operator ,String Value) throws Exception {
		
		
		advancequery.PerformaFunction(Field,Operator, Value);
		
//		Screen screen = new Screen();
//		Pattern dataset = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581493550801.PNG");
//		Pattern canvas = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581493560850.PNG");
//		
//		Pattern filterfunction = new Pattern("C:\\Users\\Rajit\\Documents\\DRSTIN NEW IMAGES sikuli.sikuli\\1581426637410.png");
//		screen.dragDrop(dataset, canvas);
//		Thread.sleep(4000);
//		System.out.println("Null check 1");
//		FunctiontabinAdvanceQuery.click();
//		
//		System.out.println("Null check 2");
//		screen.dragDrop(filterfunction, canvas);
//		Filterfieldvalue.click();
//		Filterfieldvalue.sendKeys("Late by");
//		Filterfieldvalue.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//		FilterOperatorValue.click();
//		FilterOperatorValue.sendKeys(">");
//		FilterOperatorValue.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//		FilterValueField.click();
//		FilterValueField.sendKeys("5");
//		FilterValueField.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//		FilterSubmitButton.click();
	
		
	}
	
	
	
	@AfterMethod
	public void teardown() throws Exception {
		
		Thread.sleep(4000);
		driver.quit();
	}

}
