package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Todo_List_Page extends Base_Page {

	WebDriver driver;
	boolean allCheckBoxStatus;

	public Todo_List_Page(WebDriver driver) {
		this.driver = driver;
	}

	// element list
	@FindBy(how = How.XPATH, using = "//input[@name='data']")
	WebElement PRODUCT_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Add']")
	WebElement ADD_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='allbox']")
	WebElement TOGGLE_ALL_CHECK_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"todos-content\"]/form/ul/li[1]/input")
	WebElement FIRST_ITEM_CHECK_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Remove']")
	WebElement REMOVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']")
	WebElement ADD_CATEGORY_TEXT_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='music']")
	WebElement CATEGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']")
	WebElement DUE_MONTH_DROP_DOWN_ELEMENT;
	
	

	public void insertProductName(String product) {
		PRODUCT_NAME_ELEMENT.sendKeys(product + generateRandomNo());
	}

	public void clickAddButton() {
		ADD_BUTTON_ELEMENT.click();
	}

	public void verifyInsertedName(String foundProduct) {

		String xpath_first_half = "//*[@id=\"todos-content\"]/form/ul/li[";
		String xpath_last_half = "]";

		int sizeOfList = driver.findElements(By.xpath("//form[@name='todo']/ul/li")).size();

		String name = driver.findElement(By.xpath(xpath_first_half + sizeOfList + xpath_last_half)).getText();

		if (name.contains(foundProduct)) {
			System.out.println("Product found at position: " + sizeOfList);
		}
	}

	public void clickOnToggleAllCheckBox() {
		TOGGLE_ALL_CHECK_BOX_ELEMENT.click();
	}

	public void verifyToggleAllCheckBox() {
		boolean checkBoxStatus = TOGGLE_ALL_CHECK_BOX_ELEMENT.isSelected();

		if (checkBoxStatus == true) {
			System.out.println("'Toggle All' Check box is checked");
		} else {
			System.out.println("'Toggle All' Check box is unchecked");
		}
	}

	public void verifyAllCheckBoxes() {

		String xpath_first_half = "//*[@id=\"todos-content\"]/form/ul/li[";
		String xpath_last_half = "]/input";

		int totalCheckBoxes = driver.findElements(By.xpath("//form[@name='todo']/ul/li")).size();

		for (int i = 1; i <= totalCheckBoxes; i++) {
			allCheckBoxStatus = driver.findElement(By.xpath(xpath_first_half + i + xpath_last_half)).isSelected();
		}

		if (allCheckBoxStatus == true) {
			System.out.println("All Check boxes are checked");
		} else {
			System.out.println("All Check boxes are unchecked");
		}

		takeScreenshot(driver);
	}

	public void clickOnFirstListItem() {
		FIRST_ITEM_CHECK_BOX_ELEMENT.click();

	}

	public void clickOnRemoveButton() {
		REMOVE_BUTTON_ELEMENT.click();
	}

	public boolean productRemoveStatus() {
		try {
			driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li"));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void verifyProductRemoval() {
		
		if(productRemoveStatus()==false) {
			System.out.println("Product Removed");
		} else {
			System.out.println("Product available");
		}
		
	}
	
	public void addCategory(String category) {
		ADD_CATEGORY_TEXT_BOX_ELEMENT.sendKeys(category);
	}
	
	public void clickOnAddCategoryButton() {
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}
	
	public void verifyCategory(String category) {
		Assert.assertEquals(CATEGORY_ELEMENT.getText(),category, "Category mismatch");
	}
	
	public void duplicateCategoryMessage(String category, String yesButtonText) {
		
		String first_half_xpath = "//span[1][text()='";
		String last_half_xpath= "']";
		
		WebElement categoryName= driver.findElement(By.xpath(first_half_xpath + category + last_half_xpath));
		WebElement yesButton= driver.findElement(By.xpath("//a[text()='Yes']"));
		
		Assert.assertEquals(categoryName.getText(),category, "Category mismatch");
		Assert.assertEquals(yesButton.getText(),yesButtonText, "Yes button not found");
	}
	
	public void clickOnDueMonthDropDownMenu() {
		DUE_MONTH_DROP_DOWN_ELEMENT.click();
		
	}
	
	
	public void validateDueMonthDropDownMenu() {
		
		String[] originalListOfOptions = {"None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
		ArrayList<String> expectedListOfOptions = new ArrayList<String>();
		
		Select select = new Select(DUE_MONTH_DROP_DOWN_ELEMENT);
		
		for(WebElement element:select.getOptions()) {
			expectedListOfOptions.add(element.getText());
		}
		
		System.out.println(expectedListOfOptions);
		
		for(int i=0; i<originalListOfOptions.length; i++) {
			if(expectedListOfOptions.get(i).equals(originalListOfOptions[i])) {
				System.out.println("Expected list item: " + originalListOfOptions[i] + " Actual list item: " + expectedListOfOptions.get(i));
			}
			
		Assert.assertEquals(originalListOfOptions.length, expectedListOfOptions.size(), "Array are not same length");
		
		}
	}
	
	
}
