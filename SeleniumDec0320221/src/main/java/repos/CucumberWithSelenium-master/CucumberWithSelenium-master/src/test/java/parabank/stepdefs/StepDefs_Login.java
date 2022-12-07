package parabank.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import parabank.TestContext;
import parabank.po.PO_Login;

public class StepDefs_Login {

	TestContext cntxt;
	
	public StepDefs_Login(TestContext cntxt) {
		this.cntxt = cntxt;
	}
	
	@Given("Login in to Parabank url as {string} username as {string} passowrd as {string}")
	public void login_in_to_parabank(String url, String u, String p) {
		browser_is_invoked();
		navigate_to_URL(url);
		i_enter_username_as(u);
		i_enter_password_as(p);
		i_click_on_submit_button();
	}


	@Given("Browser is  invoked")
	public void browser_is_invoked() {
		cntxt.driver = new ChromeDriver();
		cntxt.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cntxt.driver.manage().window().maximize();
		cntxt.oPO_Login = PageFactory.initElements(cntxt.driver, PO_Login.class);
		
		cntxt.scn.write("Browser Invoked and maximized");
	}

	@Given("navigate to URL {string}")
	public void navigate_to_URL(String arg) {
		cntxt.driver.get(arg);
		cntxt.scn.write("Browser navigated to url: " + arg);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String arg) {
		cntxt.oPO_Login.EnterUserName(arg);
		cntxt.scn.write("Username text field set as : " + arg);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String arg) {
		cntxt.oPO_Login.EnterPassword(arg);
		cntxt.scn.write("password text field set as : " + arg);
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		cntxt.oPO_Login.ClickSubmitButton();
		cntxt.scn.write("Submit button clicked");
		cntxt.hm.get("NEW_ACCOUNT_NUMBER");
	}
}
