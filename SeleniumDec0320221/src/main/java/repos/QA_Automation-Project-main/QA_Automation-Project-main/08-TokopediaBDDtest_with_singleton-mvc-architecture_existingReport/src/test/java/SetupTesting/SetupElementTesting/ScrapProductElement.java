package SetupTesting.SetupElementTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupTesting.SetupDriverSingleton.DriverSingleton;

public class ScrapProductElement {

	private WebDriver driver;
	private List<WebElement> elemPrice;
	private List<WebElement> elemName;
	
	public ScrapProductElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Element
	@FindBy(xpath = "//div[@data-testid='spnSRPProdName']")
	private List<WebElement> nameAll;

	@FindBy(xpath = "//div[@data-testid='spnSRPProdPrice']")
	private List<WebElement> priceAll;

	@FindBy(xpath = "//button[@aria-label='Laman berikutnya']")
	private WebElement next;
	
	//name product
	public List<WebElement> produkNameElem() {
		this.scroll();
		return nameAll;
	}
	
	public List<WebElement> produkNameElem(int page) {
		this.scroll();
		this.pageName(page);
		return elemName;
	}

	// product price
	public List<WebElement> priceAllElem() {
		this.scroll();
		return priceAll;
	}
	
	public List<WebElement> priceAllElem(int page) {
		this.scroll();
		this.pagePrice(page);
		return elemPrice;
	}
	
	
// method
	//scroll
	private void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int y = 0; y <= 110; y++) {
			js.executeScript("window.scrollBy(0," + y + ")");
		}
	}
	
	//page name
	private List<WebElement> pageName(int page) {
		for (int i = 0; i < page; i++) {
			this.elemName = nameAll;
			for (int x = 0; x < elemName.size(); x++) {
				System.out.println(elemName.get(x).getText());
				this.elemName = nameAll;
			}
			System.out.println("Size of product every page "+elemName.size());
			System.out.println("Size of product " + elemName.get(i).getSize());
			WebDriverWait wait = new WebDriverWait(driver, 500);
			WebElement next = wait.until(ExpectedConditions.visibilityOf(this.next));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", next);
			this.scroll();
		}
		return nameAll;
	}
	
	//page price
	private List<WebElement> pagePrice(int page) {
		for (int i = 0; i < page; i++) {
			this.scroll();
			this.elemPrice = priceAll;
			for (int x = 0; x < elemPrice.size(); x++) {
				System.out.println(elemPrice.get(x).getText());
				this.elemPrice = priceAll;
			}
			System.out.println("Size of product every page "+elemPrice.size());
			System.out.println("Size of product " + elemPrice.get(i).getSize());
			WebDriverWait wait = new WebDriverWait(driver, 500);
			WebElement next = wait.until(ExpectedConditions.visibilityOf(this.next));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", next);
			this.scroll();
		}
		return priceAll;
	}



}
