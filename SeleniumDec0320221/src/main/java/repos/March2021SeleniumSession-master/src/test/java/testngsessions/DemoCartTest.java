package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoCartTest {
	public WebDriver driver;

	// global pre conditions
	// pre conditions
	// TC01- test steps + validations (act vs exp)
	// TC02- test steps + validations (act vs exp)
	// TC03- test steps + validations (act vs exp)
	// post steps

	// before -- BS, BT, BC, BM
	
	/*
	BS - setupDB
	BT -- create user
	BC -- launch browser
	
		BM -- Login to app
		T1 --logoutLinkTest 
		page title is : My Account
		AM -- logout

		BM -- Login to app
		T2 --logoutLinkTest 
		AM -- logout
		
		BM -- Login to app
		T3 --searchBarTest 
		AM -- logout
		
	AC -- close browser
	AT -- delete user
	AS -- disconnect DB */

	@BeforeSuite
	public void setupDB() {
		System.out.println("BS - setupDB");
	}

	@BeforeTest
	public void createUser() {
		System.out.println("BT -- create user");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- launch browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM -- Login to app");
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Test
	public void accountPageTitleTest() {
		System.out.println("T1 --logoutLinkTest ");
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "My Account");
	}

	@Test
	public void logoutLinkTest() {
		System.out.println("T2 --logoutLinkTest ");
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}

	@Test
	public void searchBarTest() {
		System.out.println("T3 --searchBarTest ");
		Assert.assertTrue(driver.findElement(By.name("search")).isDisplayed());
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout");
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- close browser");
		driver.quit();
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- delete user");
	}

	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS -- disconnect DB");
	}

}
