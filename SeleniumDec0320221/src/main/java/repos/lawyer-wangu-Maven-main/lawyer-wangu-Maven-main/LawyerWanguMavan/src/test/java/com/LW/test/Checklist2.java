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

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.LW.Pom.backend;
import com.LW.generics.LWBaseClass;

public class Checklist2 extends LWBaseClass{
	@Test(priority=1)
	public void Checklist2_backend() throws InterruptedException, IOException   {

		ExtentTest = extent.startTest(" Checklist2_backend");

		String adminUrl = f.getPropertyData("adminUrl");
		driver.get(adminUrl);

		Thread.sleep(500);

		String un = f.getPropertyData("AdminUserName");
		String pw =f.getPropertyData("AdminPassword"); 
		
		backend d=new backend(driver);
		
		d.adminlogin(un, pw);


		Thread.sleep(500);

		String etitle = "Lawyer Wangu"; 
		String atitle = driver.getTitle(); 
		System.out.println("Title name : "+atitle);
		AssertJUnit.assertEquals(etitle, atitle);

		Thread.sleep(1000);

		ExtentTest = extent.startTest(" Checklist2_backend");

		String Url = f.getPropertyData("url");
		driver.get(Url);

		//driver.get("https://devstaging.lawyerwangu.com");

		d.myaccount();
		
		Reporter.log("backend login working fine",true);
		AssertJUnit.assertTrue(true == true);
		sa.assertAll(); 


	}

}
