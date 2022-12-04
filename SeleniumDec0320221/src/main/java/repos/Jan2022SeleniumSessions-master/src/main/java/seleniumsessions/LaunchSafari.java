package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchSafari {

	public static void main(String[] args) {

		WebDriver driver = new SafariDriver();

		driver.get("https://www.google.com");// enter url
		String title = driver.getTitle(); // get thte page title -- Google
		System.out.println(title);

		driver.quit();

	}

}
