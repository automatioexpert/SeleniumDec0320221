package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptUtilConcept {

	static WebDriver driver;

		
		//JSE - JavaScript Executor

		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
			driver.get("https://classic.crmpro.com/index.html");
			
			JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
			//jsUtil.generateAlert("this classic crm home page");
			//System.out.println(jsUtil.getTitleByJS());
			
			//jsUtil.refreshBrowserByJS();
			
//			String pageText = jsUtil.getPageInnerText();
//				if(pageText.contains("Group Calendar")) {
//					System.out.println("available");
//				}
			
//			jsUtil.drawBorder(driver.findElement(By.xpath("//input[@value='Login']")));
//			jsUtil.drawBorder(driver.findElement(By.id("loginForm")));
		
			
//			jsUtil.flash(driver.findElement(By.name("username")));
			driver.findElement(By.name("username")).sendKeys("groupautomation");
//			
//			jsUtil.flash(driver.findElement(By.name("password")));
			driver.findElement(By.name("password")).sendKeys("Test@12345");
//			
//			jsUtil.flash(driver.findElement(By.xpath("//input[@value='Login']")));
//			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
//			jsUtil.scrollPageDown();
//			Thread.sleep(3000);
//			jsUtil.scrollPageUp();
//			jsUtil.scrollPageDown("200");
			
			//jsUtil.scrollIntoView(driver.findElement(By.xpath("//span[text()='Essentials for your safety']")));
			//lazy loading of the page:
			
			
			jsUtil.clickElementByJS(driver.findElement(By.xpath("//input[@value='Login']")));
			
	}

}
