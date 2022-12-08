package com.kugeci;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Setup {
	// Variable scope: Broadly speaking, public means everyone is allowed to access, 
	// private means that only members of the same class are allowed to access, 
	// and protected means that members of subclasses are also allowed. 
	protected WebDriver driver;
	protected String browser;
	
	@BeforeClass //every class needs it owner driver, can not write BeforeTest here to run multiple classes in testng.xml
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		//this.browser = browser;
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","..\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","..\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterTest() {
		driver.quit();	
	}

}
