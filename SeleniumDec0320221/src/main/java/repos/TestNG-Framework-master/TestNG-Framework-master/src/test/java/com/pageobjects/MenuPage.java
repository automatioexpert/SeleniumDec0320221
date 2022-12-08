package com.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.reporting.ExtentReporting;
import com.utils.SeleniumUtils;

public class MenuPage {

	WebDriver driver;
	SeleniumUtils sel;
	ExtentReporting ex;

	public MenuPage(WebDriver driver, SeleniumUtils seleniumHelper, ExtentReporting ex) {
		this.driver = driver;
		this.sel = seleniumHelper;
		this.ex = ex;
		PageFactory.initElements(this.driver, this);
	}

	// By elements
	public By menuItems(String itemName) {
		return By.xpath("//*[text() = \" " + itemName + " \"]//parent::div[1]/parent::div[@class='detail--wrapper']");
	}

	@FindBy(css = "[class='honest-mt-10 no-address-container'] a")
	public WebElement continueWithoutAnAddressLink;

	@FindBy(css = "[class='navigation--entry login-logout']")
	public WebElement loginButton;

	@FindBy(css = "#address-input")
	public WebElement addressTextBox;

	@FindBy(css = "[class='btn--honest blattgold--form-banner-submit']")
	public WebElement submitAddressButton;

	@FindBy(css = "[class='btn is--primary is--icon-right no--float button']")
	public WebElement addItemsToCartButton;

	@FindBy(id = "jsLoadMethod")
	public WebElement jsLoader;

	@FindBy(css = "[class='alert is--success is--rounded']")
	public WebElement addSucessLabel;

	By extraItems = By.cssSelector("[class='label-text']");

	public WebElement menuNameLabel(String menuName) {
		// \"Mamacita's Burrito Menu\"
		return driver.findElement(By.xpath("//*[text()=\" " + menuName
				+ " \"]/parent::a/parent::form/following-sibling::div[3]/child::form/child::button"));
	}

	public void verifyMenuPage() throws IOException {
		if (sel.isElementPresent(continueWithoutAnAddressLink)) {
			ex.logTestSteps(Status.PASS, "Menu page is opened.");
		} else
			ex.logTestStepWithScreenshot(driver, Status.FAIL, "Menu page is not opened.");
	}

	public void enterStreetAddress(String address) throws IOException, InterruptedException {

		sel.sendKeys(addressTextBox, address);
		sel.clickElement(submitAddressButton);
		sel.waitForElementToBeNotVisible(jsLoader);
		Thread.sleep(8000);
	}

	public void continueWithoutAddress() throws IOException {
		sel.clickElement(continueWithoutAnAddressLink);

		sel.isElementNotPresent(continueWithoutAnAddressLink);
	}

	public void selectMenu(String menuName) throws IOException {
		for (int i = 0; i < 5; i++)
			sel.scrollDown();
		sel.clickElementJS(menuNameLabel(menuName));
	}

	public void selectMenuItems(String items, List<?> extras) throws IOException {

		sel.waitForElementToBeVisible(driver.findElement(menuItems(items)));
		sel.clickElement(menuItems(items));

		List<WebElement> list = sel.getListOfElements(extraItems);
		for (WebElement item : list) {
			sel.scrollElementIntoView(item);
			if (extras.contains(item.getText()))
				sel.clickElement(item);
		}

		sel.clickElement(addItemsToCartButton);

		sel.waitForElementToBeVisible(addSucessLabel);

		if (sel.isElementPresent(addSucessLabel))
			ex.logTestStepWithScreenshot(driver, Status.PASS, "Items added Suceessfully");
		else
			ex.logTestStepWithScreenshot(driver, Status.FAIL, "Items are not added Suceessfully");
	}

}
