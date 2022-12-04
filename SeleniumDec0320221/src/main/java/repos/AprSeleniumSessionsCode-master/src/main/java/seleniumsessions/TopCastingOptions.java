package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TopCastingOptions {

	public static void main(String[] args) {

		// 1. cross browser - Recommended
		//local execution
//		WebDriver driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver = new SafariDriver();
//
//		// 2. chrome specific - not Recommended for cross browser
//		ChromeDriver d1 = new ChromeDriver();
		
		//3. RWD - CD - Recommended - local
//		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
//		RemoteWebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
		
		//4. WD - RWD - Recommended
		//remote execution: grid, cloud, aws, docker grid
		//WebDriver driver = new RemoteWebDriver(192.178.1.1/wd/hub, capabilities);
		
		//5. SC -- CD - Not recommended
		//SearchContext driver = new ChromeDriver();
		
	}

}
