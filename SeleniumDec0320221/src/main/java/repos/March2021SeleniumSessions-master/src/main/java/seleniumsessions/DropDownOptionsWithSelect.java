package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOptionsWithSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

//		Select indus = new Select(driver.findElement(industry));
//		
//		List<WebElement> indusOptions = indus.getOptions();
//		
//		for(WebElement e : indusOptions) {
//			System.out.println(e.getText());
//		}

//		for(int i=0; i<indusOptions.size(); i++) {
//			System.out.println(indusOptions.get(i).getText());
//		}

		// indusOptions.stream().forEach(e -> System.out.println(e.getText()));
//		printDropDownOptions(industry);		
//		printDropDownOptions(country);	

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");

		doSelectValueFromDropDown(country, "India");
		doSelectValueFromDropDown(industry, "Travel");

		if (getDropDownOptions(industry).size() == 21) {
			System.out.println("PASSED");
		}

		if (getDropDownOptions(industry).contains("Travel")) {
			System.out.println("PASSED");
		}

		String Title = driver.getTitle();
		System.out.println(Title);
		if (Title.equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
			System.out.println("correct Title");
		} else {
			System.out.println("Incorrect Title");
		}

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void printDropDownOptions(By locator) {
		getDropDownOptions(locator).stream().forEach(e -> System.out.println(e));
	}

	public static List<String> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			optionsTextList.add(e.getText());
		}
		return optionsTextList;
	}

	public static void doSelectValueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

}
