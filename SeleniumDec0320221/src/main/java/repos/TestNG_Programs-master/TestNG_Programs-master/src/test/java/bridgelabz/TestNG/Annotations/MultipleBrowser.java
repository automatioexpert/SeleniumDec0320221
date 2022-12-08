package bridgelabz.TestNG.Annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowser {
	WebDriver driver = null;
	
	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) {
		System.out.println("Browser lauched is: " + browserName);
		
			//setup for Chrome browser
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//Raj Kawale//OneDrive//Desktop//chromedriver_win32//chromedriver.exe");
			WebDriverManager.chromedriver();   
			driver =  new ChromeDriver();
			
			//setup for Edge browser
		}else if(browserName.equalsIgnoreCase("edge")) {
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriverManager.edgedriver();  
			driver =  new EdgeDriver();
		}
	}
	
	@Test
	public void LauchBrowser() {
		driver.get("https://google.com");    //Opening URL with Browsers
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   //wait for few second
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
