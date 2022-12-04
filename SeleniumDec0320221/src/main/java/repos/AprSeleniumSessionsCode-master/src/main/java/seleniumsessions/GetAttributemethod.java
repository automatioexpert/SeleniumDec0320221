package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributemethod {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		String placeholderVal = driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
//		System.out.println(placeholderVal);
//		
//		String loginUrl = driver.findElement(By.linkText("Login")).getAttribute("href");
//		System.out.println(loginUrl);
		
		By fn = By.id("input-firstname");
		By login = By.linkText("Login");
		
		String placeholderVal = doGetAttributeValue(fn, "placeholder");
		String loginUrl = doGetAttributeValue(login, "href");

		System.out.println(placeholderVal);
		System.out.println(loginUrl);
		
	}
	
	public static String doGetAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	
	
	
	
	

}
