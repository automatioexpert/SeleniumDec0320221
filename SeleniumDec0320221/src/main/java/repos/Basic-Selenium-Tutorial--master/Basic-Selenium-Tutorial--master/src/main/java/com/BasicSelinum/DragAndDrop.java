package com.BasicSelinum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", driverPath + "\\Drivers\\geckodriver.exe");

		WebDriver driver = new ChromeDriver();

		String URL = "https://demoqa.com/droppable/";
		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Actions class method to drag and drop
		Actions act = new Actions(driver);

		WebElement from = driver.findElement(By.id("draggable"));
		
		WebElement to = driver.findElement(By.id("droppable"));
		
		// Perform drag and drop
		act.dragAndDrop(from, to).perform();

		// verify text changed in to 'Drop here' box
		String textTo = to.getText();

		if (textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		} else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}

		driver.close();
	}

}
