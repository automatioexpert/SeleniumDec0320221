/**
 * 
 */
package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.listener.WebEventListener;
import com.util.Testutil;

/**
 * @author anand acharya
 * This is the parent class
 * **************************** PURPOSE *************************************
 * To read config.properties file
 * To initialize the required browser driver and create the web driver instance
 * To open the required website landing page 
 */
public class Testbase {

	public WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//create a constructor
	public Testbase() {
	//read the properties file
	prop = new Properties();
	try {
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
		} 
	}
	
	//instantiate web driver
	public void initialization(String url, String browserName){
		ChromeOptions chromeOptions;
		FirefoxOptions firefoxOptions;
		String osName = prop.getProperty("os");
		String chromedriverPath = System.getProperty("user.dir")+"/drivers/chromedriver";
		String geckodriverPath = System.getProperty("user.dir")+"/drivers/geckodriver";
		
		if(osName.equalsIgnoreCase("windows")) {
			if(browserName.equalsIgnoreCase("chrome")) {
				chromedriverPath+=".exe"; 
				System.setProperty("webdriver.chrome.driver", chromedriverPath);
				chromeOptions = new ChromeOptions();
				//disableImageChrome(options); //to disable all images in the page to speed up execution 
				chromeOptions.addArguments("--disable-notifications");
				driver = new ChromeDriver(chromeOptions);
			} else if(browserName.equalsIgnoreCase("chromeheadless")) {
				chromedriverPath+=".exe"; 
				System.setProperty("webdriver.chrome.driver", chromedriverPath);
				chromeOptions = new ChromeOptions();
				chromeOptions.setHeadless(true);
				driver = new ChromeDriver(chromeOptions);
			} else if(browserName.equalsIgnoreCase("firefox")) {
				geckodriverPath+=".exe";
				System.setProperty("webdriver.gecko.driver", geckodriverPath);
				firefoxOptions = new FirefoxOptions();
				//disableImageFirefox(firefoxOptions); //to disable all images in the page to speed up execution  
				firefoxOptions.addPreference("dom.webnotifications.enabled",false);
				driver = new FirefoxDriver(firefoxOptions);
			} else if(browserName.equalsIgnoreCase("firefoxheadless")) {
				geckodriverPath+=".exe";
				System.setProperty("webdriver.gecko.driver", geckodriverPath);
				firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(true);
				driver = new FirefoxDriver(firefoxOptions);
			}
		} else if (osName.equalsIgnoreCase("mac")) {
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromedriverPath);
				chromeOptions = new ChromeOptions();
				//disableImageChrome(options); //to disable all images in the page to speed up execution 
				chromeOptions.addArguments("--disable-notifications");
				driver = new ChromeDriver(chromeOptions);
			} else if(browserName.equalsIgnoreCase("chromeheadless")) {
				System.setProperty("webdriver.chrome.driver", chromedriverPath);
				chromeOptions = new ChromeOptions();
				chromeOptions.setHeadless(true);
				driver = new ChromeDriver(chromeOptions);
			} else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", geckodriverPath);
				firefoxOptions = new FirefoxOptions();
				//disableImageFirefox(firefoxOptions); //to disable all images in the page to speed up execution  
				firefoxOptions.addPreference("dom.webnotifications.enabled",false);
				driver = new FirefoxDriver(firefoxOptions);
			} else if(browserName.equalsIgnoreCase("firefoxheadless")) {
				System.setProperty("webdriver.firefox.marionette", geckodriverPath);
				firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(true);
				driver = new FirefoxDriver(firefoxOptions);
			}
		}
		
		//create object of EventFiringWebDriver class
		e_driver = new EventFiringWebDriver(driver);
		//Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().deleteAllCookies(); //delete all browser cookies
		driver.manage().window().maximize(); //maximize the browser
		//manage timeouts
		driver.manage().timeouts().pageLoadTimeout(Testutil.page_load_timeout, TimeUnit.SECONDS); //maximum time for the page to load completely
		driver.manage().timeouts().implicitlyWait(Testutil.implicit_wait, TimeUnit.SECONDS);//maximum time for the webelements to be visible
		//open the website
		driver.get(url);
	}
	
	//to disable all images in the page so improve execution speed
	public static void disableImageChrome(ChromeOptions options){
		HashMap<String, Object> images = new HashMap<String, Object>();
		images.put("images", 2);
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", images);
		options.setExperimentalOption("prefs", prefs);
	}
	
	//to disable all images in the page so improve execution speed
	public static void disableImageFirefox(FirefoxOptions options){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
	}
	
	//get the current webdriver instance
	public WebDriver getDriver() {
        return driver;
	}
	
	@BeforeSuite
	public void testSuitePrerequisites() throws InterruptedException {
		//delete the old run screenshots
		try {
			FileUtils.forceDelete(new File(System.getProperty("user.dir")+"/failedTestsScreenshots"));
			} catch (Exception e) {}
	}
	
	@AfterSuite
	public void onFinish() throws InterruptedException {
		if(driver!=null) {
			try {
				driver.quit();
			}
			catch (WebDriverException e) {
				System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
			}
		}
	}
	
}
