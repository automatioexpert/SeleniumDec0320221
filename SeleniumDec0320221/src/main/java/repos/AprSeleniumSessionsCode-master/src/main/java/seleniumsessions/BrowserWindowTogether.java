package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowTogether {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent window
		String parentWindowId = driver.getWindowHandle();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on youtube']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		
		Iterator<String> it = handles.iterator();
		
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl());
			
			if(!windowId.equals(parentWindowId)) {
				driver.close();
			}
			Thread.sleep(2000);
		}
		

		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title: " + driver.getTitle());
		
		driver.quit();
		
		
	}

}
