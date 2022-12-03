package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentWindowId = it.next();
		System.out.println("parent window id: " + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window id: " + childWindowId);
		
		//
		driver.switchTo().window(childWindowId);
		System.out.println("child window url : " + driver.getCurrentUrl());
		
		driver.close();//close child window
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window url : " + driver.getCurrentUrl());
		System.out.println("parent window title : " + driver.getTitle());

		
		driver.quit();
		

		
	}

}
