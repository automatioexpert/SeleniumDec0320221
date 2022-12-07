package driver;

import java.util.Objects;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	private Driver() {

	}

	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.firefoxdriver().setup();
			DriverManager.setDriver(new FirefoxDriver());
		} 
		DriverManager.getDriver().get("https://www.google.com");
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
