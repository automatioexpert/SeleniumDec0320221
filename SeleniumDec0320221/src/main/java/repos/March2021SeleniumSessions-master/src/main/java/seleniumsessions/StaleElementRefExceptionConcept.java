package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefExceptionConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement emailId = driver.findElement(By.id("input-email"));
		
		emailId.sendKeys("test@gmail.com");
		
		driver.navigate().refresh();
		
		emailId = driver.findElement(By.id("input-email"));
		emailId.sendKeys("test123@gmail.com");
		
		
	}

}
