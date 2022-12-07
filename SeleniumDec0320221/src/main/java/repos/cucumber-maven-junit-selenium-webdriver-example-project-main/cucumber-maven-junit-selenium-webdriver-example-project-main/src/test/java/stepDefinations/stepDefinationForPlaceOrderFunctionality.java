package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.OrderPage;
import resources.Base;

public class stepDefinationForPlaceOrderFunctionality extends Base{
	HomePage hp;
	CartPage cp;
	OrderPage op;
	String selectedProductName, selectedProductQuantity, selectedProductPrice;
	int totalPrice;

	 @Given("^Initialize the browser with specific sites home page$")
	    public void initialize_the_browser_with_specific_sites_home_page() throws Throwable {
		 this.invokeBrowser();
		 driver.get(getWebsiteName());
		 hp = new HomePage(driver);
		 cp = new CartPage(driver);
		 op = new OrderPage(driver);
	    }

	 @When("^Place order with \"([^\"]*)\" product in cart$")
	    public void place_order_with_something_product_in_cart(String productName) throws Throwable {
	        //search with specific product
		 	hp.getPageElement(hp.searchBox).sendKeys(productName);
		 	hp.getPageElement(hp.searchButton).click();
		 	Assert.assertTrue(hp.getPageElement(hp.productImage).isDisplayed());
		 	//read and store all informations
		 	Assert.assertTrue(hp.getPageElement(hp.productName).getText().contains(productName));
		 	hp.getPageElement(hp.productQuantityIncrement).click();
		 	Thread.sleep(3000);
	    	selectedProductName = productName;
		 	selectedProductPrice = hp.getPageElement(hp.productPrice).getText();
		 	selectedProductQuantity = (hp.getPageElement(hp.productTotalQuantity).getAttribute("value"));
		 	if(hp.getPageElement(hp.productAddButton).isDisplayed()) hp.getPageElement(hp.productAddButton).click();
		 	//proceed to cart page
		 	hp.getPageElement(hp.addCartIcon).click();
	    	hp.getPageElement(hp.proccedToCheckoutButton).click();
	    }

	    @Then("^Cart page populated with all information$")
	    public void cart_page_populated_with_all_information() throws Throwable {
	    	totalPrice = Integer.parseInt(selectedProductQuantity)*Integer.parseInt(selectedProductPrice);
	    	Assert.assertTrue(cp.getPageElement(cp.selectedProductSection).isDisplayed());
	    	Assert.assertTrue(cp.getPageElement(cp.selectedProductNameCP).getText().contains(selectedProductName));
	    	Assert.assertTrue(cp.getPageElement(cp.selectedProductQuantityCP).getText().equalsIgnoreCase(selectedProductQuantity));
	    	Assert.assertTrue(cp.getPageElement(cp.selectedProductPriceCP).getText().equalsIgnoreCase(selectedProductPrice));
	    	Assert.assertTrue(cp.getPageElement(cp.selectedProductTotalPriceCP).getText().equalsIgnoreCase(new Integer(totalPrice).toString()));
	    	Assert.assertTrue(cp.getPageElement(cp.promoCodeApplyButton).isDisplayed());

	    }

	    @And("^Order should be placed via order page$")
	    public void order_should_be_placed_via_order_page() throws Throwable {
	    	if(cp.getPageElement(cp.placeOrderButton).isDisplayed()) cp.getPageElement(cp.placeOrderButton).click();
	    	Assert.assertTrue(op.getPageElement(op.countrySelect).isDisplayed());
	    	//Thread.sleep(5000);
	    	op.getPageElement(op.countrySelect).click();
	    	Select country = new Select(op.getPageElement(op.countrySelect));
	    	if(op.getPageElement(op.selectedCountry).isDisplayed()) country.selectByValue("Bangladesh");
	    	op.getPageElement(op.termsAndConditions).click();
	    	op.getPageElement(op.proceedButton).click();
	    	Thread.sleep(5000);
	    	Assert.assertTrue(hp.getPageElement(hp.companyName).getText().contains("GREEN"));
	    }
}
