package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		//windows:
		//System.setProperty("webdriver.chrome.driver", "c:\\users\\naveen\\downloads\\chromedriver.exe");
		
		//mac:
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();//launch browser chrome
		
		//driver.get("http://www.google.com");//enter url
		driver.navigate().to("http://www.google.com");
		
		String title = driver.getTitle();//getting the page title
		System.out.println("page title is: " + title);
		
		//verification point//checkpoint/Act vs Exp result
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("in corect title");
		}
		
		//Automation Testing: Automation Steps + verification point
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		driver.quit();//close the browser
		//driver.close();
		
		
		
	}

}
