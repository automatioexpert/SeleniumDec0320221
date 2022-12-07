package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	@Given("User Lanuch Chrome Browser")
	public void user_lanuch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
	}

	@When("User Open URL {string}")
	public void user_open_url(String url) {
		driver.navigate().to(url);
	}

	@When("User Enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		loginPage.setUserName(email);
		loginPage.setPassword(password);
	}

	@When("Click on Login button")
	public void click_on_login_button() throws InterruptedException {
		loginPage.clickLoginButton();
		Thread.sleep(3000);
	}

	@Then("Login Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("User Click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		loginPage.clickLogoutLink();
		Thread.sleep(3000);

	}

	@Then("Home Page Title should be {string}")
	public void home_page_title_should_be(String hometitle) {
		if (driver.getPageSource().contains("Your store. Login")) {
			Assert.assertEquals(hometitle, driver.getTitle());
		}
	}

	@Then("Close Browser")
	public void close_browser() {
		driver.quit();
	}

	// -------- Add Customer features step definitions --------
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickCustomerMenu();
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.ClickCustomerMenuItem();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(3000);
		addCust.ClickAddNew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomString() + "@gmail.com";

		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setFirstName("Hassen");
		addCust.setLastName("Hannachi");
		addCust.setGender("Male");
		addCust.setDateOfBirth("07/05/1985"); // format mm/dd/yyyy
		addCust.setCompanyName("busyQA");
		addCust.setTaxExempt();
		addCust.setNewsletter(email);
		// Regiseterd -default
		// customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add customer to 'Guests' or 'Registered' customer roles
		addCust.setCustomerRoles("Guests");
		addCust.setVendor("Vendor 2");
		addCust.setActiveButton();
		addCust.setAdminComment("This is for testing ...........");
	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickSaveButton();
		Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}
	
	// -------- Search Customer by Email ID features step definitions --------
	@When("Enter customer email")
	public void enter_customer_email() {
		serachCust=new SearchCustomerPage(driver);
		serachCust.setEmail("victoria_victoria@nopCommerce.com");	    
	}
	
	@When("Click on serach button")
	public void click_on_serach_button() throws InterruptedException {
		serachCust.clickSearchButton();
		Thread.sleep(3000);	  
	}
	
	@Then("User should found email in the serach table")
	public void user_should_found_email_in_the_serach_table() {
		boolean status=serachCust.serachCustomerByEmail("victoria_victoria@nopCommerce.com");	
		Assert.assertEquals(true, status);
	}
	
	// -------- Search Customer by First Name & Last Name features step definitions --------
	@When("Enter customer First name")
	public void enter_customer_first_name() {
		serachCust=new SearchCustomerPage(driver);
		serachCust.setFirstName("V");	    
	}

	@When("Enter customer Last name")
	public void enter_customer_last_name() {
		serachCust.setLastName("");	    
	}

	@Then("User should found Name in the serach table")
	public void user_should_found_name_in_the_serach_table() {
		boolean status=serachCust.serachCustomerByName("victoria Treces");	
		Assert.assertEquals(true, status);	    
	}
}
