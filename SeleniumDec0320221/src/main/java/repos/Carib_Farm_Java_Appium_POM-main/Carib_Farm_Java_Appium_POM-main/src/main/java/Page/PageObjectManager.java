package Page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.Arrays;
import java.util.List;

public class PageObjectManager {
    protected WebDriver driver;
    protected Wait wait;
    protected int Timeout = 30;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    private void locatorType(String locatorType){
        String[] locatorTypes = {"id","name","xpath","classname","css","dom","linktext"};

        Assert.assertTrue(Arrays.asList(locatorTypes).contains(locatorType));
    }

    private By getByElement(String locatorType, String locatorName) {
        //locatorType(locatorType);

        if (locatorType.equalsIgnoreCase("ID")) {
            return By.id(locatorName);
        } else if (locatorType.equalsIgnoreCase("NAME")) {
            return By.name(locatorName);
        } else if (locatorType.equalsIgnoreCase("XPATH")) {
            return By.xpath(locatorName);
        } else if (locatorType.equalsIgnoreCase("CLASSNAME")) {
            return By.className(locatorName);
        } else if (locatorType.equalsIgnoreCase("CSSSELECTOR")) {
            return By.cssSelector(locatorName);
        } else if (locatorType.equalsIgnoreCase("LINKTEXT")) {
            return By.linkText(locatorName);
        } else if (locatorType.equalsIgnoreCase("PARTIALLINKTEXT")) {
            return By.partialLinkText(locatorName);
        } else {
            return null;
        }
    }


    /**
     * click an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    protected void clickElement(String locatorType, String locatorName){
        waitElementToBeClickAble(locatorType,locatorName);
        driver.findElement(getByElement(locatorType,locatorName)).click();
    }

    /**
     * click an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    protected boolean isElementDisplayed(String locatorType, String locatorName){
        waitElementToBeClickAble(locatorType,locatorName);
        return driver.findElement(getByElement(locatorType,locatorName)).isDisplayed();
    }

    /**
     * type an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     * @param input
     */
    protected void SendKeysToInputField(String locatorType, String locatorName, String input){
        By by  = getByElement(locatorType,locatorName);
        driver.findElement(by).sendKeys(input);
    }

    /**
     *
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    protected void waitElementToBeClickAble(final String locatorType, final String locatorName) {
        wait = new WebDriverWait(driver,Timeout);
        wait.until(ExpectedConditions.elementToBeClickable(getByElement(locatorType,locatorName)));
    }

    /**
     * click an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    protected List<MobileElement> getListOfElements(String locatorType, String locatorName){
        waitElementToBeClickAble(locatorType,locatorName);
        return driver.findElements(getByElement(locatorType,locatorName));
    }

    /**
     * click an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    protected MobileElement getElement(String locatorType, String locatorName){
        waitElementToBeClickAble(locatorType,locatorName);
        return driver.findElement(getByElement(locatorType,locatorName));
    }


    protected String getTextString(String locatorType, String locatorName){
        return driver.findElement(getByElement(locatorType,locatorName)).getText();
    }
}
