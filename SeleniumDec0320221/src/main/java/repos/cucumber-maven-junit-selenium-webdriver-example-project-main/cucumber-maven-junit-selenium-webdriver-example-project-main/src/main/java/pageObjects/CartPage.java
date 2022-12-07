package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	WebDriver driver;
	//common base path
	String productAreaBasePath = "//div[@class=\"products\"]/table/tbody";
	//selected product section
	public By selectedProductSection = By.xpath(productAreaBasePath);
	public By selectedProductNameCP = By.xpath(productAreaBasePath+"//p[@class=\"product-name\"]");
	public By selectedProductQuantityCP = By.xpath(productAreaBasePath+"//p[@class=\"quantity\"]");
	public By selectedProductPriceCP = By.xpath(productAreaBasePath+"//td[4]//p");
	public By selectedProductTotalPriceCP = By.xpath(productAreaBasePath+"//td[5]//p");
	//other elements
	public By promoCodeApplyButton = By.className("promoBtn");
	public By placeOrderButton = By.xpath("//button[text()=\"Place Order\"]");
	
	//constructor method
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	//common method
	public WebElement getPageElement(By element) {
		return driver.findElement(element);
	}

}
