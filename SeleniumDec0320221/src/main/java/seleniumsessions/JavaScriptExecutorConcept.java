package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//browser -- JS 
		
//		JavascriptExecutor js = ((JavascriptExecutor)driver);
//		String title = js.executeScript("return document.title;").toString();
//		System.out.println(title);
//		
//		js.executeScript("alert('hello java')");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		
		//jsUtil.generateAlert("hi this is my alert");
		
//		jsUtil.refreshBrowserByJS();
//		
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
//		
//		if(pageText.contains("Companies & Contacts")) {
//			System.out.println("PASS-1");
//		}
//		if(pageText.contains("Deals & Sales Pipeline")) {
//			System.out.println("PASS-2");
//		}
		
//		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
//		jsUtil.drawBorder(login);
		
//		WebElement loginForm = driver.findElement(By.cssSelector("div#content"));
//		jsUtil.drawBorder(loginForm);

//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();

//		WebElement ele = driver.findElement(By.xpath("//span[text()='Top Sellers in Books for you']"));
//		jsUtil.scrollIntoView(ele);
		
//		WebElement amz = driver.findElement(By.linkText("Amazon Science"));
//		jsUtil.clickElementByJS(amz);
		
		//jsUtil.sendKeysUsingWithId("input-email", "tom@gmail.com");
		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
		String text = driver.findElement(By.id("input-email")).getAttribute("value");
		System.out.println(text);
	}

}
