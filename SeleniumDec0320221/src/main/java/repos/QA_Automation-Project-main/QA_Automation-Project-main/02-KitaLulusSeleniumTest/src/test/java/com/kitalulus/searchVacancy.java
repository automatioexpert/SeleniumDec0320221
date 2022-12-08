package com.kitalulus;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class searchVacancy {

	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";

	public static File ambilGambar(WebDriver webdriver, String filePath) throws IOException {
		TakesScreenshot screenShoot = ((TakesScreenshot) webdriver);
		File srcFile = screenShoot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(filePath);

		// copy file at destination
		FileUtils.copyFile(srcFile, destinationFile);

		return destinationFile;
	}

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
		
		//Screenshoot code
		state = true;
		while (state) {
			try {
				// file path
				String akhirFile = System.getProperty("user.dir") + "\\test-output\\searchVacancy.png";
				File destinationFile = searchVacancy.ambilGambar(driver, akhirFile);

				// report code
				Reporter.log("<a target='_blank' href=' " + destinationFile.getAbsolutePath() + "'>" + "'<img src='"
						+ destinationFile.getAbsolutePath() + "'width=100 height=100/></a>");
				state = false;
			} catch (IOException e) {
				System.out.println("ada eror bang");
			}
		}

	}

	@AfterSuite
	public void closeDriver() {
		this.driver.close();

	}

}
