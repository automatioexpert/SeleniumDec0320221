package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String loginPageTitle;
	private static String homePageTitle;
	
	@Given("User is on the login page")
	public void User_is_on_the_login_page() {
		System.out.println("User navigated to the login page");
	}
	
	@When("User observe the title of the page")
	public void user_observe_the_title_of_the_page() {
		loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is: " + loginPageTitle);
	}

	@Then("Login page title should display {string}")
	public void login_page_title_should_display(String expectedTitle) {
	    Assert.assertTrue(loginPageTitle.contains(expectedTitle));
	}

	@Then("Login page should display forget password link")
	public void login_page_should_display_forget_password_link() {
		Assert.assertTrue(loginPage.validateForgotPasswordLink());
	}

	@When("User enters {string} as a username")
	public void user_enters_as_a_username(String uname) {
	    loginPage.enterUsername(uname);
	}

	@When("Enter {string} as a password")
	public void enter_as_a_password(String password) {
	    loginPage.enterPassword(password);
	}
	
	@When("Click on login button")
	public void click_on_login_button() {
	  loginPage.clickLoginButton();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
		homePageTitle = loginPage.getHomePageTitle(); 
	}

	@Then("Home page title should be {string}")
	public void home_page_title_should_be(String expectedHPTitle) {
	    Assert.assertTrue(homePageTitle.contains(expectedHPTitle));
	}
}
