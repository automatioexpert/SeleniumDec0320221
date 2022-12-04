package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.linkText("CONTACTS")).click();
		selectContact("Tom Selenium");
		selectContact("Kiran Pawar");
		//a[text()='Aliss Jeyhun']/parent::td/preceding-sibling::td/input[@name='contact_id']
		System.out.println(getCompName("Aliss Jeyhun"));
	}

	public static void selectContact(String name) {
		driver.findElement(
				By.xpath("//a[text()='" + name + "']/parent::td/preceding-sibling::td/input[@name='contact_id']"))
				.click();
	}
	
	public static String getCompName(String name) {
		return driver
		.findElement
		(By.xpath("//a[text()='"+name+"']/parent::td/following-sibling::td/a[@context='company']"))
		.getText();
	}

}
