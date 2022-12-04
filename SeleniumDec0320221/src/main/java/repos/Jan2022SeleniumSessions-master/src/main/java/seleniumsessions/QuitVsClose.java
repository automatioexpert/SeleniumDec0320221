package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();// launch chrome -- 123
		driver.get("https://www.google.com");//enter url
		String title = driver.getTitle(); //get thte page title -- Google
		System.out.println(title);
		
		driver.quit();//quit browser--sid = null
		//driver.close();//close browser
		//System.out.println(driver.getTitle());//?
		//NoSuchSessionException: invalid session id

		//re-initialization of the driver
		driver = new ChromeDriver();//launch chrome -- 456
		driver.get("https://www.google.com");//enter url
		title = driver.getTitle(); //get thte page title -- Google
		System.out.println(title);

		
	}

}
