package stepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import resources.Base;

public class stepDefinationForSearchingFunctionality extends Base{
	HomePage hp;

    @Given("^User is on home page$")
    public void user_is_on_home_page() throws Throwable {
    	this.invokeBrowser();
		 driver.get(getWebsiteName());
		 hp = new HomePage(driver);
    }

    @When("^User search with valid (.+)$")
    public void user_search_with_valid(String productname) throws Throwable {
    	Assert.assertTrue(hp.getPageElement(hp.searchBox).isDisplayed());
	 	hp.getPageElement(hp.searchBox).sendKeys(productname);
	 	//sometimes it takes time to load specific products 
	 	//thats the reason of waiting for 3 sec
	 	Thread.sleep(3000);
    }

    @When("^User search with invalid (.+)$")
    public void user_search_with_invalid(String productname) throws Throwable {
    	Assert.assertTrue(hp.getPageElement(hp.searchBox).isDisplayed());
	 	hp.getPageElement(hp.searchBox).sendKeys(productname);
	}
    
    @When("^User search with specific \"([^\"]*)\" letters for multiple product$")
    public void user_search_with_specific_something_letters_for_multiple_product(String searchingLetters) throws Throwable {
    	Assert.assertTrue(hp.getPageElement(hp.searchBox).isDisplayed());
	 	hp.getPageElement(hp.searchBox).sendKeys(searchingLetters);
	 	//sometimes it takes time to load all the products which contains "ot" letters
	 	//thats the reason of waiting for 3 sec
	 	Thread.sleep(3000);
    }

    @Then("^Search page is populated with exact (.+)$")
    public void search_page_is_populated_with_exact(String productname) throws Throwable {
	 	Assert.assertTrue(hp.getPageElement(hp.productName).getText().contains(productname));
    }


    @Then("^Search page is populated with \"([^\"]*)\" message$")
    public void search_page_is_populated_with_something_message(String message) throws Throwable {
	 	Assert.assertTrue(hp.getPageElement(hp.noResultMessage).getText().contains(message));
    }

    @Then("^Search page is populated with multiple products which contains \"([^\"]*)\" letters$")
    public void search_page_is_populated_with_multiple_products_which_contains_something_letters(String letters) throws Throwable {
   		List<WebElement> products = hp.getMultiplePageElement(hp.productName);
    	for(WebElement name : products) {
    		Assert.assertTrue(name.getText().contains(letters));
    	}
    }

}
