package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;

	public AddCustomerPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(ldriver, this);
	}

	By lnkcustomerMenu = By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[4]");

	By linkcustomerMenuItem = By.xpath("//li[@class='nav-item has-treeview menu-open']/ul[1]/li[1]/a[1]");

	By btnAddnew = By.xpath("//a[@class='btn btn-primary']");

	By txtemail = By.xpath("//input[@id='Email']");

	By txtpassword = By.xpath("//input[@id='Password']");

	By txtfirstname = By.xpath("//input[@id='FirstName']");

	By txtlastname = By.xpath("//input[@id='LastName']");

	By rdgendermale = By.xpath("//input[@id='Gender_Male']");

	By rdgenderfemale = By.id("Gender_Female");

	By dateofb = By.xpath("//input[@id='DateOfBirth']");

	By companyname = By.xpath("//input[@id='Company']");

	By taxexempt = By.xpath("//input[@id='IsTaxExempt']");

	By txtnewsletter = By.xpath("//input[@class='k-input k-readonly']");

	By customerroles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

	By lstitemAdmincomment = By.xpath("//option[contains(text(),'Administrators')]");
	By lstitemModerators = By.xpath("//option[contains(text(),'Forum Moderators')]");
	By lstitemGuests = By.xpath("//option[@value='4']");
	By lstitemRegistered = By.xpath("//option[@value='3']");
	By lstitemVendors = By.xpath("//option[@value='5']");

	By managervendor = By.xpath("//select[@id='VendorId']");

	By btnactive = By.xpath("//input[@id='Active']");

	By admincomment = By.xpath("//textarea[@id='AdminComment']");

	By btnsave = By.xpath("//button[@class='btn btn-primary'][1]");

	By btnsaveContinueEdit = By.xpath("//button[@class='btn btn-primary'][2]");

	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	// To click on customer link menu
	public void clickCustomerMenu() {
		ldriver.findElement(lnkcustomerMenu).click();
	}

	// To click on customer link Sub-menu
	public void ClickCustomerMenuItem() {
		ldriver.findElement(linkcustomerMenuItem).click();
	}

	// To click on Add new customer link
	public void ClickAddNew() {
		ldriver.findElement(btnAddnew).click();;
	}

	public void setEmail(String uname) {
		ldriver.findElement(txtemail).sendKeys(uname);
	}

	public void setPassword(String pwd) {
		ldriver.findElement(txtpassword).sendKeys(pwd);
	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtfirstname).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtlastname).sendKeys(lname);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rdgendermale).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(rdgenderfemale).click();
		} else {
			ldriver.findElement(rdgendermale).click(); // default
		}
	}

	public void setDateOfBirth(String dob) {
		ldriver.findElement(dateofb).sendKeys(dob);
	}

	public void setCompanyName(String compname) {
		ldriver.findElement(companyname).sendKeys(compname);
	}

	public void setTaxExempt() {
		if (((WebElement) taxexempt).isDisplayed() & ((WebElement) taxexempt).isEnabled()) {
			((WebElement) taxexempt).click();
		}
	}

	public void setNewsletter(String newsletter) {
		Select select = new Select(ldriver.findElement(By.id("SelectedNewsletterSubscriptionStoreIds")));

		List<WebElement> lst = select.getOptions();
		for (WebElement options : lst) {
			System.out.println(options.getText());
		}
		if (newsletter.equals("Your store name")) {
			select.selectByValue("1");
		} else if (newsletter.equals("Test store 2")) {
			select.selectByValue("2");
		}
	}

	public void setCustomerRoles(String roles) throws InterruptedException {
		if (!roles.equals("Registered")) {
			ldriver.findElement(customerroles);
		}
		ldriver.findElement(customerroles).click();

		WebElement listitem;
		Thread.sleep(3000);

		if (roles.equals("Administrators")) {
			listitem = ldriver.findElement(lstitemAdmincomment);
		} else if (roles.equals("lstitemModerators")) {
			listitem = ldriver.findElement(lstitemModerators);
		} else if (roles.equals("Guests")) {
			listitem = ldriver.findElement(lstitemGuests);
		} else if (roles.equals("Registered")) {
			listitem = ldriver.findElement(lstitemRegistered);
		} else if (roles.equals("Vendors")) {
			listitem = ldriver.findElement(lstitemVendors);
		} else {
			listitem = ldriver.findElement(lstitemRegistered);
		}
		listitem.click();

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listitem);
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

	public void setVendor(String value) {
		Select select = new Select(ldriver.findElement(managervendor));

		List<WebElement> lst = select.getOptions();
		for (WebElement options : lst) {
			System.out.println(options.getText());
		}
		if (value.equals("Not a vendor")) {
			select.selectByVisibleText("Not a vendor");
		} else if (value.equals("Vendor 1")) {
			select.selectByValue("1");
		} else if (value.equals("Vendor 2")) {
			select.selectByValue("2");
		}
	}

	public void setActiveButton() {
		ldriver.findElement(btnactive).click();
	}

	public void setAdminComment(String content) {
		ldriver.findElement(admincomment).sendKeys(content);
	}

	public void clickSaveButton() {
		ldriver.findElement(btnsave).click();
	}

	public void clickSaveEditButton() {
		ldriver.findElement(btnsaveContinueEdit).click();
	}
}
