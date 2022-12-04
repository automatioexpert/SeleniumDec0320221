package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.bigbasket.com/");

//		WebElement contentEle = driver.findElement(By.className("menulink"));
//		
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(contentEle).perform();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.linkText("COURSES")).click();

//		By parentMenu = By.className("menulink");
//		By childMenu = By.linkText("COURSES");
//
//		selectSubMenu(parentMenu, childMenu);
		
		By mainMenu = By.className("meganav-shop");
		By bevrages = By.linkText("Beverages");
		By tea = By.linkText("Tea");
		By teaBags = By.linkText("Tea Bags");
		selectSubMenu(mainMenu, bevrages, tea, teaBags);
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}

	public static void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();
	}

	public static void selectSubMenu(By parentMenu, By childMenu1, By subChildMenu2, By subChildMenu3)
			throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(subChildMenu2)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu3).click();
	}

}
