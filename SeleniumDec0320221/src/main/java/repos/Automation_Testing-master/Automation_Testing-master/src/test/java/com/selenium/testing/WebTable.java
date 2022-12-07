package com.selenium.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class WebTable {
	
	@Test
	public void fetchWebTable() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); //initialize the driver
		
		driver.get("C:\\Users\\Raj Kawale\\OneDrive\\Desktop\\QA Testing\\Selenium\\SeleniumPrograms\\WebTable.html");
		
		//***1*** Counting total number of Rows are in table
		//Using list
		List <WebElement> Rows = driver.findElements(By.xpath("//tr")); 
		int TotalRows = Rows.size(); 
		System.out.println("Total number of rows are: "+ TotalRows);
		
		//***2*** Counting total number of Columns are in table
		List<WebElement> Columns = driver.findElements(By.xpath("//th"));
		int TotalColumns = Columns.size();
		System.out.println("Total number of columns are:"+ TotalColumns);
		
		//***3*** Counting total number of Cells are in table
		List<WebElement> Cells = driver.findElements(By.xpath("//th|//td"));   
		int TotalCells = Cells.size();
		System.out.println("Total number of Cells are: " + TotalCells);
		
		//***4*** Printing ages of peoples
		int NumberOfPersons = 0;
		int sum = 0;
		for (WebElement webElement : Cells) {
			String Data = webElement.getText();
			
			try {
				int age = Integer.valueOf(Data);
				System.out.println("The person with age is: " + age);
				NumberOfPersons++;
				sum = sum + NumberOfPersons;
				
			}catch (Exception e) {
			}
		}		
		System.out.println("Total number of persons are: " + NumberOfPersons );
		System.out.println("Total sum: " + sum );
		driver.close(); //closing web table
	} 
}
