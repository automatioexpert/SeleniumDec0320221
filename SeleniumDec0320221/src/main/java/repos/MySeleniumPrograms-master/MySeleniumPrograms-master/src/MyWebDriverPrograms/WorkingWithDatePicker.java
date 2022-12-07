package MyWebDriverPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithDatePicker {

	public static void main(String[] args) throws InterruptedException {
		// Working with date picker
		// Logic 1 - Enter the date as text in the date picker element
		WebDriver driver;
		// Launch Chrome
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(); // launch chrome
		driver.get("http://jqueryui.com/datepicker/"); // Get URL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Create a Webelement for Frame
		WebElement FrameElement = driver.findElement(By.className("demo-frame"));
		// Move the fous to frame
		driver.switchTo().frame(FrameElement);
		System.out.println("FrameElement is:" + FrameElement);
		// Identify the date picker and click on it
		driver.findElement(By.id("datepicker")).click();
		// Enter the date as required Text
		/*
		 * driver.findElement(By.id("datepicker")).clear();
		 * driver.findElement(By.id("datepicker")).sendKeys("12/11/2018", Keys.ENTER);
		 * //MM/DD/YYYY
		 */

		/*
		 * // Logic 2 - Select the current month as 30th August as date //Identify Popup
		 * calendar table WebElement Table =
		 * driver.findElement(By.className("ui-datepicker-calendar"));
		 * System.out.println("Table is :" + Table); //Get all the Rows in the table;
		 * List<WebElement> TableRows = Table.findElements(By.xpath("//tr"));
		 * System.out.println("TableRows is:" +TableRows); for(WebElement row:TableRows)
		 * // Retrieve each row value { System.out.println("Row is:" +row);
		 * List<WebElement> cells = row.findElements(By.xpath("td"));
		 * System.out.println("Cells is:" +cells); // Start loop for each value in the
		 * partiular rows for(WebElement cell:cells) { if(cell.getText().equals("30")) {
		 * driver.findElement(By.linkText("30")).click(); System.out.println("Cell is :"
		 * +cell); System.out.println("Date is selected as:" + "30"); } } }
		 */

		// Logic 3 - Select the current month as 28th December as date (Select the month
		// at the top of window)
		String nextbuttonxpath = "//*[@id=\"ui-datepicker-div\"]//a[@class=\"ui-datepicker-next ui-corner-all\"]";
		// String prevbuttonxpath =
		// "//*[@id=\"ui-datepicker-div\"]//a[@class=\"ui-datepicker-prev
		// ui-corner-all\"]";
		for (int i = 0; i < 12; i++) {
			String month = "ui-datepicker-month";

			WebElement monthname = driver.findElement(By.className(month));
			String MonthValue = monthname.getText();
			System.out.println("Month Value is:" + MonthValue);

			if (MonthValue.equalsIgnoreCase("December")) {
				System.out.println("Selected Month is: " + MonthValue);

				// Get all the Rows in the table;
				WebElement Table = driver.findElement(By.className("ui-datepicker-calendar"));
				System.out.println("Table is :" + Table);
				// Get all the Rows in the table;
				List<WebElement> TableRows = Table.findElements(By.xpath("//tr"));
				System.out.println("TableRows is:" + TableRows);
				for (WebElement row : TableRows)

				{ // Retrieve each row value
					System.out.println("Row is:" + row);
					List<WebElement> cells = row.findElements(By.xpath("td"));
					System.out.println("Cells is:" + cells);
					// Start loop for each value in the partiular rows
					for (WebElement cell : cells) {
						if (cell.getText().equals("31")) {
							driver.findElement(By.linkText("31")).click();
							System.out.println("Cell is :" + cell);
							System.out.println("Date is selected as:" + "31");
						}
					}
				}
				break;
			} else {

				driver.findElement(By.xpath(nextbuttonxpath)).click();
			}
		}

	}

}
