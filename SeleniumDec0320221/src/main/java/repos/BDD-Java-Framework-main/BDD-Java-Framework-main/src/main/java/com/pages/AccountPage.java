package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;
	
	//1 By Locators - OR
	
	private By accountSections = By.xpath("//div[@id='center_column']//span");
	private By womenTab = By.linkText("Women");
	
	public AccountPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public int getAccountSectionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAcccountSections() {
		List<String> accSectionNames = new ArrayList<String>();
		List<WebElement> accSections = driver.findElements(accountSections);
		for(WebElement ele: accSections) {
			accSectionNames.add(ele.getText());
		}
		return accSectionNames;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public void navigateToWomenTab() {
		driver.findElement(womenTab).click();
	}
}
