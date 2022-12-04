package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// dropdown - select tag
		// use Select class from selenium

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");

		//doSelectByIndex(country, 5);
		doSelectByVisibleText(country, "India");
		Thread.sleep(2000);
		doSelectByVisibleText(state, "Goa");

//		Select select = new Select(driver.findElement(country));
//		
//		select.selectByIndex(5);
//		select.selectByVisibleText("India");
//		select.selectByValue("Belarus");

	}

	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doSelectByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
