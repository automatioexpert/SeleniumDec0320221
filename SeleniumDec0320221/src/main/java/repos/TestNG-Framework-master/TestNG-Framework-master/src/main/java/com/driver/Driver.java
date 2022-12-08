package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.support.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	WebDriver driver;

	
	/** 
	 * @return WebDriver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	
	/** 
	 * @param driver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Driver() {
	}

	
	/** 
	 * Create Webdriver 
	 * 
	 * @param browserName
	 * @return WebDriver
	 */
	public WebDriver getWebdriver(String browserName) {
		try {
			browserName = browserName.toUpperCase();
			Browsers browser = Browsers.valueOf(browserName);
			switch (browser) {
				case CHROME:
					WebDriverManager.chromedriver().setup();
					setDriver(new ChromeDriver());
					break;
				case FIREFOX:
					WebDriverManager.firefoxdriver().setup();
					setDriver(new FirefoxDriver());
					break;
				case EDGE:
					WebDriverManager.edgedriver().setup();
					setDriver(new EdgeDriver());
				default:
					break;

			}
		} catch (Exception e) {
			System.out.println("...........Driver initilization failed......");
			e.printStackTrace();
		}
		return getDriver();
	}

}
