package com.cukes.pages;

import org.automation.base.BasePage;
import org.automation.elements.Button;
import org.automation.elements.DropDown;
import org.openqa.selenium.By;

public class CarSearchPage extends BasePage {

	public final DropDown make = new DropDown("Make", By.id("makes"));
	public final DropDown model = new DropDown("Model", By.id("models"));
	public final DropDown location = new DropDown("Location", By.id("locations"));
	public final DropDown price = new DropDown("Price", By.id("priceTo"));
	public final Button search = new Button("Search", By.id("search-submit"));

}
