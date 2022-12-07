package com.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.bridgelabz.selenium.main.Base;

public class ActionClass extends Base{
	
	WebDriver driver;			

    @Test	
    public void DragnDrop()					
    {		
         System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");					
         driver= new EdgeDriver();					
         driver.get("http://demo.guru99.com/test/drag_drop.html");					
         
		//Element which needs to drag.    		
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
         
         //Element on which need to drop.		
         WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
         		
         //Using Action class for drag and drop.	
         Actions act=new Actions(driver);					

         //Dragged and dropped.		
         act.dragAndDrop(From, To).build().perform();	
	}		
}
