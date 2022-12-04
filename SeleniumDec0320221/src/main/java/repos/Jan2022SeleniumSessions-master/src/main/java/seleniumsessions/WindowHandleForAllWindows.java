package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//click on all links and open all the windows at the same time:
public class WindowHandleForAllWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		String parentId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String childWindowId = it.next();
			driver.switchTo().window(childWindowId);
			System.out.println(driver.getTitle());
			if(!parentId.equals(childWindowId)) {
				driver.close();
			}
		}
		
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());

		
		
	}

}
