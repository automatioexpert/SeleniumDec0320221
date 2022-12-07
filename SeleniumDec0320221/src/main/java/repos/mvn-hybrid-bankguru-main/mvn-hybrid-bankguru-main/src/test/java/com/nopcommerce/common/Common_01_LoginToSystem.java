package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nopcommerce.*;

import java.util.Set;

public class Common_01_LoginToSystem extends BaseTest {
  WebDriver driver;
  HomePageObject homePage;
  LoginPageObject loginPage;
  RegisterPageObject registerPage;
  public static String firstName, lastName, email, password;
  public static Set<Cookie> loginCookie;
  
  @Parameters({"browser", "url"})
  @BeforeTest
  public void BeforeTest(String browserName, String appUrl) {
    log.info("Pre_Condition - Step 01: Open browser");
    driver = getBrowserDriver(browserName, appUrl);
    homePage = PageGeneratorManager.getHomePageObject(driver);
    
    firstName = "John";
    lastName = "Thomas";
    email = "john.thomas" + getRandomNumber() + "@mail.com";
    password = "555566677";
    
    log.info("Pre_Condition - Step 02: Open Register Page");
    homePage.openPageInAreaByText(driver, "header", "Register");
    registerPage = PageGeneratorManager.getRegisterPageObject(driver);
    
    log.info("Pre_Condition - Step 02: Enter to First Name textbox with valid value: " + firstName);
    registerPage.enterToTextboxByID(driver, "FirstName", firstName);
    
    log.info("Pre_Condition - Step 03: Enter to Last Name textbox with valid value: " + lastName);
    registerPage.enterToTextboxByID(driver, "LastName", lastName);
    
    log.info("Pre_Condition - Step 04: Enter to Email textbox with invalid value: " + email);
    registerPage.enterToTextboxByID(driver, "Email", email);
    
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
    
    log.info("Pre_Condition - Step 11: Enter to Email textbox with valid value: " + email);
    loginPage.enterToTextboxByID(driver, "Email", email);
    
    log.info("Pre_Condition - Step 12: Enter to Password textbox with incorrect value: " + password);
    loginPage.enterToTextboxByID(driver, "Password", password);
    
    log.info("Pre_Condition - Step 13: Click Login button");
    loginPage.clickToButtonByText(driver, "Log in");
    homePage = PageGeneratorManager.getHomePageObject(driver);
    
    log.info("Pre_Condition - Step 14: Get all login cookie");
    loginCookie = homePage.getAllCookies(driver);
    
    log.info("Pre_Condition - Step 15: Verify My account link is displayed");
    verifyTrue(loginPage.isHeaderLinkDisplayedByText(driver, "My account"));

    log.info("Pre_Condition - Step 16: Close browser");
    cleanBrowserAndDriver();
  }
}
