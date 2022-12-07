package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class Register extends BaseTest {
  WebDriver driver;
  HomePageObject homePage;
  RegisterPageObject registerPage;
  LoginPageObject loginPage;
  String firstName, lastName, invalidEmail, validEmail, password, invalidPassword;
  
  @Parameters({"browser", "url"})
  @BeforeClass
  public void BeforeClass(String browserName, String appUrl) {
    log.info("Pre_Condition - Step 01: Open browser");
    driver = getBrowserDriver(browserName, appUrl);
    homePage = PageGeneratorManager.getHomePageObject(driver);
    
    firstName = "John";
    lastName = "Thomas";
    invalidEmail = "john.thomas#@7^^^^";
    validEmail = "john.thomas" + getRandomNumber() + "@mail.com";
    password = "555566677";
    invalidPassword = "123";
    
    log.info("Pre_Condition - Step 02: Open Register Page");
    homePage.openPageInAreaByText(driver, "header", "Register");
    registerPage = PageGeneratorManager.getRegisterPageObject(driver);
  }
  
  @Test
  public void Register_01_Empty_Data() {
    log.info("Empty_Data_01 - Step 01: Click Register Button");
    registerPage.clickToButtonByText(driver, "Register");
    
    log.info("Empty_Data_01 - Step 02: Verify error message at First Name field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "FirstName-error"), "First name is required.");
    
    log.info("Empty_Data_01 - Step 03: Verify error message at Last Name field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "LastName-error"), "Last name is required.");
    
    log.info("Empty_Data_01 - Step 04: Verify error message at Email field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "Email-error"), "Email is required.");
    
    log.info("Empty_Data_01 - Step 05: Verify error message at Password field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "Password-error"), "Password is required.");
    
    log.info("Empty_Data_01 - Step 06: Verify error message at Confirm Password field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "ConfirmPassword-error"), "Password is required.");
  }
  
  @Test
  public void Register_02_Invalid_Email() {
    log.info("Invalid_Email_02 - Step 01: Refresh Page");
    registerPage.refreshToPage(driver);
    
    log.info("Invalid_Email_02 - Step 02: Enter to First Name textbox with valid value: " + firstName);
    registerPage.enterToTextboxByID(driver, "FirstName", firstName);
    
    log.info("Invalid_Email_02 - Step 03: Enter to Last Name textbox with valid value: " + lastName);
    registerPage.enterToTextboxByID(driver, "LastName", lastName);
    
    log.info("Invalid_Email_02 - Step 04: Enter to Email textbox with invalid value: " + invalidEmail);
    registerPage.enterToTextboxByID(driver, "Email", invalidEmail);
    
    log.info("Invalid_Email_02 - Step 05: Enter to Password textbox with valid value: " + password);
    registerPage.enterToTextboxByID(driver, "Password", password);
    
    log.info("Invalid_Email_02 - Step 06: Enter to Confirm Password textbox with value: " + password);
    registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
    
    log.info("Invalid_Email_02 - Step 07: Click Register Button");
    registerPage.clickToButtonByText(driver, "Register");
    
    log.info("Invalid_Email_02 - Step 08: Verify error message at Email field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "Email-error"), "Wrong email");
  
  }
  
  @Test
  public void Register_03_Success() {
    log.info("Success_03 - Step 01: Refresh Page");
    registerPage.refreshToPage(driver);
  
    log.info("Success_03 - Step 02: Enter to First Name textbox with valid value: " + firstName);
    registerPage.enterToTextboxByID(driver, "FirstName", firstName);
  
    log.info("Success_03 - Step 03: Enter to Last Name textbox with valid value: " + lastName);
    registerPage.enterToTextboxByID(driver, "LastName", lastName);
  
    log.info("Success_03 - Step 04: Enter to Email textbox with invalid value: " + validEmail);
    registerPage.enterToTextboxByID(driver, "Email", validEmail);
  
    log.info("Success_03 - Step 05: Enter to Password textbox with valid value: " + password);
    registerPage.enterToTextboxByID(driver, "Password", password);
  
    log.info("Success_03 - Step 06: Enter to Confirm Password textbox with value: " + password);
    registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
  
    log.info("Success_03 - Step 07: Click Register Button");
    registerPage.clickToButtonByText(driver, "Register");
  
    log.info("Success_03 - Step 08: Verify register success message is displayed");
    verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    
    log.info("Success_03 - Step 09: Logout to system");
    registerPage.openPageInAreaByText(driver, "header", "Log out");
    homePage = PageGeneratorManager.getHomePageObject(driver);
  }
  
  @Test
  public void Register_04_Email_Exist() {
    log.info("Email_Exist_04 - Step 01: Open Register Page");
    homePage.openPageInAreaByText(driver, "header", "Register");
    registerPage = PageGeneratorManager.getRegisterPageObject(driver);
  
    log.info("Email_Exist_04 - Step 02: Enter to First Name textbox with valid value: " + firstName);
    registerPage.enterToTextboxByID(driver, "FirstName", firstName);
  
    log.info("Email_Exist_04 - Step 03: Enter to Last Name textbox with valid value: " + lastName);
    registerPage.enterToTextboxByID(driver, "LastName", lastName);
  
    log.info("Email_Exist_04 - Step 04: Enter to Email textbox with invalid value: " + validEmail);
    registerPage.enterToTextboxByID(driver, "Email", validEmail);
  
    log.info("Email_Exist_04 - Step 05: Enter to Password textbox with valid value: " + password);
    registerPage.enterToTextboxByID(driver, "Password", password);
  
    log.info("Email_Exist_04 - Step 06: Enter to Confirm Password textbox with value: " + password);
    registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
  
    log.info("Email_Exist_04 - Step 07: Click Register Button");
    registerPage.clickToButtonByText(driver, "Register");
  
    log.info("Email_Exist_04 - Step 08: Verify email exist message is displayed");
    verifyEquals(registerPage.getSummaryErrorMessage(driver), "The specified email already exists");
  }
  
  @Test
  public void Register_05_Password_Less_Than_6() {
    log.info("Password_Less_Than_6_05 - Step 01: Refresh Page");
    registerPage.refreshToPage(driver);
  
    log.info("Password_Less_Than_6_05 - Step 02: Enter to First Name textbox with valid value: " + firstName);
    registerPage.enterToTextboxByID(driver, "FirstName", firstName);
  
    log.info("Password_Less_Than_6_05 - Step 03: Enter to Last Name textbox with valid value: " + lastName);
    registerPage.enterToTextboxByID(driver, "LastName", lastName);
  
    log.info("Password_Less_Than_6_05 - Step 04: Enter to Email textbox with valid value: " + validEmail);
    registerPage.enterToTextboxByID(driver, "Email", validEmail);
  
    log.info("Password_Less_Than_6_05 - Step 05: Enter to Password textbox with invalid value: " + invalidPassword);
    registerPage.enterToTextboxByID(driver, "Password", invalidPassword);
  
    log.info("Password_Less_Than_6_05 - Step 06: Enter to Confirm Password textbox with value: " + password);
    registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
  
    log.info("Password_Less_Than_6_05 - Step 07: Click Register Button");
    registerPage.clickToButtonByText(driver, "Register");
  
    log.info("Password_Less_Than_6_05 - Step 08: Verify error message at Password field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "Password-error"), "Password must meet the following rules:\n" + "must have at least 6 characters");
  
  }
  
  @Test
  public void Register_06_Confirm_Password_Not_Match() {
    log.info("Confirm_Password_Not_Match_06 - Step 01: Refresh Page");
    registerPage.refreshToPage(driver);
  
    log.info("Confirm_Password_Not_Match_06 - Step 02: Enter to First Name textbox with valid value: " + firstName);
    registerPage.enterToTextboxByID(driver, "FirstName", firstName);
  
    log.info("Confirm_Password_Not_Match_06 - Step 03: Enter to Last Name textbox with valid value: " + lastName);
    registerPage.enterToTextboxByID(driver, "LastName", lastName);
  
    log.info("Confirm_Password_Not_Match_06 - Step 04: Enter to Email textbox with valid value: " + validEmail);
    registerPage.enterToTextboxByID(driver, "Email", validEmail);
  
    log.info("Confirm_Password_Not_Match_06 - Step 05: Enter to Password textbox with valid value: " + password);
    registerPage.enterToTextboxByID(driver, "Password", password);
  
    log.info("Confirm_Password_Not_Match_06 - Step 06: Enter to Confirm Password textbox with value: " + "1222222");
    registerPage.enterToTextboxByID(driver, "ConfirmPassword", "1222222");
  
    log.info("Confirm_Password_Not_Match_06 - Step 07: Click Register Button");
    registerPage.clickToButtonByText(driver, "Register");
  
    log.info("Confirm_Password_Not_Match_06 - Step 08: Verify error message at Password field");
    verifyEquals(registerPage.getErrorMessageAtFieldByID(driver, "ConfirmPassword-error"), "The password and confirmation password do not match.");
  
  }
  
  @AfterClass
  public void afterClass() {
    log.info("Post-Condition: Close browser");
    cleanBrowserAndDriver();
  }
}
