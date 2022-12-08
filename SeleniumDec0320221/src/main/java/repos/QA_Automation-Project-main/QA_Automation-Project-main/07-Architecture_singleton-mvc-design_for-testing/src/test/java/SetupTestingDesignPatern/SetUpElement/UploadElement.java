package SetupTestingDesignPatern.SetUpElement;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SetupTestingDesignPatern.DriverSingleton.DriverSingleton;

public class UploadElement {
	private WebDriver driver;

	public UploadElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//Element

	@FindBy(xpath = "//span[normalize-space()='OK']")
	private WebElement messageOK;

	@FindBy(id = "ui-id-11")
	private WebElement dataTable;

	@FindBy(xpath = "//span[normalize-space()='Upload Data']")
	private WebElement uploadTable;

	@FindBy(xpath = "//input[@id='tl_upload_new--52043_text']")
	private WebElement importData;

	@FindBy(xpath = "//span[normalize-space()='Upload']")
	private WebElement uploadBtn;
	
	@FindBy(xpath = "//*[@id='tl_upload_new--52045_table']/tbody/tr")
	private List<WebElement> dataSize;

	@FindBy(xpath = "//button[@id='52055_query']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@id='formtl_upload_newdialog-123']")
	private WebElement msgSaveValidation;
	
	@FindBy(xpath = "//span[normalize-space()='SIMPAN']")
	private WebElement saveValidationBtn;
	
	@FindBy(xpath = "//button[@title='Close']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//*[@id='nikita-form-dialog']/p")
	private WebElement msgValidation;

	
	//method
	public void messageOK(){
		messageOK.click();;
	}

	public void dataTable() {
		dataTable.click();
	}

	public void uploadTable() {
		uploadTable.click();
	}
	
	public void importData(String excel) {
		importData.sendKeys(excel);;
	}
	
	public void uploadBtn() {
		uploadBtn.click();
	}
	
	public int dataSize() {
		return dataSize.size();
	}
	
	public void saveBtn() {
		saveBtn.click();
	}
	
	public String msgSaveValidation() {
		return msgSaveValidation.getText();
	}
	
	public void saveValidationBtn() {
		saveValidationBtn.click();
	}
	
	public void closeBtn() {
		closeBtn.click();
	}
	
	public String msgValidation() {
		return msgValidation.getText();
	}

}
