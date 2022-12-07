package org.qa.sharif.pageobjectrepisotory;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.sharif.commonutils.DriverHelper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class CurrencyTable extends BasePage {

    private By officialRateLocator = By.xpath(".//td[2]");
    private By companyAmountLocator = By.xpath(".//td[4]");
    private By swedBankLocator = By.xpath(".//td[5]");
    private By sebBankLocator = By.xpath(".//td[6]");
    private By citadeleLocator = By.xpath(".//td[7]");
    private By luminorLocator = By.xpath(".//td[8]");
    private By otherbankAmountLocator = By.xpath(".//span[@class='ng-binding']");
    private By otherBankLossLocator = By.xpath(".//span[contains(@data-ng-if,'getCommercialRateDifference' )]");

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> currencyTableRow;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement currencyExchangeTableFirstRow;

    public float getOtherBankCalculatedLoss(String bankName, String currencyProvided) {
        float loss = 0;
        loss = getOtherBankAmount(bankName, currencyProvided) - getCompanyAmountByCurrency(currencyProvided);

        return loss;
    }

    public float getOfficialExchangeRateByCurrency(String currencyProvided) {
        float officialRate = 0;
        DriverHelper.waitForPageJsLoad();
        DriverHelper.waitForElementVisibility(currencyExchangeTableFirstRow);
        for (WebElement currencyRow : currencyTableRow) {
            if (currencyRow.getText().contains(currencyProvided)) {
                officialRate = Float.parseFloat(currencyRow.findElement(officialRateLocator).getText());
                break;
            }
        }
        return officialRate;
    }

    public float getCompanyAmountByCurrency(String currencyProvided) {
        float amount = 0;
        DriverHelper.waitForElementVisibility(currencyExchangeTableFirstRow);
        for (WebElement currencyRow : currencyTableRow) {
            if (currencyRow.getText().contains(currencyProvided)) {
                String amountString = currencyRow.findElement(companyAmountLocator).getText();
                try {
                    amount = NumberFormat.getInstance().parse(amountString).floatValue();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return amount;
    }

    public float getOtherBankAmount(String bankName, String currencyProvided) {
        DriverHelper.waitForElementVisibility(currencyExchangeTableFirstRow);
        By bankLocator = getLocatorByBankName(bankName);

        return getBankAmountByLocator(bankLocator, currencyProvided);
    }

    public float getOtherBankLoss(String bankName, String currencyProvided) {
        DriverHelper.waitForElementVisibility(currencyExchangeTableFirstRow);
        By bankLocator = getLocatorByBankName(bankName);

        return getBankLossByLocator(bankLocator, currencyProvided);
    }

    private By getLocatorByBankName(String bankName) {
        By locator;
        switch (bankName.toUpperCase()) {
            case "SWEDBANK":
                locator = swedBankLocator;
                break;
            case "SEB":
                locator = sebBankLocator;
                break;
            case "CITADELE":
                locator = citadeleLocator;
                break;
            case "LUMINOR":
                locator = luminorLocator;
                break;
            default:
                throw new IllegalStateException("Bank is Not Supported : " + bankName.toUpperCase());
        }

        return locator;
    }

    private float getBankAmountByLocator(By locator, String currencyProvided) {
        float amount = 0;
        for (WebElement currencyRow : currencyTableRow) {
            if (currencyRow.getText().contains(currencyProvided)) {
                String amountString = currencyRow.findElement(locator).findElement(otherbankAmountLocator).getText();
                try {
                    amount = NumberFormat.getInstance().parse(amountString).floatValue();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return amount;
    }

    private float getBankLossByLocator(By locator, String currencyProvided) {
        float loss = 0;
        DriverHelper.waitForElementVisibility(currencyExchangeTableFirstRow);
        for (WebElement currencyRow : currencyTableRow) {
            if (currencyRow.getText().contains(currencyProvided)) {
                if (currencyRow.findElement(locator).findElements(otherBankLossLocator).size() != 0) {
                    String lossString = currencyRow.findElement(locator).findElement(otherBankLossLocator).getText();
                    lossString = StringUtils.substringBetween(lossString, "(", ")");
                    try {
                        loss = NumberFormat.getInstance().parse(lossString).floatValue();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
        return loss;
    }

}
