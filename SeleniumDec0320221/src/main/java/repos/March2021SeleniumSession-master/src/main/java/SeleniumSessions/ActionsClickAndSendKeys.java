package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {
	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement firstName = driver.findElement(By.id("Form_submitForm_FirstName"));
		
		Actions act = new Actions(driver);
		act.sendKeys(firstName, "testautomation").perform();
		
		doActionsSendKeys(By.id("Form_submitForm_LastName"), "selenium");
		
		act.click(driver.findElement(By.linkText("CONTACT SALES"))).perform();
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	

}
