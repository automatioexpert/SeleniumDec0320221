package pagefiles_SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.testBase;

public class ProductsPage extends testBase {

	@FindBy(xpath="//img[@alt='Sauce Labs Backpack']")
	private WebElement Backpack;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement Add_to_Cart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement shopping_cart_link;
	
	@FindBy(xpath="//button[@name='checkout']")
	private WebElement checkout;

	
	public ProductsPage() throws Exception {

		PageFactory.initElements(getDriver(),this);
	}

	
	public void clickBackpack() {
		Backpack.click();
	}

	

	public void clickAdd_to_Cart() {
		Add_to_Cart.click();
	}

	

	public void clickShopping_cart_link() {
		shopping_cart_link.click();
	}

	

	public void clickCheckout() {
		checkout.click();
	}
	
	
	
	
	
}
