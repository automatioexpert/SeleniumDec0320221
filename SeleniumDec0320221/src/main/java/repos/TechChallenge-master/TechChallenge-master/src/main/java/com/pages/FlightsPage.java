/**
 * 
 */
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;
import com.util.Testutil;

/**
 * @author anand acharya
 * *********************************** PURPOSE ************************************
 * To declare required web elements (page objects) in the Flights page
 * To perform required actions on the page
 */
public class FlightsPage extends Testbase {

	//declare reference variables
	WebDriver driver;
	Testutil testutil;
	
	/*********************** Declare the page web elements with page factory annotation ***********************/
	@FindBy(xpath="//cart-flights-subtotal//span[contains(@class,'amount')]")
	WebElement subTotalFlights;
	
	@FindBy(xpath="//button[contains(text(),'Red e-Deal')]")
	WebElement redeDealLink;
	
	@FindBy(xpath="//div[@id='e2e-itinerary-0']//upsell-fare-cell[1]//span[contains(@class,'amount cash')]")
	WebElement redeDealFlight;
	
	@FindBy(xpath="//button[@name='add-to-cart']//span")
	WebElement addToTrip;
	
	@FindBy(xpath = "//div[@id='tripRecapPanel']//div[contains(@class,'amount-per-bound e2e-cash-amount')]")
	WebElement tripValue;
	
	@FindBy(id="btn-continue")
	WebElement continueBtn;
	
	@FindBy(id="btn-accept")
	WebElement acceptBtn;
	
	/*************************** Initialize the web elements **************************/
	public FlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testutil = new Testutil(driver);
	}
	
	/******************* Actions on the page *******************************/
	//get the flight sub total amount value
	public String getFlightsSubTotalValue() {
		String flightsSubTotalValue = subTotalFlights.getAttribute("innerText");
		flightsSubTotalValue = flightsSubTotalValue.replaceAll("[^0-9.]","");
		System.out.println("Flight Sub total value is "+flightsSubTotalValue);
		return flightsSubTotalValue;
	}
	
	//click a Red e-deal fight and click the add to trip button
	public void addRedeDealFlightToTrip() {
		testutil.waitElementToView(By.xpath("//button[contains(text(),'Red e-Deal')]"), 20);
		testutil.clickElementByJS(redeDealFlight);
		testutil.clickElementByJS(addToTrip);
	}
	
	//get the total trip amount value
	public String getTripValue() {
		testutil.waitElementToView(By.xpath("//*[text()='Your trip']"), 10);
		String tripAmount = tripValue.getAttribute("innerText");
		tripAmount = tripAmount.replaceAll("[^0-9.]","");
		return tripAmount;
	}
	
	//click continue to navigate to next page
	public OptionsPage clickContinue() {
		testutil.waitElementClick(continueBtn, 10);
		return new OptionsPage(driver);
	}
	
}
