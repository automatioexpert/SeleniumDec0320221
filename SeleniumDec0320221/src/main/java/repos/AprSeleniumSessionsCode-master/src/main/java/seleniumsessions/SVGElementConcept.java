package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	public static void main(String[] args) throws InterruptedException {

		// SVG element:

		// *[name()='g' and @fill-rule='evenodd']
		// *[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);
		
		List<WebElement> statesList = 
					driver.findElements
					(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='path']"));
		
		System.out.println(statesList.size());
		Actions act = new Actions(driver);
		
		for(WebElement e : statesList) {
			String name = e.getAttribute("name");
			System.out.println(name);
				if(name.equals("Maryland")) {
					act.click(e).perform();
					break;
				}
		}
		
	}

}
