package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		// 8 locators:

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		//create the web element + perform the action(click, sendKeys, getText, isdisplayed)
		
		//create the web element: using 8 locators:
		
		//1. id: unique
		
		//1st:
//		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		//2nd:
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("naveen@gmail.com");
//		password.sendKeys("test@123");
		
		//3rd: using By locator:
//		By email = By.id("input-email");
//		By password = By.id("input-password");
		
//		driver.findElement(email).sendKeys("test@gmail.com");
//		driver.findElement(password).sendKeys("test@123");

		//4th approach: By locator with a generic function
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(email).sendKeys("test@gmail.com");
//		getElement(password).sendKeys("test@123");
		
		//5th: By locator with getElement() and sendkeys() generic methods:
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "test@gmail.com");
//		doSendKeys(password, "test@123");
		
		//6th: Maintain a util class and move all the functions to that class
		
		//2nd: name: its not unique
		//driver.findElement(By.name("FirstName")).sendKeys("naveen");
		
//		By firstName = By.name("FirstName");
//		doSendKeys(firstName, "naveen");
		
		//3. className: is not unique all the time.
		//multiple elements can have same class 
		//we have to class name in case of unique only
		//driver.findElement(By.className("form-control")).sendKeys("naveen");
		
		//4. xpath: is a locator, but its not attribute
		//xpath: is the address of the element in HTML DOM
		//1. absolute xpath: /html/body/div[3]/div/div[]/ul/li/div[2]/input
		//2. relative xpath: custom xpath with xpath functions, attributes and xpath axes
		//parent, child, sibling, ancestors, following-sibling, preceding-sibling
		
		//driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("testing");
		
		//5. cssSelector: is a locator, but its not attribute
		//CSS: Cascaded Style Sheet
		//id -- #id
		//classname: .classname
		//driver.findElement(By.cssSelector("#input-firstname")).sendKeys("test");
		
		//6. linkText: is only aplicable for links
		//<a> Anchor Tag -- tage name for links
		
		//driver.findElement(By.linkText("Login")).click();
//		By loginLink = By.linkText("Login");
//		By regLink = By.linkText("Register");
//
//		doClick(loginLink);
//		doClick(regLink);

		//7th: partialLinkText: is only aplicable for links
		//hi please click on it.
		// Forgotten username
		// Forgotten password
		//driver.findElement(By.partialLinkText("Forgotten")).click();
//		By forgotPwdLink = By.partialLinkText("Forgotten");
//		doClick(forgotPwdLink);
		
		//8. tagName: html tag
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
//		By header = By.tagName("h1");
//		String h1 = doGetText(header);
//		System.out.println(h1);
		
		//***************************
		//can I get the text for any element with any By locator strategy?
		
		By agree = By.xpath("//*[@id=\"content\"]/form/div/div");
		String text = doGetText(agree);
		System.out.println(text);
		
		By forgtPwd = By.linkText("Forgotten Password");
		String forgPwdText = doGetText(forgtPwd);
		System.out.println(forgPwdText);
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	
	

}
