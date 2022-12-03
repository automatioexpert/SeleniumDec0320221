package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();// launch chrome

		driver.get("https://naveenautomationlabs.com/opencart/");// enter url
		String title = driver.getTitle();// get the title
		System.out.println("page title is: " + title);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		//driver.quit();//sid = 123 --> null
		driver.close();//close browser //sid = 123 ---> 123 --> invalid(expired)
		//System.out.println(driver.getTitle());
		
		driver = new ChromeDriver();//open browser: sid = 456
		driver.get("https://naveenautomationlabs.com/opencart/");//456
		System.out.println(driver.getTitle());//456

	}

}
