package com.parallelExecution.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parallelExecution.pages.HomePage;
import com.parallelExecution.pages.SearchHotelPage;

public class SearchHotelTC extends BaseClassforTest {

	HomePage homePage;
	SearchHotelPage searchHotel;

	@Override
	@BeforeClass
	public void beforeClass() {
		setup("chrome");
		openURL("https://www.cleartrip.com/");
	}

	@BeforeMethod
	public void openSearchHotel() {
		homePage = new HomePage();
		searchHotel = homePage.selecthotelOption();
	}

	@Test
	public void searchHotel() {
		System.out.println("In searchHotel " + Thread.currentThread().getId());
		searchHotel.enterLocation("Pune");
	}

	@Override
	@AfterClass
	public void afterClass() {
		driver.close();

	}

}
