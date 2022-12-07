package com.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RelativesXpath {
	@Test
	@SuppressWarnings("static-access")
	public void xpath() {
		
		try {
			//Setting web-driver
			System.setProperty("webdriver.chrome.driver", "C://Users//Raj Kawale//OneDrive//Desktop//chromedriver_win32//chromedriver.exe");					
		    WebDriver driver= new ChromeDriver();
		    
		    driver.get("https://www.amazon.in/");
		    WebElement element = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		    element.sendKeys("Mobile");
		    Thread.sleep(4000);
		    element.clear();
		    
		    element.sendKeys("Laptop");
		    element.sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    
		    WebElement element2 = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[13]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));	    
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].scrollIntoView(true);", element2);
		    element2.click();
		    Thread.sleep(5000);
		    //driver.close();   //It will close only one current window
		    driver.quit();      //It will close all opened window
	    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
