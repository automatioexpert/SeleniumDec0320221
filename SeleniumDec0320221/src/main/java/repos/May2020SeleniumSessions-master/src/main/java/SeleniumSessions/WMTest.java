package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WMTest {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
//
//		WebDriver driver = new ChromeDriver();// launch browser

		//WebDriverManager.firefoxdriver().setup();
		
		WebDriverManager.getInstance(SafariDriver.class).setup();
		
		WebDriver driver = new SafariDriver();
		
		driver.get("http://www.amazon.com");// enter url

		String actualTitle = driver.getTitle();// get the page title
		System.out.println("page title is: " + actualTitle);

	}

}
