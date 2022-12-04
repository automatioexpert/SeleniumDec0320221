package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherLocators {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		//1. id: (its a unique attribute) -- I
		
		//2. name: -- II
		
//		driver.findElement(By.name("username")).sendKeys("test@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("test@123");
		
//		By emailId = By.name("username");
		ElementUtil elutil = new ElementUtil(driver);
//		elutil.doSendKeys(emailId, "naveen@gmail.com");
		
		//3. className: -- III
		//its not unique.
		//we can have same class name for different elements
		//driver.findElement(By.className("form-control")).sendKeys("naveen");
		
		
		//4. xpath: its not an attribute
		//address of the element inside the HTML DOM
		//we have to use attributes to create the xpath
		
		//*[@id="input-email"] -- realtive xpath
		//html/body/div[5]/div/div/div[2]/div/form/div[1]/input -- absolute xpath
		//we will never use absolute xpath
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[2]/input"))
//			.sendKeys("test@123");
		
//		By emailId = By.xpath("//*[@id=\"input-email\"]");
//		elutil.doSendKeys(emailId, "test@gmail.com");
		
		//5. cssSelector: its not an attribute
		//we have to use attributes to create the css selector
		//driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");

		//6. linkText: only for links, but its not attibute
		//text of the link
		//html tag = a
		//driver.findElement(By.linkText("Register")).click();
		
//		By registerLink = By.linkText("Register");
//		doClick(registerLink);
		
//		String register = "Register";
//		elutil.doClick("linktext", register);
		
		//7. partialLinkText: only for links, but its not attibute
		//partial text of the link
		//html tag = a
		//driver.findElement(By.partialLinkText("Policy")).click();
		//this is app privacy Policy
		//Privacy Policy
		//User Policy
		//reset pwd
		//forgot pwd
		
		//8. tagName: html tag
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
//		if(header.contains("Delight made easy")) {
//			System.out.println("h1 header is correct");
//		}
		
		By header = By.tagName("h1");
		if(doGetText(header).contains("Delight made easy")){
			System.out.println("h1 header is correct");
		}
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	
	
	
	

}
