package com.selenium.testing;
import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.bridgelabz.selenium.main.SecondDemo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondTest extends SecondDemo{

		@Test
		public void login(){
			
			try {
				if (browser.equals("edge")){
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}else{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();	
					}
			
			driver.get("https://accounts.spotify.com/en/login"); 
			
			//Find all elements within the current page using the given mechanism.
			driver.findElement(By.id("login-username")).sendKeys("Rajkawale00@gmail.com");
	        Thread.sleep(100);
	        driver.findElement(By.id("login-password")).sendKeys("Mietgondia712@1");
	        Thread.sleep(100);
	        driver.findElement(By.className("Remember me")).click();
	        Thread.sleep(100);
	        driver.findElement(By.xpath("*[@id=\"login-button\"]/div[1]")).click();
	        
	      //Taking screenshot with actual date
	        System.out.println("Page source: " + driver.getPageSource());
	        Date date = new Date();
	        String date1 = date.toString();
	        System.out.println("Date of screenshot is: " + date1);
	        String date2 = date1.replaceAll(":" , "_");
	        TakesScreenshot ts = (TakesScreenshot)driver;     //use of screenshot driver
	        
	        File srcFile = ts.getScreenshotAs(OutputType.FILE);
	        File destFile = new File("./Screenshot/" + date2 + "_Spotify.png");
	        FileUtils.copyFile(srcFile, destFile);
	       

	        String expectedUrl= driver.getCurrentUrl();
	        String actualUrl="https://open.spotify.com/user/kp3h8vi2tcgpixazjqzqsurj6";  //LinkedIn
	        
	        Assert.assertEquals(actualUrl,expectedUrl);	
	        
	        driver.close(); //Close the current window     
			} catch (Exception e){
				System.out.println("The Cause of error:" + e.getCause());
				System.out.println("The Message for error:" + e.getMessage());
				e.printStackTrace();
			}
		}
}
