package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class OrangeHRMSteps {
	WebDriver driver;

	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HASSEN\\workspace\\cucumber\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@When("I open orage HRM home page")
	public void i_open_orage_hrm_home_page() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");	    
	}

	@Then("I verify that the logo present on the page")
	public void i_verify_that_the_logo_present_on_the_page() {
		boolean status=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertEquals(true, status);			   
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();	    
	}
}
