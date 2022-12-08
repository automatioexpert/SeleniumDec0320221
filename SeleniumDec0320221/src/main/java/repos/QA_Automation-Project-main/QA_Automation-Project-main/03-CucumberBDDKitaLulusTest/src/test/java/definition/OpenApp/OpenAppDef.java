package definition.OpenApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenAppDef {
	WebDriver driver;
	String baseURL;

	@Given("User on the Browser")
	public void user_on_the_Browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	@When("User type url {string}")
	public void user_type_url(String string) {
		this.baseURL = string;
	}

	@When("User send the url to the browser")
	public void user_send_the_url_to_the_browser() {
		driver.get(this.baseURL);
	}

	@Then("User get title validate {string}")
	public void user_get_title_validate(String string) {
		System.out.println(this.driver.getTitle());
		Assert.assertEquals(this.driver.getTitle(), string);
		driver.close();
	}

}
