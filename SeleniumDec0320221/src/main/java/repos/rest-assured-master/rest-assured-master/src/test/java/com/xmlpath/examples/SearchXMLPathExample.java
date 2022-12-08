package com.xmlpath.examples;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.walmart.base.WalmartBase;

import io.restassured.internal.path.xml.NodeChildrenImpl;

public class SearchXMLPathExample extends WalmartBase {

	static final String APIKEY = "nprqvdpf647zfcqmevjbuu9h";

	@Test
	public void extractNumberOfItems() {
		assertThat(given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "xml").when()
				.get("/search").then().extract().path("searchresponse.numItems")).as("check the number of items")
						.isEqualTo("10");

		// Note: searchresponse is the parent tag in XML response

	}

	@Test
	public void extractProductNameOfSpecificItem() {
		assertThat(given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "xml").when()
				.get("/search").then().extract().path("searchresponse.items.item[0].name"))
						.as("check the product name of specific item").isEqualTo("Apple iPod touch 128GB");
	}

	@Test
	public void extractGiftItemsKeyValues() {

		String xml = given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "xml").when()
				.get("/search").asString();
		String giftOptions = with(xml).getString("searchresponse.items.item[0].giftOptions");

		System.out.println(giftOptions);
	}
	
	@Test
	public void extractSizeofItemsList() {
		NodeChildrenImpl val = given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "xml").when()
				.get("/search").then().extract().path("searchresponse.items.item");
		
		assertThat(val.size()).as("check size of item list").isEqualTo(10);
	}
	
	@Test
	public void extractNameOfAllItems() {

		String xml = given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "xml").when()
				.get("/search").asString();
		List<String> names = with(xml).getList("searchresponse.items.item.name");

		Iterator<String> namesIterator = names.iterator();
		while (namesIterator.hasNext()) {
			System.out.println(namesIterator.next());
		}
	}
	
	@Test
	public void extractAllValuesOfSpecificItem() {
		
		String xml = given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "xml").when()
				.get("/search").asString();
		List<String> values = with(xml).getList("searchresponse.items.item.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");

		Iterator<String> valueIterator = values.iterator();
		while (valueIterator.hasNext()) {
			System.out.println(valueIterator.next());
		}
	}
	
	@Test
	public void testDeepSearchXML() {
		
		String xml = given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "xml").when()
				.get("/search").asString();
		List<String> values = with(xml).getList("**.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");

		Iterator<String> valueIterator = values.iterator();
		while (valueIterator.hasNext()) {
			System.out.println(valueIterator.next());
		}
	}
}
