package dRSTinV3_Tests;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dRSTinV3_Pages.dRSTinV3_Homepage;
import dRSTinV3_Pages.dRSTinV3_loginpage;
import dRSTinV3_baseclass.baseclass;
import dRSTinV3_util.util;

public class loginpage_test extends baseclass{
	
	
	
	dRSTinV3_loginpage loginpage;
	
	dRSTinV3_Homepage homepage ;
	
	Logger log = Logger.getLogger(loginpage_test.class);
	
	public loginpage_test() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		initialization();
		
		loginpage = new dRSTinV3_loginpage();
		
		log.info("Launching Browser");
		
		
		
	}
	
	@Test(description = "Verify that the user is able to log in successfully")
	
	public void SuccesfulLogin() throws Exception {
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		log.info("Successful Login");
	}
	
	
	@AfterMethod
	public void closure(ITestResult result) throws Exception {
		
		if(ITestResult.SUCCESS == result.getStatus())
		{
			
			util.screenshot(driver, result.getName());
		}
		
		Thread.sleep(4000);
		
		driver.quit();
		
		log.info("Closing Browser");
	}
	

}
