package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class contextClickForRightClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//contextClick is the method of Actions class
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions act = new Actions(driver);
		WebElement button = driver.findElementByXPath("//span[contains(text(),'right click me')]");
		act.contextClick(button).build().perform();
		driver.findElementByXPath("//body[1]/ul[1]/li[3]/span[1]").click();
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(text.contains("clicked: copy"))
			System.out.print("test case passed ");
	}
}
