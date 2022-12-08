package com.homeDepot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebElement element=null;

	public void getHomePageTittle(WebDriver driver) {
		driver.getTitle();			
	}

	public WebElement register(WebDriver driver) {
		element= driver.findElement(By.xpath("//span[contains(text(),'Register')]"));	
		return element;
	}
	
}
