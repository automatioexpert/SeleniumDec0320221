package seleniumsessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testcheck {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Thread.sleep(5000);
		

		
		WebElement ele = driver.findElement(By.cssSelector("span.stay-signed-in.checkbox-container input"));

		//driver.findElement(with(By.tagName("input")).toLeftOf(ele)).click();
		//System.out.println(leftRank);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(with(By.tagName("span")).toLeftOf(ele))).click()
		.build().perform();

	}

}
