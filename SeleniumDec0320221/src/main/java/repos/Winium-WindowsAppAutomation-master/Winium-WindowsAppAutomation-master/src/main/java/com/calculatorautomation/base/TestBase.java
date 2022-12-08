package com.calculatorautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class TestBase {
	/**
	 * @author Krishna Majgaonkar
	 * 
	 */

	protected static WiniumDriver driver = null;
	protected DesktopOptions options = null;
	protected Properties properties= null;  
	protected FileInputStream ip = null;
	
	protected TestBase(){
		properties = new Properties();
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/calculatorautomation/config/config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	protected void Initialization() {
		options = new DesktopOptions();
		options.setApplicationPath(properties.getProperty("CalculatorPath"));
		try {
		driver = new WiniumDriver(new URL(properties.getProperty("WiniumServerURL")), options);
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		catch (MalformedURLException e) {
			System.out.println("URL is not correct");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
