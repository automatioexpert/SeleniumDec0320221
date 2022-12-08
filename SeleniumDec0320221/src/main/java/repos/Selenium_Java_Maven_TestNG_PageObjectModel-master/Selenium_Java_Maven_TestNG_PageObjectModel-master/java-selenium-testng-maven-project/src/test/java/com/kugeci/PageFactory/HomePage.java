package com.kugeci.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

    @FindBy(css=".form-control")
    WebElement search_field;
    
    @FindBy(css="[type='submit']")
    WebElement search_button;
    
    public HomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    //Set search terms in search_field
    public void setSearchTerm(String serachTerm){
    	search_field.sendKeys(serachTerm);     
    }
    
    //Click on search button
    public void clickSearch(){
            search_button.click();
    } 
    
    /**

     * This POM method will be exposed in test case to do a search in the application

     * @param strSearchTerm

     * @return

     */

    public void SearchAtHomePage(String strSearchTerm){

        //Fill search term
        this.setSearchTerm(strSearchTerm);

        //Click search button
        this.clickSearch();       
    }
}
