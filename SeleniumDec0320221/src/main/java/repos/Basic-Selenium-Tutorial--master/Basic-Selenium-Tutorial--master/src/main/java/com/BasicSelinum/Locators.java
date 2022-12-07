package com.BasicSelinum;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.navigate().to("https://login.yahoo.com/");

		// Locate by ID attribute
		driver.findElement(By.id("login-username")).sendKeys("QAutomation@yahoo.com");
		Thread.sleep(700);
		driver.findElement(By.id("login-username")).clear();

		// Locate by Name attribute
		driver.findElement(By.name("username")).sendKeys("QualityTesting@yahoo.com");
		Thread.sleep(700);
		driver.findElement(By.name("username")).clear();

		// Locate by className attribute
		driver.findElement(By.className("phone-no")).sendKeys("edureka@yahoo.com");
		Thread.sleep(700);
		driver.findElement(By.className("phone-no")).clear();

		// Locate by LinkText attribute
		driver.findElement(By.linkText("Forgot username?")).click();
		Thread.sleep(700);
		driver.navigate().back();

		// partialLinkText attribute
		driver.findElement(By.partialLinkText("Create an accou")).click();
		Thread.sleep(700);
		
		driver.navigate().back();
		
		// Locate by cssSelector attribute
		driver.findElement(By.cssSelector("input[id='login-username']")).sendKeys("UnitTesting@yahoo.com"); //Locating Strategies- (By CSS-Tag and Attribute)
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input#login-username")).clear();  //Locating Strategies- (By CSS- Tag and ID)
		Thread.sleep(700);
		
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("JenkinsCI@yahoo.com"); //Locating Strategies- (By CSS-Tag and Attribute)
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input[name='username']")).clear();
		Thread.sleep(700);
		
		driver.findElement(By.cssSelector("input.phone-no")).sendKeys("Github@yahoo.com"); //Locating Strategies- (By CSS-Tag and Class)
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input.phone-no[name='username']")).clear();  //Locating Strategies- (By CSS-Tag, Class and Attribute)
		Thread.sleep(700);
		
		// Locate by tagName attribute
		
	    // Return Number of Link Elements Present in a WebPage
		List <WebElement> LinkNumber=driver.findElements(By.tagName("a"));
        System.out.println(LinkNumber.size());
        // Return Name of all Elements
        for (WebElement LinksName:LinkNumber) {
			System.out.println(LinksName.getText());			
		}
        
     // Locate by xpath
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("xpathTesting@yahoo.com");        
	}
}
