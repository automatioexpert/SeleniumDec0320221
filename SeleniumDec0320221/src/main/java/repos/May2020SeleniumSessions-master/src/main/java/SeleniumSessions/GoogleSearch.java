package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(2000);
		
		//1. create a generic method to select the single from the list
		//2. capture all the suggestions in a list and return
		//3. http://automationpractice.com/index.php
		
		List<WebElement> suggestionsList = driver.findElements(By.xpath("//ul[@class='erkvQe']/li//span"));
		System.out.println(suggestionsList.size());
		
		for(int i=0; i<suggestionsList.size(); i++){
			if(suggestionsList.get(i).getText().equals("selenium python")){
				suggestionsList.get(i).click();
				break;
			}
		}
		
		
	}

}
