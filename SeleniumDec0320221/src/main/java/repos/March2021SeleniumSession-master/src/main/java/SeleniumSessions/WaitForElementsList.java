package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementsList {

		static WebDriver driver;
		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.get("https://www.freshworks.com/");
			
			By footerList = By.xpath("//ul[@class='footer-nav']//a");
			
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			List<WebElement> footerLinksList = 
//					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerList));
//			
//			for(WebElement e : footerLinksList) {
//				System.out.println(e.getText());
//			}
			
			ElementUtil eleUtil = new ElementUtil(driver);
			eleUtil.printAllElementsTextWithWait(footerList, 5);
			
	}

}
