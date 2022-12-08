package com.parallelExecution.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parallelExecution.base.BaseClass;

public class SearchHotelPage extends BaseClass{
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "from")
	WebElement where;
	
	public void enterLocation(String location) {
		where.sendKeys(location);
	}

}
