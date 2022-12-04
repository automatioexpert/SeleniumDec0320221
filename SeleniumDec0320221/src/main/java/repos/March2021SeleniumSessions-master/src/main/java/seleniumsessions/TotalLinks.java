package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;
	public static void main(String[] args) {

		// total number of links on the page
		// you have to print the text of each link on the console
		// ignore the blank link text

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");

//		for(int i=0; i<linksList.size(); i++) {
//			System.out.println(linksList.get(i).getText());
//		}
		
		By links = By.tagName("a");
		
//		List<String> actualList = getElementsTextList(links);
//		for(String s : actualList) {
//			System.out.println(s);
//		}
		
		printElementsText(links);
	}

	/**
	 * This function will take By locator and will return the list of elements
	 * @param locator
	 * @return 
	 */
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	
	public static void printElementsText(By locator) {
		getElementsTextList(locator).stream().forEach(e -> System.out.println(e));
	}

}
