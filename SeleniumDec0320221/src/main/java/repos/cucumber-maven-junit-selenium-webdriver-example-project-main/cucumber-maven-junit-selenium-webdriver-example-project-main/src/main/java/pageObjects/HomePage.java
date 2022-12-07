package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	//common base path
	String buyingItemInfoHomePageBasePath = "//div[@class=\"cart-info\"]";
	String cartAreaBasePath = "//div[@class=\"cart-preview active\"]";
	String productQuantityManageBasePath = "//div[@class=\"stepper-input\"]";
	//page header elements
	public By companyName = By.xpath("//div[@class='brand greenLogo']");
	public By searchBox = By.xpath("//input[@type='search']");
	public By searchButton = By.className("search-button");
	public By itemQuantity = By.xpath(buyingItemInfoHomePageBasePath+"//tr/td[3]/strong");
	public By itemPrice = By.xpath(buyingItemInfoHomePageBasePath+"//tr[2]/td[3]/strong");
	public By addCartIcon = By.xpath("//a[@class=\"cart-icon\"]/img");
	//home page cart section's elements
	public By emptyCart = By.xpath(cartAreaBasePath+"//div[@class=\"empty-cart\"]");
	public By emptyCartText = By.xpath(cartAreaBasePath+"//h2");
	public By proccedToCheckoutButton = By.xpath(cartAreaBasePath+"//button");
	public By productRemoveIcon = By.xpath(cartAreaBasePath+"//a[@class=\"product-remove\"]");
	public By selectedProductNameHP = By.xpath(cartAreaBasePath+"//p[@class=\"product-name\"]");
	public By selectedProductQuantityHP = By.xpath(cartAreaBasePath+"//p[@class=\"quantity\"]");
	public By selectedProductPriceHP = By.xpath(cartAreaBasePath+"//p[@class=\"product-price\"]");
	//product section's elements
	public By productImage = By.xpath("//div[@class=\"product-image\"]");
	public By productName = By.xpath("//h4[@class=\"product-name\"]");
	public By productPrice = By.xpath("//p[@class=\"product-price\"]");
	public By productQuantity = By.xpath("//input[@class=\"quantity\"]");
	public By productAddButton = By.xpath("//button[text()=\"ADD TO CART\"]");
	public By productQuantityIncrement = By.xpath(productQuantityManageBasePath+"/a[@class=\"increment\"]");
	public By productQuantityDecrement = By.xpath(productQuantityManageBasePath+"/a[@class=\"decrement\"]");
	public By productTotalQuantity = By.xpath(productQuantityManageBasePath+"/input[@type=\"number\"]");
	public By noResultMessage = By.xpath("//div[@class=\"no-results\"]/h2");
	
	//constructor method
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	//common method
	public WebElement getPageElement(By element) {
		return driver.findElement(element);
	}
	//multiple elements method
	public List<WebElement> getMultiplePageElement(By element) {
		return driver.findElements(element);
	}
}
