package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowser {
	
	static WebDriver driver;


	public static void main(String[] args) {

		String browser = "safari";
		
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/NaveenKhunteta/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("safari")){
			driver = new SafariDriver();
		}
		
		else{
			System.out.println("Please pass the correct browser name... " + browser);
		}
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
	}

}
