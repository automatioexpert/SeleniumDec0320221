package org.wego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class FlightSearchResultPage extends BasePage {
    @FindBy(css = "#app")
    private WebElement shadowHostMainPage;
    By shadowHostFlightPage = new By.ByCssSelector("wego-search-form[app-name='flights']");
    By shadowHostFlightSearchContainer = new By.ByCssSelector("wego-flight-search-form[page='flights-search']");
    By shadowHostFlightSearchForm = new By.ByCssSelector("wego-flight-search-form-results[page='flights-search']");
    By shadowHostFlightLocationPicker = new By.ByCssSelector("wego-location-picker[app-type='flights']");
    By shadowHostFromLocation = new By.ByCssSelector("single-location-picker:nth-child(2)");
    By shadowHostToLocation = new By.ByCssSelector("single-location-picker:nth-child(3)");
    By shadowHostLocationSelector = new By.ByCssSelector("#locationSelector");
    By activeTripType = new By.ByCssSelector(".active");
    By inputFromAirport = new By.ByCssSelector("input[placeholder='From']");
    By inputToAirport = new By.ByCssSelector("input[placeholder='to']");
    By shadowHostDatePicker = new By.ByCssSelector("wego-date-picker[app-type='flights']");
    By shadowHostDateSelector = new By.ByCssSelector("wego-date-selectors");
    By shadowHostDepartDate = new By.ByCssSelector("wego-date-selector:nth-child(2)");
    By shadowHostReturnDate = new By.ByCssSelector("wego-date-selector:nth-child(3)");
    By inputDepartDate = new By.ByCssSelector("input[placeholder='Depart']");
    By inputReturnDate = new By.ByCssSelector("input[placeholder='Return']");
    By shadowHostCabinPicker = new By.ByCssSelector("cabin-class-picker");
    By cabinClass = new By.ByCssSelector("div:nth-child(2) > div:nth-child(2)");
    By shadowHostPassengerDropDown = new By.ByCssSelector("#passengers");
    By passengerDropDownButton = new By.ByCssSelector(".btn");
    By adultPassengerCount = new By.ByCssSelector("div:nth-child(3) > div:nth-child(1) > div:nth-child(4)");
    By childPassengerCount = new By.ByCssSelector("div:nth-child(3) > div:nth-child(2) > div:nth-child(4)");
    By infantPassengerCount = new By.ByCssSelector("div:nth-child(3) > div:nth-child(3) > div:nth-child(4)");
    By totalPassengerCount = new By.ByCssSelector("div:nth-child(2) > div:nth-child(2)");

    private SearchContext getFlightSearchForm() {
        // Return FlightContainerShadowRoot
        SearchContext mainShadowRoot = getShadowRootForMainShadowDom(shadowHostMainPage);
        SearchContext shadowRootFlightPage = getShadowDomInsideShadowDom(mainShadowRoot, shadowHostFlightPage);
        SearchContext shadowRootFlightSearchContainer = getShadowDomInsideShadowDom(shadowRootFlightPage, shadowHostFlightSearchContainer);
        return getShadowDomInsideShadowDom(shadowRootFlightSearchContainer, shadowHostFlightSearchForm);
    }

    private SearchContext getFlightLocation(String location) {
        //Return the form which contain To and From
        SearchContext shadowRootFlightLocationPicker = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostFlightLocationPicker);
        SearchContext flightLocationRoot = null;
        if (location.equalsIgnoreCase("to")) {
            flightLocationRoot = getShadowDomInsideShadowDom(shadowRootFlightLocationPicker, shadowHostToLocation);
        } else if (location.equalsIgnoreCase("from")) {
            flightLocationRoot = getShadowDomInsideShadowDom(shadowRootFlightLocationPicker, shadowHostFromLocation);
        }
        assert flightLocationRoot != null;
        return getShadowDomInsideShadowDom(flightLocationRoot, shadowHostLocationSelector);

    }

    private SearchContext getFlightCalenderForm(String dateType) {
        //Return the form which contain To and From
        SearchContext shadowRootDatePicker = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostDatePicker);
        SearchContext shadowRootDateSelector = getShadowDomInsideShadowDom(shadowRootDatePicker, shadowHostDateSelector);
        SearchContext flightDateRoot = null;
        if (dateType.equalsIgnoreCase("depart")) {
            flightDateRoot = getShadowDomInsideShadowDom(shadowRootDateSelector, shadowHostDepartDate);
        } else if (dateType.equalsIgnoreCase("return")) {
            flightDateRoot = getShadowDomInsideShadowDom(shadowRootDateSelector, shadowHostReturnDate);
        }
        assert flightDateRoot != null;
        return flightDateRoot;
    }

    private SearchContext getPassengerSelectionModal() {
        SearchContext shadowRootPassengerDropDown = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostPassengerDropDown);
        selectElementInsideShadowDom(shadowRootPassengerDropDown, passengerDropDownButton);
        return shadowRootPassengerDropDown;
    }

    public String getFromAirport() {
        SearchContext locationShadowDom = getFlightLocation("from");
        return getAttributeFromElementInsideShadowDom(locationShadowDom, inputFromAirport, "value");
    }

    public String getToAirport() {
        SearchContext locationShadowDom = getFlightLocation("to");
        return getAttributeFromElementInsideShadowDom(locationShadowDom, inputToAirport, "value");
    }

    public String getActiveTripType() {
        return getTextFromElementInsideShadowDom(getFlightSearchForm(), activeTripType);
    }

    public HashMap<String, String> getAllPassengerCount() {
        HashMap<String, String> result = new HashMap<>();
        SearchContext passengerModalShadowDom = getPassengerSelectionModal();
        result.put("adult", getTextFromElementInsideShadowDom(passengerModalShadowDom, adultPassengerCount));
        result.put("child", getTextFromElementInsideShadowDom(passengerModalShadowDom, childPassengerCount));
        result.put("infant", getTextFromElementInsideShadowDom(passengerModalShadowDom, infantPassengerCount));
        String total = getTextFromElementInsideShadowDom(getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostPassengerDropDown), totalPassengerCount);
        result.put("total_passenger", total);
        return result;
    }

    public String getCabinType() {
        SearchContext shadowRootCabinPicker = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostCabinPicker);
        return getTextFromElementInsideShadowDom(shadowRootCabinPicker, cabinClass);
    }

    public String getDepartDate() {
        SearchContext flightDepartShadowDom = getFlightCalenderForm("Depart");
        return getAttributeFromElementInsideShadowDom(flightDepartShadowDom, inputDepartDate, "value");
    }

    public String getReturnDate() {
        SearchContext flightReturnShadowDom = getFlightCalenderForm("Return");
        return getAttributeFromElementInsideShadowDom(flightReturnShadowDom, inputReturnDate, "value");
    }
}
