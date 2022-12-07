package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	public WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testThree() throws InterruptedException {
		System.out.println("TestThree");
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
