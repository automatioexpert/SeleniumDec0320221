package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		By rightClickBtn = By.xpath("//span[text()='right click me']");
		By rightClickOptions = By.xpath("//ul[@class='context-menu-list context-menu-root']//span");
		
		if(getRightClickOptionsCount(rightClickBtn, rightClickOptions) == 6) {
			System.out.println("PASS");
		}
		
		selectRightClickMenu(rightClickBtn, rightClickOptions, "Copy");
		
		
	}
	
	public static int getRightClickOptionsCount(By rightClick, By rightClickOptions) {
		return getRightClickOptinsList(rightClick, rightClickOptions).size();
	}
	
	public static List<String> getRightClickOptinsList(By rightClick, By rightClickOptions) {
		WebElement rightClickEle = driver.findElement(rightClick);
		List<String> rightClickItems = new ArrayList<String>();
		
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		List<WebElement> itemsList = driver.findElements(rightClickOptions);
		System.out.println(itemsList.size());
		
		for (WebElement e : itemsList) {
			String text = e.getText();
			System.out.println(text);
			rightClickItems.add(text);
		}
		return rightClickItems;
	}

	public static void selectRightClickMenu(By rightClick, By rightClickOptions, String value) {
		WebElement rightClickEle = driver.findElement(rightClick);
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		List<WebElement> itemsList = driver.findElements(rightClickOptions);
		System.out.println(itemsList.size());
		for (WebElement e : itemsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}

}
