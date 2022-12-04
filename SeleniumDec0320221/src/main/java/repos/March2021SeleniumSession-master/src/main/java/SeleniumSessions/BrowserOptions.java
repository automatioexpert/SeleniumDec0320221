package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		
		//headless mode:
		//No browser
		//testing is happening behind the scene
		//fast
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		co.addArguments("--incognito");
		
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");

		WebDriver driver = new FirefoxDriver(fo);// launch browser chrome

		// driver.get("http://www.google.com");//enter url
		driver.navigate().to("http://www.google.com");

		String title = driver.getTitle();// getting the page title
		System.out.println("page title is: " + title);

		// verification point//checkpoint/Act vs Exp result
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("in corect title");
		}

		// Automation Testing: Automation Steps + verification point

		System.out.println(driver.getCurrentUrl());

		// System.out.println(driver.getPageSource());

		driver.quit();

	}

}
