package com.LW.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Popup_SignIN {
	
	@FindBy(xpath= "//a[@title=\"Business\"]")
	private WebElement Business;

	@FindBy(xpath= "//a[@title=\"Letter of Consent to Register a Company with similar name\"]")
	private WebElement Document;



	public Popup_SignIN(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public void IndividualLogin() throws InterruptedException {
		
		
		Thread.sleep(4000);
		
	}
	


}
