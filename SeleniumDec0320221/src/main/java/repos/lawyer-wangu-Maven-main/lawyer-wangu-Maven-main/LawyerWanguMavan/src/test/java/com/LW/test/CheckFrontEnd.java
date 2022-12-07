package com.LW.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.LW.Pom.Logout;
import com.LW.Pom.MyAccount;
import com.LW.generics.LWBaseClass;

public class CheckFrontEnd extends LWBaseClass {
	@Test(priority=5, groups={"Smoke Testing"})
	public void TestMyAccount() throws Throwable  { 
	ExtentTest = extent.startTest(" TestsMyAccount");
	
	Thread.sleep(500);
	
	MyAccount m= new MyAccount(driver);
	
	m.myAccount();
	m.Profile();
	Reporter.log("Profile Pass",true);
	m.Details();
	Thread.sleep(500);

	m.Details2();
	
	// js.executeScript("window.scrollBy(0,-500)");

    m.Save();
   
	m.removecontect();
	Reporter.log("MyAccount Pass",true);
	m.checkCompletedDocuments();
	Reporter.log("Completed Documents pass",true);
	m.SavedForLater();
	Reporter.log("Saved For Later pass",true);
	m.Documentcart();
	Reporter.log("Document cart pass",true);
	Thread.sleep(1000);
	
	Reporter.log("CheckFrontEnd",true);
	
sa.assertAll(); 
}}


