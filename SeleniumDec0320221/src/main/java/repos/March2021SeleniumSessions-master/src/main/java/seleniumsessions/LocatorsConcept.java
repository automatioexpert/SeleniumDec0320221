package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//create webelement (By id, name, xpath, css) --> perform actions(click, sendKeys, gettext)
		//HTML DOM: Document Object Model
		
		//1. id -- this is unique locator
		//1st:
//		driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("testing");
//		driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("selenium");
		//driver.findElement(By.linkText("Register")).click();
		
		//2nd:
//		WebElement firstName = driver.findElement(By.id("Form_submitForm_FirstName"));
//		WebElement lastName = driver.findElement(By.id("Form_submitForm_LastName"));
//
//		firstName.sendKeys("testing");
//		lastName.sendKeys("selenium");
		
		//3rd:
		//By locators:
//		By firsName = By.id("Form_submitForm_FirstName");
//		By lastName = By.id("Form_submitForm_LastName");
//		
//		driver.findElement(firsName).sendKeys("testing");
//		driver.findElement(lastName).sendKeys("selenium");
		
		//4th:
		By firsName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		By jobTitle = By.id("Form_submitForm_JobTitle");
		By emailId = By.id("Form_submitForm_Email");
//		
//		getElement(firsName).sendKeys("testing");
//		getElement(lastName).sendKeys("selenium");
		
		//5th:
		doSendKeys(firsName, "Selenium");
		doSendKeys(lastName, "Testing");
		doSendKeys(emailId, "test@gmail.com");
		doSendKeys(jobTitle, "SDET");
		
		//6th : ElementUtil Lib
		
		//1. id: - I
		//2: linktext: only for links -- IV
		//3. tagName 
		//4. xpath -- III
		//5. css Selector -- III
		//6. name -- II
		//7. partialLinkText -- V
		//8. className IV
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	
	

}
