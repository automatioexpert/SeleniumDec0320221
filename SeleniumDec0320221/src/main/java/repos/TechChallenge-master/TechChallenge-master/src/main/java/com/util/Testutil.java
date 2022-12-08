/**
 * 
 */
package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author anand acharya
 * Utility class to define generic functions
 * *********************************** PURPOSE **************************************
 * To initialize implicit, explicit, and fluent waits
 * To use java scripts for actions like click, scrolling etc
 */
public class Testutil {

	public static long page_load_timeout = 120; //max 120 seconds buffer to load any page
	public static long implicit_wait = 30; //max 30 seconds buffer to load all web elements in the page
	
	WebDriver driver;
	
	public Testutil(WebDriver driver) {
		this.driver = driver;
	}
	
	//methods for different explicit waits
	//wait for iframe to load and click
	public  void waitElementFrame(By locator, int timeout) { 
		 new WebDriverWait(driver, timeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	 }
	
	//wait for element to be located and enter text data
	public  void waitElementText(WebElement locator, int timeout, String data) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(data);
	}
	
	//wait for element to be located and then click it
	public  void waitElementClick(WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	//wait for element to be visible on a new page
	public  void waitElementToView(By locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//wait for element to be invisible on a new page
	public  void waitElementNotToView(By locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public  void waitElement(WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator));
	}
	
	//scroll fully down the page
	public  void pageScrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	//scroll down the page to an element reference
	public void pageScrollDownToElementRefernce(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				element);
	}
	
	//scroll down to an element y coordinates
	public  void pageScrollDownToElementCoordinate(WebElement element) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"+(element.getLocation().getY())+");");
	}
	
	//click element by javascript
	public  void clickElementByJS(WebElement element){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	//move to element
	public  void moveToElementAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	// take screenshot of failed tests for Extent report
	public  String getScreenshotExtent() {	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/failExtentScreenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
}
