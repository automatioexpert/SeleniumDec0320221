package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		TimeUtil.shortWait();

		By emailID = By.id("input-email111");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

	}

	public static WebElement waitForElementWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_WEB_ELEMENT_MSG)
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class, 
						StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public static Alert waitForAlertWithFluentWait(int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_ALERT_MSG)
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoAlertPresentException.class);

		 return wait.until(ExpectedConditions.alertIsPresent());

	}
	
	
	public static WebDriver waitForFrameWithFluentWait(String frameLocator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_FRAME_ELEMENT_MSG)
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchFrameException.class);

		 return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

	}

}
