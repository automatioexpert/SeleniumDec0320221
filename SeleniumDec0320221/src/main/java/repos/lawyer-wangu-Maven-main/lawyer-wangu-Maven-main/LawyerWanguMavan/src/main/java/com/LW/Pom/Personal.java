package com.LW.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Personal {

	@FindBy(xpath= "(//a[contains(@href,'https://phpstack-309053-945841.cloudwaysapps.com/document/personal/')])[1]")
	private WebElement Personal;

	@FindBy(xpath= "(//a[.=\"View all +\"])[1]\n")
	private WebElement Affidavit;

	@FindBy(xpath= "(//a[.=\"Create Document +\"])[1]")
	private WebElement Companys_Doc;

	@FindBy(name= "discard-page")
	private WebElement DiscardPage;

	public Personal(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void PersonalTab() throws InterruptedException {
		Personal.click();
		
		Thread.sleep(4000);
		
	}
	
	
	public void Affidavit() throws InterruptedException {

		Affidavit.click();
		Thread.sleep(4000);
		
	}
	
	public void Companys_Doc(){
		Companys_Doc.click();

	}

	public void DiscardPage() {
		DiscardPage.click();

	}

}
