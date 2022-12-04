package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();//launch browser
		
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		//driver.close();
		
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());//NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

		
		
	}

}
