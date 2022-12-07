#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package stepdef;

import com.neovisionaries.ws.client.WebSocketException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.BuilderMessages;
import driver.ChromeDevTools;
import driver.DriverFactory;
import driver.SharedDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.GoogleHomePO;
import pageobject.GoogleSearchPO;

import java.io.IOException;

public class StepDefinition {
	
	private GoogleHomePO ghPO;
	private GoogleSearchPO gsPO;

	public StepDefinition(SharedDriver driver, GoogleHomePO ghPO, GoogleSearchPO gsPO) {
		this.ghPO = ghPO;
		this.gsPO = gsPO;
	}
	
	@Given("estoy en la pagina de busqueda de google")
	public void Go_to_google_page() {
		ghPO.get();
	}
	
	@When("ingreso la palabra {string}")
	public void enter_search(String search){
		ghPO.writeInputSearchBox(search);
	}

	@When("realizo la busqueda")
	public void realizo_la_busqueda(){
		ghPO.submitSearchBox();
	}

	@When("Se pierde la conexion de internet")
	public void se_pierde_la_conexion_de_internet() throws InterruptedException, WebSocketException, IOException {
		ChromeDevTools.sendWSMessage(BuilderMessages.buildNetworkEmulationOffline());
	}

	@When("busco {string}")
	public void busco_string(String search){
		ghPO.performSearch(search);
	}

	@Then("el titulo contiene {string}")
	public void el_titulo_contiene_string(String titulo){
		Assert.assertTrue(gsPO.getTitle().contains(titulo));
	}

	@Then("se muestra la pagina sin conexion")
	public void se_muestra_la_pagina_sin_conexion(){

	}

}
