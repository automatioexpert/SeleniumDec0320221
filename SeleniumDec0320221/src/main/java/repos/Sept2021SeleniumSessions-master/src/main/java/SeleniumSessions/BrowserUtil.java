package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	

	public WebDriver driver;

	/**
	 * This method is used to launch the browser on the basis of given browser name
	 * 
	 * @param browser
	 * @return this will return the driver
	 */
	public WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();// launch chrome
		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();// launch ff
		}

		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();// launch safari
		}

		else {
			System.out.println("please pass the right browser...." + browser);
		}

		return driver;
	}

	/**
	 * this method is used to enter the url
	 * 
	 * @param url
	 */
	public void enterUrl(String url) {
		if (url == null) {
			System.out.println("url is null...");
			return;
		}
		if (url.indexOf("http") == -1) {
			System.out.println("http is missing in url");
			return;
		}
		driver.get(url);
	}

	/**
	 * 
	 * @return this method will return current page url
	 */
	public String getAppCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	
}
