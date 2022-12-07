package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_LoginToSystem;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.*;

public class Search extends BaseTest {
  WebDriver driver;
  HomePageObject homePage;
  SearchPageObject searchPage;
  String productName, notExistProduct, relativeProductName, absoluteProductName;
  
  @Parameters({"browser", "url"})
  @BeforeClass
  public void BeforeClass(String browserName, String appUrl) {
    log.info("Pre_Condition - Step 01: Open browser");
    driver = getBrowserDriver(browserName, appUrl);
    homePage = PageGeneratorManager.getHomePageObject(driver);
    
    productName = "Apple Macbook Pro";
    notExistProduct = "Mac Pro 2050";
    relativeProductName = "Lenovo";
    absoluteProductName = "ThinkPad X1 Carbon";
    
    log.info("Pre_Condition - Step 02: Login To System");
    homePage.setAllCookies(driver, Common_01_LoginToSystem.loginCookie);
    homePage.refreshToPage(driver);
    
    log.info("Pre_Condition - Step 03: Open Search Page");
    homePage.openPageInAreaByText(driver, "footer", "Search");
    searchPage = PageGeneratorManager.getSearchPageObject(driver);
  }
  
  @Test
  public void Search_01_Empty_Data() {
    log.info("Empty_Data_01 - Step 01: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Empty_Data_01 - Step 02: Verify error message at search result is displayed");
    verifyEquals(searchPage.getMessageAtSearchResults(), "Search term minimum length is 3 characters");
  }
  
  @Test
  public void Search_02_Data_Not_Exist() {
    log.info("Data_Not_Exist_02 - Step 01: Refresh page");
    searchPage.refreshToPage(driver);
    
    log.info("Data_Not_Exist_02 - Step 02: Enter to Search Keyword textbox with value not exist: " + notExistProduct);
    searchPage.enterToTextboxByID(driver, "q", notExistProduct);
    
    log.info("Data_Not_Exist_02 - Step 03: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Data_Not_Exist_02 - Step 04: Verify error message at search result is displayed");
    verifyEquals(searchPage.getMessageAtSearchResults(), "No products were found that matched your criteria.");
  }
  
  @Test
  public void Search_03_Product_Name_Relative() {
    log.info("Product_Name_Relative_03 - Step 01: Refresh page");
    searchPage.refreshToPage(driver);
    
    log.info("Product_Name_Relative_03 - Step 02: Enter to Search Keyword textbox with value not exist: " + relativeProductName);
    searchPage.enterToTextboxByID(driver, "q", relativeProductName);
    
    log.info("Product_Name_Relative_03 - Step 03: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Product_Name_Relative_03 - Step 04: Verify 2 products info are displayed");
    verifyEquals(searchPage.getProductsSizeDisplayed(), 2);
  }
  
  @Test
  public void Search_04_Product_Name_Absolute() {
    log.info("Product_Name_Absolute_04 - Step 01: Refresh page");
    searchPage.refreshToPage(driver);
    
    log.info("Product_Name_Absolute_04 - Step 02: Enter to Search Keyword textbox with value not exist: " + absoluteProductName);
    searchPage.enterToTextboxByID(driver, "q", absoluteProductName);
    
    log.info("Product_Name_Absolute_04 - Step 03: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Product_Name_Absolute_04 - Step 04: Verify 1 product info is displayed");
    verifyEquals(searchPage.getProductsSizeDisplayed(), 1);
  }
  
  @Test
  public void Search_05_Advance_Search_With_Parent_Categories() {
    log.info("Advance_Search_With_Parent_Categories_05 - Step 01: Refresh page");
    searchPage.refreshToPage(driver);
    
    log.info("Advance_Search_With_Parent_Categories_05 - Step 02: Enter to Search Keyword textbox with value not exist: " + productName);
    searchPage.enterToTextboxByID(driver, "q", productName);
    
    log.info("Advance_Search_With_Parent_Categories_05 - Step 03: Check to Advanced Search checkbox");
    searchPage.clickToCheckboxByLabel(driver, "Advanced search");
    
    log.info("Advance_Search_With_Parent_Categories_05 - Step 04: Select to Category dropdown");
    searchPage.selectItemInDropdownByName(driver, "cid", "Computers");
    
    log.info("Advance_Search_With_Parent_Categories_05 - Step 04: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Advance_Search_With_Parent_Categories_05 - Step 05: Verify error message at search result is displayed");
    verifyEquals(searchPage.getMessageAtSearchResults(), "No products were found that matched your criteria.");
  }
  
  @Test
  public void Search_06_Advance_Search_With_Sub_Categories() {
    log.info("Advance_Search_With_Sub_Categories_06 - Step 01: Refresh page");
    searchPage.refreshToPage(driver);
    
    log.info("Advance_Search_With_Sub_Categories_06 - Step 02: Enter to Search Keyword textbox with value not exist: " + productName);
    searchPage.enterToTextboxByID(driver, "q", productName);
    
    log.info("Advance_Search_With_Sub_Categories_06 - Step 03: Check to Advanced Search checkbox");
    searchPage.clickToCheckboxByLabel(driver, "Advanced search");
    
    log.info("Advance_Search_With_Sub_Categories_06 - Step 04: Select to Category dropdown");
    searchPage.selectItemInDropdownByName(driver, "cid", "Computers");
    
    log.info("Advance_Search_With_Sub_Categories_06 - Step 05: Check to  Automatically search sub categories checkbox");
    searchPage.clickToCheckboxByLabel(driver, "Automatically search sub categories");
    
    log.info("Advance_Search_With_Sub_Categories_06 - Step 06: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Advance_Search_With_Sub_Categories_06 - Step 07: Verify 1 products info is displayed");
    verifyEquals(searchPage.getProductsSizeDisplayed(), 1);
  }
  
  @Test
  public void Search_07_Advance_Search_With_Incorrect_Manufacturer() {
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 01: Refresh page");
    searchPage.refreshToPage(driver);
    
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 02: Enter to Search Keyword textbox with value not exist: " + productName);
    searchPage.enterToTextboxByID(driver, "q", productName);
    
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 03: Check to Advanced Search checkbox");
    searchPage.clickToCheckboxByLabel(driver, "Advanced search");
    
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 04: Select to Category dropdown");
    searchPage.selectItemInDropdownByName(driver, "cid", "Computers");
    
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 05: Check to  Automatically search sub categories checkbox");
    searchPage.clickToCheckboxByLabel(driver, "Automatically search sub categories");
    
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 06: Select to Manufacturer dropdown");
    searchPage.selectItemInDropdownByName(driver, "mid", "HP");
    
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 07: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Advance_Search_With_Incorrect_Manufacturer_07 - Step 08: Verify error message at search result is displayed");
    verifyEquals(searchPage.getMessageAtSearchResults(), "No products were found that matched your criteria.");
  }
  
  @Test
  public void Search_08_Advance_Search_With_Correct_Manufacturer() {
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 01: Refresh page");
    searchPage.refreshToPage(driver);
    
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 02: Enter to Search Keyword textbox with value not exist: " + productName);
    searchPage.enterToTextboxByID(driver, "q", productName);
    
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 03: Check to Advanced Search checkbox");
    searchPage.clickToCheckboxByLabel(driver, "Advanced search");
    
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 04: Select to Category dropdown");
    searchPage.selectItemInDropdownByName(driver, "cid", "Computers");
    
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 05: Check to  Automatically search sub categories checkbox");
    searchPage.clickToCheckboxByLabel(driver, "Automatically search sub categories");
    
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 06: Select to Manufacturer dropdown");
    searchPage.selectItemInDropdownByName(driver, "mid", "Apple");
    
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 07: Click Search Button");
    searchPage.clickToSearchButton();
    
    log.info("Advance_Search_With_Correct_Manufacturer_08 - Step 08: Verify 1 products info is displayed");
    verifyEquals(searchPage.getProductsSizeDisplayed(), 1);
  }
  
  @AfterClass
  public void afterClass() {
    log.info("Post-Condition: Close browser");
    cleanBrowserAndDriver();
  }
}
