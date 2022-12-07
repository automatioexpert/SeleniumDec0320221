package Files.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

@SuppressWarnings("unused")
public class CheckGroups {
	
	
    WebDriver driver;
	
	@BeforeTest(alwaysRun=true)
	public void setup(ITestContext testcontext) {
		
		System.out.println("Setup Method is dispalyed" );
		String Username = testcontext.getCurrentXmlTest().getParameter("UserName");
		System.out.println("Username: " +Username);
		String browser  = testcontext.getCurrentXmlTest().getParameter("browser");
		System.out.println("Browser: " +browser);
		
		if(browser.equalsIgnoreCase("Chrome")) {
	
	 	System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
	    driver = new ChromeDriver(); // launch chrome 
	    System.out.println("Browser is Chrome - Test passed");
			 
			
		}	
		else if (browser.equalsIgnoreCase("IE")) {
			System.out.println("IE Browser");
			driver=new InternetExplorerDriver();
			
		}
				
	}
	
     @Test(groups= {"Sanity","Regression"},priority=0)
     public void testLogin() {
    	 
    	String browser = "Chrome";
		AssertJUnit.assertEquals(browser, "Chrome");
    	System.out.println("testLogin is executed");
    	Reporter.log("This Test cases is testLogin()");
    	 
     }
	
	
     @Test(groups="Sanity",priority=1)
     public void testCreateAdmin() {
     System.out.println("testCreateAdmin is executed");
     Reporter.log("This Test cases is testCreateAdmin()");
    	 
     }
     
     @Test(groups={"Regression","Sanity"},priority=2)
     public void testEditAdmin() {
     System.out.println("testEditAdmin executed");
    	 
     }
     
     @Test(groups="Sanity",priority=3)
     public void testCreateUser() {
     System.out.println("testCreateUser is executed");
     }
     
     @Test(priority=4,groups="Regression")
     public void testDeleteUser() {
    	 
    	// Assert.assertEquals(true, false);
    	 
    	 System.out.println(" Test executed in testDeleteUser");
    	 Reporter.log("This Test cases is testDeleteUser()");
     }
	
     @AfterMethod
     //I Found a way to use Reporter.log("Message") in @AfterMethod annotated method. 
     public void getTestResult(ITestResult TestResult){
    	 System.out.println("Test Case Name:" +TestResult.getName());
    	 System.out.println("Test Result:" +TestResult.getStatus());
    	 Reporter.setCurrentTestResult(TestResult);
    	 Reporter.log("This testcase is executed based on the ITestResult");

     }
         //TestResult -1 Pass, 2 - Fail
}
