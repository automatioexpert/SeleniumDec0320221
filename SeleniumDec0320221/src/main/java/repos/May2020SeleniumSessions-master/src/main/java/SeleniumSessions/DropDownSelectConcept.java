package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_submitForm_Country");
		By industry = By.id("Form_submitForm_Industry");

		List<String> countryList = getDropDownOptionsValues(country);
		System.out.println(countryList);

		List<String> industryList = getDropDownOptionsValues(industry);
		System.out.println(industryList);

	}

	public static List<String> getDropDownOptionsValues(By locator) {
		List<String> optionsList = new ArrayList<String>();

		Select select = new Select(getElement(locator));

		List<WebElement> dropList = select.getOptions();
		System.out.println(dropList.size());

		for (int i = 0; i < dropList.size(); i++) {
			String text = dropList.get(i).getText();
			// System.out.println(i +" -->"+ text);
			optionsList.add(text);
		}

		return optionsList;

	}

	public static WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

}
