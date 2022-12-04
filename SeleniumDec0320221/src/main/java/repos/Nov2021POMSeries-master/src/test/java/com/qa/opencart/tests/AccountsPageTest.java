package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccountsPageTitle();
		System.out.println("Acc page title : " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageUrlTest() {
		String actUrl = accPage.getAccountsPageUrl();
		System.out.println("Acc page url : " + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
	}

	@Test
	public void accPageHeaderTest() {
		String header = accPage.getAccPageHeader();
		System.out.println("acc page header : " + header);
		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER);
	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.searchExist());
	}

	@Test
	public void accPageSectionsTest() {
		List<String> accSectionsList = accPage.getAccPageSections();
		System.out.println("actual sec list: " + accSectionsList);
		Assert.assertEquals(accSectionsList, Constants.ACCOUNTS_PAGE_SECTIONS_LIST);
	}
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Apple"}
		};
	}
	
	@Test(dataProvider = "productData")
	public void searchTest(String productName) {
		resultsPage = accPage.doSearch(productName);
		Assert.assertTrue(resultsPage.getProductListCount()>0);
	}
	
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] {
			{"Macbook", "MacBook Pro"},
			{"Macbook", "MacBook Air"},
			{"iMac", "iMac"},
			{"Apple", "Apple Cinema 30\""}
		};
	}
	
	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		resultsPage = accPage.doSearch(productName);
		productInfoPage = resultsPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductHeaderName(), mainProductName);
	}
	

}
