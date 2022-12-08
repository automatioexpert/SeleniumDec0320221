package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.Todo_List_Page;
import util.BrowserFactory;
import util.ExcelReader;

public class RemoveProductTest {

	WebDriver driver;
	
	ExcelReader excelReader = new ExcelReader("src/main/java/testData/test_data.xlsx");
	String product = excelReader.getCellData("to_do","Product_1", 2);
	
	@Test
	public void validUserShouldBeAbleToRemoveProduct() {
		driver =BrowserFactory.init();
		
		Todo_List_Page todoListPage = PageFactory.initElements(driver, Todo_List_Page.class);
		
		todoListPage.clickOnFirstListItem();
		todoListPage.clickOnRemoveButton();
		todoListPage.verifyProductRemoval();
		
		BrowserFactory.tearDown();
		
	}
	
}
