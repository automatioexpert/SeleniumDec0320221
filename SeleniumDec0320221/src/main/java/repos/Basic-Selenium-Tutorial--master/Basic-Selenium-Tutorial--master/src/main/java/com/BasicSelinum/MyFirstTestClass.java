package com.BasicSelinum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstTestClass {
	public static void main(String[] args) {
		// Setting the driver path
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\geckodriver.exe");

		// Creating WebDriver instance
		WebDriver driver = new FirefoxDriver();

		// Navigate to web page
		driver.get("https://demoqa.com/login");

		// Maximizing window
		driver.manage().window().maximize();

		// Retrieving web page title
		String title = driver.getTitle();
		System.out.println("The page title is : " + title);

		// Locating web element
		WebElement uName = driver.findElement(By.id("userName"));
		WebElement pswd = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));

		// Performing actions on web elements
		uName.sendKeys("testuser");
		pswd.sendKeys("Password@123");
		loginBtn.click();

		// Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			WebElement logoutBtn = driver
					.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));
			if (logoutBtn.isDisplayed()) {
				logoutBtn.click();
				System.out.println("logout successful!");
			}
		} catch (Exception e) {
			System.out.println("Inccorect Login...");
			e.printStackTrace();
		}
		System.out.println("Test Complete!! --WebDriver session is closed.");
		driver.quit();
	}

}
