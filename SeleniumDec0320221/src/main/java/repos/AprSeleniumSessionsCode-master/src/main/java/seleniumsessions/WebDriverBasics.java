package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		//start the server with binary/.exe file
		
		//windows:
		//System.setProperty("webdriver.chrome.driver", "c:\\users\\naveenautomationlabs\\Downloads\\chromedriver.exe");
		
		//mac:
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//launch chrome
		
		driver.get("https://www.google.com");//enter url
		
		String title = driver.getTitle();//get the title
		System.out.println("page title is: " + title);
		
		//verification point/checkpoint/assertion/act vs exp result
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		
		//automation steps + verification point(checkpoint) => Automation Testing
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
//		String source = driver.getPageSource();
//		System.out.println(source.contains("Copyright The Closure Library Authors"));
		
		driver.quit();//close the browser
		
	}

}
