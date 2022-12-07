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

public class Login extends BaseTest {
  WebDriver driver;
  HomePageObject homePage;
  LoginPageObject loginPage;
  RegisterPageObject registerPage;
  String firstName, lastName, invalidEmail, notFoundEmail, validEmail, password, invalidPassword;
  
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
    notFoundEmail = "tony" + getRandomNumber() + "@mail.com";
    password = "555566677";
    invalidPassword = "123";
  
    log.info("Pre_Condition - Step 02: Open Register Page");
    homePage.openPageInAreaByText(driver, "header", "Register");
    registerPage = PageGeneratorManager.getRegisterPageObject(driver);
    
    log.info("Pre_Condition - Step 02: Enter to First Name textbox with valid value: " + firstName);
    registerPage.enterToTextboxByID(driver, "FirstName", firstName);
  
    log.info("Pre_Condition - Step 03: Enter to Last Name textbox with valid value: " + lastName);
    registerPage.enterToTextboxByID(driver, "LastName", lastName);
  
    log.info("Pre_Condition - Step 04: Enter to Email textbox with invalid value: " + validEmail);
    registerPage.enterToTextboxByID(driver, "Email", validEmail);
  
    log.info("Pre_Condition - Step 05: Enter to Password textbox with valid value: " + password);
    registerPage.enterToTextboxByID(driver, "Password", password);
  
    log.info("Pre_Condition - Step 06: Enter to Confirm Password textbox with value: " + password);
    registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
  
    log.info("Pre_Condition - Step 07: Click Register Button");
    registerPage.clickToButtonByText(driver, "Register");
  
    log.info("Pre_Condition - Step 08: Verify register success message is displayed");
    verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
  
    log.info("Pre_Condition - Step 09: Logout to system");
    registerPage.openPageInAreaByText(driver, "header", "Log out");
    homePage = PageGeneratorManager.getHomePageObject(driver);
    
    log.info("Pre_Condition - Step 10: Open Login Page");
    homePage.openPageInAreaByText(driver, "header", "Log in");
    loginPage = PageGeneratorManager.getLoginPageObject(driver);
  }
  
  @Test
  public void Login_01_Empty_Data() {
    log.info("Empty_Data_01 - Step 01: Click Login button");
    loginPage.clickToButtonByText(driver, "Log in");
    
    log.info("Empty_Data_01 - Step 02: Verify error message at Email field");
    verifyEquals(loginPage.getErrorMessageAtFieldByID(driver, "Email-error"), "Please enter your email");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
    log.info("Invalid_Email_02 - Step 01: Refresh page");
    loginPage.refreshToPage(driver);
    
    log.info("Invalid_Email_02 - Step 02: Enter to Email textbox with invalid value: " + invalidEmail);
    loginPage.enterToTextboxByID(driver, "Email", invalidEmail);
    
    log.info("Invalid_Email_02 - Step 03: Enter to Password textbox with value: " + password);
    loginPage.enterToTextboxByID(driver, "Password", password);
    
    log.info("Invalid_Email_02 - Step 04: Click Login button");
    loginPage.clickToButtonByText(driver, "Log in");
    
    log.info("Invalid_Email_02 - Step 05: Verify error message at Email field");
    verifyEquals(loginPage.getErrorMessageAtFieldByID(driver, "Email-error"), "Wrong email");
    
  }
  
  @Test
  public void Login_03_Not_Found_Email() {
    log.info("Not_Found_Email_03 - Step 01: Refresh page");
    loginPage.refreshToPage(driver);
  
    log.info("Not_Found_Email_03 - Step 02: Enter to Email textbox with invalid value: " + notFoundEmail);
    loginPage.enterToTextboxByID(driver, "Email", notFoundEmail);
  
    log.info("Not_Found_Email_03 - Step 03: Enter to Password textbox with value: " + password);
    loginPage.enterToTextboxByID(driver, "Password", password);
  
    log.info("Not_Found_Email_03 - Step 04: Click Login button");
    loginPage.clickToButtonByText(driver, "Log in");
  
    log.info("Not_Found_Email_03 - Step 05: Verify error message is displayed");
    verifyEquals(loginPage.getSummaryErrorMessage(driver), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
  }
  
  @Test
  public void Login_04_Existing_Email_Empty_Password() {
    log.info("Existing_Email_Empty_Password_04 - Step 01: Refresh page");
    loginPage.refreshToPage(driver);
  
    log.info("Existing_Email_Empty_Password_04 - Step 02: Enter to Email textbox with valid value: " + validEmail);
    loginPage.enterToTextboxByID(driver, "Email", validEmail);
    
    log.info("Existing_Email_Empty_Password_04 - Step 03: Click Login button");
    loginPage.clickToButtonByText(driver, "Log in");
  
    log.info("Existing_Email_Empty_Password_04 - Step 04: Verify error message is displayed");
    verifyEquals(loginPage.getSummaryErrorMessage(driver), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
  
  }
  
  @Test
  public void Login_05_Existing_Email_Incorrect_Password() {
    log.info("Existing_Email_Incorrect_Password_05 - Step 01: Refresh page");
    loginPage.refreshToPage(driver);
  
    log.info("Existing_Email_Incorrect_Password_05 - Step 02: Enter to Email textbox with valid value: " + validEmail);
    loginPage.enterToTextboxByID(driver, "Email", validEmail);
  
    log.info("Existing_Email_Incorrect_Password_05 - Step 03: Enter to Password textbox with incorrect value: " + "24234234");
    loginPage.enterToTextboxByID(driver, "Password", "24234234");
    
    log.info("Existing_Email_Incorrect_Password_05 - Step 04: Click Login button");
    loginPage.clickToButtonByText(driver, "Log in");
  
    log.info("Existing_Email_Incorrect_Password_05 - Step 05: Verify error message is displayed");
    verifyEquals(loginPage.getSummaryErrorMessage(driver), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

  }
  
  @Test
  public void Login_06_Success() {
    log.info("Success_06 - Step 01: Refresh page");
    loginPage.refreshToPage(driver);
  
    log.info("Success_06 - Step 02: Enter to Email textbox with valid value: " + validEmail);
    loginPage.enterToTextboxByID(driver, "Email", validEmail);
  
    log.info("Success_06 - Step 03: Enter to Password textbox with incorrect value: " + password);
    loginPage.enterToTextboxByID(driver, "Password", password);
  
    log.info("Success_06 - Step 04: Click Login button");
    loginPage.clickToButtonByText(driver, "Log in");
  
    log.info("Success_06 - Step 05: Verify My account link is displayed");
    verifyTrue(loginPage.isHeaderLinkDisplayedByText(driver, "My account"));

  }
  
  @AfterClass
  public void afterClass() {
    log.info("Post-Condition: Close browser");
    cleanBrowserAndDriver();
  }
}
