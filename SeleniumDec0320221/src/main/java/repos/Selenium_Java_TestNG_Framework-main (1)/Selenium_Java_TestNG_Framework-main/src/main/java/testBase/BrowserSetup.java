package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utililty.ReadProperties;

public class BrowserSetup {
	public static WebDriver driver = null;
	
	
	public static WebDriver initDriver() throws Exception
	{
		String browser =ReadProperties.getData("browser");
		System.out.println("Browser initialized as :"+browser);
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		else
		{
			System.out.println(browser+" Didn't matched any browser specified in properties file");
		}
		return driver;
	}

}
