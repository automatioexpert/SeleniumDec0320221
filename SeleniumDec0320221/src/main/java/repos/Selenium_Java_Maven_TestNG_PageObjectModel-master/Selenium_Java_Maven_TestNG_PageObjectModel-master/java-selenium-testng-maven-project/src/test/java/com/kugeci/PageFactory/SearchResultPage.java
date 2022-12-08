package com.kugeci.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;

    @FindBy(css="[class='col-md-8'] h3:nth-child(2)")
    WebElement search_result;
    
    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    //See if search_result is returned
    public boolean searchResultReturned(){
    	return search_result.isDisplayed();     
    }
}
