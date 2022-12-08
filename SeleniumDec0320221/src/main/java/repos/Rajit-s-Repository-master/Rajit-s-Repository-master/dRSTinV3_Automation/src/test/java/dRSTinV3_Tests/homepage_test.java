package dRSTinV3_Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dRSTinV3_Pages.dRSTinV3_Homepage;
import dRSTinV3_Pages.dRSTinV3_UserPage;
import dRSTinV3_Pages.dRSTinV3_loginpage;
import dRSTinV3_baseclass.baseclass;

public class homepage_test extends baseclass{
	
	
	dRSTinV3_loginpage loginpage;
	
	dRSTinV3_Homepage homepage ;
	
	dRSTinV3_UserPage userpage;
	
	
	public homepage_test() throws Exception {
		
		super();
		
	}
	
	@BeforeMethod
	
	public void setup() throws Exception {
		
		initialization();
		loginpage = new dRSTinV3_loginpage();
		homepage = new dRSTinV3_Homepage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		}
	
	@Test(description = "Verify that the user is able to navigate to the manage user page successfully. ")
	
	public void userpagenavigation() throws Exception {
		
		userpage = homepage.NavigatetoUser();
	}
	
	
	@AfterMethod
	public void closure() throws Exception {        
		
		Thread.sleep(6000);
		driver.quit();
	}
	

}
