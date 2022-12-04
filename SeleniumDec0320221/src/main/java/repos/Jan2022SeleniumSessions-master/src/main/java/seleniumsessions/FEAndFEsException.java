package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FEAndFEsException {


		static WebDriver driver;

		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.freshworks.com/");
			
			
			//IllelgalStateException
			//StaleElementRefException
			//ElemntNotInteractableException 
			//ElementNotFoundException -- not in selenium
			//NoSuchSessionException
			//TimeOutException
			//NoAlertException
			
			
			//driver.findElement(By.linkText("Customers1111")).click();
			//NoSuchElementException
			
			
			boolean flag = driver.findElement(By.linkText("Customers1111")).isDisplayed();
			System.out.println(flag);
			//NoSuchElementException
			
			//wrong selector: InvalidSelectorException
			List<WebElement> footerList = driver.findElements(By.xpath("@@@@ul@@[@class'footer-nav11']//a"));
			System.out.println(footerList.size());//0
			
			if(footerList.size() > 0) {
				System.out.println("footers are present on the page...");
				for(WebElement e : footerList) {
					String text = e.getText();
					System.out.println(text);
				}
			}
			
			//
//			if(driver.findElements(By.linkText("Customers")).size() > 0) {
//				System.out.println("customers link is present on the page");
//			}
			System.out.println(isElementPresent(By.linkText("Customers")));
	}
		
		public static boolean isElementPresent(By locator) {
			if(getElements(locator).size()>0) {
				return true;
			}
			return false;
		}
		
		public static List<WebElement> getElements(By locator) {
			return driver.findElements(locator);
		}

}
