package com.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils{	    
            
    /**
	 *  This function will check element presence
	 * 
	 * @param webdriver
	 * @param selector
	 * 
	 */  
    public static boolean isPresent(WebDriver webdriver, By selector) {
    	try {
			webdriver.findElement(selector);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
    }  
    
    /**
	 *  This function will wait To Be Clickable
	 * 
	 * @param webdriver
	 * @param selector
	 * 
	 */  
    public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}
    /**
	 *  This function will wait For Element Presence
	 * 
	 * @param webdriver
	 * @param selector
	 * 
	 */
    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}
    
    /**
	 *  This function will wait for the title presence
	 * 
	 * @param webdriver
	 * @param title
	 * @param waitInterval
	 * 
	 */  
    public static void waitForTitle(WebDriver driver, String title, int waitInterval){
		 (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
	}
}
