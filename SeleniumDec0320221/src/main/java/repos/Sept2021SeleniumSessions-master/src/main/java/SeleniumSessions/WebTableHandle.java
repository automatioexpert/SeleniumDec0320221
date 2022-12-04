package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//a[text()='deepti Gupta']/parent::td/preceding-sibling::td/input
		//a[text()='Harindra Test']/parent::td/preceding-sibling::td/input
		//a[text()='Harindra Test']/../preceding-sibling::td/child::input
		//input[@id='username']//ancestor::div
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		Thread.sleep(3000);
		
		//String xpath = "//a[text()='deepti Gupta']/parent::td/preceding-sibling::td/input";
		selectContact("deepti Gupta");
		selectContact("Harindra Test");
		
		System.out.println(getCompanyName("Amar3 Singh3"));
		System.out.println(getContactPhoneList("Amar3 Singh3"));

	}
	
	public static void selectContact(String contactName) {
		String xpath = "//a[text()='"+contactName+"']/parent::td/preceding-sibling::td/input";
		driver.findElement(By.xpath(xpath)).click();

	}
	
	public static String getCompanyName(String contactName) {
		String xpath = "//a[text()='"+contactName+"']//parent::td//following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(xpath)).getText();

	}
	
	public static List<String> getContactPhoneList(String contactName) {
		String xpath = "//a[text()='"+contactName+"']//parent::td//following-sibling::td/span[@context='phone']";
		List<WebElement> phoneList = driver.findElements(By.xpath(xpath));
		List<String> phoneValList = new ArrayList<String>();
		for(WebElement e : phoneList) {
			String text = e.getText();
			phoneValList.add(text);
		}
		return phoneValList;
	}
	
	
	

}
