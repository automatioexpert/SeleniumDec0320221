package com.cukes.pages;

import org.automation.base.BasePage;
import org.automation.elements.Element;
import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {

	public final Element carList = new Element("Car List", By.cssSelector("div.listing-cars"));

	public String getPageTitle() {
		return super.getPageTitle();
	}

}
