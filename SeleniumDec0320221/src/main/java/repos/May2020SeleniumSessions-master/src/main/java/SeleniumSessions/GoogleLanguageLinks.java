package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguageLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		languageClick(driver, "తెలుగు");

	}

	/**
	 * 
	 * @param driver
	 * @param langName
	 */
	public static void languageClick(WebDriver driver, String langName) {
		List<WebElement> langLinks = driver.findElements(By.xpath("//*[@id='SIvCob']/a"));

		System.out.println(langLinks.size());

		for (int i = 0; i < langLinks.size(); i++) {
			String text = langLinks.get(i).getText();
			System.out.println(text);

			if (text.equals(langName)) {
				langLinks.get(i).click();
				break;
			}

		}
	}

}
