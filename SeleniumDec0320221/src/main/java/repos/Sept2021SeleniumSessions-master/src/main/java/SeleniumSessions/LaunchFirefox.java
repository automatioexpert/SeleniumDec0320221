package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();//launch ff
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
