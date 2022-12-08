package definitionLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;
	String baseURL = "https://sqa.peluangkerjaku.com/tele/";

	@Given("User on the login page")
	public void user_on_the_login_page() {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get(baseURL);
	}

	@When("User fill the username {string}")
	public void user_fill_the_username(String string) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
		} catch (Exception e) {
		}
	}

	@When("User fill the password {string}")
	public void user_fill_the_password(String string) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string);
		} catch (Exception e) {
		}
	}

	@When("User click the login button")
	public void user_click_the_login_button() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
		} catch (Exception e) {
		}
	}

	@Then("User get login validate {string}")
	public void user_get_login_validate(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
		} catch (Exception e) {

		}
		driver.close();
	}

	@Then("User get alert or notification {string}")
	public void user_get_alert_notification(String string) {
		try {
			Thread.sleep(1000);
			WebElement invalidText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Invalid validation => " + invalidText.getText());
			Assert.assertEquals(invalidText.getText(), string);
		} catch (Exception e) {

		}
		driver.close();
	}

}
