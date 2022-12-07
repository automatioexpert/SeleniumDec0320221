package com.inetBanking.testCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilites.ReadConfig;
import com.inetBanking.utilites.WebElementListener;

public class BaseClass {

	ReadConfig read = new ReadConfig();

	public String baseURL = read.getApplicationURL();
	public String username = read.getUsername();
	public String password = read.getPassword();

	public static EventFiringWebDriver e_driver;
	public static WebElementListener eventListener;
	public static WebDriver driver;
	public static Logger logger;
	private int invalidLinksCount;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = logger.getLogger("ebanking");
		PropertyConfigurator.configure("Configuration/Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", read.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.chrome.driver", read.getEdgePath());
			driver = new EdgeDriver();
		}
		// Initializing EventFiringWebDriver
		e_driver = new EventFiringWebDriver(driver);

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebElementListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get(baseURL);
		System.out.println("Webpage gets loaded successfully!!");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}
		System.out.println("Test Completed Successfully");
	}


	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}

	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (generatedString2);
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * public boolean isAlertPresent() { boolean isPresent = false; try { Alert
	 * alert = driver.switchTo().alert(); isPresent = true; alert.accept(); } catch
	 * (NoAlertPresentException e) { System.out.println("No alert found."); } return
	 * isPresent; }
	 */

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetText() {
		boolean acceptNextAlert = true;
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	/*public void validateInvalidLinks() {
		// description ="Get number of links for this test and return number of valid
		// Links"
		try {
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			System.out.println("Total no. of links are " + anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						verifyURLStatus(url);
					} else {
						invalidLinksCount++;
					}
				}
			}

			System.out.println("Total no. of invalid links are " + invalidLinksCount);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(true);
	}

	public void verifyURLStatus(String URL) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200, if not increment
			// invalid link count
			//// We can also check for 404 status code like
			// response.getStatusLine().getStatusCode() == 404
			if (response.getStatusLine().getStatusCode() != 200)
				invalidLinksCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	public void verifyLinks() {
		try {
			invalidLinksCount = 0;
			List<WebElement> links = driver.findElements(By.tagName("a"));
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));

			System.out.println("Total links are " + links.size());

			for (int i = 0; i < anchorTagsList.size(); i++) {
				WebElement ele = links.get(i);
				String url = ele.getAttribute("href");

				verifyLinkActive();
				System.out.println(url);
			}
			invalidLinksCount++;
			System.out.println("Total no. of invalid links are " + invalidLinksCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public void verifyLinkActive() {
		try {
			String linkUrl = null;
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == 404) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}

			if (httpURLConnect.getResponseCode() == 500) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}

}
