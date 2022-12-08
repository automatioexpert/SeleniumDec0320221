/**
 * 
 */
package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.pages.FlightsPage;
import com.pages.HomePage;
import com.pages.OptionsPage;
import com.pages.PassengersPage;
import com.util.ExcelUtil;

/**
 * @author anand acharya
 * ************************************** PURPOSE *******************************************
 * To add different scenarios and test cases by using methods declared in pages package class
 * To validate expected results by proper assertion for verifying if test case is pass or fail
 */
public class UserAcceptanceTest extends Testbase {

	//declare reference variable
	HomePage homePage;
	FlightsPage flightsPage;
	OptionsPage optionsPage;
	PassengersPage passengersPage;
	
	//To read the properties file
	public UserAcceptanceTest() {
		super();
	}
	
	//To be executed before each test method for setting up browser and opening required url
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		initialization(prop.getProperty("url"),browser);
		homePage = new HomePage(driver);
	}
	
     //Data driven framework concept
	@DataProvider
	public Object[][] getFlightInfo(){
		Object flightsData[][] = ExcelUtil.readExcel("flights", System.getProperty("user.dir")+"/src/main/java/com/testdata/flightsdata.xlsx");
		return flightsData;
	}
	
	/******************************************* TEST SCENARIOS **********************************************************/
	//5 test cases to verify domestic flight pair combinations and iterating the bag count in each scenario
	//using data driven framework approach for this test scenario
	//the test data is read from flightsdata.xlsx file in testdata package and the same test is executed 5 times with different data combinations
	@Test(dataProvider="getFlightInfo")
	public void verify_domestic_flights_bags(String origin, String destination, String bagsCount) throws InterruptedException {
		System.out.println("******************* starting verify_domestic_flights_bags test case *****************************");
		homePage.selectOneWayFlight(); //click the one way flight radio button
		homePage.enterFromToCityXcelData(origin, destination); //enter origin and destination city
		homePage.selectDepartureDate(); //select departure date 15 days in future
		flightsPage = homePage.searchFlights(); //click search flights
		String flightsSubTotalValue = flightsPage.getFlightsSubTotalValue(); //get the flights subtotal value
		Assert.assertEquals(flightsSubTotalValue, "0", "Flights sub total amount value is not equal to 0"); //verify the flights subtotal value
		flightsPage.addRedeDealFlightToTrip(); //add the first Rededeal flight to trip
		String redeDealTripValue = flightsPage.getTripValue(); //get the RedeDeal amount value
		flightsSubTotalValue = flightsPage.getFlightsSubTotalValue(); //get the flights subtotal value
		Assert.assertEquals(flightsSubTotalValue, redeDealTripValue, "Flights sub total value is not equal to Red e-Deal value"); //verify the eDeal value and flights subtotal value
		optionsPage = flightsPage.clickContinue(); //move to Options page
		passengersPage = optionsPage.clickContinue(); //move to Passengers page
		passengersPage.clickAddBags(); //Click the Add bags link
		passengersPage.addAdditionalBags(bagsCount); //Add additional bags
		String bagsSubTotalValue = passengersPage.getBagsSubTotalValue(); //get the bags subtotal value
		String bagsSeatAmount = passengersPage.getBaggageSeatsValue(); //get the baggage value
		Assert.assertEquals(bagsSubTotalValue, bagsSeatAmount, "Bags sub total value is not equal to the baggage value"); //verify the bags sub total value and baggage amount value
		System.out.println("******************* ending verify_domestic_flights_bags test case ******************************");
	}

	//Test scenario for a domestic flight pair to add one bag, 
	//then navigating to previous page and adding one more bag,
	//and repeating this process till 5 bags are added for the same flight search
	@Test()
	public void sydney_Brisbane_Bags_1to5() {
		System.out.println("******************* starting sydney_Brisbane_Bags_1to5 test case *****************************");
		homePage.selectOneWayFlight(); //click the one way flight radio button
		homePage.enterFromToCityPropData(); //enter origin and destination city
		homePage.selectDepartureDate(); //select departure date 15 days in future
		flightsPage = homePage.searchFlights(); //click search flights
		String flightsSubTotalValue = flightsPage.getFlightsSubTotalValue(); //get the flights subtotal value
		Assert.assertEquals(flightsSubTotalValue, "0", "Flights sub total amount value is not equal to 0"); //verify the flights subtotal value
		flightsPage.addRedeDealFlightToTrip(); //add the first Rededeal flight to trip
		String redeDealTripValue = flightsPage.getTripValue(); //get the RedeDeal amount value
		flightsSubTotalValue = flightsPage.getFlightsSubTotalValue(); //get the flights subtotal value
		Assert.assertEquals(flightsSubTotalValue, redeDealTripValue, "Flights sub total value is not equal to Red e-Deal value"); //verify the eDeal value and flights subtotal value
		optionsPage = flightsPage.clickContinue(); //move to Options page	
		passengersPage = optionsPage.clickContinue(); //move to Passengers page
		passengersPage.clickAddBags(); //Click the Add bags link
		passengersPage.addAdditionalBags("1"); //Add 1 additional bag
		String bagsSubTotalValue = passengersPage.getBagsSubTotalValue(); //get the bags subtotal value
		String bagsSeatAmount = passengersPage.getBaggageSeatsValue(); //get the baggage value
		Assert.assertEquals(bagsSubTotalValue, bagsSeatAmount, "Bags sub total value is not equal to the baggage value"); //verify the bags sub total value and baggage amount value
		optionsPage = passengersPage.clickBack(); //navigate back to options page
		for(int i=2; i<=5; i++) {
			passengersPage = optionsPage.clickContinue(); //move to Passengers page
			passengersPage.clickEditBags(); //Add upto 4 additional bags one by one
			passengersPage.addAdditionalBags("2"); //Add 1 more bag
			bagsSubTotalValue = passengersPage.getBagsSubTotalValue(); //get the bags subtotal value
			bagsSeatAmount = passengersPage.getBaggageSeatsValue(); //get the baggage value
			Assert.assertEquals(bagsSubTotalValue, bagsSeatAmount, "Bags sub total value is not equal to the baggage value"); //verify the bags sub total value and baggage amount value
			optionsPage = passengersPage.clickBack(); //navigate back to options page
		}
		passengersPage = optionsPage.clickContinue(); //move to Passengers page
		bagsSubTotalValue = passengersPage.getBagsSubTotalValue(); //get the bags subtotal value
		bagsSeatAmount = passengersPage.getBaggageSeatsValue(); //get the baggage value
		Assert.assertEquals(bagsSubTotalValue, bagsSeatAmount, "Bags sub total value is not equal to the baggage value"); //verify the bags sub total value and baggage amount value
		System.out.println("******************* ending sydney_Brisbane_Bags_1to5 test case ******************************");
	}
	
	//to close browser after each method
	@AfterMethod
	public void tearDown() throws IOException {
		if(driver!=null) {
			try {
				driver.quit();
			}
			catch (WebDriverException e) {
				System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
			}
		}
		System.out.println("***************************************Browser closed***************************************************");
	}	
}
