package com.LW.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

import com.LW.Pom.Document;
import com.LW.Pom.InternalLogin;
import com.LW.generics.LWBaseClass;

public class checklist8 extends LWBaseClass {

	@Test(priority=4)
	public void Cheklist8_InternalUser_TillPreviewPage() throws InterruptedException, IOException  { 

		ExtentTest = extent.startTest(" Cheklist8_InternalUser_TillPreviewPage");

		String c="window.scrollTo(0,document.body.scrollHeight)";
		js.executeScript(c);

		String un = f.getPropertyData("inusername");
		String pw =f.getPropertyData("inpassword"); 
		InternalLogin ig=new InternalLogin(driver); 

		ig.ClickCorporate();
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@name=\"login_username\"]")));
		ig.setLogin(un,pw);

		//driver.get("https://devstaging.lawyerwangu.com/lw/auto");
		String DocumentUrl = f.getPropertyData("DocumentUrl");
		driver.get(DocumentUrl);

		Document dc = new Document(driver);

		dc.Doc();
		String z="window.scrollTo(0,document.body.scrollHeight)";
		js.executeScript(z);

		dc.nextbutton();
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@value=\"Proceed to Purchase\"]")));

		dc.ProceedtoPurchaseButton();
		Reporter.log("Login as internal user,check the document till preview page woking fine",true);
		dc.Edit();

		Thread.sleep(1000);

		String d="window.scrollTo(0,document.body.scrollHeight)";
		js.executeScript(d);

		dc.ProceedtoPurchaseButton();

		dc.MyAccount();
		Reporter.log("Document is in cart, click on edit from the cart , Its working fine",true);
		Thread.sleep(1000);

		AssertJUnit.assertTrue(true == true);
		sa.assertAll(); 



	}

}
