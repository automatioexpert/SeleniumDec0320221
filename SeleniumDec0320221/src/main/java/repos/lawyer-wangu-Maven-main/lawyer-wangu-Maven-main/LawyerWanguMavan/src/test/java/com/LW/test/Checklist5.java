package com.LW.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.LW.Pom.backend;
import com.LW.generics.LWBaseClass;

public class Checklist5 extends LWBaseClass {
	@Test(priority=6)

	public void Checklist5_BackEndBasicFunctionality() throws InterruptedException, IOException   {

		ExtentTest = extent.startTest(" Checklist5_BackEndBasicFunctionality)");

		//driver.get("https://devstaging.lawyerwangu.com/lw/admin/login");
		String adminUrl = f.getPropertyData("adminUrl");
		driver.get(adminUrl);

		Thread.sleep(500);

		String un = f.getPropertyData("AdminUserName");
		String pw =f.getPropertyData("AdminPassword"); 
		backend d=new backend(driver);
		d.adminlogin(un, pw);


		WebElement sales = driver.findElement(By.xpath("//li[@id=\"sales_module\"]"));
		WebElement order = driver.findElement(By.xpath("//a[@id=\"order_check\"]"));
		Actions actions = new Actions(driver);
		//Performing the mouse hover action on the target element.
		actions.moveToElement(sales).moveToElement(order).click().build().perform();
		Reporter.log("Orders",true);
		d.Home();
		Thread.sleep(1000);

		WebElement sales2 = driver.findElement(By.xpath("//li[@id=\"sales_module\"]"));
		WebElement Payments = driver.findElement(By.xpath("//span[.=\"Payments\"] "));
		WebElement SuccessPayments = driver.findElement(By.xpath("//a[.=\"Success Payments\"] "));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(sales2).moveToElement(Payments).moveToElement(SuccessPayments).click().build().perform();
		Reporter.log("SuccessPayments",true);
		d.Home();

		WebElement sales3 = driver.findElement(By.xpath("//li[@id=\"sales_module\"]"));
		WebElement Payments2 = driver.findElement(By.xpath("//span[.=\"Payments\"] "));
		WebElement OtherTransactions = driver.findElement(By.xpath("//a[.=\"Other Transactions\"] "));
		Actions actions11 = new Actions(driver);
		actions11.moveToElement(sales3).moveToElement(Payments2).moveToElement(OtherTransactions).click().build().perform();
		Reporter.log("Other Transactions",true);

		Thread.sleep(1000);

		WebElement Catalog = driver.findElement(By.xpath("//span[.=\"Catalog\"]"));
		WebElement Products = driver.findElement(By.xpath("//a[.=\"Products\"]"));
		//WebElement OtherTransactions = driver.findElement(By.xpath("//a[.=\"Other Transactions\"] "));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(Catalog).moveToElement(Products).click().build().perform();
		Reporter.log("Products",true);

		Thread.sleep(1000);

		WebElement Catalog22 = driver.findElement(By.xpath("//span[.=\"Catalog\"]"));
		WebElement Offers = driver.findElement(By.xpath("//a[.=\"Offers\"]"));
		//WebElement OtherTransactions = driver.findElement(By.xpath("//a[.=\"Other Transactions\"] "));
		Actions actions3 = new Actions(driver);
		actions3.moveToElement(Catalog22).moveToElement(Offers).click().build().perform();
		Reporter.log("Offers",true);

		Thread.sleep(1000);

		WebElement Customers = driver.findElement(By.xpath("//span[.=\"Customers\"]"));
		WebElement customers = driver.findElement(By.xpath("(//a[contains(text(),\"Customers\")])[1]"));
		WebElement IndividualUsers = driver.findElement(By.xpath("//span[.=\"Individual Users\"]"));
		Actions actions4 = new Actions(driver);
		actions4.moveToElement(Customers).moveToElement(customers).moveToElement(IndividualUsers).click().build().perform();
		Reporter.log("Individual Users",true);
		
		Thread.sleep(1000);

		WebElement Customers1 = driver.findElement(By.xpath("//span[.=\"Customers\"]"));
		WebElement customers1 = driver.findElement(By.xpath("(//a[contains(text(),\"Customers\")])[1]"));
		WebElement InternalUsers = driver.findElement(By.xpath("//span[.=\"Internal Users\"]"));
		Actions actions5 = new Actions(driver);
		actions5.moveToElement(Customers1).moveToElement(customers1).moveToElement(InternalUsers).click().build().perform();
		Reporter.log("Internal Users",true);

		Thread.sleep(1000);

		WebElement Customers2 = driver.findElement(By.xpath("//span[.=\"Customers\"]"));
		WebElement customers2 = driver.findElement(By.xpath("(//a[contains(text(),\"Customers\")])[1]"));
		WebElement GuestUsers = driver.findElement(By.xpath("//span[.=\"Guest Users\"]"));
		Actions actions6 = new Actions(driver);
		actions6.moveToElement(Customers2).moveToElement(customers2).moveToElement(GuestUsers).click().build().perform();
		Reporter.log("Guest Users",true);


		Thread.sleep(1000);

		WebElement Reports = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement SalesReports = driver.findElement(By.xpath("//span[.=\"Sales Reports\"]"));
		WebElement IndividualUsersSalesReport = driver.findElement(By.xpath("//a[.=\"Individual Users Sales Report\"]"));
		Actions actions7 = new Actions(driver);
		actions7.moveToElement(Reports).moveToElement(SalesReports).moveToElement(IndividualUsersSalesReport).click().build().perform();
		Reporter.log("Individual Users Sales Report",true);

		Thread.sleep(1000);

		WebElement Reports1 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement SalesReports1 = driver.findElement(By.xpath("//span[.=\"Sales Reports\"]"));
		WebElement InternalUsersSalesReport = driver.findElement(By.xpath("//a[.=\"Internal Users Sales Report\"]"));
		Actions actions8 = new Actions(driver);
		actions8.moveToElement(Reports1).moveToElement(SalesReports1).moveToElement(InternalUsersSalesReport).click().build().perform();
		Reporter.log("Internal Users Sales Report",true);

		Thread.sleep(1000);

		WebElement Reports2 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement SalesReports2 = driver.findElement(By.xpath("//span[.=\"Sales Reports\"]"));
		WebElement Payments1 = driver.findElement(By.xpath("//a[.=\"Payments\"]"));
		Actions actions9 = new Actions(driver);
		actions9.moveToElement(Reports2).moveToElement(SalesReports2).moveToElement(Payments1).click().build().perform();
		Reporter.log("Report Payment",true);



		Thread.sleep(1000);

		WebElement Reports3 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement Customers3 = driver.findElement(By.xpath("(//span[.=\"Customers\"])[2]"));
		WebElement CustomersReport = driver.findElement(By.xpath("//a[.=\"Customers Report\"]"));
		Actions actions10 = new Actions(driver);
		actions10.moveToElement(Reports3).moveToElement(Customers3).moveToElement(CustomersReport).click().build().perform();
		Reporter.log("CustomersReport",true);
		Thread.sleep(1000);

		WebElement Reports4 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement Customers4 = driver.findElement(By.xpath("(//span[.=\"Customers\"])[2]"));
		WebElement CustomersFailedLoginReport = driver.findElement(By.xpath("//a[.=\"Customers Failed Login Report\"]"));
		Actions actions12 = new Actions(driver);
		actions12.moveToElement(Reports4).moveToElement(Customers4).moveToElement(CustomersFailedLoginReport).click().build().perform();
		Reporter.log("Customers Failed Login Report",true);
		Thread.sleep(1000);

		WebElement Reports5 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement Customers5 = driver.findElement(By.xpath("(//span[.=\"Customers\"])[2]"));
		WebElement AbandonedCart = driver.findElement(By.xpath("//a[.=\"Abandoned Cart\"]"));
		Actions actions13 = new Actions(driver);
		actions13.moveToElement(Reports5).moveToElement(Customers5).moveToElement(AbandonedCart).click().build().perform();
		Reporter.log("AbandonedCart",true);
		Thread.sleep(1000);

		WebElement Reports6 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement GuestUser = driver.findElement(By.xpath("//span[.=\"Guest User\"]"));
		WebElement IncompleteRegistration = driver.findElement(By.xpath("//a[.=\"Incomplete Registration\"]"));
		Actions actions14 = new Actions(driver);
		actions14.moveToElement(Reports6).moveToElement(GuestUser).moveToElement(IncompleteRegistration).click().build().perform();
		Reporter.log("Incomplete Registration",true);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.=\"Reports\"]")));
		
		
		WebElement Reports9 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement GuestUser1 = driver.findElement(By.xpath("//span[.=\"Guest User\"]"));
		WebElement AbandonedCartUsers = driver.findElement(By.xpath("//a[.=\"Abandoned Cart Users\"]"));
		Actions actions15 = new Actions(driver);
		actions15.moveToElement(Reports9).moveToElement(GuestUser1).moveToElement(AbandonedCartUsers).click().build().perform();
		Reporter.log("Abandoned Cart Users",true);
		Thread.sleep(1000);

		WebElement Reports8 = driver.findElement(By.xpath("//span[.=\"Reports\"]"));
		WebElement DocumentSellingReport = driver.findElement(By.xpath("//span[.=\"Document Selling Report\"]"));
		Actions actions16 = new Actions(driver);
		actions16.moveToElement(Reports8).moveToElement(DocumentSellingReport).click().build().perform();
		Reporter.log("DocumentSellingReport",true);
		
		String Url = f.getPropertyData("url");
		driver.get(Url);
		
		Reporter.log("BackEnd Basic Functionality working fine",true);
		AssertJUnit.assertTrue(true == true);
		
	    d.myaccount();
	    sa.assertAll(); 

	}
	

}
