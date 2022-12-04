package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_2 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(3000);


		//Xpath Axes:
		//child to parent: backward traversing in xpath
		//input[@id='username']/../../../../../../../../../..
		//input[@id='username']/..
		//input[@id='username']/parent::div
		
		//parent to child:
		//div[@class='private-form__input-wrapper']/input
		//div[@class='private-form__input-wrapper']/child::input[@id='username']
		
		//parent to ancestor:
		//input[@id='username']/ancestor::div
		
		//className : form-control private-form__control login-email
//		By.className("form-control private-form__control login-email");//not valid
//		By.className("login-email");//valid
//		//xpath
//		By.xpath("//input[@class='form-control private-form__control login-email']");
//		//cssSelector
//		By.cssSelector("input.form-control.private-form__control.login-email");
		
		//a[text()='Apple Malvia']/parent::td/preceding-sibling::td/child::input[@type='checkbox' and @name='contact_id']
		//a[text()='Bogus Otani']/parent::td/preceding-sibling::td/child::input[@type='checkbox' and @name='contact_id']
		selectContact("Apple Malvia");
		selectContact("Bogus Otani");
		
		System.out.println(getContactCompName("Apple Malvia"));

	}
	
	public static void selectContact(String name) {
		String checkBoxXpath = 
				"//a[text()='"+name+"']/parent::td/preceding-sibling::td/child::input[@type='checkbox' and @name='contact_id']";
		driver.findElement(By.xpath(checkBoxXpath)).click();
	}
	
	public static String getContactCompName(String name) {
		String compXpath = "//a[text()='"+name+"']/parent::td/following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(compXpath)).getText();
	}

}
