package com.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

	@Test
	public void crmHomePageTest() {
		doLogin();
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
	}
	
	public void doLogin(){
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//input[@type='submit']"))).perform();
	}

}
