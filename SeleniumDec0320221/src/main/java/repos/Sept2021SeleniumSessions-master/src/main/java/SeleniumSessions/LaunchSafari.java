package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchSafari {

	public static void main(String[] args) {

		WebDriver driver = new SafariDriver();
		driver.get("https://www.google.com");//launch url
		String title = driver.getTitle();//get the title
		System.out.println("page title is: " + title);
		
		
		
	}

}
