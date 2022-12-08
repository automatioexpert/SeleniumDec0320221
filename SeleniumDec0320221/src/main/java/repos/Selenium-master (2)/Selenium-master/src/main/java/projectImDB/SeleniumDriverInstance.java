package projectImDB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriverInstance {
	
	protected static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SeleniumDriverInstance.driver = driver;
	}

	public SeleniumDriverInstance(String browserName){

		try {
			
			if(browserName.contains("firefox")){
			driver = new FirefoxDriver();	
			} else if (browserName.contains("Chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();	
			} 
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
