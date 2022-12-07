/**
 * 
 */
package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

/**
 * @author anand acharya
 * for data table with maps we use asMaps method
 * comment the code in other step definitions file before running code in this file
 */

//data table with maps: for parameterization of test cases

public class DealWithMapStepDefinition {
	
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
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) {
		//use asMaps method
		for (Map<String,String> data : credentials.asMaps(String.class, String.class)){
		driver.findElement(By.name("username")).sendKeys(data.get("username"));
		driver.findElement(By.name("password")).sendKeys(data.get("password"));
		}
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
	
	@Then("^user moves to new deals page$")
	public void user_moves_to_new_deals_page() {
	  driver.switchTo().frame("mainpanel");
	  Actions action = new Actions(driver);
	  action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
	  driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
	}
	
	@Then("^user enters deal details and saves it$")
	public void user_enters_deal_details_and_saves_it(DataTable dealData) {
		//use asMaps method
		for(Map<String,String> dealValues : dealData.asMaps(String.class, String.class)){
		driver.findElement(By.id("title")).sendKeys(dealValues.get("title"));
		driver.findElement(By.id("amount")).sendKeys(dealValues.get("amount"));
		driver.findElement(By.id("probability")).sendKeys(dealValues.get("probability"));
		driver.findElement(By.id("commission")).sendKeys(dealValues.get("commission"));
		//save button click		
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save and Create Another']//preceding-sibling::input[@value='Save']")).click();
		//move to new deal page
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
		}
	}
	
	@Then("^close the browser$")
	public void close_the_browser(){
		driver.quit();
	}
	
}
