package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// webelement + actions(click, sendkeys, gettext, isDisplayed....)

		// 1. id

		// 1st:
//		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");

		// 2nd:
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");

		// 3rd: By locator: OR
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailEle = driver.findElement(emailId);
//		WebElement pwdEle = driver.findElement(password);
//		
//		emailEle.sendKeys("naveen@gmail.com");
//		pwdEle.sendKeys("test@123");

		// 4. By locator + generic function
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(emailId).sendKeys("naveen@gmail.com");
//		getElement(password).sendKeys("test@123");

		// 5. By locator + generic functions for element and actions:
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(emailId, "naveen@gmail.com");
//		doSendKeys(password, "test@123");

		// 6th: By locator + generic functions for element and actions in some util
		// class:
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(emailId, "test@gmail.com");
//		eleUtil.doSendKeys(password, "test@123");

		// 7th: using utils in a different class

		// 8th: String locator + generic functions for element and actions in some util
		// class:
		String email_id = "input-email";
		String password_id = "input-password";
		
		doSendKeys("id", email_id, "test@gmail.com");
		doSendKeys("id", password_id, "test@123");


	}

	public static By getBy(String locatorType, String selector) {

		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(selector);
			break;

		default:
			break;
		}

		return locator;

	}
	
	public static void doSendKeys(String locatorType, String selector, String value) {
		By locator = getBy(locatorType, selector);
		getElement(locator).sendKeys(value);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
