package org.qa.sharif.commonutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.sharif.driver.DriverProvider;


public class DriverHelper {

    public static void scrollToBottom() {
        WebDriver driver = DriverProvider.getDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void waitForElementVisibility(WebElement element) {
        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, AppConfig.getDefaultElementTimeOut());
        wait.until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForPageJsLoad() {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), AppConfig.getDefaultPageTimeout());
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).
                executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForElementBecomeInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), AppConfig.getDefaultElementTimeOut());
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void pageReload() {
        WebDriver driver = DriverProvider.getDriver();
        driver.navigate().refresh();
    }

}
