package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrl {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.linkText("Register")).click();

		String url = waitForUrl(5, "route=account/register");
		System.out.println(url);
	
	}
	
	
	public static String waitForUrl(int timeOut, String urlFractionValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFractionValue))) {
			return driver.getCurrentUrl();
		}
		else {
			System.out.println("url is not found....");
			return null;	
		}

	}
	
	public static String waitForUrlToBe(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
		else {
			System.out.println("url is not found....");
			return null;	
		}

	}
	
	
	
	
	

}
