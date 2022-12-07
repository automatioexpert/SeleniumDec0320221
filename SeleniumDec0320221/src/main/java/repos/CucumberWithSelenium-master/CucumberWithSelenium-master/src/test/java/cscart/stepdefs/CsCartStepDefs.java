package cscart.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cscart.po.PO_Search;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Cmn;

public class CsCartStepDefs {

	TestContextCsCart cntxt;
	
	public CsCartStepDefs(TestContextCsCart cntxt) {
		this.cntxt = cntxt;
	}
	
	@Before
	public void BeforeMethod(Scenario scn) {
		cntxt.scn = scn;
	}
	
	@Given("I open {string} Browser and browser is navigated to {string}")
	public void i_open_Browser_and_browser_is_navigated_to(String browser, String url) {
		i_open_browser(browser);
		i_navigate_to_url_as(url);
	}
	
	
	@Given("I open {string} browser")
	public void i_open_browser(String browser) {
		cntxt.driver = Cmn.InvokeBrowser(browser);
		cntxt.scn.write("Browser Invoked");
	}

	@Given("I navigate to url as {string}")
	public void i_navigate_to_url_as(String url) {
		Cmn.NavigateToUrl(cntxt.driver, url);
		cntxt.scn.write("URL Navigated to : " + url);
	}

	@When("I enter text in search text box as {string}")
	public void i_enter_text_in_search_text_box_as(String text) {
		cntxt.PO_Search = PageFactory.initElements(cntxt.driver, PO_Search.class);
		cntxt.PO_Search.EnterTextInSearchBox(text);
		cntxt.scn.write("Search box text entered as :" + text);
	}

	@When("I click on Search button")
	public void i_click_on_Search_button() {
		cntxt.PO_Search.ClickonSearchButton();
		cntxt.scn.write("Clicked on Search Button");
	}

	@Then("Search results are displayed")
	public void search_results_are_displayed() {
		cntxt.PO_Search.ValidateSearchResultIsDisplayed();
		cntxt.scn.write("Search Results are displayed successfully");
	}



}
