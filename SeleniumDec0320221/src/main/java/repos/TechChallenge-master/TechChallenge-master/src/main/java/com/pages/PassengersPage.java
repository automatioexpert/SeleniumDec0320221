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
 * *********************************** PURPOSE **************************************
 * To declare required web elements (page objects) in the Passengers page
 * To perform required actions on the page
 */
public class PassengersPage extends Testbase {

	//declare reference variables
	WebDriver driver;
	Testutil testutil;
	
	/*************** Declare the page web elements with page factory annotation **************/
	@FindBy(xpath="//button//span[text()='Add']")
	WebElement addBagsLink;
	
	@FindBy(xpath="//button//span[text()='Edit']")
	WebElement editBagsLink;
	
	@FindBy(xpath="//button[@aria-label='Add additional bag']")
	WebElement addAdditionalBag;
	
	@FindBy(id="bags-btn-continue")
	WebElement continueBtn;
	
	@FindBy(xpath="//div[@id='bagsTermsAndConditionsModal']//button//span[text()='Accept']")
	WebElement acceptBtn;
	
	@FindBy(xpath="//cart-bags-subtotal//span[contains(@class,'amount')]")
	WebElement subTotalBags;
	
	@FindBy(xpath="//*[@id='add-bag-seat-total-priceADT1']//span[@class='amount total-amount']")
	WebElement bagsSeatValue;
	
	@FindBy(id="btn-back")
	WebElement back;
	
	/*************************** Initialize the web elements **************************/
	public PassengersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testutil = new Testutil(driver);
	}
	
	/******************* Actions on the page *******************************/
	//click the Additional bags Add link in checked baggage and seats section
	public void clickAddBags() {
		testutil.waitElementToView(By.xpath("//*[text()='Passenger details']"), 20);
		testutil.clickElementByJS(addBagsLink);
	}
	
	//click the Additional bags Edit link in checked baggage and seats section
	public void clickEditBags() {
		testutil.waitElementToView(By.xpath("//*[text()='Passenger details']"), 20);
		testutil.clickElementByJS(editBagsLink);
	}
	
	//click the required number of bags in Add additonal baggage popup
	public void addAdditionalBags(String bagCount) {
		testutil.waitElementToView(By.xpath("//div[@id='add-bags-modal']//h1[text()='Add Additional Baggage']"), 10);
		double d = Double.parseDouble(bagCount);
		for(int i=1; i<(int)d ; i++) {
			testutil.waitElementClick(addAdditionalBag, 5);
		}
		testutil.waitElementClick(continueBtn, 5);
		testutil.waitElementClick(acceptBtn, 5);
		testutil.waitElementToView(By.xpath("//*[text()='Passenger details']"), 10);
	}
	
	//get the bags sub total amount value
	public String getBagsSubTotalValue() {
		String bagsSubTotalValue = subTotalBags.getAttribute("innerText");
		bagsSubTotalValue = bagsSubTotalValue.replaceAll("[^0-9.]","");
		System.out.println("Bags Sub total value is "+bagsSubTotalValue);
		return bagsSubTotalValue;
	}
	
	//get the baggage amount value from baggage and seats section
	public String getBaggageSeatsValue() {
		String bagsSeatAmount = bagsSeatValue.getAttribute("innerText");
		bagsSeatAmount = bagsSeatAmount.replaceAll("[^0-9.]","");
		System.out.println("Baggage and Seat amount is "+bagsSeatAmount);
		return bagsSeatAmount;
	}

	//click Back link to navigate to the previous page
	public OptionsPage clickBack() {
		back.click();
		return new OptionsPage(driver);
	}
}
