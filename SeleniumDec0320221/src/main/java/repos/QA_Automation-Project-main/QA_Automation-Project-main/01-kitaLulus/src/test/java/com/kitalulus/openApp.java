package com.kitalulus;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class openApp {

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
		System.out.println(this.driver.getTitle());
		Assert.assertEquals(this.driver.getTitle(), "Info Lowongan Kerja Terbaru 2022 - Kitalulus");

	}

	@AfterSuite
	public void closeDriver() {
		this.driver.close();

	}

}
