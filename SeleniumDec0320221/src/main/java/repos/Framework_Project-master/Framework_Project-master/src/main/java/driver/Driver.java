package driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {
		
	}
	
	public static void initDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
		}
		DriverManager.getDriver().get(PropertyUtlis.get(ConfigProperties.URL));
	}

	public static void quitDriver() {
		if (Objects.isNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}		
	}
}
