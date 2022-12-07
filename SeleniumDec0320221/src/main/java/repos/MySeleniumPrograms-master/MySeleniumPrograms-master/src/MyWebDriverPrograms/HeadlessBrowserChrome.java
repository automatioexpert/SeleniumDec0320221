package MyWebDriverPrograms;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessBrowserChrome {

	static WebDriver driver;

	@BeforeClass
	public static void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");

		driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in");
	}

	@Test
	public static void HomePageTittleValidation()
	{
		String Tittle=driver.getTitle();
		System.out.println("Tittle of Page is: " +Tittle);
	}

	@Test
	public static void logoCheck()
	{
		boolean logo=driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		assertTrue(logo);
	}
}