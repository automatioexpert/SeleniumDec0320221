package com.BasicSelinum;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table_Dynamic_Handling {
	static WebDriver driver = null;
	static String max;
	static double m = 0, r = 0;

	public static void main(String[] args) throws ParseException {
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", driverPath + "\\Drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.navigate().to("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Get the Number of columns in the table
		List<WebElement> columnsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("Number of rows in this Table is: " + columnsNumber.size());

		// Get the Number of rows in the table
		List<WebElement> rowsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println("Number of rows in this Table is: " + rowsNumber.size());

		// Get 3rd row data of the table
		WebElement thirdRow = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
		String rowtext = thirdRow.getText();
		System.out.println("Third row of table : " + rowtext);

		// Get data of the cell 3rd row and 4nd column
		WebElement cellData = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[4]"));
		String value = cellData.getText();
		System.out.println("The Cell Value of 3rd row and 2nd column is :" + value);

		// Get Maximum of all the Values in a Column of Dynamic Table
		for (int i = 0; i < rowsNumber.size(); i++) {
			// we have to change x-path to get next row.This will scan all rows to find/ maximum from current price
			max = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + (i + 1) + "]/td[4]")).getText();
			NumberFormat f = NumberFormat.getNumberInstance();
			Number num = f.parse(max);
			max = num.toString();
			m = Double.parseDouble(max);
			if (m > r) {
				r = m;
			}
			System.out.println("Maximum current price is : "+ r);
		}
	}
}
