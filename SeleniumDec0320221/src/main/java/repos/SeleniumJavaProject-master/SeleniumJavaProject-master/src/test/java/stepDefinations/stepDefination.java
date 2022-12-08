package stepDefinations;

import java.io.IOException;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageobject.homepage;
import pageobject.productDetailpage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefination extends base {

//Homepage
	@Given("Initialize the browser with chrome")
	public void ınitialize_the_browser_with_chrome() throws IOException {
	   
		driver =initializeDriver();
		
	}
	@Given("Navigate to {string} Site")
	public void navigate_to_site(String string) {
	  
		driver.get(string);
		
	}
	@When("user enter product searchbox")
	public void user_enter_product_searchbox() {
		homepage h= new homepage(driver);
		//urun ara
		h.getsearchbar().sendKeys("laptop");
		h.getfindproduct().click();
	}
	@When("user click first product")
	public void user_click_first_product() {
	   
		//ilk laptop a tıkla
		homepage h= new homepage(driver);
		h.getchooseproduct().click();
	}
	@Then("Verify preminum text is checked")
	public void verify_preminum_text_is_checked() {
		homepage h= new homepage(driver);
		Assert.assertTrue(h.getpreminum().isDisplayed());
		System.out.println(h.getpreminum().getText());
	  
	}


	//ProductPage
	@Given("Continue from homepage")
	public void continue_from_homepage() {
	  
productDetailpage p = new productDetailpage(driver);
		
		Set<String> windows = driver.getWindowHandles();

		java.util.Iterator<String> it=windows.iterator();

		String parentId = it.next();

		String childId = it.next();
		driver.switchTo().window(childId);
		
	}
	@When("the selected product is printed")
	public void the_selected_product_is_printed() {
		productDetailpage p = new productDetailpage(driver);
		System.out.println(p.getproductname().getText());
	}
	@When("Seller name is printed")
	public void seller_name_is_printed() {
		
		productDetailpage p = new productDetailpage(driver);
if(p.getsellerpanel().isDisplayed()) {
			
			System.out.println(p.getsellerword().getText() + " " + p.getspecialsellername().getText()); 
		}
	
	}
	@Then("Verify comment button is displayed")
	public void verify_comment_button_is_displayed() {
		
		productDetailpage p = new productDetailpage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scroll(0,2500)");
		p.getcommenttab().click();
		
		
		//yorumlardaki degerlendir butonu kontrolu
		Assert.assertTrue(p.getcommentbutton().isDisplayed());
	
	}
	
}
