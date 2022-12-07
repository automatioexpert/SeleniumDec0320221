package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;

public class AddCustomerTest extends BaseClass {

	@Test(dataProvider="getData")
	public void addCustomer(String firstname,String lastname,String postcode) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	

		
		WebElement add_customerBtn = driver.findElement(By.cssSelector(objectRepo.getProperty("add_customerBtn")));
		add_customerBtn.click();

		 
		driver.findElement(By.cssSelector(objectRepo.getProperty("firstname_CSS"))).sendKeys(firstname);;
		driver.findElement(By.xpath(objectRepo.getProperty("lastname_XPATH"))).sendKeys(lastname);;
		driver.findElement(By.cssSelector(objectRepo.getProperty("postcode_CSS"))).sendKeys(postcode);;
		driver.findElement(By.cssSelector(objectRepo.getProperty("addbtn_CSS"))).click();
		
		
		Alert  alert  = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains("Customer added successfully"));
		Reporter.log("Done Add customer!!");
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() {
 
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];
	
		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2			
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;
		
	}
	
	
	
}
