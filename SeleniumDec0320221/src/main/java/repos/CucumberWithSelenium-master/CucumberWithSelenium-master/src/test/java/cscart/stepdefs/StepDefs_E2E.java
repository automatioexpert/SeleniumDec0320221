package cscart.stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utils.Cmn;

public class StepDefs_E2E {
	
	TestContextCsCart cntxt;
	
	public StepDefs_E2E(TestContextCsCart cntxt) {
		this.cntxt = cntxt;
	}
	

	@Given("I have browser opened with url of cscart")
	public void i_have_browser_opened_with_url_of_cscart() {
		cntxt.driver = Cmn.InvokeBrowser("chrome");
		cntxt.scn.write("Browser Invoked");
		
	}

	@Given("I login in to the application")
	public void i_login_in_to_the_application() {
		Cmn.NavigateToUrl(cntxt.driver, cntxt.URL);
		cntxt.scn.write("URL Navigated to : " + cntxt.URL);
	}

	@When("I search {string} and add product {string} to cart")
	public void i_search_and_add_product_to_cart(String product, String code) {
		cntxt.driver.findElement(By.id("search_input")).sendKeys(product);
		cntxt.driver.findElement(By.xpath("//button[@class='ty-search-magnifier']")).click();
		cntxt.scn.write("Product is searched");
		
		//Click on List View Icon
		cntxt.driver.findElement(By.xpath("(//i[@class='ty-icon-short-list'])[3]")).click();
		
		cntxt.driver.findElement(By.xpath("//button[@class='bp-close']")).click();
		
		
		//Click on Add To Cart
		String xpath_add_cart = "//span[text()='"+code+"']/parent::div/parent::div/following-sibling::div//div[contains(@id,'add_to_cart')]";
		cntxt.driver.findElement(By.xpath(xpath_add_cart)).click();
		
		
		/*
		//Add to cart
		List<WebElement> collection_code = cntxt.driver.findElements(By.xpath("//span[contains(@class,'ty-control-group__item')]"));
		//Find the Code index
		String temp;
		int index=-1;
		for(int i=0;i<collection_code.size();i++) {
			temp = collection_code.get(i).getText()	;
			if (temp.equalsIgnoreCase(code)) {
				index = i;
				break;
			}
		}
		
		if (index==-1) {
			cntxt.scn.write("Code not present in the search result. " + code);
			Assert.assertTrue(false);
		}
		//Fetch the Price
		List<WebElement> collection_price = 
				cntxt.driver.findElements(By.xpath("//span[contains(@id,'sec_discounted_price')]"));
		String value = collection_price.get(index).getText();
		cntxt.hm.put("PRODUCT_PRICE_1", value);
		
		//Fetch all the Add to cart button
		List<WebElement> collection_button = 
				cntxt.driver.findElements(By.xpath("//button[text()='Add to cart']"));

		//Click on the add to cart button
		collection_button.get(index).click();
		*/
	}

	@When("I navigate to View Cart and validate products are added")
	public void i_navigate_to_View_Cart_and_validate_products_are_added() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I navigate to Check out page and validate the ammount")
	public void i_navigate_to_Check_out_page_and_validate_the_ammount() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I enter payment details")
	public void i_enter_payment_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I click on Place Order")
	public void i_click_on_Place_Order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Order has been received page is displayed")
	public void order_has_been_received_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Order details are correctly displayed")
	public void order_details_are_correctly_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

}
