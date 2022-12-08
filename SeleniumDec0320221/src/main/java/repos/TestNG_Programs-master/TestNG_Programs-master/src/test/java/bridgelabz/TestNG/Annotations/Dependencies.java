package bridgelabz.TestNG.Annotations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dependencies {
	public static WebDriver driver;
	
	@BeforeTest
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C://Users//Raj Kawale//OneDrive//Desktop//chromedriver_win32//chromedriver.exe");
		WebDriverManager.chromedriver();   //by using bonigarcia
		driver =  new ChromeDriver();
		driver.manage().window().maximize(); //to maximize the url window
		driver.get("https://www.amazon.in/");  //Open the url into browser
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   //wait for few second
	}
	
	@Test(priority = 1, enabled = true)
	public void LauchPage() {
		System.out.println(driver.getCurrentUrl());
		String CurrentURL = "https://www.amazon.in/";
		
		if(CurrentURL.equals(CurrentURL)) {
			System.out.println("Test case PASSED");
		} else {
			System.out.println("Test case FAILED");
		}	
		
		Assert.fail("Test case failed");  //To check for other method's execution if test case will forcefully fail (Second test case should be skipped)
	}
	
	//It will execute after 1st test case
	@Test(priority = 2, enabled = true, dependsOnMethods = "LauchPage")
	public void MobilePage() {
		driver.findElement(By.linkText("Mobiles")).click();
	}
	
	@AfterTest
	public void QuitePage() {
		driver.quit();
	}
} 


