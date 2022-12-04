package SeleniumSessions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.page.Page.CaptureSnapshotFormat;
import org.openqa.selenium.devtools.v95.log.Log;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.page.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		DevTools dt = ((ChromeDriver) driver).getDevTools();	
		dt.createSession();
		driver.get("https://www.amazon.com");

		dt.send(Log.enable());
        dt.addListener(Log.entryAdded(), logEntry -> {
                System.out.println("log: " + logEntry.getText());
                System.out.println("level: " + logEntry.getLevel());
        });
        
        dt.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        dt.addListener(Network.requestWillBeSent(), e -> {
        	 System.out.println(e.getRequest().getUrl());
        	 System.out.println(e.getRequest().getPostData());
        	 System.out.println(e.getRequest().getMethod());
        });
		
        dt.send(Page.captureSnapshot(Optional.empty()));
        
	}

}
