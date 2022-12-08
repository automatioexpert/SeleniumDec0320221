package com.parallelExecution.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parallelExecution.pages.HomePage;
import com.parallelExecution.pages.SearchFlightsPage;

public class SearchFlightTC extends BaseClassforTest {

	HomePage homePage;
	SearchFlightsPage searchFlight;

	@Override
	@BeforeClass
	public void beforeClass() {
		setup("chrome");
		openURL("https://www.cleartrip.com/");
	}

	@BeforeMethod
	public void openSerachFlight() {
		homePage = new HomePage();
		searchFlight = homePage.selectFlightOption();
	}

	@Test
	public void searchFlight() {
		System.out.println("In serachFlight "+ Thread.currentThread().getId());
		searchFlight.SearchFlight("Mumbai", "Pune", "28-11-2019");
		
	}

	@Override
	@AfterClass
	public void afterClass() {
		driver.close();

	}

}
