package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class EditCustomerPage extends BaseClass {
	WebDriver ldriver;

	public EditCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Edit Customer')]")
	@CacheLookup
	WebElement lnkEditCustomer;

	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement txtCustomerID;

	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement btnSubmit;

	public void clickEditCustomer() {
		lnkEditCustomer.click();
	}

	public void custID(String cid) {
		txtCustomerID.sendKeys(cid);
	}

	public void custSubmit() {
		btnSubmit.click();
	}
}
