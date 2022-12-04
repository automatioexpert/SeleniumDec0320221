package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricinfoTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		List<WebElement> list = driver.findElements(By.xpath(
				"//table[@id='tablepress-1']//td[text()='windows']/preceding-sibling::td/input[@type='checkbox']"));

		for (WebElement e : list) {
			e.click();
		}

	}

}
