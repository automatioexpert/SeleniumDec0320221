package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		List<WebElement> langList = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		System.out.println("total lang links: " + langList.size());
		for (WebElement e : langList) {
			String text = e.getText();
			if (text.equals("मराठी")) {
				e.click();
				break;
			}
		}

	}

}
