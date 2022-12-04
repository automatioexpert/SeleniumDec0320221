package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		// html tag = select
		// we have to use Select class in selenium:
		WebElement indus = driver.findElement(By.id("Form_submitForm_Industry"));
//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//
//		
		Select sel = new Select(indus);
		System.out.println(sel.isMultiple());
		
//		//sel.selectByIndex(4);
//		sel.selectByVisibleText("Automotive");
//		//sel.selectByValue("health");
//		
//		Select sel1 = new Select(country);
//		sel1.selectByVisibleText("India");

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		doSelectDropDownByIndex(industry, 4);
		doSelectDropDownByIndex(country, 10);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectDropDownByIndex(By locator, int index) {
		Select sel = new Select(getElement(locator));
		sel.selectByIndex(index);
	}

	public static void doSelectDropDownByVisibleText(By locator, String text) {
		Select sel = new Select(getElement(locator));
		sel.selectByVisibleText(text);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select sel = new Select(getElement(locator));
		sel.selectByValue(value);
	}
	
	
	
	
	
	
}
