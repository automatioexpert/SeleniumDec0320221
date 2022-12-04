package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// table[@id="customers"]--5
		// *[@id="customers"]--100

		// table[@id="customers"]/tbody/tr[2]/td[1]
		// table[@id="customers"]/tbody/tr[3]/td[1]
		// table[@id="customers"]/tbody/tr[4]/td[1]
		// table[@id="customers"]/tbody/tr[5]/td[1]
		// table[@id="customers"]/tbody/tr[6]/td[1]
		// table[@id="customers"]/tbody/tr[7]/td[1]

//		String beforeXpath_comp = "//table[@id=\"customers\"]/tbody/tr[";
//		String afterXpath_comp = "]/td[1]";
//		
//		int rowCount = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
//		
//		for(int i=2; i<=rowCount; i++) {
//			String compXpath = beforeXpath_comp+i+afterXpath_comp;
//			//System.out.println(compXpath);
//			String compName = driver.findElement(By.xpath(compXpath)).getText();
//			System.out.println(compName);
//		}

		// *[@id="customers"]/tbody/tr[2]/td[2]
		// *[@id="customers"]/tbody/tr[3]/td[2]
		// *[@id="customers"]/tbody/tr[4]/td[2]
		By row = By.xpath("//table[@id=\"customers\"]/tbody/tr");
		By col = By.xpath("//table[@id=\"customers\"]/tbody/tr[1]/th");
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[";
		printTable(row, col, beforeXpath, afterXpath);

	}

	public static void printTable(By rowLocator, By colLocator, String beforeXpath, String afterXpath) {
		int rowCount = driver.findElements(rowLocator).size();
		int colCount = driver.findElements(colLocator).size();
		for (int row = 2; row <= rowCount; row++) {
			for (int col = 1; col <= colCount; col++) {
				String xpath = beforeXpath + row + afterXpath + col + "]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text+"     |      ");
			}
			System.out.println();
		}

	}

}
