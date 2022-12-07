package com.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	public WebDriver driver;

	@Given("User open Chrome Browser")
	public void user_open_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("User Navigates to Google webapp")
	public void user_navigates_to_google_webapp() {
		driver.navigate().to("https://www.google.com/");
	}

	@When("user searches for a {string}")
	public void user_searches_for_a(String LambTest) {
		try {
			WebElement serachbox = driver.findElement(By.xpath("//input[@type='text']"));
			serachbox.clear();
			serachbox.sendKeys(LambTest);
		} catch (Exception e) {
			System.out.println("Google serach text box not fount: " + e.getMessage());
		}
		WebElement lambatest = driver.findElement(By.xpath("//span[contains(text(),'LambdaTest')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lambatest);
		lambatest.click();
	}

	@When("click on serach button")
	public void click_on_serach_button() {
		WebElement searchbtn = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='gNO89b']"));

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(searchbtn));

		searchbtn.click();
	}

	@Then("the page should start with {string}")
	public void the_page_should_start_with(final String titleStartsWith) {
		// Google's search is rendered dynamically with JavaScript
		// Wait for the page to load timeout after ten seconds
		new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(titleStartsWith);
			}
		});
	}

}
