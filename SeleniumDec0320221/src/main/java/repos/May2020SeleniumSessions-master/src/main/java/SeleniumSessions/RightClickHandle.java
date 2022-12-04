package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickHandle {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickMe = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions ac = new Actions(driver);
		
		ac.contextClick(rightClickMe).perform();
		
		Thread.sleep(2000);
		// ul.context-menu-list.context-menu-root li.context-menu-icon

		List<WebElement> rightClickOptions = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']"
														+ "/li[contains(@class,'context-menu-icon')]"));
		
		System.out.println(rightClickOptions.size());//6
		
		for(int i=0; i<rightClickOptions.size(); i++){
			String text = rightClickOptions.get(i).getText();
			System.out.println(text);
				if(text.equals("Copy")){
					rightClickOptions.get(i).click();
					break;
				}
		}
		
		
	}

}
