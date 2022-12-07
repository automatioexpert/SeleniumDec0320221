package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.NotebooksPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;

public class DisplayPaging extends BaseTest {
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
  public void Display_01_3PerPage() {
    log.info("3PerPage_01 - Step 01: Select Display dropdown with option: 3 per page" );
    notebooksPage.selectItemInDropdownByName(driver, "products-pagesize", "3");
    
    log.info("3PerPage_01 - Step 02: Verify there are only right or less than 3 products" );
    verifyTrue(notebooksPage.isPageLoadedSuccess(driver));
    verifyTrue(notebooksPage.ísProductsSizeDisplayed(driver, 3));
  
    log.info("3PerPage_01 - Step 03: Open Paging 1" );
    notebooksPage.openPagingByPageNumber(driver, "1");
  
    log.info("3PerPage_01 - Step 04: Verify Page Number Active" );
    verifyTrue(notebooksPage.isPageNumberActive(driver, "1"));
  
    log.info("3PerPage_01 - Step 05: Verify Paging (Next icon) is displayed");
    verifyTrue(notebooksPage.isPageNumberDisplayed(driver, "Next"));
  
    log.info("3PerPage_01 - Step 06: Open Paging 2" );
    notebooksPage.openPagingByPageNumber(driver, "2");
  
    log.info("3PerPage_01 - Step 07: Verify Page Number Active" );
    verifyTrue(notebooksPage.isPageNumberActive(driver, "2"));
    
    log.info("3PerPage_01 - Step 08: Verify Paging (Previous icon) is displayed");
    verifyTrue(notebooksPage.isPageNumberDisplayed(driver, "Previous"));
  }
  
  @Test
  public void Display_02_6PerPage() {
    log.info("6PerPage_02 - Step 01: Select Display dropdown with option: 6 per page" );
    notebooksPage.selectItemInDropdownByName(driver, "products-pagesize", "6");
    
    log.info("6PerPage_02 - Step 02: Verify there are only right or less than 6 products" );
    verifyTrue(notebooksPage.isPageLoadedSuccess(driver));
    verifyTrue(notebooksPage.ísProductsSizeDisplayed(driver, 6));
  
    log.info("6PerPage_02 - Step 03: Verify Paging is undisplayed" );
    verifyTrue(notebooksPage.isPagingUnDisplay(driver));
  }
  
  @Test
  public void Display_03_9PerPage() {
    log.info("9PerPage_03 - Step 01: Select Display dropdown with option: 9 per page" );
    notebooksPage.selectItemInDropdownByName(driver, "products-pagesize", "9");
    
    log.info("9PerPage_03 - Step 02: Verify there are only right or less than 9 products" );
    verifyTrue(notebooksPage.isPageLoadedSuccess(driver));
    verifyTrue(notebooksPage.ísProductsSizeDisplayed(driver, 9));
  
    log.info("9PerPage_03 - Step 03: Verify Paging is undisplayed" );
    verifyTrue(notebooksPage.isPagingUnDisplay(driver));
  }
  
  @AfterClass
  public void afterClass() {
    log.info("Post-Condition: Close browser");
    cleanBrowserAndDriver();
  }
}
