package seleniumsessions;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(3000);

		driver.switchTo().frame("mainpanel");
		
		By contactLink = By.linkText("CONTACTS111");
		
		waitForPresenceOfElementWithFluentWait(contactLink, 10, 2000).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.pollingEvery(Duration.ofMillis(2))
				.ignoring(StaleElementReferenceException.class,
						NoSuchElementException.class);		
	}
	
	
	public static WebElement waitForPresenceOfElementWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(StaleElementReferenceException.class,
						NoSuchElementException.class).withMessage(locator + " is not present...");

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void waitForFrameWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(NoSuchFrameException.class);

		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public static Alert waitForAlertWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(NoAlertPresentException.class);

		 return wait.until(ExpectedConditions.alertIsPresent());
	}
	

}
