package com.TestNG.Listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Addinng listeners that we wants to perform on this class level test
@Listeners(BasicTest_Listeners.class)
public class BasicTest {
	
	@Test
	public void testUrl() {
		//setup for webpage and driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		//To check the and title and getting title name
		Assert.assertEquals(driver.getTitle(), "Online shopping sites in india");
	}
}
