package com.extentreports.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverManager;

public final class ExtentReportDemo extends BaseTest{
	
	@Test
	public void firstTest() throws IOException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
		String title=DriverManager.getDriver().getTitle();
		Assert.assertEquals(title, "Google");
	}
	
	@Test
	public void secondTest() throws IOException {
		Assert.assertTrue(false);
	}
}
