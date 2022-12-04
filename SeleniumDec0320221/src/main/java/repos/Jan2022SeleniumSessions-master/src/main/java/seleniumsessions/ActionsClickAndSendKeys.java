package seleniumsessions;

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
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By email = By.id("input-email"); 
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value = 'Login']");
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(email), "tom@gmail.com").perform();
		act.sendKeys(driver.findElement(password), "tom123").perform();

		act.click(driver.findElement(loginBtn)).perform();
		
		
		//ElementNotIntereactableException
		
				
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	
	
	

}
