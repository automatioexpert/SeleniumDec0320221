package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setBrowserVersion(prop.getProperty("browserversion"));
			co.setPlatformName("linux");
			co.setCapability("enableVNC", true);
			//sel 4.x
		}
		
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("enableVNC", true);
		caps.setCapability("browserVersion", prop.getProperty("browserversion"));
		caps.setCapability("moz:debuggerAddress", false);
		
		
		fo = new FirefoxOptions(caps);
//		if (Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
//		if (Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
//		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
//			fo.setBrowserVersion(prop.getProperty("browserversion"));
//			fo.setPlatformName("linux");
//			fo.setCapability("enableVNC", true);
////			fo.setCapability("moz:debuggerAddress", false);
//
//			//sel 4.x
//		}
		return fo;
	}

}
