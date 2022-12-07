#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharedDriver {

	public SharedDriver() {

		ChromeOptions options = new ChromeOptions();

		//Add headless option
		String headless = System.getProperty("headless", "false");
		if(headless.equals("true")) options.addArguments("headless");
		options.setExperimentalOption("useAutomationExtension", false);
		util.printCurrentThread();

		if (DriverFactory.getDriver() == null) {
			String webdriver = System.getProperty("browser", "chrome");
			switch(webdriver) {
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					DriverFactory.addDriver(new FirefoxDriver());
					break;
				case "chrome":
					//Permite guardar el log del chromeDriver
					System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, System.getProperty("user.dir") + "/target/chromedriver.log");
					WebDriverManager.chromedriver().setup();
					DriverFactory.addDriver(new ChromeDriver(options));
					break;
				case "safari":
					//TODO: implement SafariDriver
					throw new RuntimeException("Unsupported webdriver: " + webdriver);
				default:
					throw new RuntimeException("Unsupported webdriver: " + webdriver);
			}
		}
	}
}
