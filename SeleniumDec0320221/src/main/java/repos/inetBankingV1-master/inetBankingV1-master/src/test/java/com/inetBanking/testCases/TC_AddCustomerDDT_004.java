package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilites.XLUtils;



public class TC_AddCustomerDDT_004 extends BaseClass {
	@Test(dataProvider = "CustomerData")
	public void addCustomerDDT(String name, String gender, String dob, String address, String city, String state, String pin, String phonenum, String email, String pwd) throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();		
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		addcust.custName(name);
		addcust.custGender(gender);
		addcust.custdob(dob);
		Thread.sleep(3000);

		addcust.custaddress(address);
		addcust.custcity(city);
		addcust.custstate(state);
		addcust.custpinno(pin);
		addcust.custtelephoneno(phonenum);
		addcust.custemailid(email);
		addcust.custpassword(pwd);
		
		addcust.custsubmit();
		Thread.sleep(7000);
		
		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Add Customer test Passed");
			addcust.clickAddNewCustomer();			
		} else {
			//captureScreen(driver, "addCustomer");
			Assert.assertTrue(false);
			logger.info("Add Customer test Failed");
		}
	}
	
	@DataProvider(name = "CustomerData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\testData\\AddCustomerData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String CustomerData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				CustomerData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return CustomerData;
	}

}
