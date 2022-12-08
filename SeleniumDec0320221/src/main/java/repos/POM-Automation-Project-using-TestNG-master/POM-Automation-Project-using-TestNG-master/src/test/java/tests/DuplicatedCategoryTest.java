package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Todo_List_Page;
import util.BrowserFactory;
import util.ExcelReader;

public class DuplicatedCategoryTest {

	WebDriver driver;
	String yesButtonText = "Yes";
	
	ExcelReader excelReader = new ExcelReader("src/main/java/testData/test_data.xlsx");
	String category = excelReader.getCellData("to_do","Category", 2);
	
	@Test
	public void validUserShouldNotBeAbleToAddDuplicateCategory() {
		driver =BrowserFactory.init();
		
		Todo_List_Page todoListPage = PageFactory.initElements(driver, Todo_List_Page.class);
		
		//trying to add the category first time
		todoListPage.addCategory(category);
		todoListPage.clickOnAddCategoryButton();
		todoListPage.verifyCategory(category);
		
		//trying to add category 2nd time
		todoListPage.addCategory(category);
		todoListPage.clickOnAddCategoryButton();
		
		//waiting until it finds the yes button web element on the page
		WebDriverWait wait = new WebDriverWait(driver,4);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Yes']"))));
		
		todoListPage.duplicateCategoryMessage(category, yesButtonText);
		
		BrowserFactory.tearDown();
		
	}
	
}
