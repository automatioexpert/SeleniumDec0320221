package SeleniumSessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DifferentDrivers {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");

		// 1.
		// SearchContext sc = new ChromeDriver();

		// 2. for Remote execution
		// WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities)

		// 3.
		// SearchContext sc = new RemoteWebDriver(remoteAddress, capabilities)

		// 4. only for chrome
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");// enter url

		String title = driver.getTitle();// getting the page title
		System.out.println("page title is: " + title);
		
		//5. WebDriver driver = new ChromeDriver();
		//cross browser testing
		

	}

}
