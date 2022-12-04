package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WhyWebDriverNotChromeDriver {

	public static void main(String[] args) {
		
		//why WebDriver driver = new ChromeDriver()? 
		//why not ChromeDriver driver = new ChromeDriver() ?

		WebDriverManager.chromedriver().setup();
		
		//WebDriver driver = new ChromeDriver();
		
		//ChromeDriver driver = new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();

		driver.get("http://www.amazon.com");// enter url

		String actualTitle = driver.getTitle();// get the page title
		System.out.println("page title is: " + actualTitle);

	}

}
