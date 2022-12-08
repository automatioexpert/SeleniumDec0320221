package com.TestNG.DataProvider;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderWithExcel {
	
	WebDriver driver;
	
	//execute before every test method
	@BeforeMethod   
	public void setup() {
		//launch chrome
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//open url
		driver.get("http://www.google.com");
		
		//maximize browser
		driver.manage().window().maximize();
	}
	
	//Entering keyword to search
	@Test(dataProvider = "searchDataProvider")
	public void searchKeyword(String keyword) {   
		//it will accept parameter "Keyword"
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys(keyword); //passing keywords
		searchbox.sendKeys(Keys.ENTER);  //to hit the enter by using key
	}
	
	@DataProvider(name = "searchDataProvider")
	public Object[][] searchDataProviderMethod()
	{
		String fileName = "C:\\Users\\Raj Kawale\\OneDrive\\Desktop\\QA Testing\\Selenium\\TestNG\\src\\test\\java\\com\\TestNG\\DataProvider\\Book1.xlsx";
		Object [][] searchData = getExcelData(fileName, "Sheet1");
		
		//Object [][] searchData = new Object[2][1];  //rows=2, col=1
		//searchData[0][0] = "New York"; //row=1, col=1
		//searchData[1][0] = "Scotland"; //row=2, col=1
		return searchData;
	}
	
	//creating method to read data from excel file, sheet name and return into string data
	public String [][] getExcelData(String fileName, String sheetName)
	{
		//Declare array
		String[][] data = null;
		
		//open file in read open
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
		
			//creating XssfWorkbook class object for excel file 
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet excelSheet= workBook.getSheet(sheetName);   //accessing sheet from excel tab and getting sheet name 
			
			//Getting total number of rows count
			int totalRows = excelSheet.getLastRowNum() + 1; //indexing start with zero. So, it will count 2 rows but we want 3 rows
			
			//Getting total number of cell
			int totalCells = excelSheet.getRow(0).getLastCellNum();
			
			//Initialize array
			data = new String[totalRows-1][totalCells];
			
			//Using for loop to fetch the data from excel :: Outer loop for rows and inner loop to get the data from cells
			for(int currentRow = 1; currentRow < totalRows; currentRow++ )
			{ 		
				//loop for row
				for(int currentCell = 0; currentCell < totalCells; currentCell++)
				{	
					//for inner cells
					data[currentRow-1][currentCell] = excelSheet.getRow(currentRow).getCell(currentCell).getStringCellValue();
					//It will use to get the data into string format from excel sheet::: excelSheet.getRow(currentRow).getCell(currentCell).getStringCellValue();
					//It will Store the data into string array::: data[currentRow-1][currentCell];
				} 		
			}
			workBook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@AfterMethod
	public void quiteBrowser() {
		driver.quit();
	}
}
