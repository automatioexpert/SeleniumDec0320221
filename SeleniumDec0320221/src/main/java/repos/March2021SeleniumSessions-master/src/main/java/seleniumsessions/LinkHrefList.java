package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkHrefList {
	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

//		By links = By.tagName("a");
//		
//		List<WebElement> linksList = driver.findElements(links);
//		
//		for(WebElement e : linksList) {
//			String hrefVal = e.getAttribute("href");
//			System.out.println(hrefVal);
//		}

		By links = By.tagName("a");
		By images = By.tagName("img");
		
		getAttributeList(links, "href");
		getAttributeList(images, "src");

	}

	public static void getAttributeList(By locator, String attr) {
		List<WebElement> attrList = driver.findElements(locator);

		for (int i = 0; i < attrList.size(); i++) {
			String srcVal = attrList.get(i).getAttribute(attr);
			System.out.println(srcVal);
		}
	}

}
