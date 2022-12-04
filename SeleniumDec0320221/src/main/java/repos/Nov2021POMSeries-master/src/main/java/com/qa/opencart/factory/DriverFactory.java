package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal();

	/**
	 * this method is used to initialize the driver using browser name
	 * 
	 * @param browserName
	 * @return this returns the webdriver
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		String browserVersion = prop.getProperty("browserversion").trim();

		highlight = prop.getProperty("highlight").trim();

		System.out.println("browser name is : " + browserName + " and browserversion: " + browserVersion);
		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// remote execution on grid server:
				init_remoteDriver("chrome");
			} else {
				// local execution:
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}

		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// remote execution on grid server:
				init_remoteDriver("firefox");
			} else {
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}

		}

		else if (browserName.equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());
		}

		else {
			System.out.println("Please pass the right browser name : " + browserName);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
		return getDriver();
	}

	/**
	 * run test cases on remote machine
	 * 
	 * @param browser
	 */
	private void init_remoteDriver(String browser) {

		System.out.println("Running test cases on remote grid server : " + browser);

		if (browser.equals("chrome")) {
			try {
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (browser.equals("firefox")) {
			try {
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * this will return the thread local copy of the driver
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is used to initialize the properties
	 * 
	 * @return this returns properties class ref
	 */
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;

		// mvn clean install -Denv="qa"
		String envName = System.getProperty("env");// qa/stage/dev/prod
		System.out.println("Running tests on environment: " + envName);

		if (envName == null) {
			System.out.println("No env is gievn....hence running it on QA");
			System.out.println("Running tests on QA environment: " + envName);

			try {
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		else {
			try {
				switch (envName.toLowerCase()) {
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;

				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;

				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;

				default:
					System.out.println("Please pass the right environment......");
					break;
				}
			} catch (Exception e) {
			}
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	// ThreadLocal -- JDK 8 --> create a local copy of driver
	// set driver with TL
	// getdriver() -- driver
	// dribver null problem
	// u can take ur driver copy anywhere in ur framework
	// better thread management
	// to avoid the dead local conditon -- TL driver copy
	// large test cases count -- 200, 300 TCS --> proper test results

	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
