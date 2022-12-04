package testngsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountsPageTest {
	public WebDriver driver;
	
	public void doLogin() {
		driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		doLogin();
	}

	@Test
	public void accountPageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "My Account");
	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}

	@Test
	public void searchBarTest() {
		Assert.assertTrue(driver.findElement(By.name("search")).isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
