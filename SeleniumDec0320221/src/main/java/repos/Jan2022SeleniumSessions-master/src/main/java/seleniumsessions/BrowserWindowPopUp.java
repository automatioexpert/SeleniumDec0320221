package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		//child window
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id : " + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window id : " + childWindowId);

		
		driver.switchTo().window(childWindowId);
		String childWindowTitle = driver.getTitle();
		System.out.println("child window title : " + childWindowTitle);
		
		driver.close();//close the child window -- driver is lost
		
		driver.switchTo().window(parentWindowId);
		//if without switching, you are interacting with parent window:
		//it will throw: NoSuchWindowException: no such window: target window already closed
		String parentWindowTitle = driver.getTitle();
		System.out.println("parent window title : " + parentWindowTitle);

		
		
		driver.quit();

	}

}
