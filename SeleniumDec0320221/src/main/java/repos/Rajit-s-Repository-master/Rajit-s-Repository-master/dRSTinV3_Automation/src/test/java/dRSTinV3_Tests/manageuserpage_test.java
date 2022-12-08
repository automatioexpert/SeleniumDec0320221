package dRSTinV3_Tests;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dRSTinV3_Pages.dRSTinV3_Homepage;
import dRSTinV3_Pages.dRSTinV3_UserPage;
import dRSTinV3_Pages.dRSTinV3_loginpage;
import dRSTinV3_baseclass.baseclass;

import dRSTinV3_util.reader;


public class manageuserpage_test extends baseclass{
	
	dRSTinV3_loginpage loginpage;
	dRSTinV3_Homepage  homepage;
	dRSTinV3_UserPage  userpage;
	
	boolean upage;
	
	public manageuserpage_test() throws Exception {
		
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws Exception {
		
		initialization();
		
		PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, dRSTinV3_loginpage.class);
		
		loginpage = new dRSTinV3_loginpage();
		homepage = new dRSTinV3_Homepage();
		userpage = new dRSTinV3_UserPage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		userpage = homepage.NavigatetoUser();
	}
	
	
	@DataProvider()
	
		public Iterator<Object[]> gettestdata() {
		
		
		
		ArrayList<Object[]> testdata = reader.getdata();
		
		return testdata.iterator();
		
		}
	
	@Test(description = "Verify that on clicking the no button while removing an user system navigates back to the manage user page",enabled = false)
	public void userremoval() throws Exception {
		
		upage = userpage.userremove();
		
		upage = false;
	
	}
	
	
	@Test(dataProvider="gettestdata")
	public void createadminuser() throws Exception {
		
		userpage.Addnonadminuser();
	}
	
	
	@Test(description = "Verify that the user is able to edit each of the fields in the edit user section.",enabled = false)
	
	public void edituser() {
		
		
	}
	
	@AfterMethod
	public void closure() throws Exception {
		
		Thread.sleep(10000);
		
		driver.quit();
	}
	

}
