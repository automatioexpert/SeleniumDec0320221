package SeleniumSessions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementExceptionConcept {
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// driver.findElement(By.id("input-email11")).sendKeys("test@123");
		// NoSuchElementException: no such element: Unable to locate element
		// ElementNotFoundException

		By emailId = By.id("input-email");
		vefiyElementPresent(emailId);
		driver.findElement(emailId).sendKeys("test@gmail.com");

	}

	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public static void vefiyElementPresent(By locator) {
		List<WebElement> emailList = doGetElements(locator);
		System.out.println(emailList.size());// 0
		try {
			if (emailList.size() == 0) {
				System.out.println("element not present");
				throw new Exception("ELEMENTNOTPRESENTEXCEPTION");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
