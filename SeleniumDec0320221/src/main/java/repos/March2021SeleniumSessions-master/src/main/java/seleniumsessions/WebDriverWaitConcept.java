package seleniumsessions;

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

		// WebDriverWait -- class -- extends FluentWait --until()
		//customize as per the webelement
		//not applied for all the WE by default
		//not a global wait
		//can be applied for non web elements: title, urls, alerts

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//input[@value='Login']");
		
		doPresenceOfElementLocated(emailId, 5).sendKeys("test@gmail.com");
		driver.findElement(password).sendKeys("test@123");
		driver.findElement(loginButton).isDisplayed();
		
		

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
	public static WebElement doPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element, 
	 * known to be present on the DOM of a page, is visible on the page also. 
	 * Visibility means that the element is not only displayed but also 
	 * has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement doVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	
	

}
