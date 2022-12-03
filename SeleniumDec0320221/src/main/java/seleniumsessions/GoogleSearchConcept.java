package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		By search = By.name("q");
		By suggListLocator = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']");
		performSearch(search, "Naveen Automation Labs", suggListLocator, "youtube");
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	public static void performSearch(By search, String searchKey, By suggListLocator, String suggName) throws InterruptedException {
		doSendKeys(search, searchKey);
		Thread.sleep(2000);
		
		List<WebElement> suggList = driver.findElements(suggListLocator);
		
		System.out.println("total suggs: " + suggList.size());
		
		for(WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
				if(text.contains(suggName)) {
					e.click();
					break;
				}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
