package org.qa.sharif.testcases;

import org.qa.sharif.dataproviders.CountryData;
import org.qa.sharif.dataproviders.ReadData;
import org.qa.sharif.pageobjectrepisotory.CurrencyExchangeCalculatorPage;
import org.qa.sharif.pageobjectrepisotory.CurrencyTable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CurrencyUpdateTest extends BaseTestClass {

    @BeforeClass
    public void createCurrencyPage() {
        currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyTable = new CurrencyTable();
        softVerify = new SoftAssert();
    }

    @Test(dataProvider = "CountryCurrencyUpdateTest", dataProviderClass = ReadData.class)
    public void verify_Currency_Update_With_Selected_Country(String firstCountry, String secondCountry) {
        float officialRateOfFirstCurrency, officialRateOfSecondCurrency;
        String firstCountryCurrency, secondCountryCurrency;

        currencyExchangeCalculatorPage.selectCountry(CountryData.valueOf(firstCountry).getCountryName());
        reportLog("First country selected successfully from dropdown :" + firstCountry);
        firstCountryCurrency = currencyExchangeCalculatorPage.getSellCurrency();
        softVerify.assertEquals(firstCountryCurrency, CountryData.valueOf(firstCountry).getCurrency());
        reportLog("First Country Currency :" + CountryData.valueOf(firstCountry).getCurrency());
        reportLog("Currency updated to after select first country  :" + firstCountryCurrency);
        officialRateOfFirstCurrency = currencyTable.getOfficialExchangeRateByCurrency(CountryData.USA.getCurrency());
        reportLog("Official rate of first Currency :" + officialRateOfFirstCurrency);

        currencyExchangeCalculatorPage.selectCountry(CountryData.valueOf(secondCountry).getCountryName());
        reportLog("Second country selected successfully from dropdown :" + secondCountry);
        secondCountryCurrency = currencyExchangeCalculatorPage.getSellCurrency();
        softVerify.assertEquals(secondCountryCurrency, CountryData.valueOf(secondCountry).getCurrency());
        reportLog("Second Country Currency :" + CountryData.valueOf(secondCountry).getCurrency());
        reportLog("Currency updated to after select second country  :" + secondCountryCurrency);
        officialRateOfSecondCurrency = currencyTable.getOfficialExchangeRateByCurrency(CountryData.USA.getCurrency());
        reportLog("Official rate of second Currency :" + officialRateOfSecondCurrency);

        softVerify.assertNotEquals(officialRateOfFirstCurrency, officialRateOfSecondCurrency, "Currency rate not updated");
        softVerify.assertAll();
    }
}
