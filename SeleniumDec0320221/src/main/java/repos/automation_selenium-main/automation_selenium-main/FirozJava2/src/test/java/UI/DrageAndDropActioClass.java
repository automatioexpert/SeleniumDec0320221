package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrageAndDropActioClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		WebElement source = driver.findElementByXPath("//div[@id='column-a']");
		WebElement target =driver.findElementByXPath("//div[@id='column-b']");
		Actions act = new Actions(driver);
		act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		act.dragAndDrop(source, target).build().perform();
		
		
		
	}

}
