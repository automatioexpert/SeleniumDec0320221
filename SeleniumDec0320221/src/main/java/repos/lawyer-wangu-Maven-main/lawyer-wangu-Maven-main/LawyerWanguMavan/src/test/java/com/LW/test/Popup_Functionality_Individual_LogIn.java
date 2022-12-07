package com.LW.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.LW.generics.LWBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Popup_Functionality_Individual_LogIn  {

	public WebDriver driver;
	public Actions actions;
	public SoftAssert sa;
	static {

		//System.setProperty("webdriver.chrome.driver", "/Users/activemac03/Downloads/chromedriver");
		WebDriverManager.chromiumdriver().setup();
	}


	@Test(dataProvider="UserData")
	public void Popup_Individual_LogIn(String UserName , String UserPasword) throws InterruptedException, IOException {

		driver= new ChromeDriver(); driver.get("https://staging.lawyerwangu.com/");
		driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class=\"cn-set-cookie cn-button\"]")).click();
		

driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();

		//Sign in popup
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(
				UserName);
		driver.findElement(By.xpath("//input[@id=\"con_password\"]")).sendKeys(
				UserPasword);
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();
		driver.findElement(By.xpath("//button[@id=\"login_button\"]")).click();

		String Account =
				driver.findElement(By.xpath("//a[@title=\"My Account\"]")).getText(); sa =
				new SoftAssert(); Assert.assertEquals(Account,"MY ACCOUNT"); driver.quit();
				sa.assertAll();


	}

	@DataProvider(name="UserData") String[][] getUserData() throws IOException

	{ 
		String empdata [][]= {{ "lwtesterindi@gmail.com" , "tester@123"},
				{"lwtesterindi@gmail.com" , "teste123"},
				{"testerlw1","tester@123"}
		}; 
		return empdata; 
	}
}
//	  
//	  @Test(dataProvider="GuestData") public void Popup_Continue_as_Guest(String
//	  Name , String Email ,String Number) throws InterruptedException, IOException
//	  { driver= new ChromeDriver(); driver.get("https://staging.lawyerwangu.com/");
//	  driver.manage().window().maximize(); driver.manage().deleteAllCookies();
//	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	  driver.findElement(By.xpath("//a[@class=\"cn-set-cookie cn-button\"]")).click
//	  (); WebElement Business =
//	  driver.findElement(By.xpath("//a[@title=\"Business\"]"));
//	  
//	  WebElement Document = driver.findElement(By.
//	  xpath("//a[@title=\"Letter of Consent to Register a Company with similar name\"]"
//	  ));
//	  
//	  
//	  actions = new Actions(driver);
//	  
//	  actions.moveToElement(Business).moveToElement(Document).click().build().
//	  perform();
//	  
//	  driver.findElement(By.xpath("(//div[@class=\"document-create\"])[2]")).click(
//	  );
//	  
//	  //Continue as a Guest
//	  driver.findElement(By.xpath("//a[.=\"Continue as a Guest\"]")).click();
//	  
//	  driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys(Name)
//	  ;
//	  driver.findElement(By.xpath("//input[@id=\"login_email\"]")).sendKeys(Email);
//	  driver.findElement(By.xpath("//input[@id=\"phone_number\"]")).sendKeys(Number
//	  );
//	  driver.findElement(By.xpath("(//input[@id=\"signin-popup-btn\"])[1]")).click(
//	  ); String Account =
//	  driver.findElement(By.xpath("//a[@title=\"My Account\"]")).getText(); sa =
//	  new SoftAssert(); Assert.assertEquals(Account,"MY ACCOUNT"); driver.quit();
//	  sa.assertAll(); }
//	  
//	  @DataProvider(name="GuestData") String[][] getGuestData() throws IOException
//	  
//	  { String guestdata [][]= {{ "1231346546" , "tester@gmail.com" , "98562365452"
//	  },{"AutomatedTester" , "AutomatedTester@gmail.com" , "abchdjkl"},
//	  {"AutomatedTester","AutomatedTester@gmail.com" , "745869385265" }}; return
//	  guestdata; }


//	@Test()
//	public void Popup_Register_Here() throws InterruptedException, IOException {
//		driver= new ChromeDriver();
//
//		driver.get("https://staging.lawyerwangu.com/");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		sa = new SoftAssert();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//a[@class=\"cn-set-cookie cn-button\"]")).click();
//		WebElement Business = driver.findElement(By.xpath("//a[@title=\"Business\"]"));
//
//		WebElement Document = driver.findElement(By.xpath("//a[@title=\"Letter of Consent to Register a Company with similar name\"]"));
//
//
//		actions = new Actions(driver);
//
//		actions.moveToElement(Business).moveToElement(Document).click().build().perform();
//
//		driver.findElement(By.xpath("(//div[@class=\"document-create\"])[2]")).click();
//
//		//Register Here
//
//		driver.findElement(By.xpath("//a[@id=\"create_free_account\"]")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//input[@id=\"signup_username\"]")).sendKeys("AutTester");
//		Thread.sleep(200);
//		driver.findElement(By.xpath("//input[@id=\"signup_email\"]")).sendKeys("Autr@gmail.com");
//		Thread.sleep(200);
//		driver.findElement(By.xpath("//input[@id=\"signup_password\"]")).sendKeys("tester@123");
//		Thread.sleep(200);
//		driver.findElement(By.xpath("//input[@id=\"signup_confirm_password\"]")).sendKeys("tester@123");
//		Thread.sleep(200);
//		driver.findElement(By.xpath("//input[@id=\"signup_mobile_number\"]")).sendKeys("79420420420");
//		Thread.sleep(200);
//		WebElement submit = driver.findElement(By.xpath("//input[@id=\"signup-btn\"]"));
//
//		actions.doubleClick(submit).build().perform();
//
//		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"signup-btn\"]"))).click();
//
//
//		Thread.sleep(500);
//
//		String Account = driver.findElement(By.xpath("//a[@title=\"My Account\"]")).getText();
//
//		AssertJUnit.assertEquals(Account,"MY ACCOUNT");
//		driver.quit();
//		sa.assertAll();
//
//	}
//
//
//	@DataProvider(name="RegisterUser") String[][] getRegisterUser() throws
//	IOException
//
//	{
//		String Registerdata [][]= {{"AutomatdTester","Autotr@gmail.com" ,
//			"tester@123" , "tester@123" , "794204204200"},
//				
//				{"AutomatdTestUser%$","AutomatdTestUser1.com" , "ester@123" , "tester@123" ,
//				"dadadawd465"},
//				{ "1231645546" , "tester@gmail.com" , "tester@123" ,
//					"tester@123" , "45656456465" }, 
//				{"AutomatdTestUser1" ,
//						"AutomatdTestUser@gmail.com" , "ester@123" , "tester@123" , "45656456465" }};
//		return Registerdata; }
//
//
//}




































