package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	/**
	 * This mehtod is used to initialize the driver on the basis of given browser
	 * 
	 * @param browserName
	 * @return This returns the driver
	 */
	public WebDriver launchBrowser(String browserName) {

		System.out.println("browser name is: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the correct browser: " + browserName);
		}

		return driver;
	}

		

	public void launchUrl(String url) {
		if (url == null) {
			System.out.println("please pass the right url");
			return;
		}
		if (url.contains("https") || url.contains("http")) {
			driver.get(url);
		} else {
				driver.close();
			try {
			throw new Exception("INVALIDURLEXCEPTION - please pass the right url");
			}
			catch(Exception e ) {
				e.printStackTrace();
			}
		}

	}
	
	public void launchUrl(URL url) {
		driver.navigate().to(url);
	}
	
	

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
