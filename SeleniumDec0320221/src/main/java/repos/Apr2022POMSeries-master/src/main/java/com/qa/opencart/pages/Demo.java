package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");

		By name = By.id("Form_getForm_FullName");

		doActionSendKeys(name, "sidharth");

	}

	public static WebElement getFindElement(By loc) {
		return driver.findElement(loc);
	}

	public static void doActionSendKeys(By loc, String value) {

		Actions ac = new Actions(driver);
	    ac.sendKeys(Keys.PAGE_DOWN).build().perform();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ele =  wait.until(ExpectedConditions.elementToBeClickable(loc));
		ac.moveToElement(ele).clickAndHold(ele).sendKeys(ele, value).build().perform();
//		
		
	}

	
}
