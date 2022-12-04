package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrwoserTest {

	static WebDriver driver;

	public static void main(String[] args) {

		String browser = "CHROME";

		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("please pass the correct browser....");
			break;
		}

		driver.get("http://www.google.com");// enter url

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

		driver.quit();// close the browser

	}

}
