package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	WaitHelper wait;

	public SearchCustomerPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(ldriver, this);
		wait=new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.ID, using="SearchEmail")
	@CacheLookup
	WebElement emailID;
	
	@FindBy(how = How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement firstName;

	@FindBy(how = How.ID, using="SearchLastName")
	@CacheLookup
	WebElement lastName;

	@FindBy(how = How.ID, using="SearchMonthOfBirth" )
	@CacheLookup 
	WebElement dobMonth;
	
	@FindBy(how = How.ID, using="SearchDayOfBirth" )
	@CacheLookup 
	WebElement dobDay;	

	@FindBy(how = How.ID, using="SearchCompany")
	@CacheLookup
	WebElement companyName;

	@FindBy(how = How.ID, using="SearchIpAddress")
	@CacheLookup
	WebElement IPaddress;

	@FindBy(how = How.XPATH, using="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement customerRoles;
	
	@FindBy(how = How.XPATH, using="//option[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstitemAdmincomment;
	
	@FindBy(how = How.XPATH, using="//option[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement lstitemModerators;
	
	@FindBy(how = How.XPATH, using="//option[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstitemGuests;
	
	@FindBy(how = How.XPATH, using="//option[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstitemRegistered;
	
	@FindBy(how = How.XPATH, using="//option[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstitemVendors;
	

	@FindBy(how = How.XPATH, using="//button[@id='search-customers']")
	@CacheLookup
	WebElement serachBtn;

	@FindBy(how = How.XPATH, using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;

	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	
	public void setEmail(String email) {
		wait.WaitForElement(emailID, 0);
		emailID.clear();
		emailID.sendKeys(email);
	}

	public void setFirstName(String fname) {
		wait.WaitForElement(firstName, 20);
		firstName.clear();
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		wait.WaitForElement(lastName, 20);
		lastName.clear();
		lastName.sendKeys(lname);
	}

	public void setDateOfBirth(String dob) {
		wait.WaitForElement(dobDay, 20);
		
	}

	public void setMonthOfBirth(String compname) {
		wait.WaitForElement(dobMonth, 20);
	}
	
	public void setCompanyName(String compname) {
		wait.WaitForElement(companyName, 20);
		companyName.clear();
		companyName.sendKeys(compname);
	}
	
	public void setIPAdress(String ipadd) {
		wait.WaitForElement(IPaddress, 20);
		IPaddress.clear();
		IPaddress.sendKeys(ipadd);
	}

	public void setRoles(String role) {
		Select select = new Select(ldriver.findElement(By.id("SelectedCustomerRoleIds")));

		List<WebElement> lst = select.getOptions();
		for (WebElement options : lst) {
			System.out.println(options.getText());
		}
		if (role.equals("Registered")) {
			select.selectByValue("3");
		} else if (role.equals("Administrators")) {
			select.selectByValue("1");
		} else if (role.equals("Guests")) {
			select.selectByValue("4");
		} else if (role.equals("Vendors")) {
			select.selectByValue("5");
		} else if (role.equals("Forum Moderators")) {
			select.selectByValue("3");
		}
	}

	public void clickSearchButton() {
		wait.WaitForElement(serachBtn, 20);
		serachBtn.click();
	}
	
	public int getNoOfRows() {
		return (tableRows.size());		
	}
	
	public int getNoOfColumns() {
		return (tableColumns.size());		
	}
	
	public boolean serachCustomerByEmail(String email) {
		boolean flag=false;
		
		for (int i = 1; i <=getNoOfRows(); i++) {
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if (emailid.equals(email)) {
				flag=true;
			}		
		}
		return flag;
	}
	
	public boolean serachCustomerByName(String Name) {
		boolean flag=false;
		
		for (int i = 1; i <=getNoOfRows(); i++) {
			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String names[]=name.split(" "); //separating First name & Last name
			System.out.println(name);
			if (names[0].equals("Victoria") && names[1].equals("Treces")) {
				flag=true;
			}		
		}
		return flag;
	}	
}
