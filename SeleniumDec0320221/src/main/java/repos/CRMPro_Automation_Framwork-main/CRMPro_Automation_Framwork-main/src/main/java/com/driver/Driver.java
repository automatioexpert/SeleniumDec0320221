package com.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.utils.PropertyUtils;


public final class Driver {

	private Driver() {
	}
	
	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxdriverpath());
			DriverManager.setDriver(new FirefoxDriver());
			
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getImplicitWait(), TimeUnit.SECONDS);
			DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getPageLoadTimeout(), TimeUnit.SECONDS);
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}		
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
