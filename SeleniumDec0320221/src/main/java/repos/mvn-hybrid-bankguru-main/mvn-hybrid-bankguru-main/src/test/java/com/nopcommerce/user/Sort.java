package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.*;

public class Sort extends BaseTest {
  WebDriver driver;
  HomePageObject homePage;
  NotebooksPageObject notebooksPage;
  
  @Parameters({"browser", "url"})
  @BeforeClass
  public void BeforeClass(String browserName, String appUrl) {
    log.info("Pre_Condition - Step 01: Open browser");
    driver = getBrowserDriver(browserName, appUrl);
    homePage = PageGeneratorManager.getHomePageObject(driver);
    
    log.info("Pre_Condition - Step 02: Open Sub Menu - Notebooks Page");
    homePage.openSubMenuPage(driver, "Computers", "Notebooks");
    notebooksPage = PageGeneratorManager.getNotebooksPageObject(driver);
  }
  
  @Test
  public void Sort_01_Name_ASC() {
    log.info("Name_ASC_01 - Step 01: Select Sort By dropdown with option: Name: A to Z" );
    notebooksPage.selectItemInDropdownByName(driver, "products-orderby", "Name: A to Z");
    
    log.info("Name_ASC_01 - Step 02: Verify product name sorted from A to Z" );
    verifyTrue(notebooksPage.ísProductNameSorted(driver, "ASC"));
  }
  
  @Test
  public void Sort_02_Name_DESC() {
    log.info("Name_DESC_02 - Step 01: Select Sort By dropdown with option: Name: Z to A" );
    notebooksPage.selectItemInDropdownByName(driver, "products-orderby", "Name: Z to A");
    
    log.info("Name_DESC_02 - Step 02: Verify product name sorted from Z to A" );
    verifyFalse(notebooksPage.ísProductNameSorted(driver, "DESC"));
  }
  
  @Test
  public void Sort_03_Price_Low_To_High() {
    log.info("Price_Low_To_High_03 - Step 01: Select Sort By dropdown with option: Name: A to Z" );
    notebooksPage.selectItemInDropdownByName(driver, "products-orderby", "Price: Low to High");
    notebooksPage.sleepInSecond(3);
    
    log.info("Price_Low_To_High_03 - Step 02: Verify product price sorted from Low to High" );
    verifyTrue(notebooksPage.ísProductPriceSorted(driver, "LowToHigh"));
  }
  
  @Test
  public void Sort_04_Price_High_To_Low() {
    log.info("Price_High_To_Low_04 - Step 01: Select Sort By dropdown with option: Name: A to Z" );
    notebooksPage.selectItemInDropdownByName(driver, "products-orderby", "Price: High to Low");
    notebooksPage.sleepInSecond(3);
    
    log.info("Price_High_To_Low_04 - Step 02: Verify product price sorted from High to Low" );
    verifyTrue(notebooksPage.ísProductPriceSorted(driver, "HighToLow"));
  }
  
  @AfterClass
  public void afterClass() {
    log.info("Post-Condition: Close browser");
    cleanBrowserAndDriver();
  }
}
