package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountsPage;

	@Given("A user is on the login page")
	public void A_user_is_on_the_login_page() {
		/* DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account"); */
	}

	@Given("Enters credential and click on the login button")
	public void Enters_credential_and_click_on_the_login_button(DataTable dataTable) {
		List<Map<String, String>> cred = dataTable.asMaps();
		String userName = cred.get(0).get("username");
		String password = cred.get(0).get("password");
		accountsPage = loginPage.doLogin(userName, password);
	}

	@Then("{string} should be Account page title")
	public void should_be_account_page_title(String expectedTitle) {
		Assert.assertTrue(accountsPage.getAccountPageTitle().contains(expectedTitle));
	}

	@Then("Following section should display")
	public void following_section_should_display(DataTable dataTable) {
		List<List<String>> expectedSectionsList = dataTable.asLists(String.class);
		System.out.println("Expected list of sections is: "+ expectedSectionsList);
		List<String> actualSectionsList = accountsPage.getAcccountSections(); 
		System.out.println("Actual list of section is: "+actualSectionsList);
		Assert.assertTrue(actualSectionsList.containsAll(actualSectionsList));
	}

	@Then("Total count should be {int}")
	public void total_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedSectionCount);
	}

}
