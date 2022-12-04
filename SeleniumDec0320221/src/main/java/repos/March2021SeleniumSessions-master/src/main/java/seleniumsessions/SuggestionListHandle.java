package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionListHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com");

		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class='ac_results']//li[text()='T-shirts > Faded Short Sleeve T-shirts']"))
				.click();
		

	}

}
