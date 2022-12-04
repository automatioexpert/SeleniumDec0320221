package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptionsConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
		doSelectDropDownValue(country, "India");
		Thread.sleep(2000);
		doSelectDropDownValue(state, "Goa");
		
//		Select select = new Select(driver.findElement(country));
//		List<WebElement> countryList = select.getOptions();
//		for(WebElement e : countryList) {
//			String text = e.getText();
//				if(text.equals("India")) {
//					e.click();
//					break;
//				}
//		}

//		Select select = new Select(driver.findElement(country));
//		List<WebElement> countryOptions = select.getOptions();
//		System.out.println(countryOptions.size());
//
//		for (WebElement e : countryOptions) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
//		System.out.println(doGetDropDownOptions(country).contains("India"));
//		doSelectByVisibleText(country, "India");
//		Thread.sleep(2000);
//		System.out.println(doGetDropDownOptions(state).contains("Goa"));

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public static List<String> doGetDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsValList = new ArrayList<String>();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text);
		}
		return optionsValList;
	}
	
	public static void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e : optionsList) {
			String text = e.getText();
				if(text.equals(value)) {
					e.click();
					break;
				}
		}
	}
	

}
