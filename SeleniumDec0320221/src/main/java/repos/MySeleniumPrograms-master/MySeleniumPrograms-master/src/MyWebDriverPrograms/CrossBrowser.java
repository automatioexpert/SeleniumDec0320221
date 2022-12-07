package MyWebDriverPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CrossBrowser {
   
	 static WebDriver driver;
 
	public static void main(String[] args) {
		        
		        //Create Chrome
				System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		        driver = new ChromeDriver(); // launch chrome
		        driver.get("https://www.facebook.com/");  //Get URL
		        
		        
		        //Create FireFox
		        System.setProperty("webdriver.gecko.driver","C:/geckodriver/geckodriver.exe");
				driver = new FirefoxDriver(); 
		        driver.get("https://www.facebook.com/");  //Get URL
				
		        //Create Internet Explorer
				System.setProperty("webdriver.ie.driver", "C:/IEDriver/IEDriver.exe");
		        driver = new InternetExplorerDriver(); // launch IE
		        driver.get("https://www.facebook.com/");  //Get URL
		        String URL = driver.getCurrentUrl();
		        System.out.println("Current URL is:" +URL); 
		        
	}

}
