package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadedConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");

		waitForPageLoaded();
		
		Point p = driver.findElement(By.name("txtsearch")).getLocation();
		int xVal = p.x;
		int yVal = p.y;
		
		System.out.println(xVal + " " + yVal);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static boolean elementIsDisplayed(By locator) {
		if(doGetElements(locator).size()>0) {
			return true;
		}
		return false;
	}	
	
	
	
	
	

	public static void waitForPageLoaded() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String loadingStatus = js.executeScript("return document.readyState;").toString();

		if (loadingStatus.equals("complete")) {
			System.out.println("page is fully loaded");
		} 
		else {
			for (int i = 1; i <= 20; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				loadingStatus = js.executeScript("return document.readyState;").toString();
				System.out.println("current page loading status: " + loadingStatus);
				if (loadingStatus.equals("complete")) {
					break;
				}

			}
		}

	}

}
