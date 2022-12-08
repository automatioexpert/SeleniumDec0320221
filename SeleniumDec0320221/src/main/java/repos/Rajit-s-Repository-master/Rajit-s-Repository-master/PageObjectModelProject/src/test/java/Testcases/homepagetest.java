package Testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.baseclass.baseclass;
import crm.pages.HomePage;
import crm.pages.LoginPage;

public class homepagetest extends baseclass{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public homepagetest() throws Exception {
		
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		initialization();
		
		loginpage = new LoginPage();
		
		homepage = new HomePage();
		
		homepage = loginpage.validatelogin(prop.getProperty("User"), prop.getProperty("Password"));
	}
	
	@Test(enabled = false)
	
	public void usernavigation() {
		
		String usernameshown = homepage.Userdetails();
		Assert.assertEquals(usernameshown, "S R");
	
	}
	
	@Test(description = "Verify that the user is able to see the username in the homepage")
	public void Usernamedisplayed() {
		
		
		Assert.assertEquals(homepage.usernamedisplayedinHomepage(), "R S");
		
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		
		Thread.sleep(2000);
		driver.quit();
	}

}
