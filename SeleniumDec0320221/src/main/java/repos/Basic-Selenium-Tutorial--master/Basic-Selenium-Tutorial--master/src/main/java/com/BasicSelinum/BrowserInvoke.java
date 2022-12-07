package com.BasicSelinum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInvoke {
	static WebDriver driver = null;
	static String driverPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		usingFirfox();
		usingEdge();
		usingChrome();
	}

	public static void usingFirfox() {
		System.setProperty("webdriver.gecko.driver", driverPath + "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.close();
	}

	public static void usingEdge() {
		System.setProperty("webdriver.edge.driver", driverPath + "\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.google.com");

		System.out.println("The URL of the Page is: " + driver.getCurrentUrl());
		System.out.println("The Title of the Page is: " + driver.getTitle());

		driver.close();
	}

	public static void usingChrome() {
		System.setProperty("webdriver.chrome.driver", driverPath + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Page URL is: " + currentUrl);

		String title = driver.getTitle();
		System.out.println("The Title of the Page is: " + title);

		driver.quit();
	}
}
