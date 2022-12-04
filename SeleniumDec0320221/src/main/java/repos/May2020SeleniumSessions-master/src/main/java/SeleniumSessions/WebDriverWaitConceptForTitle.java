package SeleniumSessions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConceptForTitle {

	public static void main(String[] args) {

		// WebDriverWait is a class
		// extending FluentWait class
		// Wait interface

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		String title = doGetPageTitleWithContains(driver, 10, "Amazon");
		System.out.println(title);

		// (tried for 2 second(s) with 500 milliseconds interval) --
		// TimeoutException -- if title is not found within 2 secs
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.urlContains("amazon"));
		
		System.out.println(doGetPageCurrentUrl(driver, 5, "amazon"));

	}

	public static String doGetPageTitleWithContains(WebDriver driver, int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public static String doGetPageTitleWithIsTitle(WebDriver driver, int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	public static String doGetPageCurrentUrl(WebDriver driver, int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlContains(urlValue));
		return  driver.getCurrentUrl();
	}


}
