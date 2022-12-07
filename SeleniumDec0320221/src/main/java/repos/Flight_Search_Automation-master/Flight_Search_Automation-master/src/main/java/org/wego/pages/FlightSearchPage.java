package org.wego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.wego.driver.DriverHelper;

public class FlightSearchPage extends BasePage {
    @FindBy(css = "#app")
    private WebElement shadowHostMainPage;
    By shadowHostFlightPage = new By.ByCssSelector("wego-search-form[app-name='flights']");
    By shadowHostFlightSearchContainer = new By.ByCssSelector("wego-flight-search-form[page='home']");
    By shadowHostFlightSearchForm = new By.ByCssSelector("wego-flight-search-form-home[page='home']");
    By oneWayButton = new By.ByCssSelector("button[data-category='oneWay']");
    By roundTripButton = new By.ByCssSelector("button[data-category='return']");
    By multiCityButton = new By.ByCssSelector("button[data-category='multicity']");
    // By multiCityButton = new By.ByCssSelector("button:nth-child(2)");
    By shadowHostFlightLocationPicker = new By.ByCssSelector("wego-location-picker[app-type='flights']");
    By shadowHostFromLocation = new By.ByCssSelector("single-location-picker:nth-child(2)");
    By shadowHostToLocation = new By.ByCssSelector("single-location-picker:nth-child(3)");
    By shadowHostLocationSelector = new By.ByCssSelector("#locationSelector");
    By shadowHostLocationOverlay = new By.ByCssSelector("#locationOverlay");
    By shadowHostLocationInputField = new By.ByCssSelector("wego-selector");
    By inputFromAirport = new By.ByCssSelector("input[placeholder='From']");
    By inputToAirport = new By.ByCssSelector("input[placeholder='to']");
    By shadowHostDatePicker = new By.ByCssSelector("wego-date-picker[app-type='flights']");
    By shadowHostDateSelector = new By.ByCssSelector("wego-date-selectors");
    By shadowHostDepartDate = new By.ByCssSelector("wego-date-selector:nth-child(2)");
    By shadowHostReturnDate = new By.ByCssSelector("wego-date-selector:nth-child(3)");
    By inputDepartDate = new By.ByCssSelector("input[placeholder='Depart']");
    By inputReturnDate = new By.ByCssSelector("input[placeholder='Return']");
    By calenderOverlay = new By.ByCssSelector("calendar-overlay");
    By calenderMonth1 = new By.ByCssSelector("calendar-month:nth-child(1)");
    By calenderMonth2 = new By.ByCssSelector("calendar-month:nth-child(2)");
    By monthName = new By.ByCssSelector(".month");
    By nextMonthButton = new By.ByCssSelector("wego-sprite[class='chevron']");
    By monthDate = new By.ByCssSelector(".days");
    By daysOfMonth = new By.ByCssSelector("div.days i.day");
    By shadowHostDirectFlightCheckBox = new By.ByCssSelector("wego-checkbox.return");
    By directFlightButton = new By.ByCssSelector("#checkbox");

    By shadowHostPassengerDropDown = new By.ByCssSelector("#passengers");
    By passengerDropDownButton = new By.ByCssSelector(".btn");
    By adultPassengerCount = new By.ByCssSelector("div:nth-child(3) > div:nth-child(1) > div:nth-child(4)");
    By adultPassengerIncrementButton = new By.ByCssSelector("#a2");
    By adultPassengerDecrementButton = new By.ByCssSelector("#a1");

    By childPassengerCount = new By.ByCssSelector("div:nth-child(3) > div:nth-child(2) > div:nth-child(4)");
    By childPassengerIncrementButton = new By.ByCssSelector("#c2");
    By childPassengerDecrementButton = new By.ByCssSelector("#c1");

    By infantPassengerCount = new By.ByCssSelector("div:nth-child(3) > div:nth-child(3) > div:nth-child(4)");
    By infantPassengerIncrementButton = new By.ByCssSelector("#i2");
    By infantPassengerDecrementButton = new By.ByCssSelector("#i1");

    By passengerApplyButton = new By.ByCssSelector(".apply-btn");

    By shadowHostCabinPicker = new By.ByCssSelector("cabin-class-picker");
    By cabinPickerButton = new By.ByCssSelector("#arrow");
    By cabinSelector = new By.ByCssSelector("div div.dropdown-item");

    By flightSearChButton = new By.ByCssSelector(".search");


    private SearchContext getFlightSearchForm() {
        // Return FlightContainerShadowRoot
        SearchContext mainShadowRoot = getShadowRootForMainShadowDom(shadowHostMainPage);
        SearchContext shadowRootFlightPage = getShadowDomInsideShadowDom(mainShadowRoot, shadowHostFlightPage);
        SearchContext shadowRootFlightSearchContainer = getShadowDomInsideShadowDom(shadowRootFlightPage, shadowHostFlightSearchContainer);
        return getShadowDomInsideShadowDom(shadowRootFlightSearchContainer, shadowHostFlightSearchForm);
    }

    private SearchContext getFlightLocationForm(String location) {
        //Return the form which contain To and From
        SearchContext shadowRootFlightLocationPicker = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostFlightLocationPicker);
        SearchContext flightLocationRoot = null;
        if (location.equalsIgnoreCase("to")) {
            flightLocationRoot = getShadowDomInsideShadowDom(shadowRootFlightLocationPicker, shadowHostToLocation);
        } else if (location.equalsIgnoreCase("from")) {
            flightLocationRoot = getShadowDomInsideShadowDom(shadowRootFlightLocationPicker, shadowHostFromLocation);
        }
        assert flightLocationRoot != null;
        selectElementInsideShadowDom(flightLocationRoot, shadowHostLocationSelector);
        SearchContext locationOverlay = getShadowDomInsideShadowDom(flightLocationRoot, shadowHostLocationOverlay);
        return getShadowDomInsideShadowDom(locationOverlay, shadowHostLocationInputField);
    }

    private SearchContext getFlightCalenderForm(String dateType) {
        //Return the form which contain To and From
        SearchContext shadowRootDatePicker = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostDatePicker);
        SearchContext shadowRootDateSelector = getShadowDomInsideShadowDom(shadowRootDatePicker, shadowHostDateSelector);
        SearchContext flightDateRoot = null;
        if (dateType.equalsIgnoreCase("depart")) {
            flightDateRoot = getShadowDomInsideShadowDom(shadowRootDateSelector, shadowHostDepartDate);
            selectElementInsideShadowDom(flightDateRoot, inputDepartDate);
        } else if (dateType.equalsIgnoreCase("return")) {
            flightDateRoot = getShadowDomInsideShadowDom(shadowRootDateSelector, shadowHostReturnDate);
        }
        assert flightDateRoot != null;
        return getShadowDomInsideShadowDom(shadowRootDatePicker, calenderOverlay);
    }

    private void selectDate(SearchContext calenderOverlay, String dateOfYear) {
        //dateOfYear is a string of format "date month year"
        SearchContext month = getShadowDomInsideShadowDom(calenderOverlay, calenderMonth1);
        String nameOfMonth = getTextFromElementInsideShadowDom(month, monthName);
        String[] dates = dateOfYear.split(" ");
        String months = dates[1] + " " + dates[2];
        String date = dates[0];
        while (!months.equalsIgnoreCase(nameOfMonth)) {
            selectElementInsideShadowDom(calenderOverlay, nextMonthButton);
            month = getShadowDomInsideShadowDom(calenderOverlay, calenderMonth1);
            nameOfMonth = getTextFromElementInsideShadowDom(month, monthName);
        }
        SearchContext monthElement = getElementInsideShadowDom(month, monthDate);
        selectElementByVisibleTextInsideShadowDom(monthElement, daysOfMonth, date);
    }

    private SearchContext getPassengerSelectionModal() {
        SearchContext shadowRootPassengerDropDown = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostPassengerDropDown);
        selectElementInsideShadowDom(shadowRootPassengerDropDown, passengerDropDownButton);
        return shadowRootPassengerDropDown;
    }

    private void setAdultPassenger(SearchContext passengerRoot, String count) {
        String adultCount = getTextFromElementInsideShadowDom(passengerRoot, adultPassengerCount);
        int adultValue = Integer.parseInt(adultCount);
        int expectedCount = Integer.parseInt(count);
        if (adultValue < expectedCount) {
            while (adultValue < expectedCount) {
                selectElementInsideShadowDom(passengerRoot, adultPassengerIncrementButton);
                adultCount = getTextFromElementInsideShadowDom(passengerRoot, adultPassengerCount);
                adultValue = Integer.parseInt(adultCount);
            }
        } else if (adultValue > expectedCount) {
            while (adultValue > expectedCount) {
                selectElementInsideShadowDom(passengerRoot, adultPassengerDecrementButton);
                adultCount = getTextFromElementInsideShadowDom(passengerRoot, adultPassengerCount);
                adultValue = Integer.parseInt(adultCount);
            }
        }
    }

    private void setChildPassenger(SearchContext passengerRoot, String count) {
        String childCount = getTextFromElementInsideShadowDom(passengerRoot, childPassengerCount);
        int childValue = Integer.parseInt(childCount);
        int expectedCount = Integer.parseInt(count);
        if (childValue < expectedCount) {
            while (childValue < expectedCount) {
                selectElementInsideShadowDom(passengerRoot, childPassengerIncrementButton);
                childCount = getTextFromElementInsideShadowDom(passengerRoot, childPassengerCount);
                childValue = Integer.parseInt(childCount);
            }
        } else if (childValue > expectedCount) {
            while (childValue > expectedCount) {
                selectElementInsideShadowDom(passengerRoot, childPassengerDecrementButton);
                childCount = getTextFromElementInsideShadowDom(passengerRoot, childPassengerCount);
                childValue = Integer.parseInt(childCount);
            }
        }
    }

    private void setInfantPassenger(SearchContext passengerRoot, String count) {
        String infantCount = getTextFromElementInsideShadowDom(passengerRoot, infantPassengerCount);
        int infantValue = Integer.parseInt(infantCount);
        int expectedCount = Integer.parseInt(count);
        if (infantValue < expectedCount) {
            while (infantValue < expectedCount) {
                selectElementInsideShadowDom(passengerRoot, infantPassengerIncrementButton);
                infantCount = getTextFromElementInsideShadowDom(passengerRoot, infantPassengerCount);
                infantValue = Integer.parseInt(infantCount);
            }
        } else if (infantValue > expectedCount) {
            while (infantValue > expectedCount) {
                selectElementInsideShadowDom(passengerRoot, infantPassengerDecrementButton);
                infantCount = getTextFromElementInsideShadowDom(passengerRoot, infantPassengerCount);
                infantValue = Integer.parseInt(infantCount);
            }
        }
    }

    private SearchContext getCabinSelectionModal() {
        SearchContext shadowRootCabinPicker = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostCabinPicker);
        selectElementInsideShadowDom(shadowRootCabinPicker, cabinPickerButton);
        return shadowRootCabinPicker;
    }

    public void selectTripType(String type) {

        if (type.equalsIgnoreCase("One-way")) {
            selectElementInsideShadowDom(getFlightSearchForm(), oneWayButton);
        } else if (type.equalsIgnoreCase("Round-trip")) {
            selectElementInsideShadowDom(getFlightSearchForm(), roundTripButton);
        } else if (type.equalsIgnoreCase("Multi-city")) {
            selectElementInsideShadowDom(getFlightSearchForm(), multiCityButton);
        }

    }

    public void selectDirectFlight() {
        SearchContext shadowRootDirectFlightCheckBox = getShadowDomInsideShadowDom(getFlightSearchForm(), shadowHostDirectFlightCheckBox);
        selectElementInsideShadowDom(shadowRootDirectFlightCheckBox, directFlightButton);
    }

    public void enterFromAirport(String airport) {
        SearchContext flightFromRoot = getFlightLocationForm("From");
        sendKeysElementInsideShadowDom(flightFromRoot, inputFromAirport, airport);
    }

    public void enterToAirport(String airport) {
        SearchContext flightFromRoot = getFlightLocationForm("To");
        sendKeysElementInsideShadowDom(flightFromRoot, inputToAirport, airport);
    }

    public void selectDepartDate(String date) {
        SearchContext departDateOverlay = getFlightCalenderForm("Depart");
        selectDate(departDateOverlay, date);

    }

    public void selectReturnDate(String date) {
        SearchContext departDateOverlay = getFlightCalenderForm("Return");
        selectDate(departDateOverlay, date);
    }

    public void selectNumberOfPassenger(String adult, String child, String infant) {
        SearchContext passengerRoot = getPassengerSelectionModal();
        setAdultPassenger(passengerRoot, adult);
        setChildPassenger(passengerRoot, child);
        setInfantPassenger(passengerRoot, infant);
        selectElementInsideShadowDom(passengerRoot, passengerApplyButton);
    }

    public void selectCabinType(String cabin) {
        SearchContext cabinRoot = getCabinSelectionModal();
        selectElementByVisibleTextInsideShadowDom(cabinRoot, cabinSelector, cabin);
    }

    public void clickFlightSearch() {
        selectElementInsideShadowDom(getFlightSearchForm(), flightSearChButton);
        DriverHelper.moveToChildWindow();
    }
}
