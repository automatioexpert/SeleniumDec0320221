package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.pages.WomenTabPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WomenTabSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountsPage;
	private WomenTabPage womenTabPage = new WomenTabPage(DriverFactory.getDriver());
	private String actualTitle;

	@Given("User is on My Account Page")
	public void user_is_on_my_account_page(DataTable dataTable) {
		List<Map<String, String>> cred = dataTable.asMaps();
		String userName = cred.get(0).get("username");
		String password = cred.get(0).get("password");
		accountsPage = loginPage.doLogin(userName, password);
	}

	@When("User navigates to Women tab")
	public void user_navigates_to_Women_tab() {
		accountsPage.navigateToWomenTab();
	}

	@Then("Women tab title should be {string}")
	public void women_tab_title_should_be(String expectedTitle) {
		Assert.assertTrue(womenTabPage.getWomenTabPageTitle().contains(expectedTitle));
	}

	@When("User validate the subcategories")
	public void user_validate_the_subcategories() {
		System.out.println("User is validating the subcategories");
		System.out.println(womenTabPage.getSubCatList());
	}

	@Then("Following subcategories should display")
	public void following_subcategories_should_display(DataTable expectedSubcat) {
		List<String> expectedSubcategories = expectedSubcat.asList();
		System.out.println("Expected subcategories list is "+expectedSubcategories);
		Assert.assertTrue(womenTabPage.getSubCatList().containsAll(expectedSubcategories));
	}

	@Then("count should be {int}")
	public void count_should_be(Integer expectedCount) {
		Assert.assertTrue(womenTabPage.getsubCatCount() == expectedCount);
	}
}
