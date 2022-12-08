package com.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reporting.ExtentReporting;
import com.utils.SeleniumUtils;

public class HomePage {
	
	WebDriver driver;
	SeleniumUtils sel;
	ExtentReporting ex;
	
	public HomePage(WebDriver driver, SeleniumUtils seleniumHelper, ExtentReporting ex) {
		this.driver = driver;
		this.sel = seleniumHelper;
		this.ex = ex;
		PageFactory.initElements(this.driver, this);
	}

	@FindAll({
			@FindBy(css = ".category-cards > div")
	})
	private List<WebElement> menuOptionsLinks;
	
	public void navigateToMenusPage(String menuName) throws IOException {
		for(WebElement menu : menuOptionsLinks) {
			if (menu.getText().contains(menuName)) {
				menu.click();
				break;
			}
		}
	}
}
