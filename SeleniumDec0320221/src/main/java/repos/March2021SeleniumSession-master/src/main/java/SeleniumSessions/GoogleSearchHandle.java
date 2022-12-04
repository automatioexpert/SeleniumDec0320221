package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		Thread.sleep(2000);
		
		List<WebElement> suggList = 
					driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
		
		for(WebElement e : suggList) {
			if(e.getText().equals("naveen automation labs selenium")) {
				e.click();
				break;
			}
		}
		
	}

}
