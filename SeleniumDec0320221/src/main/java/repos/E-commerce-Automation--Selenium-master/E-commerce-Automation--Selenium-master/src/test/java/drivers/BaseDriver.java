package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	
	public static String baseURL="http://automationpractice.com";
	
     public static WebDriver driver=null;
     
     @BeforeSuite
     public void start() {
		String browser = System.getProperty("browser","chrome");
	    
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else{
			WebDriverManager.edgedriver().setup();
			driver =  new EdgeDriver();
		}
		
		PageDriver.getInstance().setDriver(driver);;
	}
     
     @AfterSuite
     public void close() {
		PageDriver.getCurrentDriver().quit();
	}
      
}
