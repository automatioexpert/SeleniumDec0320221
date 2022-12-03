package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterListWithStaleElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		List<WebElement> footerList = driver.findElements(By.cssSelector("footer a"));
		
		for(WebElement e : footerList) {
			e.click();
			Thread.sleep(5000);
			//driver.navigate().back();
			footerList = driver.findElements(By.cssSelector("footer a"));
		}
		

	}

}
