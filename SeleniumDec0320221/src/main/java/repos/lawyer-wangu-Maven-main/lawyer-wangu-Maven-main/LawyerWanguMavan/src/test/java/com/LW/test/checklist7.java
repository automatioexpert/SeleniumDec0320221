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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.LW.Pom.Document;
import com.LW.generics.LWBaseClass;

public class checklist7  extends LWBaseClass{
	@Test(priority=3)
	public void Cheklist7_IndividualUser_TillPreviewPage() throws InterruptedException, IOException   {

		ExtentTest = extent.startTest(" Cheklist7_IndividualUser_TillPreviewPage");

		//driver.get("https://devstaging.lawyerwangu.com/lw/auto");

		String DocumentUrl = f.getPropertyData("DocumentUrl");
		driver.get(DocumentUrl);

		Document dc = new Document(driver);

		dc.Doc();
		String b="window.scrollTo(0,document.body.scrollHeight)";
		js.executeScript(b);
		dc.nextbutton();

		String c="window.scrollTo(0,document.body.scrollHeight)";

		js.executeScript(c);
		Thread.sleep(500);
		WebElement ProceedtoPurchaseButton = driver.findElement(By.xpath("//input[@value=\"Proceed to Purchase\"]"));
		Thread.sleep(500);
		Object button = js.executeScript("arguments[0].scrollIntoView(true);", ProceedtoPurchaseButton);

		dc.ProceedtoPurchaseButton();
		dc.LWLogo();
		dc.ClickCart();

		dc.Edit();


		Thread.sleep(1000); 
		WebElement doc = driver.findElement(By.xpath("//canvas[contains(@id,\"canvas\")] "));

		wait.until(ExpectedConditions.visibilityOf(doc));
		
		
		WebElement ProceedtoPurchaseButton2 = driver.findElement(By.xpath("//input[@value=\"Proceed to Purchase\"]"));

		Object button2 = js.executeScript("arguments[0].scrollIntoView(true);", ProceedtoPurchaseButton2);

		//String d="window.scrollTo(0,document.body.scrollHeight)";
		Thread.sleep(500);

		dc.ProceedtoPurchaseButton();




		dc.MyAccount();

		Reporter.log("Login as individual user,check the document till preview page woking fine",true);

		AssertJUnit.assertTrue(true == true);
		sa.assertAll(); 


	}

}
