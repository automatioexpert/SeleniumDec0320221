package com.pageobjects;

import com.reporting.ExtentReporting;
import com.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {
    WebDriver driver;
    SeleniumUtils sel;
    ExtentReporting ex;

    public FormsPage(WebDriver driver, SeleniumUtils seleniumHelper, ExtentReporting ex) {
        this.driver = driver;
        this.sel = seleniumHelper;
        this.ex = ex;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = ".main-header")
    private WebElement pageHeader;

    public boolean validateHeader(){
        return pageHeader.getText().equalsIgnoreCase("Forms");
    }
}
