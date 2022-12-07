package setpDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AccountPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class Login extends Base {
	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage account;	

	@Given("^Open any Browser$")
	public void open_any_browser() {
		driver = initializeBrowser();				
	}
	
	@And("^Navigate to Login page$")
	public void navigate_to_login_page() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage();
		landingPage.myAccountDropDown().click();		
		landingPage.loginOption().click();
		Thread.sleep(3000);
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password) {
		
		loginPage=new LoginPage();
		loginPage.emailAddressTextField().sendKeys(prop.getProperty("email"));
		loginPage.passwordField().sendKeys(prop.getProperty("password"));
	}
	
	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() {
		loginPage.loginButton().click();
	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		account=new AccountPage();
		Assert.assertTrue(account.editYourAccountInformation().isDisplayed());
		account.editYourAccountInformation().click();	
	}
	
	@After
	public void closeBrowser() {
		driver.close();		
	}
}
