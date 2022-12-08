package definitionData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DistributeData {
	WebDriver driver;

	@Given("User on the login")
	public void user_on_the_login_page() {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get("https://sqa.peluangkerjaku.com/tele/");

	}

	@When("User login with valid username {string} and password {string}")
	public void user_login_with_valid_username_and_password(String string, String string2) {
		driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
		driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string2);
		driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
	}

	@When("User get login validate {string}")
	public void user_get_login_validate(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
		} catch (Exception e) {

		}
	}

	@When("User click ok to the validate message")
	public void user_click_ok_to_the_validate_message() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();

		} catch (Exception e) {
			System.out.println("1" + e);
		}

	}

	@When("User move to table Data")
	public void user_move_to_table_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
		} catch (Exception e) {
			System.out.println("2" + e);
		}
	}

	@When("User move to table Distribute Data")
	public void user_move_to_table_Distribute_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Distribute Data']")).click();
		} catch (Exception e) {
			System.out.println("3" + e);
		}
	}

	@When("User select the agent {string}")
	public void user_select_the_agent(String string) {
		Boolean state = Boolean.parseBoolean(string);
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement select = driver.findElement(By.xpath("//*[@id=\"ddcl-tl_distribute--52066_select\"]/span"));
				Thread.sleep(1000);
				select.click();
			} catch (Exception e) {
				System.out.println("5" + e);
			}

			// select agent

			try {
				Thread.sleep(1000);
				WebElement agent = driver.findElement(By.xpath("//input[@id='ddcl-tl_distribute--52066_select-i6']"));
				Thread.sleep(1000);
				agent.click();
				Thread.sleep(1000);
				agent.sendKeys(Keys.ENTER);

				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}
		state = true;

	}

	@When("User fill the quantity {string}")
	public void user_fill_the_quantity(String string) {
		try {
			Thread.sleep(1000);
			WebElement jml = driver.findElement(By.xpath("//input[@id='tl_distribute--52070_text']"));
			jml.click();
			jml.sendKeys(string);
		} catch (Exception e) {
			System.out.println("7" + e);
		}
	}

	@When("User select the New status")
	public void user_select_the_New_status() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//select[@id='tl_distribute--52079_text']")).click();
		} catch (Exception e) {
			System.out.println("8" + e);
		}
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//option[@value='NEW']")).click();
		} catch (Exception e) {
			System.out.println("9" + e);
		}
	}

	@When("User push the distribute button")
	public void user_push_the_distribute_button() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Distribusi']")).click();
		} catch (Exception e) {
			System.out.println("10" + e);
		}
	}

	@Then("User get validation message {string}")
	public void user_get_validation_message(String string) {
		try {
			Thread.sleep(1000);
			String msg = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p")).getText();
			Assert.assertEquals(msg, string);
		} catch (Exception e) {
			System.out.println("11" + e);
		}
		driver.close();
	}
}
