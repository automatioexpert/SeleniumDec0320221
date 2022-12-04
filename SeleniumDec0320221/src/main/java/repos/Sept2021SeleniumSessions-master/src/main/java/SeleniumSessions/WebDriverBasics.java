package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		//open chrome
		//enter url
		//get the title --> validation point (act vs exp)
		//get the url
		//close the browser
		
		//windows;
		//System.setProperty("webdriver.chrome.driver", "c:\\naveenautomationlabs\\Downloads\\chromedriver.exe");
		
		//mac
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//launch chrome
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
