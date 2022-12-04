package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//click on links one by one and handle 2 windows at a time:

public class WindowOneByOne {

	private static Set<String> windowHandles;
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		By fb = By.xpath("//img[@alt='OrangeHRM on Facebook']");
		By li = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		By tw = By.xpath("//img[@alt='OrangeHRM on twitter']");
		By yt = By.xpath("//img[@alt='OrangeHRM on youtube']");

		handleChildWindow(fb);
		handleChildWindow(li);
		handleChildWindow(tw);
		handleChildWindow(yt);

	}

	public static void handleChildWindow(By locator) {
		String parentId = null;
		String childId = null;
		driver.findElement(locator).click();
		windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		parentId = it.next();
		childId = it.next();

		driver.switchTo().window(childId);
		System.out.println("child window title: " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentId);
		System.out.println("parent window title: " + driver.getTitle());

	}

}
