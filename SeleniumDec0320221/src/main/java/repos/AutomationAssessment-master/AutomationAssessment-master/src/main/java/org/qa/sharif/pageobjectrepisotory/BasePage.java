package org.qa.sharif.pageobjectrepisotory;

import org.openqa.selenium.support.PageFactory;
import org.qa.sharif.driver.DriverProvider;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverProvider.getDriver(), this);
    }
}
