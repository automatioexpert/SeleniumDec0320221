package Testcases;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.baseclass.baseclass;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.pages.contactpage;
import crm.util.utility;

public class contactpage_test extends baseclass{
	
	LoginPage loginpage;
	HomePage homepage;
	contactpage cp;
	

	public contactpage_test() throws IOException {
		super();
		
	}
	
	@BeforeMethod()
	public void setup() throws Exception {
		
		
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		cp = new contactpage();
		
		
		homepage = loginpage.validatelogin(prop.getProperty("User"), prop.getProperty("Password"));
		cp = homepage.contactpageNavigation();
		
	}
	
	@Test()
	public void verifycontactpagenavigation() throws Exception {
		
		cp.Clickoncheckbox();
	}
	
	@AfterMethod()
	
	public void teardown(ITestResult result) throws Exception {
		
		if(result.getStatus()== ITestResult.SUCCESS) {
			
			utility.screenshot("Passed");
		}
		
		else
			
		
		driver.get("D:\\Eclipse Projects\\CRM\\test-output\\CRM_Report.html");
		
	//	driver.quit();
	}

}
