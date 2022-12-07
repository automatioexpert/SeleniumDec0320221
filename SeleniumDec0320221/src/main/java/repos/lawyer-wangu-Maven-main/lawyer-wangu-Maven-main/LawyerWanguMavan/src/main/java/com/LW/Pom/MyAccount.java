package com.LW.Pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

public class MyAccount {

	@FindBy(xpath = "//a[.=\"My Account\"]")
	private WebElement MyAccount;
	@FindBy(xpath = "//a[.=\"Address Book\"]")
	private WebElement AdrressBook;
	@FindBy(xpath = "//a[.=\"Add New Contact\"]")
	private WebElement AddNewContact;
	@FindBy(id = "name")
	private WebElement Entername;
	@FindBy(id = "registered_mobile")
	private WebElement registered_mobile;
	@FindBy(id = "registered_email")
	private WebElement registered_email;
	@FindBy(xpath = "//label[@ for=\"female\"]")
	private WebElement GenderAsFemale;
	@FindBy(xpath = "//label[@ for=\"male\"]")
	private WebElement GenderAsMale;
	@FindBy(id = "dob")
	private WebElement DOB;
	@FindBy(id = "identity")

	private WebElement DropDownPassport;
	@FindBy(id = "passport")
	private WebElement EnterpassportNo;

	@FindBy(xpath = "//input[@id=\"countries\"]")
	private WebElement EnteCountryAddress;
	@FindBy(xpath = "//input[@id=\"po_box\"]")
	private WebElement EntePostBoxAddress;
	@FindBy(xpath = "//input[@id=\"postal_code\"]")
	private WebElement EntePostalAddress;

	@FindBy(xpath = "//input[@id=\"county_or_state\"]")

	private WebElement EnterCounty;

	@FindBy(xpath = "//input[@id=\"kra_pin\"]")
	private WebElement EnterKra;

	private JavascriptExecutor driver;

	@FindBy(xpath = "//a[@name=\"submitted\"]")
	private WebElement SaveDetails;


	@FindBy(xpath="(//button [.=\"Remove\"])[1]")
	private WebElement RemoveContect;

	@FindBy(id="remove-details")
	private WebElement RemoveDetailsYes;


	@FindBy(id="modal_dismiss")
	private WebElement ModalDismissNo;

	@FindBy(xpath="//a[.=\"Completed Documents\"]")
	private WebElement CompletedDocuments1;
	
	@FindBy(xpath="(//a[@class=\"download download_btn\"])[1]")
	private WebElement downloadDocuments;

	@FindBy(xpath="(//a[.=\"Download Invoice\"])[1]")
	private WebElement DownloadInvoice;
	
	@FindBy(xpath="//a[.=\"Saved For Later\"]")
	private WebElement SavedForLater1;
	
	@FindBy(xpath="//a[.=\"Pending Document\"]")
	private WebElement PendingDocument;
	
	@FindBy(xpath="//a[.=\"Document cart\"]")
	private WebElement Documentcart1;
	
	@FindBy(xpath="//a[.=\"Profile\"]")
	private WebElement Profile1;

	public MyAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
public void myAccount() {
	MyAccount.click();
}
	public void Details() throws InterruptedException {
		MyAccount.click();
		AdrressBook.click();
		AddNewContact.click();
		Entername.sendKeys("Munna bhaiya1");
		registered_mobile.sendKeys("9804584755484");
		registered_email.sendKeys("tester@gmail.com");
		// GenderAsMale.click();
		// DOB.sendKeys("08-11-1995");
		// DOB.click();
		DropDownPassport.click();

		Select s = new Select(DropDownPassport);
		s.selectByValue("Passport");
		EnterpassportNo.sendKeys("658259655");
		Thread.sleep(2000);
	}

	public void Details2() throws InterruptedException {

		Thread.sleep(2000);
		// EnteCountryAddress.sendKeys("Kenya");
		EntePostBoxAddress.sendKeys("123Box");
		EntePostalAddress.sendKeys("90118 Ndalani");
		EnterCounty.sendKeys("kenya");
		EnterKra.sendKeys("62364654");
		Thread.sleep(2000);
	}

	public void Save() throws InterruptedException {

		Thread.sleep(2000);
		SaveDetails.click();
	}

	public void removecontect() throws Throwable   {

		Thread.sleep(2000);
		RemoveContect.click();
		RemoveDetailsYes.click();
		 //ModalDismissNo.click();
	}
	
	
	public void checkCompletedDocuments() {
		
		CompletedDocuments1.click();
		downloadDocuments.click();
		DownloadInvoice.click();
		
	}
	
	public void SavedForLater() {
		SavedForLater1.click();
		PendingDocument.click();
		
	}
	
	public void Documentcart() {
		Documentcart1.click();
		PendingDocument.click();
		
	}
	public void Profile() {
		Profile1.click();
		
	}
	
	
}