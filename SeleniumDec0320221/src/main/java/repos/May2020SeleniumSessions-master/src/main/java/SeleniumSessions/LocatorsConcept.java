package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		
		Thread.sleep(5000);
		
		//create a WebElement and then perform an action on it
		//WE + click
		//WE + sendKeys
		//WE + getText
		
		//1. id: --  I (unique)
//		driver.findElement(By.id("username")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("test@123");
//		driver.findElement(By.id("loginBtn")).click();
		
//		WebElement email = driver.findElement(By.id("username"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement loginButton = driver.findElement(By.id("loginBtn"));
//
//		email.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
//		loginButton.click();
		
//		By email = By.id("username");
//		By password = By.id("password");
//		By loginButton = By.id("loginBtn");

//		driver.findElement(email).sendKeys("test@gmail.com");
//		driver.findElement(password).sendKeys("test@123");
//		driver.findElement(loginButton).click();
		
//		getElement(email).sendKeys("test@gmail.com");
//		getElement(password).sendKeys("test@123");
//		getElement(loginButton).click();
		
//		doSendKeys(email, "test@gmail.com");
//		doSendKeys(password, "test@123");
//		doClick(loginButton);
		
		//2. name: II
		//driver.findElement(By.name("username")).sendKeys("test@gmail.com");
		
		//3. className: -- III (only if class is unique)
//		driver.findElement(By.className("login-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.className("login-password")).sendKeys("test@gmail.com");
		
//		form-control private-form__control login-email
//		form-control private-form__control login-password m-bottom-3
		
		//4. xpath: is not an attribute --I, II , III(Attr)
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test@123");
		
		//5. cssSelector: --- I, II , III(Attr)
//		driver.findElement(By.cssSelector("#username")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#password")).sendKeys("test");
		
		//6. linkText: only for links: -- IV
		//driver.findElement(By.linkText("Sign up")).click();
		
		//7. partialLinkText: only for links --V
		//driver.findElement(By.partialLinkText("Sign")).click();
		
		//Sign up
		//Sign in
		
		//8. tagName:
		
		
	}
	
	/**
	 * this method is used to create the webelement on the basis of given By locator
	 * @param locator
	 * @return
	 */
	public static WebElement getElement(By locator){
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public static void doSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator){
		getElement(locator).click();
	}
	

}
