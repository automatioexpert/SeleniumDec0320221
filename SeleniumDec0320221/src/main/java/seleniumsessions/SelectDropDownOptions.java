package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownOptions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// dropdown - select tag
		// use Select class from selenium

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
//		if(getDropDownCount(country)-1 == 231) {
//			System.out.println("PASS");
//		}
//		
//		System.out.println(getDropDownValuesList(country).contains("India"));

		Select select = new Select(driver.findElement(country));
		//select.deselectAll();
		
//
//		List<WebElement> countryList = select.getOptions();
//		System.out.println("total values: " + countryList.size());
//
//		for (WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//		}

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static int getDropDownCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	
	public static List<String> getDropDownValuesList(By locator) {
		Select select = new Select(getElement(locator));
		List<String> optionsValList = new ArrayList<String>();
		List<WebElement> optionsEleList = select.getOptions();
		for(WebElement e : optionsEleList) {
			String text = e.getText();
			optionsValList.add(text);
		}
		return optionsValList;
	}

}
