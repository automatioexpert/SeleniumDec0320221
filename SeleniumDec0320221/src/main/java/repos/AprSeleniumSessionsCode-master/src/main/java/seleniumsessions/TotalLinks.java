package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	//1. total number of links on the page
	//2. print the text of each link on the console
	//3. print only those links which are having text with their index number
	//4. find out the broken links -- later

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		System.out.println("total links: " + linksList.size());
		
//		for(int i=0; i<linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//				if(!text.isEmpty()) {
//					System.out.println(i+ " : "+text);
//				}
//		}
		//
//		int count = 0;
//		for(WebElement e : linksList) {
//			String text = e.getText();
//			if(!text.isEmpty()) {
//				System.out.println(count+ " : "+text);
//			}
//			count++;
//		}
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		//By links_xpath = By.xpath("//a[@href]");

		int totalLinks = getPageElementsCount(links);
		System.out.println("page links : " + totalLinks);
		
		int totalImages = getPageElementsCount(images);
		System.out.println("page images : " + totalImages);

		List<String> linksTextList = getElementsTextList(links);
		System.out.println(linksTextList.contains("Careers"));
		
		if(linksTextList.contains("Careers")) {
			System.out.println("PASS");
		}
		
		System.out.println("non blank list: " + getElementsTextCount(links));
		
	}
	
	//non blank list count:
	public static int getElementsTextCount(By locator) {
		return getElementsTextList(locator).size();
	}
	
	//non blank text list:
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
	
	public static int getEmptyEleTextList(By locator) {
		int totalLinks = getPageElementsCount(locator);
		int totalNonEmptyLinks = getElementsTextCount(locator);
		return totalLinks - totalNonEmptyLinks;
	}
	
	
	//1. total number of links on the page
	public static int getPageElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	

}
