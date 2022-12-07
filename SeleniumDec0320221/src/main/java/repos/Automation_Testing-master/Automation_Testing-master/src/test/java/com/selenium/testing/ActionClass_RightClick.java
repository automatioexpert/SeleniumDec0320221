package com.selenium.testing;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass_RightClick {
	@Test
	public void rightClick() {
		
		try {
			//Setting web-driver
			System.setProperty("webdriver.chrome.driver", "C://Users//Raj Kawale//OneDrive//Desktop//chromedriver_win32//chromedriver.exe");					
		    WebDriver driver= new ChromeDriver();				
		    driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		    
		    //Right click on user-name input field
		    WebElement username = driver.findElement(By.name("session_key"));
		    Actions action = new Actions(driver);
		    action.contextClick(username).perform();
		    Thread.sleep(2000);
		    
		    //Navigate elements in options window by using Robot class
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_DOWN);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    
		    Thread.sleep(5000);
		    driver.close();
		    
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
