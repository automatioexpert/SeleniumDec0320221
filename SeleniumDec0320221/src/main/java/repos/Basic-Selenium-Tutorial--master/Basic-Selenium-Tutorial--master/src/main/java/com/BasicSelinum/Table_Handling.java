package com.BasicSelinum;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table_Handling {
	static WebDriver driver;

	public static void main(String[] args) {

		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", driverPath + "\\Drivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.navigate().to("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Get the Number of rows in the table
		List<WebElement> rowNumber = driver.findElements(By.xpath("//div[contains(@class,'rt-tr-group')]"));
		System.out.println("Number of rows in this Table is: " + rowNumber.size());

		// Print the number of rows which has data
		List<WebElement> rowsWithData = driver.findElements(
				By.xpath("//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
		System.out.println("Number of rows having data in the table is: " + rowsWithData.size());
		
		// Get the Number of column in the table
		List<WebElement> columnNumber = driver.findElements(By.xpath("//div[contains(@class,'rt-th rt-resizable-header -cursor-pointer')]"));
		System.out.println("Number of columns in this Table is: " + columnNumber.size());

		// Print the number of columns which has data
		List<WebElement> columnsWithData = driver.findElements(By.xpath(
				"//div[contains(@class,'rt-resizable-header-content') and text()]/ancestor::div[contains(@class,'rt-th rt-resizable-header -cursor-pointe')]"));
		System.out.println("Number of columns having data in the table is: " + columnsWithData.size());

		// Finding cell value for specific row 1 & column 4
		WebElement cellAddress = driver.findElement(By.xpath("//div[contains(text(),'cierra@example.com')]"));
		String value = cellAddress.getText();
		System.out.println("The Cell Value of row 1 and column 4 is :" + value);

		// Print the text of 2nd row
		System.out.println("Data of 2nd row is: " + rowsWithData.get(1).getText());

		// Print the text of 2nd column
		List<WebElement> colsWithData = driver.findElements(By.xpath("//div[@class='rt-td'][2][text()]"));

		System.out.println("Data of 2nd Column is: ");
		for (int index = 0; index < colsWithData.size(); index++) {
			System.out.println(colsWithData.get(index).getText());
		}

		// Search for Alden in the search box, Get the rows which has data and print the Number of rows visible
		driver.findElement(By.id("searchBox")).sendKeys("Alden");
		List<WebElement> rowsWithDataAfterSearch = driver.findElements(
				By.xpath(".//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
		System.out.println("No of Rows Visible after Search: " + rowsWithDataAfterSearch.size());
		System.out.println("Data of the Table after search is: \n " + rowsWithDataAfterSearch.get(0).getText());
		
		driver.quit();
	}
}
