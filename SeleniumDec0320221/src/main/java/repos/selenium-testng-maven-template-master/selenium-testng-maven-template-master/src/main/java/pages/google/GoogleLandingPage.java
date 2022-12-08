package pages.google;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class GoogleLandingPage extends BasePage {

    public GoogleLandingPage(WebDriver driver) {
        super(driver);
    }

    private static final By searchButtonLocator = By.className(".btnK");

    @Step
    public boolean isSearchButtonDisplayed() {
        try {
            driver.findElement(searchButtonLocator).isDisplayed();
            saveFullPageScreenshot(driver);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
