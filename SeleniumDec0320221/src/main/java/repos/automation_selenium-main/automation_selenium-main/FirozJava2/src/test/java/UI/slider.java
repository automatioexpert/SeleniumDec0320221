package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class slider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
		Actions act = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement ele = driver.findElementByXPath("/html[1]/body[1]/div[1]");
		act.moveToElement(ele).dragAndDropBy(ele, 40, 0).build().perform();
		
		
		
	}

}
