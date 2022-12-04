package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//global wait: it will be applied for all the WEs by default (using FE)	
		//only applicable for webelements
		//can not applied for non web elements: title, url, alert
		
		//1. login page: 10 secs
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		WebElement emailId = driver.findElement(By.id("input-email111"));
		WebElement password = driver.findElement(By.id("input-password"));//0 sec --> 10 secs
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));

		emailId.sendKeys("test@gmail.com");
		password.sendKeys("test123");
		loginBtn.click();
		
		//2. home page: 5 secs:
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//e4
		//e5
		//e6 --logout
		
		//1. login page: 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//2. home page: 5 secs:

		//3. product page:  0 sec:
		//nullify of imp wait:
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		//login page: 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}

}
