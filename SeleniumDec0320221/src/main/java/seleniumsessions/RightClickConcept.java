package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	public static void main(String[] args) throws InterruptedException {

		
		//context click -- right click
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(rightClickEle).perform();
		Thread.sleep(1500);
		
		List<WebElement> rightEles = 
				driver.findElements(By.xpath("//li[contains(@class,'context-menu-icon')]/span"));
		
		System.out.println(rightEles.size());

		for(WebElement e : rightEles) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals("Copy")) {
					e.click();
					break;
				}
		}
		
	}

}
