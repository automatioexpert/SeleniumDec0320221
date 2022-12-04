package seleniumsessions;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	/**
	 * this method will initialize the driver on the basis of given browser name
	 * 
	 * @param browserName
	 * @return this will return the driver
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name is : " + browserName);
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("ignore-certificate-errors");
			co.addArguments("--no-sandbox");
			co.addArguments("--disable-blink-features=AutomationControlled");
			//co.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
//			co.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36");
			co.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

			driver = new ChromeDriver(co);
			((JavascriptExecutor)driver).executeScript("window.key = \"blahblah\";");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Browser not found...Please pass the right browser name...");
			break;
		}

		return driver;

	}

	public void lauchUrl(String url) {
		if (url == null)
			return;
		if (url.isEmpty())
			return;
		driver.get(url);
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
