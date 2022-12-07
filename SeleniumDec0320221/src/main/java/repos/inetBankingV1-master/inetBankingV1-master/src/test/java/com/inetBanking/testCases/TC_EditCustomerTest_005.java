package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilites.Reporting;

public class TC_EditCustomerTest_005 extends BaseClass {
	@Test
	public void editCustomerBlankID() throws IOException, InterruptedException {
		Reporting rep = new Reporting();
		rep.test.assignAuthor("Hassen").assignCategory("Edit Customer");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();

		EditCustomerPage editcust = new EditCustomerPage(driver);

		editcust.clickEditCustomer();
		editcust.custID(" ");
		editcust.custSubmit();

		boolean res = driver.getPageSource().contains("Customer ID is required");

		if (res == true) {
			//captureScreen(driver, "editCustomerBlankID");
			Assert.assertTrue(true);
			logger.info("Customer edit test Failed");
		} else {
			Assert.assertTrue(false);
			logger.info("Customer edit test passed");
		}
	}

	@Test
	public void editCustomerNoID() throws IOException {
		Reporting rep = new Reporting();
		rep.test.assignAuthor("Hassen").assignCategory("Edit Customer");

		EditCustomerPage editcust = new EditCustomerPage(driver);
		editcust.clickEditCustomer();
		editcust.custSubmit();

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			//captureScreen(driver, "editCustomerNoID");
			Assert.assertTrue(false);
			logger.info("Customer edit test Failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Customer edit test passed");
		}
	}

	@Test
	public void editCustomerWithID() throws IOException {
		Reporting rep = new Reporting();
		rep.test.assignAuthor("Hassen").assignCategory("Edit Customer");

		EditCustomerPage editcust = new EditCustomerPage(driver);
		editcust.clickEditCustomer();
		editcust.custID("82206");
		editcust.custSubmit();

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			//captureScreen(driver, "editCustomerWithID");
			Assert.assertTrue(false);
			logger.info("Customer edit test Failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Customer edit test passed");
		}
	}

	@Test
	@Override
	public void verifyLinks() {
		super.verifyLinks();
		Reporting rep = new Reporting();
		rep.test.assignAuthor("Hassen").assignCategory("Edit Customer");
	}

	@Test
	@Override
	public void verifyLinkActive() {
		super.verifyLinkActive();
		Reporting rep = new Reporting();
		rep.test.assignAuthor("Hassen").assignCategory("Edit Customer");
	}
}
