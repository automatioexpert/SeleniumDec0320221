package org.qa.sharif.testcases;

import org.qa.sharif.dataproviders.ReadData;
import org.qa.sharif.pageobjectrepisotory.CurrencyExchangeCalculatorPage;
import org.qa.sharif.pageobjectrepisotory.CurrencyTable;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;


public class CurrencyLossTest extends BaseTestClass {
    DecimalFormat df;

    @BeforeClass
    public void createCurrencyPage() {
        currencyExchangeCalculatorPage = new CurrencyExchangeCalculatorPage();
        currencyTable = new CurrencyTable();
        softVerify = new SoftAssert();
        df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
    }

    @Test(dataProvider = "CurrencyLossTest", dataProviderClass = ReadData.class)
    public void verify_Currency_Loss(String currency, String amount) {
        String compareCurrency = "USD";
        if (currency.equalsIgnoreCase(compareCurrency)) {
            compareCurrency = "EUR";
        }
        currencyExchangeCalculatorPage.setSellCurrency(currency);
        reportLog("Currency set successfully :" + currency);
        currencyExchangeCalculatorPage.enterSellAmount(amount);
        reportLog("Amount set successfully :" + amount);

        Assert.assertEquals(df.format(currencyTable.getOtherBankCalculatedLoss("SWEDBANK", compareCurrency)),
                df.format(currencyTable.getOtherBankLoss("SWEDBANK", compareCurrency)),
                "Calculated loss is not matched with Website loss for SWEDBANK"
        );

        Assert.assertEquals(df.format(currencyTable.getOtherBankCalculatedLoss("SEB", compareCurrency)),
                df.format(currencyTable.getOtherBankLoss("SEB", compareCurrency)),
                "Calculated loss is not matched with Website loss for SEB"
        );

        Assert.assertEquals(df.format(currencyTable.getOtherBankCalculatedLoss("CITADELE", compareCurrency)),
                df.format(currencyTable.getOtherBankLoss("CITADELE", compareCurrency)),
                "Calculated loss is not matched with Website loss for CITADELE"
        );

        Assert.assertEquals(df.format(currencyTable.getOtherBankCalculatedLoss("LUMINOR", compareCurrency)),
                df.format(currencyTable.getOtherBankLoss("LUMINOR", compareCurrency)),
                "Calculated loss is not matched with Website loss for LUMINOR"
        );
        softVerify.assertAll();
    }

}
