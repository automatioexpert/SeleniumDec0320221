package com.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.FrameworkConstants;
import com.driver.DriverManager;
import com.enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
		
	}

	public static WebElement preformExplicitWait(By by, WaitStrategy waitstrategy) {
		WebElement element = null;
		if (waitstrategy == WaitStrategy.CLICKABLE) {
			element=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(by));
		} 
		else if(waitstrategy == WaitStrategy.PRESENCE){
			element=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitstrategy == WaitStrategy.VISIZBLE) {
			element=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if (waitstrategy == WaitStrategy.NONE){
			element=DriverManager.getDriver().findElement(by);
		}
		
		return element;
	}

}
