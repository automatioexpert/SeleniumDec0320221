package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();	

		WebDriver driver = new ChromeDriver();// launch browser chrome

		driver.get("http://www.google.com");// enter url

		String title = driver.getTitle();// getting the page title
		System.out.println("page title is: " + title);

		// verification point//checkpoint/Act vs Exp result
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("in corect title");
		}

		driver.quit();

	}

}
