package MyWebDriverPrograms;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlixbusBookAJourney {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.get("https://global.flixbus.com/"); // enter URL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// dynamic wait

		driver.manage().window().maximize(); // Maximize window

		driver.findElement(By.xpath("//*[@id=\"cookie-policy\"]/div/div[2]/span")).click(); // delete all cookies

		// From Field "Amsterdam"
		driver.findElement(
				By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/div/input"))
				.sendKeys("Amsterdam", Keys.ENTER);

		// To Field Brussels
		driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[1]/div/div[2]/div/div[1]/div/input"))
				.sendKeys("Brussels", Keys.ENTER);

		// Departure Date Field - Select Departure Date as 20 September 2018
		driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[1]/div/div/input")).click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[4]/div[4]/span"))
				.click();

		// Return Date Field - Select Return Date as 30 December 2018
		driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[2]/div/p/i")).click();
		driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[2]/div/div[2]/div/div/input")).click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/button[2]/img"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[5]/div[7]/span"))
				.click();

		// Select Adults as "3"
		driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[1]/div/div/input"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/button[2]/i"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"search-mask-component\"]/div/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/button[2]/i"))
				.click();

		// Release from the Adults selection - Passengers/Bikes window
		driver.findElement(By.xpath("//*[@id=\"header-image\"]/div")).click();

		// Click the Search Button
		driver.findElement(By.xpath("//*[@id=\"search-mask-component\"]/div/div[4]/div/button")).click();

		driver.close();

	}

}
