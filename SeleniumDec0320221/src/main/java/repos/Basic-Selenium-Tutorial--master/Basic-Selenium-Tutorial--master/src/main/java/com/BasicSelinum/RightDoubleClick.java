package com.BasicSelinum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RightDoubleClick {
	static WebDriver driver = null;

	public static void main(String[] args) {
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", driverPath + "\\Drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.navigate().to("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Instantiate Action Class
		Actions actions = new Actions(driver);

		// Retrieve WebElement to perform right click
		WebElement rightBtn = driver.findElement(By.id("rightClickBtn"));

		// Right Click the button to display Context Menu&nbsp;
		actions.contextClick(rightBtn).perform();
	
		System.out.println("Right click Context Menu displayed");

		// Retrieve WebElement to perform double click WebElement
		WebElement doubleBtn = driver.findElement(By.id("doubleClickBtn"));
		
		// Double Click the button
		actions.doubleClick(doubleBtn).perform();

	}

}
