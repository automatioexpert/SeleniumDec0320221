/**
 * 
 */
package commonutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author rohitnegi
 *
 */
public class GetDriver {
	
	public static WebDriver driver;
	
	public static WebDriver init(String browser, String url) throws Exception{
		
				//Check if parameter passed from TestNG is 'firefox'
				if(browser.equalsIgnoreCase("firefox")){
				//create firefox instance
					System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				
				//Check if parameter passed as 'chrome'
				else if(browser.equalsIgnoreCase("chrome")){
					//set path to chromedriver.exe
					System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
					//create chrome instance
					driver = new ChromeDriver();
				}
				
				else{
					//If no browser passed throw exception
					throw new Exception("Either firefox/chrome is configured for this project currently or you have not installed one of these on your system.");
				}
				
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				return driver;
	}

	
	public WebDriver getdriver() {
		
		return driver;
	}
}
