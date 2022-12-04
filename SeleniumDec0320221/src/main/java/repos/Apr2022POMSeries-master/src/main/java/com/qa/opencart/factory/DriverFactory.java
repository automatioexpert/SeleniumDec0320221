package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author naveenautomationlabs
 *
 */
public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static Logger log = Logger.getLogger(DriverFactory.class);

	private static final String DRIVER_PATH = "./src/main/resources/";

	/**
	 * this method is used to initialize the driver on the basis of given
	 * browserName.
	 * 
	 * @param prop
	 * @return this returns driver
	 */
	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");

//		if(System.getenv("browserName")!=null) {
//			browserName = System.getenv("browserName");
//		}

		System.out.println("browser name is : " + browserName);
		log.info("browser name is : " + browserName);

		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			log.info("running test on chrome....");
			// driver = new ChromeDriver(optionsManager.optionsManager());

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// remote execution on grid:
				init_remoteWebDriver("chrome");
			} else {
				// local execution:
				log.info("Running tests on chrome -- local");
				 WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver");
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}

		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// remote execution on grid:
				init_remoteWebDriver("firefox");
			} else {
				// local execution:
				WebDriverManager.firefoxdriver().setup();
				// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
				tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}

		}

		else if (browserName.equalsIgnoreCase("safari")) {
			// driver = new SafariDriver();
			tlDriver.set(new SafariDriver());

		}

		else if (browserName.equalsIgnoreCase("edge")) {

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// remote execution on grid:
				init_remoteWebDriver("edge");
			} else {
				// local execution:
				WebDriverManager.edgedriver().setup();
				// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
				tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			}

		}

		else {
			System.out.println("please pass the right browser name : " + browserName);
			log.error("please pass the right browser...." + browserName);
			// info, error, warn, fatal
		}

		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	/**
	 * init remote webdriver on the basis of browser name
	 * 
	 * @param browserName
	 */
	private void init_remoteWebDriver(String browserName) {

		System.out.println("===========Running tests on Selenium GRID - Remote Machine...." + browserName);

		if (browserName.equals("chrome")) {
			try {
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		else if (browserName.equals("firefox")) {
			try {
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		else if (browserName.equals("edge")) {
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getEdgeOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this returns properties reference with all config properties
	 * 
	 * @return this returns properties reference
	 */
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;

		// commnd line args --> maven
		// mvn clean install -Denv="stage" -Dbrowser="chrome"
		// mvn clean install

		String envName = System.getProperty("env");
		// String envName = System.getenv("env");
		System.out.println("Running test cases on environment: " + envName);
		log.info("Running test cases on env: " + envName);

		if (envName == null) {
			System.out.println("No env is given...hence running it on QA env by default....");
			try {
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

		else {
			try {
				switch (envName.toLowerCase()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
					break;

				default:
					System.out.println("Please pass the right environment.... " + envName);
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * take screenshot
	 */
	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		// Users/naveenautomationlabs/Documents/workspace1/
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
