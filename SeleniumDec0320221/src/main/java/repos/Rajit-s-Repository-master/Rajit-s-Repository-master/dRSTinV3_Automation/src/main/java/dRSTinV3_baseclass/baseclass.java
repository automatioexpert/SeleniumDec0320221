package dRSTinV3_baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dRSTinV3_util.util;

public class baseclass {
	
	public static WebDriver driver;
	
	public static Properties prop = new Properties();
	
	public baseclass() throws Exception {
		
	
	
	FileInputStream ip = new FileInputStream("D:\\Git Repository\\Rajit-s-Repository\\dRSTinV3_Automation\\src\\main\\java\\dRSTinV3_config\\config.properties");
	
	prop.load(ip);

	}	
	
	public static void initialization() {
		String browsername = prop.getProperty("Browser");
		String url = prop.getProperty("Url");
		
		System.out.println("Rajit>>>>>>>" + url);
		
		if(browsername.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "Y:\\eclipse-java-2019-06-R-win32-x86_64\\eclipse\\chromedriver.exe");
			driver = new ChromeDriver();
			//
		}
		
		else if (browsername.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "Y:\\eclipse workspace\\TestNG\\src\\Lib\\Geckodriver\\geckodriver.exe");
			driver =  new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	}
}
