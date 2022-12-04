package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		Actions act = new Actions(driver);
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		act.contextClick(rightClickBtn).perform();
		
		List<WebElement> list = 
					driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root li.context-menu-item.context-menu-icon span"));
		
		for(WebElement e : list) {
			System.out.println(e.getText());
			
			if(e.getText().equals("Copy")) {
				e.click();
				break;
			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		
	}

}
