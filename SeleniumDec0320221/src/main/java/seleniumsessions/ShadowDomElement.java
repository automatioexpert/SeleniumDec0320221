package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//html DOM page ---> elements
				//--->iframe
						//---> Shadow DOM
									//---->input - tea
		
		//html DOM page ---> elements
				//--->iframe
					//---->input - tea
		
		//SVG -- xpath
		//ShadowDOm -- CSS -- query Selector
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(2000);
		
		driver.switchTo().frame("pact");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = 
				(WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");

		tea.sendKeys("masala tea");
		
		
	}

}
