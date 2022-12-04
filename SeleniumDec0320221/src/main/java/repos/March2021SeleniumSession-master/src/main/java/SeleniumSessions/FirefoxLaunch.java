package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();

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
