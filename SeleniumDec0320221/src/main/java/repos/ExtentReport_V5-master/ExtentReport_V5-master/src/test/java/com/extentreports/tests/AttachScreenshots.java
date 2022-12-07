package com.extentreports.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.util.IOUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttachScreenshots {
	
	/**
	 * 1. Take a screenshot as png, jpg file --> Attach to the extent report
	 * 2. Take a screenshot as png, jpg file --> Convert it in form of base64 --. Attach to the extent report
	 * 3. Take a screenshot as base64 --> Attach to the extent report (Most commended way)
	 * @throws IOException 
	 */
	
	private AttachScreenshots() {
	}
	WebDriver driver;
	ExtentReports extent;
	
	@BeforeSuite
	public void setUp() throws IOException {
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
		spark.loadXMLConfig(new File("extentconfig.xml"));
		extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void tearDown() throws IOException {
		extent.flush();  
		Desktop.getDesktop().browse(new File("index.html").toURI());
		
		driver.quit();
	}
	
	@Test
	public void attachScreenShotTest() throws IOException {	
		ExtentTest test=extent.createTest("First Test");
		WebDriverManager.firefoxdriver().setup();
		driver =new FirefoxDriver();
		test.pass("Browser opened");
		
		driver.get("https://www.google.com");		
		driver.findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		
		//test.pass("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath()).build());
		//test.pass("Value entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
		test.pass("Value entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		
		test.pass("Test finished");		
	}
	
	public String getScreenshotPath() throws IOException {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+ "/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		
		return path;		
	}
	
	public String getScreenshotAsBase64() throws IOException {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+ "/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		byte[] imageBytes=IOUtils.toByteArray(new FileInputStream(path));
		return Base64.getEncoder().encodeToString(imageBytes);		
	}
	
	public String getBase64() throws IOException {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);	
	}
}
