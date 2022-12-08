package com.kitalulus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class searchVacancy {

	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";

	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(this.baseURL);
	}

	@Test(description = "Test date 26-July-22")
	public void openAppTest() {
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
		search.sendKeys("QA Automation");
		search.sendKeys(Keys.ENTER);
		Boolean state = true;
		while (state) {
			try {
				String result = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[3]/div[2]/p/strong[2]"))
						.getText();
				String expect = "QA Automation";
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
