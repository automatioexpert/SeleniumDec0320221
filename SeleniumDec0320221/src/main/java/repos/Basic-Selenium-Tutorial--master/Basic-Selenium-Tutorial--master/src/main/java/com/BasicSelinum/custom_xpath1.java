package com.BasicSelinum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class custom_xpath1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Pizza");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		driver.quit();
		
	}

}
