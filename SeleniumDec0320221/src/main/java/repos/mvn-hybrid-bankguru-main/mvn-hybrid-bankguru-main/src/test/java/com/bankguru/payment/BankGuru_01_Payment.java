package com.bankguru.payment;

import commons.BaseTest;
import pageObjects.bankguru.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.ManagerPageObject;

public class BankGuru_01_Payment extends BaseTest {
  WebDriver driver;
  LoginPageObject loginPage;
  ManagerPageObject managerPage;
  String userName, password, customerName, genderValueInput, genderValueOutput, dateOfBirthInput, dateOfBirthOutput, address, city, state, pin, phone, email, customerID, passwordCustomer, editAddress, editCity, editState, editPin, editPhone, editEmail,
          accountTypeItem, initialDeposit;
  
  @Parameters({"browser", "url"})
  @BeforeClass
  public void BeforeClass(String browserName, String appUrl) {
    log.info("Pre_Condition - Step 01: Open browser");
    driver = getBrowserDriver(browserName, appUrl);
    loginPage = PageGeneratorManager.getLoginPageObject(driver);
    
    userName = "mngr392664";
    password = "dezyzUp";
    customerName = "AUTOMATION TESTING";
    genderValueInput = "f";
    genderValueOutput = "female";
    dateOfBirthInput = "01/01/1989";
    dateOfBirthOutput = "1989-01-01";
    address = "PO Box 911 8331 Duis Avenue";
    city = "Tampa";
    state = "FL";
    pin = "466250";
    phone = "4555442476";
    email = "automation" + getRandomNumber() + "@gmail.com";
    passwordCustomer = "123456";
    
    editAddress = "1883 Cursus Avenue";
    editCity = "Houston";
    editState = "Texas";
    editPin = "166455";
    editPhone = "4779728081";
    editEmail = "testing" + getRandomNumber() + "@gmail.com";
  
    accountTypeItem = "Savings";
    initialDeposit = "500";
    
    log.info("Pre_Condition - Step 02: Login to system");
    managerPage = loginPage.loginToSystem(userName, password);
    
    log.info("Pre_Condition - Step 03: Verify success message is displayed");
    verifyEquals(managerPage.getLoginSuccessMessage(), "Welcome To Manager's Page of Guru99 Bank");
  }
  
  @Test
  public void Payment_01_Create_New_Customer() {
    log.info("Create_New_Customer_01 - Step 01: Open New Customer Tab");
    managerPage.openManagerTabByText(driver, "New Customer");
    
    log.info("Create_New_Customer_01 - Step 02: Enter to Customer Name textbox with value: " + customerName);
    managerPage.enterToTextboxByLabel(driver, "Customer Name", customerName);
    
    log.info("Create_New_Customer_01 - Step 03: Select to Gender radio button with value: " + genderValueInput);
    managerPage.selectToRadioButton(driver, genderValueInput);
    
    log.info("Create_New_Customer_01 - Step 04: Enter to Date of Birth textbox with value: " + dateOfBirthInput);
    managerPage.enterToTextboxByLabel(driver, "Date of Birth", dateOfBirthInput);
    
    log.info("Create_New_Customer_01 - Step 05: Enter to Address textbox with value: " + address);
    managerPage.enterToTextareaByLabel(driver, "Address", address);
    
    log.info("Create_New_Customer_01 - Step 06: Enter to City textbox with value: " + city);
    managerPage.enterToTextboxByLabel(driver, "City", city);
    
    log.info("Create_New_Customer_01 - Step 07: Enter to State textbox with value: " + state);
    managerPage.enterToTextboxByLabel(driver, "State", state);
    
    log.info("Create_New_Customer_01 - Step 08: Enter to PIN textbox with value: " + pin);
    managerPage.enterToTextboxByLabel(driver, "PIN", pin);
    
    log.info("Create_New_Customer_01 - Step 09: Enter to Mobile Number textbox with value: " + phone);
    managerPage.enterToTextboxByLabel(driver, "Mobile Number", phone);
    
    log.info("Create_New_Customer_01 - Step 10: Enter to E-mail textbox with value: " + email);
    managerPage.enterToTextboxByLabel(driver, "E-mail", email);
    
    log.info("Create_New_Customer_01 - Step 11: Enter to Password textbox with value: " + passwordCustomer);
    managerPage.enterToTextboxByLabel(driver, "Password", passwordCustomer);
    
    log.info("Create_New_Customer_01 - Step 12: CLick to Submit button");
    managerPage.clickToButtonByValue(driver, "Submit");
    
    log.info("Create_New_Customer_01 - Step 13: Verify create customer success message is displayed");
    verifyEquals(managerPage.getSuccessMessageAtTableID(driver, "customer"), "Customer Registered Successfully!!!");
    
    log.info("Create_New_Customer_01 - Step 14: Get customer ID value ");
    customerID = managerPage.getRowValueByRowName(driver, "Customer ID");
    
    log.info("Create_New_Customer_01 - Step 15: Verify text displayed at Customer Name with value: " + customerName);
    verifyEquals(managerPage.getRowValueByRowName(driver, "Customer Name"), customerName);
    
    log.info("Create_New_Customer_01 - Step 16: Verify text displayed at Gender with value: " + genderValueOutput);
    verifyEquals(managerPage.getRowValueByRowName(driver, "Gender"), genderValueOutput);
    
    log.info("Create_New_Customer_01 - Step 17: Verify text displayed at Birthdate with value: " + dateOfBirthOutput);
    verifyEquals(managerPage.getRowValueByRowName(driver, "Birthdate"), dateOfBirthOutput);
    
    log.info("Create_New_Customer_01 - Step 18: Verify text displayed at Address with value: " + address);
    verifyEquals(managerPage.getRowValueByRowName(driver, "Address"), address);
    
    log.info("Create_New_Customer_01 - Step 19: Verify text displayed at City with value: " + city);
    verifyEquals(managerPage.getRowValueByRowName(driver, "City"), city);
    
    log.info("Create_New_Customer_01 - Step 20: Verify text displayed at State with value: " + state);
    verifyEquals(managerPage.getRowValueByRowName(driver, "State"), state);
    
    log.info("Create_New_Customer_01 - Step 21: Verify text displayed at Pin with value: " + pin);
    verifyEquals(managerPage.getRowValueByRowName(driver, "Pin"), pin);
    
    log.info("Create_New_Customer_01 - Step 22: Verify text displayed at Mobile No. with value: " + phone);
    verifyEquals(managerPage.getRowValueByRowName(driver, "Mobile No."), phone);
    
    log.info("Create_New_Customer_01 - Step 23: Verify text displayed at Email with value: " + email);
    verifyEquals(managerPage.getRowValueByRowName(driver, "Email"), email);
  }
  
  @Test
  public void Payment_02_Edit_Customer() {
    log.info("Edit_Customer_02 - Step 01: Open Edit Customer Tab");
    managerPage.openManagerTabByText(driver, "Edit Customer");
    
    log.info("Edit_Customer_02 - Step 02: Enter to Customer ID textbox with value: " + customerID);
    managerPage.enterToTextboxByLabel(driver, "Customer ID", customerID);
    
    log.info("Edit_Customer_02 - Step 03: Click to Submit button");
    managerPage.clickToButtonByValue(driver, "Submit");
    
    log.info("Edit_Customer_02 - Step 04: Verify Customer Name textbox is disabled");
    verifyFalse(managerPage.isFieldEnabledByLabel(driver, "Customer Name"));
    
    log.info("Edit_Customer_02 - Step 05: Verify Gender textbox is disabled");
    verifyFalse(managerPage.isFieldEnabledByLabel(driver, "Gender"));
    
    log.info("Edit_Customer_02 - Step 06: Verify Date of Birth textbox is disabled");
    verifyFalse(managerPage.isFieldEnabledByLabel(driver, "Date of Birth"));
    
    log.info("Edit_Customer_02 - Step 07: Enter new value to Address textarea");
    managerPage.enterToTextareaByLabel(driver, "Address", editAddress);
    
    log.info("Edit_Customer_02 - Step 08: Enter new value to City textarea");
    managerPage.enterToTextboxByLabel(driver, "City", editCity);
    
    log.info("Edit_Customer_02 - Step 09: Enter new value to State textarea");
    managerPage.enterToTextboxByLabel(driver, "State", editState);
    
    log.info("Edit_Customer_02 - Step 10: Enter new value to PIN textarea");
    managerPage.enterToTextboxByLabel(driver, "PIN", editPin);
    
    log.info("Edit_Customer_02 - Step 11: Enter new value to Mobile Number textarea");
    managerPage.enterToTextboxByLabel(driver, "Mobile Number", editPhone);
    
    log.info("Edit_Customer_02 - Step 12: Enter new value to E-mail textarea");
    managerPage.enterToTextboxByLabel(driver, "E-mail", editEmail);
    
    log.info("Edit_Customer_02 - Step 13: Click to Submit button");
    managerPage.clickToButtonByValue(driver, "Submit");
    
  }
  
  @Test
  public void Payment_03_Add_New_Account() {
    log.info("Add_New_Account_03 - Step 01: Open New Account Tab");
    managerPage.openManagerTabByText(driver, "New Account");
    
    log.info("Add_New_Account_03 - Step 02: Enter to Customer ID textbox with value: " + customerID);
    managerPage.enterToTextboxByLabel(driver, "Customer id", customerID);
  
    log.info("Add_New_Account_03 - Step 03: Select to Account Type dropdown with value: " + accountTypeItem);
    managerPage.selectItemInDropdownByName(driver, "selaccount", accountTypeItem);
    
    log.info("Add_New_Account_03 - Step 04: Enter to Initial deposit textbox with value:" + initialDeposit);
    managerPage.enterToTextboxByLabel(driver, "Initial deposit", initialDeposit);
    
    log.info("Add_New_Account_03 - Step 05: Click to Submit button");
    managerPage.clickToButtonByValue(driver, "Submit");
    
    log.info("Add_New_Account_03 - Step 06: Verify success message is displayed");
    verifyEquals(managerPage.getSuccessMessageAtTableID(driver, "account"), "Account Generated Successfully!!!");
  }
  
  @Test
  public void Payment_04_Edit_Account() {
  
  }
  
  @Test
  public void Payment_05_Transfer_Money_Into_Current_Account() {
  
  }
  
  @Test
  public void Payment_06_Withdraw_Money_Into_Current_Account() {
  
  }
  
  @Test
  public void Payment_07_Transfer_Money_Into_Another_Account() {
  
  }
  
  @Test
  public void Payment_08_Check_Current_Account_Balance() {
  
  }
  
  @Test
  public void Payment_09_Delete_All_Account() {
  
  }
  
  @Test
  public void Payment_10_Delete_Exist_Customer_Account() {
  
  }
  
  @AfterClass
  public void afterClass() {
    driver.quit();
  }
}
