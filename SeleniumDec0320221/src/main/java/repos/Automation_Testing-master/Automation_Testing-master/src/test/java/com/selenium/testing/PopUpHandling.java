package com.selenium.testing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import com.bridgelabz.selenium.main.Base;

public class PopUpHandling extends Base{
	
	//Alert 
	@Test
	public void alert() {
		try {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			
			//passing the URL to get the web page 
			driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
			//http://only-testing-blog.blogspot.com/2014/01/textbox.html
			//http://demo.besanttechnologies.com/test/delet_customer.php
			//driver.findElement(By.name("cusid")).sendKeys("53920");
			//driver.findElement(By.name("submit")).submit();

			//Checking for alerts
			Alert alert = driver.switchTo().alert();
			
			//Capturing the alerts text is present or not
			String alertTexts = driver.switchTo().alert().getText();
			
			//Displaying the alert text
			System.out.println(alert.getText());
			Thread.sleep(5000);
			
			//Accepting alert
			alert.accept();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void popUpWindow() {
		try {System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
        String alertMessage = "";

        driver.get("http://jsbin.com/usidix/1");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        Thread.sleep(4000);
        alertMessage = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        System.out.println(alertMessage);
        driver.quit();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}	
}
