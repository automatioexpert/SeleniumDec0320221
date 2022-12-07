package com.BasicSelinum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GeckoDriver {

	public static void main(String[] args) {
		System.out.println("Exectuion with desired capabilities");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\geckodriver.exe");

		// Initialize Gecko Driver using Desired Capabilities Class
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);

		// Launch Website
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

		// Click on the Link Text using click() command
		driver.findElement(By.linkText("This is a link")).click();

	}

}
