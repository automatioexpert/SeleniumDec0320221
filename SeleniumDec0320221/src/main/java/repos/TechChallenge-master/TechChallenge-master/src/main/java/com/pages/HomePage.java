/**
 * 
 */
package com.pages;

import java.util.Calendar;
import java.util.List;

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
 * To declare required web elements (page objects) in the landing page of the website
 * To perform required actions on the page
 */
public class HomePage extends Testbase {

	//declare reference variables
	WebDriver driver;
	Testutil testutil;
	
	/*************** Declare the page web elements with page factory annotation **************/
	@FindBy(id="panel-flights")
	WebElement panelFlights;
	
	@FindBy(xpath="//*[@id='flight-form']//div[@class='only-show-for-tablet-desktop']//span[text()='One way']")
	WebElement Oneway;
	
	@FindBy(xpath="//div[contains(@aria-label,'Clear Button')]")
	WebElement clearBtn;
	
	@FindBy(id="typeahead-input-from")
	WebElement fromCity;
	
	@FindBy(xpath="//ul[@id='typeahead-list-item-from-list']//li[@id='typeahead-list-item-from-0']")
	WebElement fromCityFirstChoice;
	
	@FindBy(xpath="//ul[@id='typeahead-list-item-to-list']//li[@id='typeahead-list-item-to-0']")
	WebElement toCityFirstChoice;
	
	@FindBy(id="typeahead-input-to")
	WebElement toCity;
	
	@FindBy(id="datepicker-input-departureDate")
	WebElement departureDate;
	
	@FindBy(xpath="//button[text()='SEARCH FLIGHTS']")
	WebElement searchFlights;
	
	/***************** Initialize the web elements **************************/
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testutil = new Testutil(driver);
	}
	
	/******************* Actions on the page *******************************/
	//select one way flight
	public void selectOneWayFlight() {
		panelFlights.click();
		//testutil.waitElementClick(Oneway, 5);
		testutil.clickElementByJS(Oneway); //use click by Javascript if .click throws element click intercepted error
	}
	
	//enter origin and destination domestic city for data driven framework ie using data from excel file
	public void enterFromToCityXcelData(String originCity, String destnCity) {
		testutil.clickElementByJS(clearBtn);
		testutil.waitElementText(fromCity, 5, originCity);
		testutil.waitElementClick(fromCityFirstChoice, 5);
		testutil.waitElementText(toCity, 5, destnCity);
		testutil.waitElementClick(toCityFirstChoice, 5);
	}
	
	//enter origin and destination domestic city for using data from config properties file
	public void enterFromToCityPropData() {
		testutil.clickElementByJS(clearBtn);
		testutil.waitElementText(fromCity, 5, prop.getProperty("origin"));
		testutil.waitElementClick(fromCityFirstChoice, 5);
		testutil.waitElementText(toCity, 5, prop.getProperty("destination"));
		testutil.waitElementClick(toCityFirstChoice, 5);
	}
	
	//select 15 days future departure date on the calendar
	public void selectDepartureDate() {
		departureDate.click();
		WebElement futureDate = getFutureDate();
		futureDate.click();
	}
	
	//find current date and add 15 days on it and return the future date
	public WebElement getFutureDate() {
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='date-picker__calendar-container']//td//span")); //list of all date elements in the displayed calendar webtable
		int totaldays = dates.size();
		int counter = 0;
		for(int i=0; i<totaldays; i++) { //get text of each web element in the list
			WebElement ele = dates.get(i);
			String s = ele.getText();
			if (s.equalsIgnoreCase(String.valueOf((Calendar.getInstance()).get(Calendar.DAY_OF_MONTH)))) { //find current date
				//dates.get(i).click(); //to select current date
				break;
			}
			counter = counter+1;
		}
		return dates.get(counter+15); //return 15 days future date
	}
	
	//click flight search button and navigate to next page
	public FlightsPage searchFlights() {
		searchFlights.click();
		return new FlightsPage(driver);
	}
}

