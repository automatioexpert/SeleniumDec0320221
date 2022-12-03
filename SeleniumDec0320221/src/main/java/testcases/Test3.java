package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptUtil;

public class Test3 {

	JavaScriptUtil js;

	@Test
	public void test1() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		js = new JavaScriptUtil(driver);

		driver.get("https://www.goodreads.com/genres/self-help");
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'My Books')]"));

		js.flash(element);

		System.out.println("Page title is: "+js.getTitleByJS());
	
		js.generateAlert("The darkNightCloud");
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Alert message: "+alert.getText());
		alert.accept();
		
		js.getPageInnerText();
		js.scrollPageDown();
		Thread.sleep(3000);
		js.scrollPageUp();
		js.refreshBrowserByJS();
		System.out.println("Refreshed the page");
			
		/*
		 * 
		 * System.out.println(driver.findElement(By.cssSelector("div.column_right>h1")).
		 * getText());
		 * System.out.println(driver.findElement(By.cssSelector("div.column_right>h1+p")
		 * ).getText()); System.out.println("Test case passed"); driver.quit();
		 */
		
		
	Thread.sleep(5000);
	
	}
}
