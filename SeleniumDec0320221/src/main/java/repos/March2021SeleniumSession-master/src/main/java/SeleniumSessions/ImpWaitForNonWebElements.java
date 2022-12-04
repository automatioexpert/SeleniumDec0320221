package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImpWaitForNonWebElements {

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//global wait: it will be applied for all the WEs by default (using FE)	
		//only applicable for webelements
		//can not applied for non web elements: title, url, alert
		
		//1. login page: 10 secs
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.switchTo().alert();
		
		
		
		
		
		
	}

}
