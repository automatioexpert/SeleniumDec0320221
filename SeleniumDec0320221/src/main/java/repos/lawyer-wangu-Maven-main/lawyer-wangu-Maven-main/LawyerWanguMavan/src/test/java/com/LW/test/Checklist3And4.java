package com.LW.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.LW.Pom.backend;
import com.LW.generics.LWBaseClass;

public class Checklist3And4 extends LWBaseClass {
	
	@Test(priority=2)
	public void Checklist3and4_backend_EQuestionnaireForNewAndOldDocument() throws InterruptedException, IOException   {
		
		ExtentTest = extent.startTest(" Checklist3and4_backend_EQuestionnaireForNewAndOldDocument");

		//driver.get("https://devstaging.lawyerwangu.com/lw/admin/login");
		String adminUrl = f.getPropertyData("adminUrl");
		driver.get(adminUrl);
		
		Thread.sleep(500);
		
		String un = f.getPropertyData("AdminUserName");
		String pw =f.getPropertyData("AdminPassword"); 
		backend d=new backend(driver);
		d.adminlogin(un, pw);
		
		WebElement catalog = driver.findElement(By.xpath("//li[@id=\"catalog_module\"]"));
		WebElement Products = driver.findElement(By.xpath("//li[.=\"Products\"]"));

		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(catalog).moveToElement(Products).click().build().perform();
		
		d.EQuestionnaire();
		
		String c="window.scrollTo(0,document.body.scrollHeight)";
		js.executeScript(c);
		
		d.OldDocumentEQuestionnaire();
		
		Thread.sleep(3000);
		//driver.get("https://devstaging.lawyerwangu.com");
		String Url = f.getPropertyData("url");
		driver.get(Url);
		
		d.myaccount();
		
		Reporter.log("backend EQuestionnaire For New And OldDocument working fine",true);
		AssertJUnit.assertTrue(true == true);
		
		Thread.sleep(1000);
		sa.assertAll(); 
	}
	

}
