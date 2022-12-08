package com.parameterization.testngXML;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterization_testNgXml {
	public static WebDriver driver;
	
	@Test
	@Parameters({"Browser", "url", "email", "password"})
	public void LinkedIn(String Browser, String url, String email, String password) {
		//for browser validation and setup
		if (Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(Browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
			
		driver.manage().window().maximize();
		driver.get(url);
		
		//**2** Finding elements within the current page by using element locators.
			driver.findElement(By.name("session_key")).sendKeys(email);
		    driver.findElement(By.name("session_password")).sendKeys(password);
		        //driver.findElement(By.className("Remember me")).click();
		    driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	}
}
