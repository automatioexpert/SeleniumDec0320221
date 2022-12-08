package com.parallelExecution.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parallelExecution.base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "cleartripLogo")
	WebElement logo;

	@FindBy(xpath = "//ul[contains(@class,'navGroup')]//li[@class='flightApp']")
	WebElement flightOption;

	@FindBy(xpath = "//nav[@class='hasProductIcons']//li[starts-with(@class, 'hotelApp')]")
	WebElement hotelOption;

	@FindBy(className = "trainsApp")
	@CacheLookup
	WebElement TrainOption;

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public SearchFlightsPage selectFlightOption() {
		if (flightOption.isEnabled()) {
			flightOption.click();
		}
		return new SearchFlightsPage();
	}

	public SearchHotelPage selecthotelOption() {
		hotelOption.click();
		return new SearchHotelPage();
	}

}
