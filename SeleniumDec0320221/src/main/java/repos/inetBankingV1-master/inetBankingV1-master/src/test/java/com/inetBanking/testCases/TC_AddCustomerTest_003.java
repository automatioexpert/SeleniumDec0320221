package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		addcust.custName("Hassen");
		addcust.custGender("male");
		addcust.custdob("10051985");
		Thread.sleep(3000);

		addcust.custaddress("USA");
		addcust.custcity("Philadelphia");
		addcust.custstate("PA");
		addcust.custpinno("5000075");
		addcust.custtelephoneno("9878900152");

		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);

		addcust.custpassword("test001");
		addcust.custsubmit();
		Thread.sleep(7000);
		
		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Add Customer test Passed");
		} else {
			//captureScreen(driver, "addCustomer");
			Assert.assertTrue(false);
			logger.info("Add Customer test Failed");
		}
	}

}
