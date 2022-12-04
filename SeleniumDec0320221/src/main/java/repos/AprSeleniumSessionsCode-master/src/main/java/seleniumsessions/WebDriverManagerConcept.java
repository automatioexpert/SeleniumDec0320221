package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		
		//WebDriver driver = WebDriverManager.chromedriver().create();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// launch chrome

		driver.get("https://www.google.com");// enter url

		String title = driver.getTitle();// get the title
		System.out.println("page title is: " + title);

	}

}
