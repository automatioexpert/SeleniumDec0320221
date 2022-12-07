package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base{
	public WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testFour() throws InterruptedException {
		System.out.println("TestFour");
	
		driver.get("http://tutorialsninja.com/demo");
		
		Thread.sleep(2000);
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}		
	}   

}
