package com.selenium.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FindElements {
	
	@Test
	public void findLinks() {
		try {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); //initialize the driver
		
		driver.get("https://github.com/Rajkawale7");
		//Creating list and storing all links from provided web page
		List<WebElement> TotalLinks = driver.findElements(By.tagName("a"));
		
		//***1*** Getting Total number of links from given web page
		System.out.println("Total number of links present in web page is : "+ TotalLinks.size());
		
		//***2*** Getting Total Visible Links
		int TotalVisibleLinks = 0;
		
		//***3*** Getting Total Hidden Links
		int TotalHiddenLinks = 0;
		
		//use of for each loop to fetch and iterate all the links
		for (WebElement Links : TotalLinks) {
			if (Links.isDisplayed()) {
				TotalVisibleLinks++;
				System.out.println(TotalVisibleLinks + "::" + Links.getText());
			} else {
				TotalHiddenLinks++;
				System.out.println(TotalHiddenLinks + "::" + Links.getText());
			}
		}
		System.out.println("Total Number of visible links: " + TotalVisibleLinks );
		System.out.println("Total Number of Hidden Links: " + TotalHiddenLinks);
		
		//TotalLinks.get(41).click();    //Fetching link of number 41
		driver.close();    //Closing web page
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
