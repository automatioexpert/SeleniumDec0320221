package com.tokopedia;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class searchProduct {

	WebDriver driver;
	String baseURL = "https://www.tokopedia.com/";

	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(this.baseURL);
	}

	@Test(description = "Test date 30-July-22")
	public void searchProductTest() {
		WebElement search = driver.findElement(By.xpath("//input[@data-unify='Search']"));
		search.sendKeys("Sony XM-4");
		search.sendKeys(Keys.ENTER);

		Boolean state = true;
		while (state) {
			try {
				String result = driver
						.findElement(By.xpath("//*[@id=\"zeus-root\"]/div/div[2]/div/div[2]/div[2]/span/div"))
						.getText();
				String expect = "XM-4";
				System.out.println("here's " + result);
				System.out.println("here's boolean " + result.contains(expect));
				Assert.assertEquals(result.contains(expect), true);
				state = false;
			} catch (Exception e) {
			}
		}
	}

	@AfterSuite
	public void closeDriver() {
		this.driver.close();

	}

}
