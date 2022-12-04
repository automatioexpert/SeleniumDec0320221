package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementException {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//driver.findElement(By.id("input-email12")).sendKeys("test@gmail.com");
		//NoSuchElementException -- element is not available on the page
		
		//driver.findElement(By.xpath("//[val'Login']")).click();
		//InvalidSelectorException: invalid selector:
		
		List<WebElement> loginList = driver.findElements(By.id("input-email12"));
		System.out.println(loginList.size());
		
		if(loginList.size()<1) {
			System.out.println("login button is not found");
		}
		
		//ElementNotFoundException - is not valid ex for Selenium
		//StaleElementException
		//illegateStateException --> driver exe files are not setup
		//NoSuchSessionException --> if use driver after quit/close
		
		
	}

}
