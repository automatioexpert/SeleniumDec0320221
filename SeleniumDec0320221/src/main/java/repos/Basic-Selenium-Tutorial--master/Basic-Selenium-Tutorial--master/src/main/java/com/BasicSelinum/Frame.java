package com.BasicSelinum;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// Any search for elements take time before throwing exception

		// By executing a java script
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());

		driver.switchTo().frame(0); // Switch by Index
		WebElement frame1Heading = driver.findElement(By.id("sampleHeading")); // Locate the frame1 heading
		String frame1Text = frame1Heading.getText(); // Finding the text of the frame1 heading
        System.out.println("Text of the frame1 heading is:"+frame1Text); //Print the heading
        
       //Switch to Parent iFrame
        driver.switchTo().parentFrame();
        
        //Switch by frame ID
        driver.switchTo().frame("frame2");
        WebElement frame2Heading = driver.findElement(By.id("sampleHeading")); // Locate the frame2 heading
		String frame2Text = frame2Heading.getText(); // Finding the text of the frame2 heading
        System.out.println("Text of the frame2 heading is:"+frame2Text); //Print the heading
        
        driver.quit();
	}

}
