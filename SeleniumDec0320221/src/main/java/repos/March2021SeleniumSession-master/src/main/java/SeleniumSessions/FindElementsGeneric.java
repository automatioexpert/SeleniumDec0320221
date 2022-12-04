package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsGeneric {
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		By images = By.tagName("img");
		By links = By.tagName("a");

		int linksCount = getLinksCount(links);
		System.out.println(linksCount);

		if (getLinksTextList(links).contains("About Us")) {
			System.out.println("PASS");
		}

		getAttributeList(links, "href").stream().forEach(e -> System.out.println(e));
	}

	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getAttributeList(By locator, String attributeName) {
		List<WebElement> eleList = doGetElements(locator);
		List<String> attrList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attributeName);
			attrList.add(attrVal);
		}
		return attrList;
	}

	public static int getLinksCount(By locator) {
		return getLinksTextList(locator).size();
	}

	public static List<String> getLinksTextList(By locator) {
		List<WebElement> list = doGetElements(locator);
		List<String> textList = new ArrayList<String>();

		for (WebElement e : list) {
			String text = e.getText();
			if (!text.isEmpty()) {
				textList.add(text);
			}
		}
		return textList;
	}

	public static List<WebElement> getLinksList(By locator) {
		return doGetElements(locator).stream().filter(e -> !e.getText().isEmpty()).collect(Collectors.toList());
	}

}
