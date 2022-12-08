package com.parallelExecution.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	protected static WebDriver driver;

	protected void setup(String browser) {
		if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	protected void openURL(String url) {
		driver.get(url);
	}

}
