package SetupTesting.SetupElementTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupTesting.SetupDriverSingleton.DriverSingleton;

public class SearchProductElement {
	private WebDriver driver;

	public SearchProductElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//Element

		@FindBy(xpath = "//*[@id='header-main-wrapper']//input[@data-unify='Search']")
		private WebElement searchBar;
		
		@FindBy(xpath = "//*[@id='zeus-root']//div[@data-testid='dSRPSearchInfo']")
		private WebElement searchInfo;
		
	//method
	public void searchProduct(String product){
		searchBar.sendKeys(product);
	}
	
	public void enterSearch(){
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public String searchInfo() {
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		WebElement searchInfo = wait.until(ExpectedConditions.visibilityOf(this.searchInfo));
		return searchInfo.getText();
	}



}
