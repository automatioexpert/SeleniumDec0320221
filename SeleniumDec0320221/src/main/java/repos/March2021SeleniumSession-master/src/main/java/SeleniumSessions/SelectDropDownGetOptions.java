package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownGetOptions {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
		List<String> indusList = doGetAllDropDownOptions(industry);
		
		if(indusList.size()==21) {
			System.out.println("industry count is correct");
		}
		
		if(indusList.contains("Electronics")) {
			System.out.println("Electronics is present");
		}
		
		doSelectValue(industry, "Education");
		doSelectValue(country, "India");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> doGetAllDropDownOptions(By locator) {
		List<String> optionsTextList = new ArrayList<String>();
		
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	
	public static void doSelectValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
				if(text.equals(value)) {
					e.click();
					break;
				}
		}
	}
	
}
