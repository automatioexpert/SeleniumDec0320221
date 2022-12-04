package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableStaticTraverse {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		By rows = By.xpath("//table[@id='customers']//tr");
		By cols = By.xpath("//table[@id='customers']//th");

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[7]/td[1]

//		String before_xpath = "//*[@id=\"customers\"]/tbody/tr[";
//		String after_xpath = "]/td[1]";
//
//		getColumnData(before_xpath, after_xpath, rows);
		
		
//		for(rows..count) {
//			for(cols ..count) {
//				
//			}
//			System.out.println();
//		}
		
		
		

	}

	public static void getColumnData(String before_xpath, String after_xpath, By rows) {
		for (int row = 2; row <= getRowCount(rows); row++) {
			String xpath = before_xpath + row + after_xpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}

	public static int getColCount(By locator) {
		return driver.findElements(locator).size();
	}

	public static int getRowCount(By locator) {
		return driver.findElements(locator).size();
	}

}
