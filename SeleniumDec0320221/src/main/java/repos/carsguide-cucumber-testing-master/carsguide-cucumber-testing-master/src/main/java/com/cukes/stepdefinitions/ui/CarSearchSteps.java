package com.cukes.stepdefinitions.ui;

import org.automation.utilities.ExplicitWait;

import com.cukes.pages.CarSearchPage;

import io.cucumber.java8.En;
import io.cucumber.java8.StepDefinitionBody.A0;

public class CarSearchSteps implements En {

	private CarSearchPage carSearchPage;

	public CarSearchSteps(CarSearchPage carSearchPage) {
		this.carSearchPage = carSearchPage;
		Then("I select Make as {string}", carSearchPage.make::selectByValue);
		And("I select Model as {string}", this::selectModel);
		And("I select Location as {string}", carSearchPage.location::selectByValue);
		And("I select Price is {string}", carSearchPage.price::selectByVisibleText);
		And("I click on Find My Next Car button", (A0) carSearchPage.search::click);
	}

	private void selectModel(String data) {
		ExplicitWait wait = new ExplicitWait(10, 1000);
		wait.until(driver -> carSearchPage.model.getNumberOfOptions() > 1);
		carSearchPage.model.selectByValue(data);
	}

}