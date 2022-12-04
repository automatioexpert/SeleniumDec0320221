package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithSelectTag {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By day = By.id("day");
		By month = By.id("month");
		By year = By.id("year");
		
		By country = By.id("Form_submitForm_Country");
		
//		doSelectValuesByVisibleText(day, "23");
//		doSelectValuesByVisibleText(month, "Oct");
//		doSelectValuesByVisibleText(year, "1990");
		
//		doSelectValuesByIndex(day, 5);
//		doSelectValuesByIndex(month, 3);
//		doSelectValuesByIndex(year, 20);
		
		doSelectValuesByVisibleText(country, "Brazil");

		
//		WebElement day = driver.findElement(By.id("day"));
//		
//		Select select = new Select(day);
//		
//		select.selectByVisibleText("10");
//		select.selectByIndex(5);
//		select.selectByValue("17");
//		
//		WebElement month = driver.findElement(By.id("month"));
//		Select select1 = new Select(month);
//		select1.selectByVisibleText("Nov");

		
	}
	
	public static void doSelectValuesByVisibleText(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public static void doSelectValuesByIndex(By locator, int index){
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectValuesByValue(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static WebElement getElement(By locator){
		WebElement element = driver.findElement(locator);
		return element;
	}
	

}
