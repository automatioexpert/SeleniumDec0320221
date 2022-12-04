package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {

	public static void main(String[] args) {

		
		//Imp wait:
		//1. its only applicable for web elements
		//2. its not applicable for non web elements: title, url, alert
		//3. global wait -- it will be applied on all the web elements by default through out the session
		//dynamic wait --> total time = 10 secs, found = 2 secs
		//remaining secs: 8 secs (ignored)
		//4. applied with driver
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//for all WE with FE -- imp wait of 10 secs will be applied
		
		driver.findElement(By.id("input-email111")).sendKeys("test@gmail.com");
		
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.findElement(By.id("input-password")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//home page: 5 secs
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//e4
		//e5
		//e6 -- logout click
		
		//login page -- 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//contact page: 0 sec
		//nullify of imp wait --> 0 sec
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//login page -- 0 sec

		

		
		
		
		
		
	}

}
