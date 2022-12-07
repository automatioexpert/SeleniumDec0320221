package com.cukes.stepdefinitions.ui;

import com.cukes.pages.HomePage;

import io.cucumber.java8.En;

public class HomeSteps implements En {

	public HomeSteps(HomePage homePage) {
		Given("I am on the home page {string} of cars guide website", homePage::openPage);
		When("I move to Cars For Sale menu", homePage.buyAndSell::moveMousePointer);
		Then("I click on {string}", homePage::clickElementWithLinkText);
	}

}
