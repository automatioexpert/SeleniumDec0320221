package org.qa.sharif.dataproviders;

public enum CountryData {
    RUSSIA("RUSSIA", "RUB"),
    UK("UNITED KINGDOM", "GBP"),
    ROMANIA("ROMANIA", "RON"),
    USA("UNITED STATE", "USD"),
    UKRAINE("UKRAINE", "UAH");
    private final String countryName;
    private final String currency;

    CountryData(String countryName, String currency) {
        this.countryName = countryName;
        this.currency = currency;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrency() {
        return currency;
    }


}
