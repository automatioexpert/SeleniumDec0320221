package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplictlyWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//script ---> app
		//Thread.sleep(10000);//static wait
		
		
		//dynamic wait:
		//implicitly wait:
			//global wait : it will be applicable for all the web elements
			//FE : imp wait will be applied by default
			//it works only for web elements
			//it does not work for non web elements: alerts, url, title
			//we avoid imp wait in framework design
		
		/**
		 * 
		 * Specifies the amount of time the driver should wait
		 *  when searching for an element if it is not immediately present.

			When searching for a single element, 
			the driver should poll the page until the element has been found, 
			or this timeout expires before throwing a NoSuchElementException. 
			
			When searching for multiple elements, 
			the driver should poll the page until at least one element has been found
			 or this timeout has expired.

			Increasing the implicit wait timeout should be used judiciously 
			as it will have an adverse effect on test run time, 
			especially when used with slower location strategies like XPath.
		 */
		
		//timeout = 10 secs --> 2 secs ---> 8 secs ignored
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		driver.findElement(By.id("input-email11")).sendKeys("test@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("test@123");
		//e3 e4 
		
		//home page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// e5 e6
		//click on logout
		//login page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//click on register:
		//register page: 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//e9 10
		//product page: 0 secs -- nullify imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));	
		
	}

}
