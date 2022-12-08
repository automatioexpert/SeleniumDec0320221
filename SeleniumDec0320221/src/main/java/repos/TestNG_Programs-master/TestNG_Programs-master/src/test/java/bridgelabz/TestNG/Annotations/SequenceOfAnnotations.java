package bridgelabz.TestNG.Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SequenceOfAnnotations {
	WebDriver driver;
	
	//It will execute only once before all text
	@BeforeSuite
	 public void beforeSuite() {
		System.out.println("In Before suit execution");
	}
	
	//It will execute before actaual test
	@BeforeTest
	 public void beforeTest() {
		System.out.println("In Before Test execution");
	 }
	
	//It will execute before actual test's method execution
	@BeforeClass
	 public void beforeClass() {
		System.out.println("In Before Class execution");
	 }
	
	//It will execute before @Test annoted methods
	@BeforeMethod
	 public void beforeMethod() {
		System.out.println("In Before Method execution");
	 }
	
	//Actual Test case 1 :: It will execute methods under the Test
	@Test
	 public void lauchBrowser() {
		
	    try {
	    	System.setProperty("webdriver.chrome.driver", "C://Users//Raj Kawale//OneDrive//Desktop//chromedriver_win32//chromedriver.exe");					
		    driver= new ChromeDriver();
		    //passing Web URl
		    driver.get("https://www.amazon.in/");
		    
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	
	//It will execute after @test annoted methods
	@AfterMethod
	 public void afterMethod() {
		System.out.println("In After Method execution");
	 }
	
	//It will execute after the test method 
	 @AfterClass
	 public void afterClass() {
		System.out.println("In After class execution");
	}
	 
	 //It will execute after the actual test method execution
	 @AfterTest
	 public void closeBrowser() {
		driver.close();
		System.out.println("In After Test execution");
	 }
	 
	 //It will execute after all methods executions
	@AfterSuite
	 public void afterSuite() {
		System.out.println("In After suite execution");
	}
}