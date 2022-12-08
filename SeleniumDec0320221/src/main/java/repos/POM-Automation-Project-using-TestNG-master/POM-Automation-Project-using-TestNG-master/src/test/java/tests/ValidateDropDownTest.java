package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.Todo_List_Page;
import util.BrowserFactory;

public class ValidateDropDownTest {

	WebDriver driver;

	
	@Test
	public void validUserShouldBeAbleToSeeAllMonths() {
		driver =BrowserFactory.init();
		
		Todo_List_Page todoListPage = PageFactory.initElements(driver, Todo_List_Page.class);
		
		todoListPage.clickOnDueMonthDropDownMenu();
		
		todoListPage.validateDueMonthDropDownMenu();
		
		BrowserFactory.tearDown();
		
	}
	
}
