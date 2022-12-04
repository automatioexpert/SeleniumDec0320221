package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLinksAttributes {
	
	//print the href attribute of each link:

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		System.out.println("total links: " +  linksList.size());

		for(WebElement e : linksList) {
			String hrefVal = e.getAttribute("href");
			System.out.println(hrefVal);
		}

	}

}
