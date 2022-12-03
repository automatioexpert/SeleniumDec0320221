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

		//1. total links on the page
		//2. print the text of each link
		//3. exclude the blank text
		//4. capture the text in a list and return
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		System.out.println("total links: " + linksList.size());
		
//		for(WebElement e : linksList) {
//			String text = e.getText();
//			if(!text.isEmpty()) {
//				System.out.println(text);
//			}
//		}
		
//		for(int i=0; i<linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			if(!text.isEmpty()) {
//				System.out.println(text);
//			}
//		}
		
		By links = By.tagName("a");
		
		System.out.println("total links : " + getElements(links).size());
		
		List<String> eleTextList = getLinksTextList(links);
		System.out.println(eleTextList.size());
		System.out.println(eleTextList.contains("Sell"));
	}
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> getLinksTextList(By locator) {
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
	
	
	
	
	
	

}
