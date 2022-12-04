package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinkNavigation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");
		List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));

		for (int i = 1; i < footerList.size(); i++) {

			System.out.println(footerList.get(i).getText());
			footerList.get(i).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
		}

	}

}
