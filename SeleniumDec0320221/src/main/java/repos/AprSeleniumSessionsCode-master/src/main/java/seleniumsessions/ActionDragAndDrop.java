package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDragAndDrop {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/#display-grid");
//		driver.switchTo().frame(0);
//		List<WebElement> nums = driver.findElements(By.cssSelector("ol#selectable li"));
		Actions act = new Actions(driver);
//		act.clickAndHold(nums.get(5)).moveToElement(nums.get(7)).release().build().perform();
//		driver.switchTo().defaultContent();
		WebElement image = driver.findElement(By.cssSelector("img[title='Support the JS Foundation']"));
		//act.moveToElement(image).click().perform();
		//act.scrollByAmount(100, 200).click(image).click().build().perform();
	}

}
