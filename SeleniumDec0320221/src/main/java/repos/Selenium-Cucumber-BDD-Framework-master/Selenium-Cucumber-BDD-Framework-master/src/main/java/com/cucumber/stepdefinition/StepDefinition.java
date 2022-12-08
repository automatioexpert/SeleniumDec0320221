package com.cucumber.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	@Given("^User is on login page$")
	public void user_is_on_login_page() {
		System.out.println("User is on login page");
	}

	@When("^User provides valid username and password$")
	public void user_provides_valid_username_and_password() {
		System.out.println("User provides valid credentials");
	}

	@Then("^User clicks on login button$")
	public void user_clicks_on_login_button() {
		System.out.println("User clicks on login page");
	}

	@Then("^User should navigate to home page$")
	public void user_should_navigate_to_home_page() {
		System.out.println("User navigates to login page");
	}

	@When("^User provides invalid username and password$")
	public void user_provides_invalid_username_and_password() {
		System.out.println("User provides invalid username and password");
	}

	@Then("^User should not navigate to home page$")
	public void user_should_not_navigate_to_home_page() throws Throwable {
		System.out.println("User should not mnavigate to home page");
	}

}
