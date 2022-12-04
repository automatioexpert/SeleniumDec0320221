package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MonkeyTesting {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);

		List<WebElement> footerList = driver.findElements(By.cssSelector("div.navFooterVerticalRow li a"));
		int footerCount = footerList.size();
		System.out.println("total footer links: " + footerCount);
		
		for(int i=0 ; i<footerCount; i++) {
			int randomindex = (int)Math.floor(Math.random() * footerCount);
			System.out.println(randomindex);
			WebElement e = footerList.get(randomindex);
			System.out.println(e.getText());
			e.click();
			driver.navigate().back();
			Thread.sleep(1500);
			footerList = driver.findElements(By.cssSelector("div.navFooterVerticalRow li a"));
		}
		

	}

}
