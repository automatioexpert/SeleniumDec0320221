package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BBTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.bigbasket.com/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().frame(0);

		Thread.sleep(5000);
		List<WebElement> qtyInputList = driver
				.findElements(By.cssSelector(".input-group span.input-group-addon + input"));

		System.out.println(qtyInputList.size());
		Actions act = new Actions(driver);
		for (int i = 1; i < qtyInputList.size(); i++) {
			// qtyInputList.get(i).clear();

			act.sendKeys(qtyInputList.get(i), "2").perform();
			try {
				if (i % 5 == 0) {
						act.click(driver.findElement(By.xpath("(//div[contains(@class,'owl-carousel')]"
								+ "//div[@class='owl-nav'])[3]/div[@class='owl-next']"))).perform();
						
		

				}
			} catch (Exception e) {

			}
		}

	}
	
	
	public static WebElement waitForElement(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='owl-next disabled']")));
	}

}
