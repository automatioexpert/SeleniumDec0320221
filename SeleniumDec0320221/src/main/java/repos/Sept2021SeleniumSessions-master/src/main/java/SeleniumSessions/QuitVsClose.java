package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		
		//session id
		
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("https://www.google.com");//launch url
		String title = driver.getTitle();//get the title
		System.out.println("page title is: " + title);
		
		//driver.close();
		driver.quit();//close the browser
		
		driver = new ChromeDriver();//launch chrome
		driver.get("https://www.google.com");//launch url
		System.out.println(driver.getTitle());
		
		
	}

}
