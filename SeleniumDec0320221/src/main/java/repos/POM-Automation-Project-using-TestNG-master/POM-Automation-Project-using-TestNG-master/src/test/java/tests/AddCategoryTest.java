package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.Todo_List_Page;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCategoryTest {

	WebDriver driver;
	
	ExcelReader excelReader = new ExcelReader("src/main/java/testData/test_data.xlsx");
	String category = excelReader.getCellData("to_do","Category", 2);
	
	@Test
	public void validUserShouldBeAbleToAddCategory() {
		driver =BrowserFactory.init();
		
		Todo_List_Page todoListPage = PageFactory.initElements(driver, Todo_List_Page.class);
		
		todoListPage.addCategory(category);
		todoListPage.clickOnAddCategoryButton();
		todoListPage.verifyCategory(category);
		
		BrowserFactory.tearDown();
		
	}
	
}
