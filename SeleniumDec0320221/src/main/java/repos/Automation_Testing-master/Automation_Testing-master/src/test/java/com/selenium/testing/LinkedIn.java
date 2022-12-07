package com.selenium.testing;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.bridgelabz.selenium.main.Base;

public class LinkedIn extends Base{
	
	@Test
	public void login(){
		try {
		//**1** setting web driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		//System.out.println("The page sources are: " + driver.getPageSource());
		driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin"); 
		
		driver.getTitle(); //Get the title of the current web page
		
		//**2** Finding elements within the current page by using element locators.
		driver.findElement(By.name("session_key")).sendKeys("Rajkawale00@gmail.com");
        //Thread.sleep(100);
        driver.findElement(By.name("session_password")).sendKeys("Mietgondia712@");
        //Thread.sleep(100);
        //driver.findElement(By.className("Remember me")).click();
        //Thread.sleep(50);
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        //Thread.sleep(3000);
        
        //**3** Taking screenshot with actual date
        //System.out.println("Page source: " + driver.getPageSource());  //Printing all sources from current page
        Date date = new Date();
        String date1 = date.toString();
        System.out.println("Date of screenshot is: " + date1);
        String date2 = date1.replaceAll(":" , "_");
        TakesScreenshot ts = (TakesScreenshot)driver;     //use of screenshot driver
        
        //Saving screenshots in local drive
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshot/" + date2 + "_LinkedIn.png");
        FileUtils.copyFile(srcFile, destFile);
        
        //Inspecting final confirmation with expected result
        String expectedUrl= driver.getCurrentUrl();
        String actualUrl="https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin";  //LinkedIn
        
        Assert.assertEquals(actualUrl,expectedUrl);	
        
        //**4** Find elements by Coordinates (Exact location of element)
        WebElement element = driver.findElement(By.xpath("//*[@id=\"ember28\"]"));
        
        //BY using points class to get x and Y coordinates of element
        Point point = element.getLocation();
        int xCoordinate = point.getX();
        System.out.println("The Position of elements are: "+ xCoordinate + " pixel in x-coordinate.");

        int yCoordinate = point.getY();
        System.out.println("The Position of elements are: "+ yCoordinate + " pixel in y-coordinate.");
        
        
        //**5** Getting Element's size
        WebElement Image = driver.findElement(By.xpath("//*[@id=\"ember74\"]"));
        //Width of element
        int ImageWidth = Image.getSize().getWidth();
        System.out.println("The width of image is: " + ImageWidth + " Pixel");
        //Height of element
        int ImageHeight = Image.getSize().getHeight();
        System.out.println("The Height of image is: " + ImageHeight + " Pixel");
        
        //**6** Navigating web page
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("http://www.google.com");
        Thread.sleep(5000);
        
        //**7** Closing the current window
        driver.close();
        
		} catch (Exception e){
			System.out.println("The Cause of error:" + e.getCause());
			System.out.println("The Message for error:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
