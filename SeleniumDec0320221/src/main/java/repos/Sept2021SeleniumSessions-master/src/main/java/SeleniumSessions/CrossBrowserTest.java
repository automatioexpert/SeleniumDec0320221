package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {

	static WebDriver driver;

	public static void main(String[] args) {

		String browser = "chrome";

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			driver = new ChromeDriver();// launch chrome

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			driver = new FirefoxDriver();// launch ff
		}

		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();// launch safari
		}

		else {
			System.out.println("please pass the right browser...." + browser);
		}

		driver.get("https://www.google.com");//launch url
		String title = driver.getTitle();//get the title
		System.out.println("page title is: " + title);
		
		//validation point/checkpoint:(act vs exp):
		if(title.equals("Google")) {
			System.out.println("PASS -- correct title");
		}else {
			System.out.println("FAIL -- incorrect title");
		}
		
		//Automation steps + validation point ==> automation testing
		
		System.out.println(driver.getCurrentUrl());
		
		//driver.quit();//close browser
		driver.close();
		
		
		
	}

}
