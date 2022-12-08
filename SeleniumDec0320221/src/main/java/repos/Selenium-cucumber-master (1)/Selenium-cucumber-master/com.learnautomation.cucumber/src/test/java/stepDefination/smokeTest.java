package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class smokeTest {

	WebDriver driver;

@Given("^Open firefox and start application$")
public void open_firefox_and_start_application() throws Throwable {
  
	
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com");
}


@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
public void i_enter_valid_and(String uname, String pass) throws Throwable {

	driver.findElement(By.id("email")).sendKeys(uname);
	driver.findElement(By.id("pass")).sendKeys(pass);

}

@Then("^user should be able to login successfully$")
public void user_should_be_able_to_login_successfully() throws Throwable {

	driver.findElement(By.id("loginbutton")).click();
}

@Then("^application should be closed$")
public void application_should_be_closed() throws Throwable {
  
	driver.quit();
}




}
