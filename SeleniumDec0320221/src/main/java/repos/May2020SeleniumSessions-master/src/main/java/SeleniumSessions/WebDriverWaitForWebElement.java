package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForWebElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");

		By email = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("loginBtn");
		
		By signIn = By.name("proceed");
		
		By footerLinks = By.cssSelector("ul.footer-nav li a");
		
		ElementUtil elementUtil = new ElementUtil(driver);
		System.out.println(elementUtil.isElementDisplayed(email, 10));
		
		
		
//		List<WebElement> footerLinksList = elementUtil.visibilityOfAllElements(footerLinks, 10);
//		System.out.println(footerLinksList.size());
//		
//		for (WebElement ele : footerLinksList) {
//			System.out.println(ele.getText());
//		}
		
		
//		System.out.println(elementUtil.doGetPageCurrentUrl(10, "login"));
//		
//		elementUtil.clickWhenReady(signIn, 5);
//		Alert alert = elementUtil.waitForAlertPresent(5);
//		System.out.println(alert.getText());
//		alert.accept();
		
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(email));
		//driver.findElement(email).sendKeys("testnaveen@gmail.com");
		
//		waitForElementPresent(driver, 10, email).sendKeys("test@gmail.com");
//		
//		driver.findElement(password).sendKeys("test123");
//		
//		waitForElementPresent(driver, 5, loginButton).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		
		//driver.findElement(By.name("proceed")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.alertIsPresent());
//		
//		driver.switchTo().alert().accept();
		
//		Alert alert = waitForAlertPresent(driver, 10);
//		System.out.println(alert.getText());
//		alert.accept();
		

	}
	
	public static WebElement waitForElementPresent(WebDriver driver, int timeOut, By locator){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static Alert waitForAlertPresent(WebDriver driver, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	

}
