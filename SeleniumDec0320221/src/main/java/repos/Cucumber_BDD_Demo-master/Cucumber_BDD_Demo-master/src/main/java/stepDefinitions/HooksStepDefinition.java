/**
 * 
 */
package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author anand acharya
 * 
 */
public class HooksStepDefinition {

	@Before
	public void setUP(){
		System.out.println("launch FF");
		System.out.println("Enter URL for Free CRM APP");
	}
	
	@After
	public void tearDown(){
		System.out.println("close the browser");
	}
	
	@Given("^user is on deal page$")
	public void user_is_on_deal_page() {

	}

	@When("^user fills the deals form$")
	public void user_fills_the_deals_form() {

	}

	@Then("^deal is created$")
	public void deal_is_created() {

	}

	@Given("^user is on contact page$")
	public void user_is_on_contact_page() {

	}

	@When("^user fills the contact form$")
	public void user_fills_the_contact_form() {

	}

	@Then("^contact is created$")
	public void contact_is_created() {

	}
}
