package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElements {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();// Browser
		driver.get("https://www.amazon.com/");
		
		By footer = By.cssSelector("div.navFooterLinkCol li a");
		
		long stTime = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> footerList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
		
		System.out.println(footerList.size());
		
		for(WebElement e : footerList) {
			System.out.println(e.getText());
		}
		
		long endTime = System.currentTimeMillis();

		System.out.println(endTime-stTime);
		
		

	}

}
