package com.BasicSelinum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_Nested {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		int iframeElementr = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The Totale number of iframe element on the page is: " + iframeElementr);

		WebElement frame1 = driver.findElement(By.id("frame1")); // locate iframe1 on the page by WebElement
		driver.switchTo().frame(frame1); // switch to the frame1

		// locate and get the text for frame1 element
		WebElement frame1Element = driver.findElement(By.tagName("body"));
		String frame1Text = frame1Element.getText();
		System.out.println("Frame1 is: " + frame1Text);

		// Number of Frames on a Frame1
		int countiFrameInFrame1 = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of iframe inside frame1 is:" + countiFrameInFrame1);

		// switch to child frame
		driver.switchTo().frame(0);

		int countiframesInFrame2 = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of iFrames inside the Frame2:" + countiframesInFrame2);

		// Switch to default content
		driver.switchTo().defaultContent();

		// Try to print the heading of the main page without swithcing
		WebElement mainPageText = driver.findElement(By.xpath("//*[@id='framesWrapper']/div[1]"));
		System.out.println(mainPageText.getText());
		driver.quit();
	}
}
