package com.testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.driver.DriverManager;
import com.listeners.Listener;

public class FastTest extends BaseTest{	
			
	@Test
	public void verifyTest() {
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in FastTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo verifyTest Method Started ");		
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("Dummy Test");
		
		DriverManager.getDriver().findElement(By.cssSelector("li:nth-child(2) > a")).click();
        
		String mainWindow = DriverManager.getDriver().getWindowHandle();
	    System.out.println("Main window handle is " + mainWindow);
	    
	    // To handle all new opened window
	    Set<String> allWindowHandles = DriverManager.getDriver().getWindowHandles();
	    System.out.println("Child window handle is" + allWindowHandles);
	    
	    Iterator<String> iterator = allWindowHandles.iterator();  
	    // Here we will check if child window has other child windows and will fetch the heading of the child window
	    // and when child window is the main window it will come out of loop.
	    while (iterator.hasNext()) {
	          String ChildWindow = iterator.next();
	          if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
	        	  DriverManager.getDriver().switchTo().window(ChildWindow);
	           }	         
	      }
		
		String title=DriverManager.getDriver().getTitle();
		System.out.println(title);	
		
		DriverManager.getDriver().close();
	}
}
