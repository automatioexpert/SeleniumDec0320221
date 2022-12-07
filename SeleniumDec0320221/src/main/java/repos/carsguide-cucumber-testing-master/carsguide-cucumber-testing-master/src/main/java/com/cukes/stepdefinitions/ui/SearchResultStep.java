package com.cukes.stepdefinitions.ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.cukes.pages.SearchResultPage;

import io.cucumber.java8.En;

public class SearchResultStep implements En {

	public SearchResultStep(SearchResultPage searchResultPage) {
		Then("I should see the list of searched cars", () -> assertTrue(searchResultPage.carList.isVisible(), "List of cars not present"));
		And("The page title should be {string}", (String data) -> assertEquals(searchResultPage.getPageTitle(), data, "Incorrect page title"));
	}

}
