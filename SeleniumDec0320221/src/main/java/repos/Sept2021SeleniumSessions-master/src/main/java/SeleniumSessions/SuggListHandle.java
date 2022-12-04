package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggListHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		
		Thread.sleep(5000);
		selectOptionFromSuggList("Casual Dresses > Printed");
		
		//driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual Dresses > Printed')]")).click();
		
//		List<WebElement> suggList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
//		
//		System.out.println(suggList.size());
//		
//		for(WebElement e : suggList) {
//			String text = e.getText();
//				if(text.contains("Casual Dresses")) {
//					e.click();
//					break;
//				}
//		}
		
	}
	
	public static void selectOptionFromSuggList(String value) {
		driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'"+value+"')]")).click();
	}

}
