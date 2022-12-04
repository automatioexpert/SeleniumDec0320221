package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllDropDownValuesWithSelectTag {

	static WebDriver driver;

	public static void main(String[] args) {

		//drop down-- html tag --> select
		//Select class in selenium
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		
		Select select = new Select(country);
		List<WebElement> countryList = select.getOptions();
		
		System.out.println(countryList.size());
		if(countryList.size()-1 == 231) {
			System.out.println("country count is correct");
		}
		
		int count = 0;
		for(WebElement e : countryList) {
			String text = e.getText();
			System.out.println(count+"::"+text);
			count++;
		}
		
//		for(int i=0; i<countryList.size(); i++) {
//			String text = countryList.get(i).getText();
//			System.out.println(i+"::"+text);
//		}
		
		
		
	}

}
