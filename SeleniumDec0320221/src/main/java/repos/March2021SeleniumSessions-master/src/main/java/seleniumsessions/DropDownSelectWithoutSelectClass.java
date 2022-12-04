package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectWithoutSelectClass {

	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		
		//WAF -- which will take By locator
		//you can not use Select class from Selenium
		//it will select the value from the drop down
		//#Form_submitForm_Industry option - 21

		By indusOptions = By.xpath("//select[@id='Form_submitForm_Industry']/option");
		doSelectValues(indusOptions, "Travel");
	}
	
	public static void doSelectValues(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		for(WebElement e : optionsList) {
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

}
