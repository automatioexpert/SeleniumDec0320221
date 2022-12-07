package com.utils;

import java.util.Iterator;
import java.util.Set;

import com.constants.FrameworkConstants;
import com.driver.DriverManager;

public class TestUtil {
	
	public static void shortWait(){
		try {
			Thread.sleep(FrameworkConstants.getShortwait());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait(){
		try {
			Thread.sleep(FrameworkConstants.getMediumwait());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longWait(){
		try {
			Thread.sleep(FrameworkConstants.getLongwait());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void multipleChildWinows () {
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
	    //BasePage.getDriver().switchTo().window(mainWindow);
        //BasePage.getDriver().close();
	}
	
}
