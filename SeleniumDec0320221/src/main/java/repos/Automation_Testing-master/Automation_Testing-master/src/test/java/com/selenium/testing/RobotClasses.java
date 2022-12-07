package com.selenium.testing;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class RobotClasses {
	
	@Test
	public void UseOfMouse() throws AWTException {
		try {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			
			driver.get("https://accounts.spotify.com/en/login");
			
			//Object of Robot class
			Robot RobotKey = new Robot();
			
			//Moving mouse in x & Y coordinates
			RobotKey.mouseMove(700, 900); 
			Thread.sleep(5000);
			driver.close();
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void UseOfKeyboard() throws AWTException {
		try {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			
			driver.get("https://accounts.spotify.com/en/login");
			
			//Object of Robot class
			Robot RobotKeyButton = new Robot();
			
			//pressing ALT key
			RobotKeyButton.keyPress(KeyEvent.VK_ALT);
			Thread.sleep(3000);
			
			//pressing R key
			RobotKeyButton.keyPress(KeyEvent.VK_R);
			
			//Releasing ALT key >>> ALT + R > Release
			RobotKeyButton.keyRelease(KeyEvent.VK_ALT);
			//Releasing R key
			RobotKeyButton.keyRelease(KeyEvent.VK_R);
			Thread.sleep(2000);

			//pressing A key
			RobotKeyButton.keyPress(KeyEvent.VK_A);
			RobotKeyButton.keyRelease(KeyEvent.VK_A);
			Thread.sleep(2000);

			//pressing J key
			RobotKeyButton.keyPress(KeyEvent.VK_J);
			RobotKeyButton.keyRelease(KeyEvent.VK_J);
			
			Thread.sleep(5000);
			driver.close();
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
