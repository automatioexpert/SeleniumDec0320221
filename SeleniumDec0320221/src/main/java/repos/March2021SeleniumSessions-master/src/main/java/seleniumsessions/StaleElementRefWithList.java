package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefWithList {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		List<WebElement> footerList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));

		for (int i = 0; i < footerList.size(); i++) {
			footerList.get(i).click();
			driver.navigate().back();
			footerList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
		}

	}

}
