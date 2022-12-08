package com.kitalulus;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class bookmarkLove {
	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";
	WebElement bookmark;

	// Type it first on your terminal
	//	cd C:\Program Files (x86)\Google\Chrome\Application
	// chrome.exe --remote-debugging-port=9222 --user-data-dir=C:\chromeData
	
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

		// set the driver path- You can also use WebDriverManager for drivers
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		// Create object of ChromeOptions Class
		ChromeOptions opt = new ChromeOptions();

		// pass the debuggerAddress and pass the port along with host. Since I am
		// running test on local so using localhost
		opt.setExperimentalOption("debuggerAddress", "localhost:9222 ");

		// pass ChromeOptions object to ChromeDriver constructor
		this.driver = new ChromeDriver(opt);

		// now you can use now existing Browser
		driver.get(baseURL);

		// Find Job
		try {

			WebElement search = driver
					.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
			search.sendKeys("QA Automation");
			search.sendKeys(Keys.ENTER);

		} catch (Exception e) {

		}

		// click job
		Boolean state = true;
		while (state) {
			try {
				WebElement job = driver
						.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/a[1]"));
				job.click();
				state = false;
			} catch (Exception e) {
			}
		}

		// click bookmark
		state = true;
		while (state) {
			try {
				WebElement loveBookmark = driver
						.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']"));
				loveBookmark.click();

				state = false;
			} catch (Exception e) {
			}
		}

		// return value for assertion
		this.bookmark = driver.findElement(By.xpath("//img[@alt='bookmark active']"));

	}

	@Test(description = "Test date 26-July-22")
	public void bookmarkTest() {

		// Assert bookmark
		try {
			System.out.println("here's" + bookmark + " iya disini xpathnya");
			Assert.assertNotNull(bookmark.isDisplayed());

			//repeat click for next test
			WebElement loveBookmark = driver
					.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']"));
			loveBookmark.click();

		} catch (Exception e) {
			System.out.println(e);
		}

		// ScreenShoot code
		Boolean state = true;
		while (state) {
			try {
				// file path
				String akhirFile = System.getProperty("user.dir") + "\\test-output\\bookmark.png";
				File destinationFile = openApp.ambilGambar(driver, akhirFile);

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
