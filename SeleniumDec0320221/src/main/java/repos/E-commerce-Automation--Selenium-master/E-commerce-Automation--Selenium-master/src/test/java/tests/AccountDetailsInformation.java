package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.AccountDetailsInfromationPage;
import utilities.ExtentFactory;

public class AccountDetailsInformation extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	
	
	  @BeforeClass
	  public void startUrl() {
	    	
	 		report = ExtentFactory.getInstance();
	 		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Account Create Details</b></p>")
	 						.assignAuthor("QA TEAM").assignDevice("Windows");
	 		PageDriver.getCurrentDriver().manage().window().maximize();
	  }
	
	  @Test(priority = 0)
	  public void accountDetails() throws IOException {
		  childTest = parentTest
					.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Information Provide.</b></p>");
			AccountDetailsInfromationPage accountDetailsInfromationPage = new AccountDetailsInfromationPage(childTest);
			accountDetailsInfromationPage.personalInfomation();
			accountDetailsInfromationPage.addressInformation();
	   }
	  
	  @AfterClass
		public void afterClass() {
			report.flush();
		}
}
