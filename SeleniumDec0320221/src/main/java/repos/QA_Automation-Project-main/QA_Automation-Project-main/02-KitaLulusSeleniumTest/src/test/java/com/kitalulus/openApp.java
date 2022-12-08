package com.kitalulus;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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


public class openApp {
	
	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";
	
	public static File ambilGambar(WebDriver webdriver, String filePath) throws IOException {
		TakesScreenshot screenShoot = ((TakesScreenshot)webdriver);
		File srcFile = screenShoot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(filePath);
		
		//copy file at destination
		FileUtils.copyFile(srcFile,destinationFile);
		
		return destinationFile;
	}
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(this.baseURL);
	}
	
	
	@Test(description = "Test date 26-July-22")
	public void openAppTest() { 
		System.out.println(this.driver.getTitle());
		Assert.assertEquals(this.driver.getTitle(), "Info Lowongan Kerja Terbaru 2022 - Kitalulus");
		
		//ScreenShoot code
		Boolean state =true;
		while(state){
		try{
			//file path
			String akhirFile = System.getProperty("user.dir") + "\\test-output\\openApp.png";
			File destinationFile = openApp.ambilGambar(driver, akhirFile);
			
			//report code
			Reporter.log("<a target='_blank' href=' "+ destinationFile.getAbsolutePath() + "'>"+"'<img src='" + destinationFile.getAbsolutePath() + "'width=100 height=100/></a>") ;
			state= false;
			}catch(IOException e) {
				System.out.println("ada eror bang");
			}
		}

	}
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}
	

}
