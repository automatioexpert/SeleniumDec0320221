package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagNameConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//find out total number of links on the page:
		//print the text of each link on the console
		//but ignore the blank/empty text
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		System.out.println("total links: "+ linksList.size());
		
		for(int i=0; i<linksList.size(); i++){
			
			String text = linksList.get(i).getText();
			
			if(!text.isEmpty()){
				System.out.println(text);
			}
		}

	}

}
