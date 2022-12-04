package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementExceptionCocnept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.id("username"));
		
		element.sendKeys("test@gmail.com");
		
		driver.navigate().refresh();
		
		element = driver.findElement(By.id("username"));
		element.sendKeys("naveen@gmail.com");//StaleElementReferenceException: stale element reference: 
		//element is not attached to the page document

		
	}

}
