package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goodreads.com/genres/self-help");
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//img[@alt='Goodreads Choice Awards 2022']")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("div.genreHeader")).getText());
		System.out.println(driver.findElement(By.cssSelector("div.mediumText.reviewText")).getText());
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Power");
		driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
		driver.close();
		
	}
}
