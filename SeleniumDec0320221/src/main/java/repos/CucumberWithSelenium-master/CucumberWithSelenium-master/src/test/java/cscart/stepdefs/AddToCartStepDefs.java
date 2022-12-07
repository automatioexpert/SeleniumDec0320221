package cscart.stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartStepDefs {

	TestContextCsCart cntxt;
	
	public AddToCartStepDefs(TestContextCsCart cntxt) {
		this.cntxt = cntxt;
	}
	@When("I click on Add to Cart for {string} product")
	public void i_click_on_Add_to_Cart_for_product(String product_id) {
		List<WebElement> coll_button = cntxt.driver.findElements(By.xpath("//button[text()='Add to cart']"));
		coll_button.get(Integer.parseInt(product_id)).click();
	}

	@Then("Product should get added in the my cart section")
	public void product_should_get_added_in_the_my_cart_section() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I click on Add to Cart for {string} product with quanity as {string}")
	public void i_click_on_Add_to_Cart_for_product_with_quanity_as(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Then("Product should get added in the my cart section with default quantity as 1")
	public void product_should_get_added_in_the_my_cart_section_with_default_quantity_as_1() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	

}
