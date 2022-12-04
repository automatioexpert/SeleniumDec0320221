package seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleUsingList {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();

		// collect the window IDs:
		Set<String> handles = driver.getWindowHandles();

		// use the List:
		List<String> handlesList = new ArrayList<String>(handles);

		String parentWindowID = handlesList.get(0);
		System.out.println("Parent window id is: " + parentWindowID);

		String childWindowID = handlesList.get(1);
		System.out.println("Child window id is: " + childWindowID);

		// switching to child window:

		driver.switchTo().window(childWindowID);
		System.out.println("child window title is: " + driver.getTitle());
		System.out.println("child window url is: " + driver.getCurrentUrl());

		// close the child window:
		driver.close();

		// switching back to the parent window:
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window title is: " + driver.getTitle());
		System.out.println("parent window url is: " + driver.getCurrentUrl());

		// close the parent window:
		driver.quit();

	}

}
