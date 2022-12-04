package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	
	/*
	 * total images on the page
	 * 
	 */

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");
		
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		System.out.println("total image: " + imgList.size());
		
		for(WebElement e : imgList) {
			
			String srcVal = e.getAttribute("src");
			String altVal = e.getAttribute("alt");

			System.out.println(srcVal + " : " + altVal);
		}
		
	}

}
