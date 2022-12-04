package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchWithoutLoop {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/");

		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		Thread.sleep(4000);

		selectValueFromSuggList("T-shirts > Faded Short Sleeve T-shirts");

	}

	public static void selectValueFromSuggList(String value) {
		driver.findElement(By.xpath("//div[@class='ac_results']//li[text()='" + value + "']")).click();
	}

}
