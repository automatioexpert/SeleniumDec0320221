package tests;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.CheckoutProcess;
import pages.AccountCreatePage;
import utilities.ExtentFactory;

public class AccountCreate extends BaseDriver{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	
	
	@BeforeClass
     public void startUrl() {
		
    	PageDriver.getCurrentDriver().get(baseURL);
    	PageDriver.getCurrentDriver().manage().window().maximize();
 		report = ExtentFactory.getInstance();
 		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Account Create</b></p>")
 						.assignAuthor("QA TEAM").assignDevice("Windows");
		
	}
	
	@Test
	public void createAnAccount() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b></b>Account Create Process</p>");
		AccountCreatePage homePage = new AccountCreatePage(childTest);
		homePage.clickOnSignIn();
		homePage.sendEmail();
		homePage.clickOnAccountBtn();
		

		
//		CheckoutProcess checkoutProcess = new CheckoutProcess();
//		checkoutProcess.womenDress();
		
	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}
