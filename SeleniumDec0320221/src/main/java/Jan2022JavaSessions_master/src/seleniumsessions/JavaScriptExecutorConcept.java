package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {

		//execute js
		//JavaScriptExecutor will help to execute the JS
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		//jsUtil.generateAlert("hi this is my alert");
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
//		System.out.println(pageText.contains("Marketing Campaigns"));
		
//		String title = jsUtil.getTitleByJS();
////		String title = driver.findElement(By.tagName("title")).getText();
//		System.out.println(title);
		
		//jsUtil.refreshBrowserByJS();
//		WebElement loginForm = driver.findElement(By.id("loginForm"));
//		jsUtil.drawBorder(loginForm);
		
		
//		WebElement email = driver.findElement(By.id("input-email"));
//		jsUtil.flash(email);
//		email.sendKeys("naveen@gmail.com");
//		
//		WebElement pwd = driver.findElement(By.id("input-password"));
//		jsUtil.flash(pwd);
//		pwd.sendKeys("test@123");
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
		
		//jsUtil.scrollPageDown("500");
//		WebElement ele = driver.findElement(By.xpath("//span[text()='Popular products in PC internationally']"));
//		jsUtil.scrollIntoView(ele);
		
		//infinite loading///lazy page loading
		
		WebElement reg = driver.findElement(By.linkText("Registry"));
		jsUtil.clickElementByJS(reg);
		//click, Actions-click : click is happening on the element on the page
		//JS click: clicking on the element by injecting the java script.
		
		
		
	}

}
