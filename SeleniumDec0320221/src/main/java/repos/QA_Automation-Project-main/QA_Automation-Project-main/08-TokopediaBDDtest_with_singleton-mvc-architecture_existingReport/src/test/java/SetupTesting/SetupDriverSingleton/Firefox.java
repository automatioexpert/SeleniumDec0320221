package SetupTesting.SetupDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategyInterface {

	public WebDriver setStrategy() {
//		System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
}