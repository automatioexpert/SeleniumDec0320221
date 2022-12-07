package com.BasicSelinum;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args) {
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath + "\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/radio-button");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Find the checkbox or radio button element by its name.
	    List<WebElement> radioNumber = driver.findElements(By.name("like"));
	    System.out.println("The number of radio button element on the page is: "+radioNumber.size());
	      
		/**
		 * Find radio button using ID, Validate isSelected and then click to select
		 */
		WebElement radioEle = driver.findElement(By.id("yesRadio"));
		boolean select = radioEle.isSelected();
		System.out.println("Yes Radio button selection Status: " + select);

		// performing click operation if element is not already selected
		if (select == false) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", radioEle);
		}

		/**
		 * Find radio button using Xpath, Validate isDisplayed and click to select
		 */
		WebElement radioElem = driver.findElement(By.xpath("//*[@id='impressiveRadio']"));

		boolean sel = radioElem.isDisplayed();
		System.out.println("Is impressive radio button displayed: " + sel);

		// performing click operation if element is displayed
		if (sel==true) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", radioElem);
		}

		/**
		 * Find radio button using CSS Selector, Validate isEnabled and click to select
		 */
		WebElement radioNo = driver.findElement(By.cssSelector("input[id='noRadio']"));
		boolean selectNo = radioEle.isEnabled();
		System.out.println(selectNo);

		// performing click operation if element is enabled
		if (selectNo == true) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", radioNo);
		}
	
	}
}
