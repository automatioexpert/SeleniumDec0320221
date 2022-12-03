package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		// win:
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Downloads\\chromedriver.exe");

		// mac:
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		
		//Top Casting: 
		//ChromeDriver class object can be referred by parent WebDriver Interface ref variable
		WebDriver driver = new ChromeDriver();// launch chrome
		
		driver.get("https://www.google.com");//enter url
		String title = driver.getTitle(); //get thte page title
		System.out.println(title);
		
		//validation point/ checkpoint/ act vs exp result / assertions
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl().contains("google"));
		
		System.out.println(driver.getPageSource().contains("Copyright The Closure Library Authors"));
		//automation steps + //validation point/ checkpoint/ act vs exp result / assertions
		//Automation Testing
		
		driver.quit();//close browser

	}

}
