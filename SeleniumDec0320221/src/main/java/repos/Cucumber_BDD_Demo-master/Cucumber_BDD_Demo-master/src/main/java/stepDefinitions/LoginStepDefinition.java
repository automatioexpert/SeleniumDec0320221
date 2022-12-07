/**
 * 
 */
package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

/**
 * @author anand acharya
 * we will write our code (Selenium + Java + Annotations)
 * contains step definitions for Login.Feature and Contacts.Feature
 */
public class LoginStepDefinition {

	WebDriver driver;
	
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com");
	}
	
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() {
	   String title = driver.getTitle();
	   System.out.println(title);
	   Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	}
	
	//Regular Expression:
	//1. \"([^\"]*)\"
	//2. \"(.*)\"
	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@Then("^user clicks the login button$")
	public void user_clicks_the_login_button() {
	    //driver.findElement(By.xpath("//input[@type='submit']")).click();
	    //other option is to use javascript executor
	  	WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	  	JavascriptExecutor js = (JavascriptExecutor)driver;
	  	js.executeScript("arguments[0].click()", loginBtn);
	}
	
	@Then("^the user is on home page$")
	public void the_user_is_on_home_page() {
		String title = driver.getTitle();
		System.out.println("homepage title is: "+title);
		Assert.assertEquals("CRMPRO", title);
	}
	
	@Then("^user clicks New contact link$")
	public void user_clicks_New_contact_link() throws InterruptedException {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}

	@Then("^user enters contacts details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_contacts_details_and_and(String firstname, String lastname, String position) {
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("surname")).sendKeys(lastname);
		driver.findElement(By.id("company_position")).sendKeys(position);
	}

	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button() {
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save and Create Another (same company)']//preceding-sibling::input[@value='Save']")).click();
	}
	
	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}


	
//code for without data driven approach
/*	@Given("^user is already on home page$")
	public void user_is_already_on_home_page() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("ananda");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    String title = driver.getTitle();
		System.out.println("homepage title is: "+title);
		Assert.assertEquals("CRMPRO", title);
	}

	@When("^user mouse over contacts link$")
	public void user_mouse_over_contacts_link() throws InterruptedException {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		Thread.sleep(2000);
	}

	@Then("^user clicks New contact link$")
	public void user_clicks_New_contact_link() {
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}

	@Then("^user enters firstname and lastname$")
	public void user_enters_firstname_and_lastname() {
		driver.findElement(By.name("first_name")).sendKeys("cucumber");
		driver.findElement(By.name("surname")).sendKeys("bdd");
	}

	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button() {
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save and Create Another (same company)']//preceding-sibling::input[@value='Save']")).click();
	}

	@Then("^verify new contact created$")
	public void verify_new_contact_created() {
		String contacts = driver.findElement(By.xpath("//td[contains(text(), 'cucumber bdd')]")).getText();
		System.out.println("contacts text is: "+contacts);
		Assert.assertEquals("cucumber bdd", contacts);
	}*/
}
