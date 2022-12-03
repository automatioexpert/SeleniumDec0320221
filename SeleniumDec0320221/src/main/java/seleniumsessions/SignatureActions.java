package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignatureActions {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://signature-generator.com/draw-signature/");
		
		WebElement canvas = driver.findElement(By.id("signature-pad"));
		
		Actions act = new Actions(driver);
		
		Action signature = act.click(canvas)
				.moveToElement(canvas, 3, 3)
				.clickAndHold(canvas)
				.moveToElement(canvas, -200, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(3, 3).release(canvas)
				.build();
		
		signature.perform();
		
	}

}
