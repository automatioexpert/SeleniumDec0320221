package stepdefs;

import java.io.IOException;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import allocator.ReusableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import listeners.ExtentReportListener;

public class FinancialReviewSteps extends ExtentReportListener 
{ 
	String AppURL = prop.getProperty("AppURL");
	ReusableMethods RM = new ReusableMethods();
	ExtentTest logInfo=null;
	
	@Given("I am on Financial Review- Foreign Affairs website")
	public void i_launch_browser() throws IOException, ClassNotFoundException {
		test = extent.createTest(Feature.class, "Verify Subscription popup");                         
		test=test.createNode(Scenario.class, "Verify Subscription popup");                       
		logInfo=test.createNode(new GherkinKeyword("Given"), "Subscription popup verification for an article");
		RM.compareAndreport(driver.getCurrentUrl().toString().trim(),AppURL.toString() , "User is on Financial Review- Foreign Affairs website", logInfo, captureScreenShot(driver));
	}

	@When("I navigate to \"([^\"]*)\" article on this page")
	public void i_navigate_to_Financial_Review_Foreign_Affairs_website(String articleName) throws IOException {
		String ArticleURL=AppURL+"/"+articleName;
		driver.get(ArticleURL);
		RM.compareAndreport(driver.getCurrentUrl().toString().trim(),ArticleURL.toString() , "User is navigated to one of the article on this page", logInfo, captureScreenShot(driver));
	}

	@Then("I verify if the subscription prompt is popped up from the bottom of the page")
	public void i_verify_if_the_subscription_prompt_is_popped_up_from_the_bottom_of_the_page() throws IOException {
		boolean Condition=RM.waitForCondition("Presence", "Subscription_Popup", 10000);
		if(Condition==true){
			logInfo.pass("Subscription prompt is popped up on the page");		}
		else {
			logInfo.fail("Subscription prompt is not popped up on the page");
		}	
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));  
	}

	@Then("I scroll down to the end of the page")
	public void i_scroll_down_to_the_end_of_the_page() throws Exception {
		RM.scrollToView("Scroll_Bottom_Element");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));  
	}

	@Then("I Wait for {int} seconds")
	public void i_Wait_for_seconds(Integer time) throws InterruptedException {
		Thread.sleep(time);
	}

	@Then("I verify if the subscription pop up disappears from the article")
	public void i_verify_if_the_subscription_pop_up_disappears_from_the_article() throws IOException {
		boolean Condition=RM.waitForCondition("NotPresent", "Subscription_Popup", 5000);
		if(Condition==true){
			logInfo.pass("Subscription prompt has disappeared from the page");		}
		else {
			logInfo.fail("Subscription prompt has not disappeared from the page");
		}	
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));  
	}
}