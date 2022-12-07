package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.driver.DriverManager;
import com.enums.WaitStrategy;
import com.factories.ExplicitWaitFactory;

public class BasePage {

	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void click(By by, WaitStrategy waitstrategy, String elementname) {
		WebElement element=ExplicitWaitFactory.preformExplicitWait(by, waitstrategy);
		element.click();
	}
	
	protected void sendKeys(By by, WaitStrategy waitstrategy, String value, String elementname) {
		WebElement element= ExplicitWaitFactory.preformExplicitWait(by, waitstrategy);
		element.sendKeys(value);
	}
}
