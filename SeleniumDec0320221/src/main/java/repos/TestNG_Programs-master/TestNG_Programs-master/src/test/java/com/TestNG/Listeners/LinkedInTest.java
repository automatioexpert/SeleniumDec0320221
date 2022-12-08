package com.TestNG.Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//to connect and link listeners to test class

public class LinkedInTest {
	static WebDriver driver = null; 
	@Test
	public void login() {
		
		//launching chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//open the Url
		driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		
		//finding login username
		driver.findElement(By.name("session_key")).sendKeys("Rajkawale00@gmail.com");
		//finding login password
		driver.findElement(By.name("session_password")).sendKeys("Mietgondia712@");
		//finding login button
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	}
	
	@Test
	public void failTest() {
		//comparing the webpage title and verify
		System.out.println("**Failed test case**");
		Assert.assertEquals(driver.getTitle(), "[(27) Feed | LinkedIn]");
		driver.close();
	}
	
	//Demo skip test
	@Test
	public void skippedTest() {
		System.out.println("**Skipped test case**");
		throw new SkipException("**Skipped exception thrown...**"); //It will throw exception with given message
	}
	
}
