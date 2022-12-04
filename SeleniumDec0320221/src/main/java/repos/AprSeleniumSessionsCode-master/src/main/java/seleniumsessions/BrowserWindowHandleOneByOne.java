package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleOneByOne {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='LinkedIn OrangeHRM group']")).click();

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

		// 2.
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on Facebook']")).click();
		Thread.sleep(2000);

		Set<String> handles2 = driver.getWindowHandles();

		Iterator<String> it2 = handles2.iterator();
		parentWindowId = it2.next();
		childWindowId = it2.next();
		
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());



	}

}
