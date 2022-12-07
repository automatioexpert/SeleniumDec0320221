package Files.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MyTestClass {
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		 System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
	     driver = new ChromeDriver(); // launch chrome   
		
		 driver.get("http://testng.org/");	
	}

	@Test(priority=0)
	public void testTitle() {
	
	 String actualTitle = driver.getTitle();
	 
	 System.out.println("Actual Title is :" +actualTitle);
	 
	 String expectedTitle = "TestNG - Welcome";
	 
	 Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=1)
	public void clickDownload() {
	
		
	/*	System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch chrome   
		 
        driver.get("http://testng.org"); */
        
        WebElement downloadLink = driver.findElement(By.xpath("//*[@id=\"topmenu\"]/table/tbody/tr[1]/td[2]/a"));
        
        downloadLink.click();
       
        String heading = driver.getTitle();
        
        System.out.println("heading is:" +heading);
        
        Assert.assertEquals(heading, "TestNG - Download Current Release and Beta Versions");
	}
	
}





