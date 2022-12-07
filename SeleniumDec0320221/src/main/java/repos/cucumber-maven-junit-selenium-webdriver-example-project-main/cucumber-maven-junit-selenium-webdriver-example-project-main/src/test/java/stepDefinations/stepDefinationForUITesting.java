package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.HomePage;
import resources.Base;

public class stepDefinationForUITesting extends Base{
	HomePage hp;
	CartPage cp;
	String selectedProductName, selectedProductQuantity, selectedProductPrice;

	@Given("^Initialize the browser with specific site$")
    public void initialize_the_browser_with_specific_site() throws Throwable {
	 this.invokeBrowser();
	 driver.get(getWebsiteName());
    }
    
    @When("^Browse to home page$")
    public void browse_to_home_page() throws Throwable {
    	hp = new HomePage(driver);
    }

    @Then("^Home page is populated with all of its elements$")
    public void home_page_is_populated_with_all_of_its_elements() throws Throwable {
    	//page header check
    	Assert.assertTrue(hp.getPageElement(hp.companyName).getText().contains("GREEN"));
    	Assert.assertTrue(hp.getPageElement(hp.searchBox).isDisplayed());
    	Assert.assertTrue(hp.getPageElement(hp.searchButton).isDisplayed());
    	//empty cart information check
    	Assert.assertTrue(hp.getPageElement(hp.itemQuantity).getText().contains("0"));
    	Assert.assertTrue(hp.getPageElement(hp.itemPrice).getText().contains("0"));
    	if(hp.getPageElement(hp.addCartIcon).isDisplayed()) {
    		hp.getPageElement(hp.addCartIcon).click();
        	if(hp.getPageElement(hp.emptyCart).isDisplayed()) {
            	Assert.assertTrue(hp.getPageElement(hp.emptyCartText).getText().contains("You cart is empty!"));
            	Assert.assertTrue(hp.getPageElement(hp.proccedToCheckoutButton).getAttribute("class").equalsIgnoreCase("disabled"));
        	}
    	}
    	//product information check
    	Assert.assertTrue(hp.getPageElement(hp.productImage).isDisplayed());
    	Assert.assertTrue(hp.getPageElement(hp.productName).isDisplayed());
    	Assert.assertTrue(hp.getPageElement(hp.productPrice).isDisplayed());
    	Assert.assertTrue(hp.getPageElement(hp.productQuantity).isDisplayed());
    	Assert.assertTrue(hp.getPageElement(hp.productAddButton).isDisplayed());
    }

    @When("^Navigate to cart page after adding one product$")
    public void navigate_to_cart_page_after_adding_one_product() throws Throwable {
    	hp = new HomePage(driver);
    	//add one product
    	if(hp.getPageElement(hp.productAddButton).isDisplayed()) {
    		hp.getPageElement(hp.productAddButton).click();
    		hp.getPageElement(hp.addCartIcon).click();
    	}
    	//read all information after adding one product
    	selectedProductName = hp.getPageElement(hp.selectedProductNameHP).getText();
    	selectedProductQuantity = hp.getPageElement(hp.selectedProductQuantityHP).getText().split("")[0];
    	selectedProductPrice = hp.getPageElement(hp.selectedProductPriceHP).getText();
    	//navigate to cart page
    	Assert.assertTrue(hp.getPageElement(hp.proccedToCheckoutButton).getAttribute("class").equalsIgnoreCase(" "));
    	hp.getPageElement(hp.proccedToCheckoutButton).click();
    }

    @Then("^Cart page is populated with all of its elements$")
    public void cart_page_is_populated_with_all_of_its_elements() throws Throwable {
    	cp = new CartPage(driver);
    	Assert.assertTrue(cp.getPageElement(cp.selectedProductSection).isDisplayed());
    	Assert.assertTrue(cp.getPageElement(cp.promoCodeApplyButton).isDisplayed());
    }

    @And("^Selected product information should be the same as home page$")
    public void selected_product_information_should_be_the_same_as_home_page() throws Throwable {
    	Assert.assertTrue(cp.getPageElement(cp.selectedProductNameCP).getText().contains(selectedProductName));
    	Assert.assertTrue(cp.getPageElement(cp.selectedProductQuantityCP).getText().equalsIgnoreCase(selectedProductQuantity));
    	Assert.assertTrue(cp.getPageElement(cp.selectedProductPriceCP).getText().equalsIgnoreCase(selectedProductPrice));
    }

}
