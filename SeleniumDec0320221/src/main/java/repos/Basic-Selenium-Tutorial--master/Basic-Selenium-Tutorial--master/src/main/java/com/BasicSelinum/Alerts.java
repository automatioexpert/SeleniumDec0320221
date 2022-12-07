package com.BasicSelinum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/alerts");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// Put an Implicit wait, this means that any search for elements on the page could take 
		// the time the implicit wait is set for before throwing exception
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10); // create a new WebDriverWait

		// This step will result in an alert on screen
		driver.findElement(By.id("alertButton")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();

		try {
			driver.findElement(By.id("timerAlertButton")).click();
			System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
			
			Alert myAlert = wait.until(ExpectedConditions.alertIsPresent()); // wait for Alert to be present
			myAlert = driver.switchTo().alert();
			System.out.println("Ether Pop Up is displayed or it is Time out");
			myAlert.accept(); // Accept the Alert
			System.out.println("Unexpected alert accepted");
		} catch (Exception e) {
			System.out.println("Unexpected alert not accepted");
		}		

		driver.findElement(By.id("confirmButton")).click();
		Alert cancel = wait.until(ExpectedConditions.alertIsPresent());
		cancel = driver.switchTo().alert();
		cancel.dismiss();
		System.out.println("Alert canceled");

		driver.findElement(By.id("promtButton")).click();
		Alert box = wait.until(ExpectedConditions.alertIsPresent());
		box = driver.switchTo().alert();
		
		String alertText = box.getText();
		System.out.println("Alert text is: " + alertText); // Capturing Alert Message
		box.sendKeys("Text");
		box.accept();		
	}
}
