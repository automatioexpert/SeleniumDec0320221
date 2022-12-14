package org.automation.config;

import static java.lang.Boolean.getBoolean;
import static java.lang.Integer.getInteger;
import static java.lang.System.getProperty;
import static java.util.Optional.ofNullable;
import static org.automation.config.DriverType.CHROME;
import static org.automation.logger.Log.error;
import static org.automation.logger.Log.info;
import static org.automation.logger.Log.warn;
import static org.openqa.selenium.Platform.valueOf;
import static org.openqa.selenium.Proxy.ProxyType.MANUAL;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * To create a thread safe web driver instances.
 * 
 * @author Sujay Sawant
 * @version 1.0.0
 * @since 6/11/2020
 *
 */
public final class WebDriverThread {

	private WebDriver driver;
	private DriverType selectedDriverType;

	private final DriverType defaultDriverType = CHROME;
	private final Optional<String> browser = ofNullable(getProperty("browser"));
	private final String operatingSystem = getProperty("os.name").toUpperCase();
	private final String systemArchitecture = getProperty("os.arch").toUpperCase();
	private final boolean useRemoteWebDriver = getBoolean("remoteDriver");
	private final boolean proxyEnabled = getBoolean("proxyEnabled");
	private final String proxyHostname = getProperty("proxyHost");
	private final Integer proxyPort = getInteger("proxyPort");
	private final String proxyDetails = String.format("%s:%d", proxyHostname, proxyPort);

	/**
	 * Get the web driver instance.
	 * 
	 * @return web driver instance
	 */
	public WebDriver getDriver() {
		if (driver == null) {
			Proxy proxy = null;
			if (proxyEnabled) {
				proxy = new Proxy();
				proxy.setProxyType(MANUAL);
				proxy.setHttpProxy(proxyDetails);
				proxy.setSslProxy(proxyDetails);
			}
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities capabilities = selectedDriverType.getCapabilities(proxy);
			instantiateWebDriver(capabilities);
		}
		return driver;
	}

	/**
	 * Quit the web driver instance.
	 */
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	/**
	 * Get the browser's driver type to use.
	 * 
	 * @return browser's driver type
	 */
	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = DriverType.valueOf(browser.orElse("No browser specified").toUpperCase());
		} catch (IllegalArgumentException e) {
			warn("Issues initializing driver, defaulting to '" + driverType + "'...");
		}
		return driverType;
	}

	/**
	 * Create a new web driver instance.
	 * 
	 * @param capabilities desired capabilities to use
	 */
	private void instantiateWebDriver(DesiredCapabilities capabilities) {
		info("Operating System: " + operatingSystem);
		info("System Architecture: " + systemArchitecture);
		info("Browser Selection: " + selectedDriverType);
		if (useRemoteWebDriver) {
			URL seleniumGridURL = null;
			try {
				seleniumGridURL = new URL(getProperty("gridURL"));
			} catch (MalformedURLException e) {
				error("Incorrect Grid URL...", e);
				e.printStackTrace();
			}
			String desiredBrowserVersion = getProperty("desiredBrowserVersion");
			String desiredPlatform = getProperty("desiredPlatform");
			if (desiredPlatform != null && !desiredPlatform.isEmpty()) {
				capabilities.setPlatform(valueOf(desiredPlatform.toUpperCase()));
			}
			if (desiredBrowserVersion != null && !desiredBrowserVersion.isEmpty()) {
				capabilities.setVersion(desiredBrowserVersion);
			}
			driver = new RemoteWebDriver(seleniumGridURL, capabilities);
		} else {
			driver = selectedDriverType.getWebDriverObject(capabilities);
		}
	}

}
