package parabank.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PO_TransferFunds {

	//1st Section
	WebDriver driver;
	
	//2nd Paramatrized constructor
	public PO_TransferFunds(WebDriver driver) {
		this.driver = driver;
	}
	
	//3rd Section: Locators
	@FindBy(how = How.ID,using = "amount") 
	private WebElement txtbx_amount;
	
	@FindBy(how = How.ID,using = "fromAccountId") 
	private WebElement drop_down_from_account;
	
	@FindBy(how = How.ID,using = "toAccountId") 
	private WebElement drop_down_to_account;
	
	@FindBy(how = How.XPATH,using = "//input[@value='Transfer']") 
	private WebElement btn_submit;
	
	@FindBy(how = How.XPATH,using = "//div[@ng-if='showResult']") 
	private WebElement div_text_transfer_success_message;
	
	
	public void EnterTextInAmount(String text) {
		txtbx_amount.sendKeys(text);

	}
	
	public void SelectAccountFrom(String text) {
		Select list = new Select(drop_down_from_account);
		list.selectByVisibleText(text);

	}
	
	public void SelectAccountTo(String text) {
		Select list = new Select(drop_down_to_account);
		list.selectByVisibleText(text);

	}
	
	public void ClickOnTranferFundsButton() {
		btn_submit.click();

	}
	
	public void TransferFunds(String amt, String from, String to) {
		EnterTextInAmount(amt);
		SelectAccountFrom(from);
		SelectAccountTo(to);
		ClickOnTranferFundsButton();
	}
	
	
	/*
	public void ValidateTransferFundsIsSuccessfull(String fromAccount, String toAccount, String amount) {
		
		String actual_message_content = div_text_transfer_success_message.getText();
		
		//Transfer complete message
		if (actual_message_content.equals("Transfer Complete!")) {
			Assert.assertTrue(true,"Transfer Funds Message is coming");

		}else {
			Cmn.log("fail", "Transfer Complete! Message  is not coming." );
			Assert.assertTrue(false,"Transfer Funds Message is not coming");
		}
		
		//From Account
		if (actual_message_content.equals(fromAccount)) {
			Assert.assertTrue(true,"From Account is correctly displayed");
		}else {
			Assert.assertTrue(false,"From Account is not correctly displayed");
		}
		
		//From Account
		if (actual_message_content.equals(toAccount)) {
			Assert.assertTrue(true,"To Account is correctly displayed");
		}else {
			Assert.assertTrue(false,"To Account is not correctly displayed");
		}
		
		//AMount
		if (actual_message_content.equals(amount)) {
			Assert.assertTrue(true,"Amount is correctly displayed.");
		}else {
			Assert.assertTrue(false,"Amount is not correctly displayed.");
		}
		
		
	}
	*/
}
