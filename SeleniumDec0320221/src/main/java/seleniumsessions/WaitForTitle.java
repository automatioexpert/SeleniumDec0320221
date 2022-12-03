package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		driver.findElement(By.linkText("Registry")).click();
		
		String title = waitForTitleContains("Registry", 5);
		System.out.println(title);
	}

	public static String waitForTitleContains(String titleFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		if (wait.until(ExpectedConditions.titleContains(titleFractionValue))) {
			return driver.getTitle();
		} else {
			System.out.println("title is not found.....");
			return null;
		}
	}
	
	public static String waitForTitleToBe(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		if (wait.until(ExpectedConditions.titleIs(titleValue))) {
			return driver.getTitle();
		} else {
			System.out.println("title is not found.....");
			return null;
		}
	}

}
