package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectBasedDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//html tag = <select>
		//we have to use Select class in Selenium:
		
//		WebElement indus_ele = driver.findElement(By.id("Form_submitForm_Industry"));
//		WebElement country_ele = driver.findElement(By.id("Form_submitForm_Country"));
//
//		Select industry = new Select(indus_ele);
//	//	industry.selectByIndex(5); 
//		//-- will be used when u have static content
//		//when we are not bothered about the value--just simple pass the 0 or 1 index
//		
//	//	industry.selectByVisibleText("Automotive");
//	//	industry.selectByValue("health");
//		
//		//20 drop downs -- 20 times we have to write Select class Object
//		
//		Select country = new Select(country_ele);
//		country.selectByVisibleText("India");

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
		doSelectDropDownByVisibleText(industry, "Electronics");
		doSelectDropDownByValue(country, "Canada");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	
	

}
