package bridgelabz.TestNG.Annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Groups_Concepts_RegEx {
			public static WebDriver driver;
			
			@BeforeTest
			public void start() {
				System.setProperty("webdriver.chrome.driver", "C://Users//Raj Kawale//OneDrive//Desktop//chromedriver_win32//chromedriver.exe");
				WebDriverManager.chromedriver();   
				driver =  new ChromeDriver();
				driver.manage().window().maximize(); //to maximize the url window
				driver.get("https://www.amazon.in/");  //Open the url into browser
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   //wait for few second
			}
			
			//Declaring with group tag
			@Test(groups = {"Demo1"})
			public void LauchPage() {
				System.out.println(driver.getCurrentUrl());
				String CurrentURL = "https://www.amazon.in/";
				
				if(CurrentURL.equals(CurrentURL)) {
					System.out.println("Test case PASSED");
				} else {
					System.out.println("Test case FAILED");
				}		
			}
			
			//It will execute after 1st test case
			@Test(groups = {"Demo2"})
			public void MobilePage() {
				driver.findElement(By.linkText("Mobiles")).click();
			}
			 
			@AfterTest
			public void QuitePage() {
				driver.quit();
			}
}
