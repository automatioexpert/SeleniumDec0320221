package com.SearchFunctionality;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchFunctionalityTest {

	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void setUp(String browser, String url) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Test Suite/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Test Suite/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/Test Suite/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}


	@Parameters("expectedTitle")
	@Test(priority=1)
	public void noDataTest(String expectedTitle) {
		driver.findElement(
				By.xpath("//button[@class='btn-special-teaser-close js-special-teaser-close' and @type='button']"))
				.click();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']")).clear();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']")).click();
		driver.findElement(By.xpath("//button[@type='submit' and @class='btn-1 search-form__btn']")).click();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, expectedTitle);
	}

	@Parameters("ExpectedTitle")
	@Test(priority=2)
	public void validDataTest(String ExpectedTitle) {
		driver.findElement(
				By.xpath("//button[@class='btn-special-teaser-close js-special-teaser-close' and @type='button']"))
				.click();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']")).clear();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']")).click();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']"))
				.sendKeys("spiderman spielzeug");
		driver.findElement(By.xpath("//button[@type='submit' and @class='btn-1 search-form__btn']")).click();
		driver.findElement(
				By.xpath("//button[@class='btn-special-teaser-close js-special-teaser-close' and @type='button']"))
				.click();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@Parameters("Expected_Title")
	@Test(priority=3)
	public void invalidDataTest(String Expected_Title) {
		driver.findElement(
				By.xpath("//button[@class='btn-special-teaser-close js-special-teaser-close' and @type='button']"))
				.click();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']")).clear();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']")).click();
		driver.findElement(
				By.xpath("//input[@type='search' and @class='input-text search-form__input js-search-input']"))
				.sendKeys("xxxxppppprotractor");
		driver.findElement(By.xpath("//button[@type='submit' and @class='btn-1 search-form__btn']")).click();
		driver.findElement(
				By.xpath("//button[@class='btn-special-teaser-close js-special-teaser-close' and @type='button']"))
				.click();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, Expected_Title);
	}


	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
