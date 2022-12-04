package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();// launch browser chrome

		driver.get("http://www.google.com");// enter url

		String title = driver.getTitle();// get the title
		System.out.println(title);

		System.out.println(driver.getCurrentUrl());

		driver.quit(); // close the browser -- 123

		// driver.close(); //close the browser

		driver = new ChromeDriver(); // 456
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());

	}

}
