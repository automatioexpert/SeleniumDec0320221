package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {

		//geckodriver
		System.setProperty("webdriver.gecko.driver", "/Users/NaveenKhunteta/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://www.amazon.com");
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
		
		
	}

}
