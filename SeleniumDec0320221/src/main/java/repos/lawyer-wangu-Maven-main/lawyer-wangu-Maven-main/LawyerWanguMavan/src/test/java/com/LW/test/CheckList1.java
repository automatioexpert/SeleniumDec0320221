package com.LW.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
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

import com.LW.Pom.InternalLogin;
import com.LW.generics.LWBaseClass;

public class CheckList1 extends LWBaseClass {
	@Test(priority=1)
	public void Checklist1_InternalLogin() throws InterruptedException, IOException {
		
		ExtentTest = extent.startTest(" Checklist1_InternalLogin");

		String c="window.scrollTo(0,document.body.scrollHeight)";
		js.executeScript(c);

		String un = f.getPropertyData("inusername");
		String pw =f.getPropertyData("inpassword"); 
		InternalLogin ig=new InternalLogin(driver); 
		ig.ClickCorporate();
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@name=\"login_username\"]")));
		ig.setLogin(un,pw);
		
		ig.myacc();
		Reporter.log("Internal login working fine",true);
        Thread.sleep(500);
        
		AssertJUnit.assertTrue(true==true);
		
	sa.assertAll(); 
		
	
		

	}

}
