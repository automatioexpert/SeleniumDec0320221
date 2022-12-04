package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		// imp wait --- 10
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailID = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		// WebDriverWait: -- Class
		// can be aplied for any web elements
		// not a global wait
		// wont be applied for all the webelements
		// can be applied for non web elements: title, url, alert

		// An expectation for checking that an element is present on the DOM of a page.
		// This does not necessarily mean that the element is visible.
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailID));
//		email_ele.sendKeys("test@gmail.com");

		doPresenceOfElementLocated(emailID, 5).sendKeys("test@gmail.com");
		driver.findElement(password).sendKeys("test@123");
		driver.findElement(loginBtn).click();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static WebElement doPresenceOfElementLocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element, known to be present on the DOM
	 * of a page, is visible. Visibility means that the element is not only
	 * displayed but also has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static WebElement isElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

}
