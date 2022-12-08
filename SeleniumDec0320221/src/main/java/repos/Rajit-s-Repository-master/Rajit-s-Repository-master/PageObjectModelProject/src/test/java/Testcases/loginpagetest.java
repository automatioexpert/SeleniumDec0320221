package Testcases;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import crm.baseclass.baseclass;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.utility;


public class loginpagetest extends baseclass {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public loginpagetest() throws Exception {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		
		
		initialization();
		
		loginpage = new LoginPage();
		
	}
	
	
	
	@Test
	public void successfullLogin() throws Exception {
		
		homepage = loginpage.validatelogin(prop.getProperty("User"), prop.getProperty("Password"));
		
		
	}
	
	@AfterMethod
	public void closure() throws Exception {
		
		
		
		Thread.sleep(4000);
		
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
