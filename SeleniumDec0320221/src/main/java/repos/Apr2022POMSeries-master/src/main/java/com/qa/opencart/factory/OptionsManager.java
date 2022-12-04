package com.qa.opencart.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public static Logger log = Logger.getLogger(OptionsManager.class);

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		log.info("adding chrome options....");
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			co.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			co.addArguments("--incognito");

		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			 co.setPlatformName("linux");
			 co.setCapability("enableVNC", true);
			 //co.setBrowserVersion(prop.getProperty("browserversion"));
//				co.setCapability("se:timeZone", "US/Pacific");
//				co.setCapability("se:screenResolution", "1920x1080");

//			Map<String, Object> selenoidOptions = new HashMap<>();
//			selenoidOptions.put("screenResolution", "1280x1024x24");
//			selenoidOptions.put("enableVNC", true);
//			selenoidOptions.put("name", prop.getProperty("testname"));
//			co.setCapability("selenoid:options", selenoidOptions);
			 
			//
			 
			 
			 
			 
		}
		
		co.addArguments("--window-size=1280,800");
		 co.addArguments("--disable-gpu");
		 co.addArguments("--disable-setuid-sandbox");
		 co.addArguments("--no-sandbox");	
		 //co.addArguments("--headless");
		 co.addArguments("--verbose");
		 co.addArguments("--whitelisted-ips=");
		 co.addArguments("--disable-extensions"); 

		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			fo.addArguments("--incognito");

		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			 fo.setPlatformName("linux");
			fo.setCapability("enableVNC", true);
			//fo.setBrowserVersion(prop.getProperty("browserversion"));
//			fo.setCapability("se:timeZone", "US/Pacific");
//			fo.setCapability("se:screenResolution", "1920x1080");
			
//			Map<String, Object> selenoidOptions = new HashMap<>();
//			selenoidOptions.put("screenResolution", "1280x1024x24");
//			selenoidOptions.put("enableVNC", true);
//			selenoidOptions.put("name", prop.getProperty("testname"));
//			fo.setCapability("selenoid:options", selenoidOptions);
		}
		return fo;
	}

	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			eo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			eo.addArguments("--incognito");

		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			eo.setPlatformName("linux");
			eo.setCapability("enableVNC", true);
			fo.setBrowserVersion(prop.getProperty("browserversion"));
			eo.setCapability("se:timeZone", "US/Pacific");
			eo.setCapability("se:screenResolution", "1920x1080");

		}
		return eo;
	}

}
