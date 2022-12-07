package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class resizeable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		Actions act = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement resize = driver.findElementByXPath("//body/div[@id='resizable']/div[1]");
		act.moveToElement(resize).dragAndDropBy(resize, 69, 60).build().perform();

	}

}
