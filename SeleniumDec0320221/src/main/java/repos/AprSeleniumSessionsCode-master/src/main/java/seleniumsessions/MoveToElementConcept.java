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
		
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");

//		WebElement parentMenu = driver.findElement(By.className("menulink"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(parentMenu).perform();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.linkText("COURSES")).click();
		
		By parentMenu = By.className("menulink");
		By courses = By.linkText("COURSES");
		
		handleTwoLevelMenuItems(parentMenu, courses);
	}
	
	public static void handleTwoLevelMenuItems(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	

}
