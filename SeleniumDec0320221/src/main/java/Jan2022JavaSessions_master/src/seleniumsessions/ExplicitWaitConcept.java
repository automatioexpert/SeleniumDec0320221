package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {

		//1. ImplictlylWait: global wait
		//2. Explicit Wait: for a specific element, custom wait, non web elements (alerts, url, title)
				//a. WebDriverWait
				//b. FluentWait
		//WebDriverWait(C) extends FluentWait(C) implements Wait (Interface) - until();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailid = By.id("input-email11");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		waitForElementToBeVisible(emailid, 10).sendKeys("naveen@gmail.com");
		getElement(password).sendKeys("test@123");
		getElement(loginBtn).click();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));//sel 4.x
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));//sel 4.x
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	

}
