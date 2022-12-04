package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {
	
	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();//Browser

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		By frame = By.name("main");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
		waitForFrameUsingLocatorAndSwitchToIt(5, frame);
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		
	}
	
	
	public static void waitForFrameUsingLocatorAndSwitchToIt(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameUsingIndexAndSwitchToIt(int timeOut, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameUsingNameOrIdAndSwitchToIt(int timeOut, String frameNameOrId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
	}
	
	public static void waitForFrameUsingElementOrIdAndSwitchToIt(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getElement(frameLocator)));
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	

}
