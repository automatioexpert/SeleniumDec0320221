package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		WebElement content = driver.findElement(By.className("menulink"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(content).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("COURSES")).click();

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public void handleTwoLevelMenu(By parentLocator, By childLocator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator)).perform();
		getElement(childLocator).click();
	}
	
	public void handleThreeLevelMenu(By parentLocator1, By parentLocator2, By childLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(parentLocator2)).perform();
		Thread.sleep(2000);
		getElement(childLocator).click();
	}
	

}
