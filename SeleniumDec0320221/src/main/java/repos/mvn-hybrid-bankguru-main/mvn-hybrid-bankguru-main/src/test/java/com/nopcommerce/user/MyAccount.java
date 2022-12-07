package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_LoginToSystem;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.*;

public class MyAccount extends BaseTest {
  WebDriver driver;
  HomePageObject homePage;
  MyAccountPageObject myAccountPage;
  LoginPageObject loginPage;
  CameraPhotoPageObject cameraPhotoPage;
  ProductReviewPageObject productReviewPage;
  String firstName, lastName, fullName, email, password, editFirstName, editLastName, editDay, editMonth, editYear, editEmail, editCompanyName, country, state, city, address1, address2, zipCode, phone, fax, newPassword,
          reviewTitle, reviewText;
  
  @Parameters({"browser", "url"})
  @BeforeClass
  public void BeforeClass(String browserName, String appUrl) {
    log.info("Pre_Condition - Step 01: Open browser");
    driver = getBrowserDriver(browserName, appUrl);
    homePage = PageGeneratorManager.getHomePageObject(driver);
    
    firstName = Common_01_LoginToSystem.firstName;
    lastName = Common_01_LoginToSystem.lastName;
    email = Common_01_LoginToSystem.email;
    password = Common_01_LoginToSystem.password;
    fullName = firstName + " "+ lastName;
    
    editFirstName = "Tony";
    editLastName = "Smith";
    editDay = "15";
    editMonth = "May";
    editYear = "2005";
    editEmail = "tony" + getRandomNumber() + "@mail.com";
    editCompanyName = "SUN Solution";
    
    country = "Viet Nam";
    state = "Other";
    city = "Da Nang";
    address1 = "123/04 Le Lai";
    address2 = "234/05 Hai Phong";
    zipCode = "55000";
    phone = "0987654321";
    fax = "0123456789";
  
    newPassword = "66668888";
    reviewTitle = "Review Product";
    reviewText = "Good Product";
    
    log.info("Pre_Condition - Step 02: Login To System");
    homePage.setAllCookies(driver, Common_01_LoginToSystem.loginCookie);
    homePage.refreshToPage(driver);
    
    log.info("Pre_Condition - Step 03: Open My Account Page");
    homePage.openPageInAreaByText(driver, "header", "My account");
    myAccountPage = PageGeneratorManager.getMyAccountPageObject(driver);
  }
  
  @Test
  public void MyAccount_01_CustomerInfo() {
    log.info("CustomerInfo_01 - Step 01: Verify text displayed at First Name textbox with value: " + firstName);
    verifyEquals(myAccountPage.getTexboxValueByID(driver, "FirstName"), firstName);
    
    log.info("CustomerInfo_01 - Step 02: Verify text displayed at Last Name textbox with value: " + lastName);
    verifyEquals(myAccountPage.getTexboxValueByID(driver, "LastName"), lastName);
    
    log.info("CustomerInfo_01 - Step 03: Verify text displayed at Email textbox with value: " + email);
    verifyEquals(myAccountPage.getTexboxValueByID(driver, "Email"), email);
    
    log.info("CustomerInfo_01 - Step 04: Select new value to Gender radio button");
    myAccountPage.clickToRadioButtonByLabel(driver, "Male");
    
    log.info("CustomerInfo_01 - Step 05: Enter new value to First Name textbox with value: " + editFirstName);
    myAccountPage.enterToTextboxByID(driver, "FirstName", editFirstName);
    
    log.info("CustomerInfo_01 - Step 06: Enter new value to Last Name textbox with value: " + editLastName);
    myAccountPage.enterToTextboxByID(driver, "LastName", editLastName);
    
    log.info("CustomerInfo_01 - Step 07: Select new value to Day dropdown");
    myAccountPage.selectItemInDropdownByName(driver, "DateOfBirthDay", editDay);
    
    log.info("CustomerInfo_01 - Step 08: Select new value to Month dropdown");
    myAccountPage.selectItemInDropdownByName(driver, "DateOfBirthMonth", editMonth);
    
    log.info("CustomerInfo_01 - Step 09: Select new value to Year dropdown");
    myAccountPage.selectItemInDropdownByName(driver, "DateOfBirthYear", editYear);
    
    log.info("CustomerInfo_01 - Step 10: Enter new value to Email textbox with value: " + editEmail);
    myAccountPage.enterToTextboxByID(driver, "Email", editEmail);
    
    log.info("CustomerInfo_01 - Step 11: Enter new value to Company Name textbox with value: " + editCompanyName);
    myAccountPage.enterToTextboxByID(driver, "Company", editCompanyName);
    
    log.info("CustomerInfo_01 - Step 12: Click to Save button");
    myAccountPage.clickToButtonByText(driver, "Save");
    
    log.info("CustomerInfo_01 - Step 13: Verify Gender radio button is updated success");
    verifyTrue(myAccountPage.isRadioButtonSelectedByLabel(driver, "Male"));
    
    log.info("CustomerInfo_01 - Step 14: Verify First Name textbox is updated success");
    verifyEquals(myAccountPage.getTexboxValueByID(driver, "FirstName"), editFirstName);
    
    log.info("CustomerInfo_01 - Step 15: Verify Last Name textbox is updated success");
    verifyEquals(myAccountPage.getTexboxValueByID(driver, "LastName"), editLastName);
    
    log.info("CustomerInfo_01 - Step 16: Verify Day dropdown is updated success");
    verifyEquals(myAccountPage.getTexboxValueByID(driver, "Email"), editEmail);
    
    log.info("CustomerInfo_01 - Step 17: Verify Month dropdown is updated success");
    verifyEquals(myAccountPage.getSelectedValueInDropdownByName(driver, "DateOfBirthDay"), editDay);
    
    log.info("CustomerInfo_01 - Step 18: Verify Year dropdown is updated success");
    verifyEquals(myAccountPage.getSelectedValueInDropdownByName(driver, "DateOfBirthMonth"), editMonth);
    
    log.info("CustomerInfo_01 - Step 19: Verify Email textbox is updated success");
    verifyEquals(myAccountPage.getSelectedValueInDropdownByName(driver, "DateOfBirthYear"), editYear);
    
    log.info("CustomerInfo_01 - Step 20: Verify Company Name textbox is updated success");
    verifyEquals(myAccountPage.getTexboxValueByID(driver, "Company"), editCompanyName);
  }
  
  @Test
  public void MyAccount_02_Addresses() {
    log.info("Addresses_02 - Step 01: Open Addresses Page");
    myAccountPage.openPageInAreaByText(driver, "side-2", "Addresses");
    
    log.info("Addresses_02 - Step 02: Click to Add New button");
    myAccountPage.clickToButtonByText(driver, "Add new");
    
    log.info("Addresses_02 - Step 03: Enter to First Name textbox with value: " + firstName);
    myAccountPage.enterToTextboxByID(driver, "Address_FirstName", firstName);
    
    log.info("Addresses_02 - Step 04: Enter to Last Name textbox with value: " + lastName);
    myAccountPage.enterToTextboxByID(driver, "Address_LastName", lastName);
    
    log.info("Addresses_02 - Step 05: Enter to Email textbox with value: " + email);
    myAccountPage.enterToTextboxByID(driver, "Address_Email", email);
    
    log.info("Addresses_02 - Step 05: Enter to Company Name textbox with value: " + editCompanyName);
    myAccountPage.enterToTextboxByID(driver, "Address_Company", editCompanyName);
    
    log.info("Addresses_02 - Step 06: Select to Country dropdown with value: " + country);
    myAccountPage.selectItemInDropdownByName(driver, "Address.CountryId", country);
    
    log.info("Addresses_02 - Step 07: Select to State / province dropdown with value: " + state);
    myAccountPage.selectItemInDropdownByName(driver, "Address.StateProvinceId", state);
    
    log.info("Addresses_02 - Step 08: Enter to City textbox with value: " + city);
    myAccountPage.enterToTextboxByID(driver, "Address_City", city);
    
    log.info("Addresses_02 - Step 08: Enter to Address 1 textbox with value: " + address1);
    myAccountPage.enterToTextboxByID(driver, "Address_Address1", address1);
    
    log.info("Addresses_02 - Step 09: Enter to Address 2 textbox with value: " + address2);
    myAccountPage.enterToTextboxByID(driver, "Address_Address2", address2);
    
    log.info("Addresses_02 - Step 10: Enter to Zip / postal code textbox with value: " + zipCode);
    myAccountPage.enterToTextboxByID(driver, "Address_ZipPostalCode", zipCode);
    
    log.info("Addresses_02 - Step 11: Enter to Phone number textbox with value: " + phone);
    myAccountPage.enterToTextboxByID(driver, "Address_PhoneNumber", phone);
    
    log.info("Addresses_02 - Step 12: Enter to Fax number textbox with value: " + fax);
    myAccountPage.enterToTextboxByID(driver, "Address_FaxNumber", fax);
    
    log.info("Addresses_02 - Step 13: Click to Save button");
    myAccountPage.clickToButtonByText(driver, "Save");
    
    log.info("Addresses_02 - Step 14: Verify text display at Full Name field with: " + fullName);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "name", fullName));
    
    log.info("Addresses_02 - Step 15: Verify text display at Email field with: " + email);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "email", email));
  
    log.info("Addresses_02 - Step 16: Verify text display at Phone Number field with: " + phone);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "phone", phone));
  
    log.info("Addresses_02 - Step 17: Verify text display at Fax Number field with: " + fax);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "fax", fax));
  
    log.info("Addresses_02 - Step 18: Verify text display at Company field with: " + editCompanyName);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "company", editCompanyName));
  
    log.info("Addresses_02 - Step 19: Verify text display at Address1 field with: " + address1);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "address1", address1));
  
    log.info("Addresses_02 - Step 20: Verify text display at Address2 field with: " + address2);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "address2", address2));
  
    log.info("Addresses_02 - Step 21: Verify text display at city-state-zip field with: " + city + ", " + zipCode);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "city-state-zip", city + ", " + zipCode));
  
    log.info("Addresses_02 - Step 22: Verify text display at country field with: " + country);
    verifyTrue(myAccountPage.isAddressInfoDisplayByClass(driver, "country", country));

  }
  
  @Test
  public void MyAccount_03_Change_Password() {
    log.info("Change_Password_03 - Step 01: Open Change Password Page");
    myAccountPage.openPageInAreaByText(driver, "side-2", "Change password");
  
    log.info("Change_Password_03 - Step 02: Enter to Old Password textbox with value: " + password);
    myAccountPage.enterToTextboxByID(driver, "OldPassword", password);
    
    log.info("Change_Password_03 - Step 03: Enter to New password textbox with value: " + newPassword);
    myAccountPage.enterToTextboxByID(driver, "NewPassword", newPassword);
    
    log.info("Change_Password_03 - Step 04: Enter to Confirm Password textbox with value: " + newPassword);
    myAccountPage.enterToTextboxByID(driver, "ConfirmNewPassword", newPassword);
    
    log.info("Change_Password_03 - Step 05: Click to Change Password button");
    myAccountPage.clickToButtonByText(driver, "Change password");
  
    log.info("Change_Password_03 - Step 06: Verify change password success notification is displayed");
    verifyEquals(myAccountPage.getBarNotificationContent(driver), "Password was changed");
    myAccountPage.closeBarNotification(driver);
  
    log.info("Change_Password_03 - Step 07: Logout to System");
    myAccountPage.openPageInAreaByText(driver, "header", "Log out");
    loginPage = PageGeneratorManager.getLoginPageObject(driver);
  
    log.info("Change_Password_03 - Step 08: Login to System with Old Password");
    loginPage.loginToSystem(email, password);
  
    log.info("Change_Password_03 - Step 09: Verify login error message is displayed");
    verifyEquals(loginPage.getSummaryErrorMessage(driver), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
    
    log.info("Change_Password_03 - Step 10: Login to System with New Password");
    homePage = loginPage.loginToSystem(email, newPassword);
    
    log.info("Change_Password_03 - Step 11: Verify My account link is displayed");
    verifyTrue(homePage.isHeaderLinkDisplayedByText(driver, "My account"));
  }
  
  @Test
  public void MyAccount_04_My_Product_Reviews() {
    log.info("My_Product_Reviews_04 - Step 01: Open Camera & Photo Page");
    myAccountPage.openSubMenuPage(driver, "Electronics", "Camera & photo");
    cameraPhotoPage = PageGeneratorManager.getCameraPhotoPageObject(driver);
    
    log.info("My_Product_Reviews_04 - Step 02: Click to Apple iCam product");
    cameraPhotoPage.clickToProductTitleByText(driver, "Apple iCam");
    
    log.info("My_Product_Reviews_04 - Step 03: Click to Add Your Review link");
    cameraPhotoPage.clickToReviewLinkByText(driver, "Add your review");
    productReviewPage = PageGeneratorManager.getProductReviewPageObject(driver);
    
    log.info("My_Product_Reviews_04 - Step 04: Enter to Review Title textbox with value: " + reviewTitle);
    productReviewPage.enterToTextboxByID(driver, "AddProductReview_Title", reviewTitle);
    
    log.info("My_Product_Reviews_04 - Step 05: Enter to Review Text textbox with value: " + reviewText);
    productReviewPage.enterToTextareaByID(driver, "AddProductReview_ReviewText", reviewText);
    
    log.info("My_Product_Reviews_04 - Step 06: Select to Rating radio button" );
    productReviewPage.selectToRatingRadioButton("addproductrating_3");
    
    log.info("My_Product_Reviews_04 - Step 07: Click to Submit Review button" );
    productReviewPage.clickToButtonByText(driver, "Submit review");
    
    log.info("My_Product_Reviews_04 - Step 08: Verify success message is displayed" );
    verifyEquals(productReviewPage.getReviewSuccessMessage(), "Product review is successfully added.");
    
    log.info("My_Product_Reviews_04 - Step 09: Verify review display at Existing Reviews Page" );
    verifyTrue(productReviewPage.isProductReviewDisplay(driver, reviewTitle));
    
    log.info("My_Product_Reviews_04 - Step 10: Open My Account Page" );
    productReviewPage.openPageInAreaByText(driver, "header", "My account");
    myAccountPage = PageGeneratorManager.getMyAccountPageObject(driver);
    
    log.info("My_Product_Reviews_04 - Step 11: Open My product reviews Page");
    myAccountPage.openPageInAreaByText(driver, "side-2", "My product reviews");
  
    log.info("My_Product_Reviews_04 - Step 12: Verify review display at My product reviews Page" );
    verifyTrue(myAccountPage.isProductReviewDisplay(driver, reviewTitle));
  }
  
  @AfterClass
  public void afterClass() {
    log.info("Post-Condition: Close browser");
    cleanBrowserAndDriver();
  }
}
