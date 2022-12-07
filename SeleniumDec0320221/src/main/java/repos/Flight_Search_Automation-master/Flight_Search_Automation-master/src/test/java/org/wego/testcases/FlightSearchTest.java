package org.wego.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.wego.dataprovider.ReadData;
import org.wego.driver.DriverProvider;
import org.wego.pages.FlightSearchPage;
import org.testng.annotations.Test;
import org.wego.pages.FlightSearchResultPage;
import org.wego.utility.ApplicationConfig;

import java.lang.reflect.Method;
import java.util.HashMap;

public class FlightSearchTest extends BaseTest {
    String baseUrl = ApplicationConfig.getBaseUrl();

    @BeforeMethod
    public void methodInit(Method m) {
        driver = DriverProvider.getDriver();
        if (!driver.getCurrentUrl().contains(baseUrl)) driver.get(baseUrl);

    }

    @AfterMethod
    public void methodEnd(Method m) {
        DriverProvider.quitDriver();
    }

    @Test(dataProvider = "flightSearch", dataProviderClass = ReadData.class)
    public void OneWayFlightSearch(String fromAirport, String toAirport, String departDate, String returnDate, String adult, String child, String infant, String cabin, String trip) {
        SoftAssert softAssert = new SoftAssert();
        FlightSearchPage flightSearchPage = new FlightSearchPage();
        FlightSearchResultPage flightSearchResultPage = new FlightSearchResultPage();
        flightSearchPage.selectTripType(trip);
        reportLog("Trip type selected: " + trip);
        flightSearchPage.enterFromAirport(fromAirport);
        reportLog("From Airport is selected: " + fromAirport);
        flightSearchPage.enterToAirport(toAirport);
        reportLog("To Airport is selected: " + toAirport);
        flightSearchPage.selectDepartDate(departDate);
        reportLog("Depart Date is selected: " + departDate);
        flightSearchPage.selectDirectFlight();
        flightSearchPage.selectNumberOfPassenger(adult, child, infant);
        reportLog("Passenger is selected:\n" + "Adult: " + adult + " child: " + child + " infant: " + infant);
        flightSearchPage.selectCabinType(cabin);
        reportLog("Cabin Type is selected: " + cabin);
        flightSearchPage.clickFlightSearch();

        String fromAirportInResult = flightSearchResultPage.getFromAirport();
        softAssert.assertTrue(fromAirportInResult.contains(fromAirport), "From airport in search page and Search result page not match");

        String toAirportInResult = flightSearchResultPage.getToAirport();
        softAssert.assertTrue(toAirportInResult.contains(toAirport), "To airport in search page and Search result page not match");

        String tripType = flightSearchResultPage.getActiveTripType();
        softAssert.assertEquals(tripType, trip, "Trip Type in search page and Search result page not match");
        System.out.println("Trip type: " + tripType);
        String departDateInResult = flightSearchResultPage.getDepartDate();
        String[] departDates = departDateInResult.split(" ");
        softAssert.assertTrue(departDate.contains(departDates[1]), "Depart departDate in search page and Search result page not match");
        softAssert.assertTrue(departDate.contains(departDates[2]), "Depart month in search page and Search result page not match");
        softAssert.assertTrue(departDate.contains(departDates[3]), "Depart year in search page and Search result page not match");

        String cabinTypeInResult = flightSearchResultPage.getCabinType();
        softAssert.assertEquals(cabinTypeInResult, cabin, "Cabin Type in search page and Search result page not match");

        HashMap<String, String> passengerCount = flightSearchResultPage.getAllPassengerCount();
        int total_passenger = Integer.parseInt(adult) + Integer.parseInt(child) + Integer.parseInt(infant);
        softAssert.assertEquals(passengerCount.get("adult"), adult, "adult passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("child"), child, "child passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("infant"), infant, "infant passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("total_passenger").split(" ")[0], Integer.toString(total_passenger), "Total passenger in search page and Search result page not match");

        softAssert.assertAll();
    }

    @Test(dataProvider = "flightSearch", dataProviderClass = ReadData.class)
    public void RoundTripFlightSearch(String fromAirport, String toAirport, String departDate, String returnDate, String adult, String child, String infant, String cabin, String trip) {
        SoftAssert softAssert = new SoftAssert();
        FlightSearchPage flightSearchPage = new FlightSearchPage();
        FlightSearchResultPage flightSearchResultPage = new FlightSearchResultPage();

        flightSearchPage.selectTripType(trip);
        reportLog("Trip type selected: " + trip);
        flightSearchPage.enterFromAirport(fromAirport);
        reportLog("From Airport is selected: " + fromAirport);
        flightSearchPage.enterToAirport(toAirport);
        reportLog("To Airport is selected: " + toAirport);
        flightSearchPage.selectDepartDate(departDate);
        reportLog("Depart Date is selected: " + departDate);
        flightSearchPage.selectReturnDate(returnDate);
        reportLog("Return Date is selected: " + returnDate);
        flightSearchPage.selectNumberOfPassenger(adult, child, infant);
        reportLog("Passenger is selected:\n" + "Adult: " + adult + " child: " + child + " infant: " + infant);
        flightSearchPage.selectCabinType(cabin);
        reportLog("Cabin Type is selected: " + cabin);
        flightSearchPage.clickFlightSearch();

        String fromAirportInResult = flightSearchResultPage.getFromAirport();
        softAssert.assertTrue(fromAirportInResult.contains(fromAirport), "From airport in search page and Search result page not match");

        String toAirportInResult = flightSearchResultPage.getToAirport();
        softAssert.assertTrue(toAirportInResult.contains(toAirport), "To airport in search page and Search result page not match");

        String tripType = flightSearchResultPage.getActiveTripType();
        softAssert.assertEquals(tripType, trip, "Trip Type in search page and Search result page not match");
        String departDateInResult = flightSearchResultPage.getDepartDate();
        String[] departDates = departDateInResult.split(" ");
        softAssert.assertTrue(departDate.contains(departDates[1]), "Depart date in search page and Search result page not match");
        softAssert.assertTrue(departDate.contains(departDates[2]), "Depart month in search page and Search result page not match");
        softAssert.assertTrue(departDate.contains(departDates[3]), "Depart year in search page and Search result page not match");

        String returnDateInResult = flightSearchResultPage.getReturnDate();
        String[] returnDates = returnDateInResult.split(" ");
        softAssert.assertTrue(returnDate.contains(returnDates[1]), "Return date in search page and Search result page not match");
        softAssert.assertTrue(returnDate.contains(returnDates[2]), "Return month in search page and Search result page not match");
        softAssert.assertTrue(returnDate.contains(returnDates[3]), "Return year in search page and Search result page not match");

        String cabinTypeInResult = flightSearchResultPage.getCabinType();
        softAssert.assertEquals(cabinTypeInResult, cabin, "Cabin Type in search page and Search result page not match");

        HashMap<String, String> passengerCount = flightSearchResultPage.getAllPassengerCount();
        int total_passenger = Integer.parseInt(adult) + Integer.parseInt(child) + Integer.parseInt(infant);
        softAssert.assertEquals(passengerCount.get("adult"), adult, "adult passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("child"), child, "child passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("infant"), infant, "infant passenger in search page and Search result page not match");
        softAssert.assertEquals(passengerCount.get("total_passenger").split(" ")[0], Integer.toString(total_passenger), "Total passenger in search page and Search result page not match");

        softAssert.assertAll();
    }
}
