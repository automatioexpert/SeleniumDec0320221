package com.LW.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.LW.generics.LWBaseClass;

public class MultiplemethodsToClearText extends LWBaseClass {

	@Test

	void Clear() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//a[@id='search-open']")).click();

		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search...']"));

		search.sendKeys("affidavit of confirmation of marriage");

		Thread.sleep(600);

		//search.clear();

		//Actions a = new Actions(driver);

		//	a.moveToElement(search).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();

		//a.moveToElement(search).keyDown(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("a","x").keyUp(Keys.COMMAND).perform();
		
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_DELETE);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_DELETE);



	}

}
