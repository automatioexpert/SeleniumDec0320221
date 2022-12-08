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
 * To declare required web elements (page objects) in the Options page
 * To perform required actions on the page
 */
public class OptionsPage extends Testbase {

	//declare reference variables
	WebDriver driver;
	Testutil testutil;
	
	/*************** Declare the page web elements with page factory annotation **************/
	@FindBy(id="btn-continue")
	WebElement continueBtn;
	
	@FindBy(id="btn-accept")
	WebElement acceptBtn;
	
	/*************************** Initialize the web elements **************************/
	public OptionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testutil = new Testutil(driver);
	}
	
	/******************* Actions on the page *******************************/
	//click continue and accept fare conditions to move to the next page
	public PassengersPage clickContinue() {
		testutil.waitElementToView(By.xpath("//div[@id='PH_fdrfTopNotesFirstPart']//span[contains(text(),'Includes taxes')]"), 20);
		testutil.waitElementClick(continueBtn, 10);
		testutil.waitElementClick(acceptBtn, 10);
		return new PassengersPage(driver);
	}
	
	
}
