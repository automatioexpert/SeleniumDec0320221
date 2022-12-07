package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
public WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testTwo() throws InterruptedException {
		System.out.println("TestTwo");
		initializeBrowser();
		driver.navigate().to(prop.getProperty("url"));
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
