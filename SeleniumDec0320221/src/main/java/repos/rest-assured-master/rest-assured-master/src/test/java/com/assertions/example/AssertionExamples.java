package com.assertions.example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.walmart.base.WalmartBase;

public class AssertionExamples extends WalmartBase {

	static final String APIKEY = "nprqvdpf647zfcqmevjbuu9h";

	@Test
	public void extractNumberOfItems() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
				.get("/search").then().body("numItems", equalTo(10)); 
	}
	
	@Test
	public void extractQueryValue() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then().body("query", equalTo("ipod")); 
		
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then().body("query", equalToIgnoringCase("IPOD"));
	}
	
	@Test
	public void extractProductNameOfSpecificItem() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then()
		.root("items")
		.body("name", hasItem("Apple iPod touch 128GB")); 
	}
	
	@Test
	public void extractProductNameOfMultipleItems() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then()
		.root("items")
		.body("name", hasItems("Apple iPod touch 128GB","Apple iPod touch 32GB")); 
	}
	
	@Test
	public void extractGiftItemsKeyValues() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then()
		.body("items[0].giftOptions", hasKey("allowGiftWrap")); 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void extractAllValuesOfSpecificItem() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then()
		.body("items.findAll{it.name=='Apple iPod touch 32GB'}", hasItems(hasEntry("name","Apple iPod touch 32GB"))); 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMultipleAssertions() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then()
		.body("items[0].giftOptions", hasKey("allowGiftWrap"))
		.body("items.findAll{it.name=='Apple iPod touch 32GB'}", hasItems(hasEntry("name","Apple iPod touch 32GB")))
		.statusCode(200);
	}
	
	@Test
	public void testLogicalAssertion() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then()
		.body("numItems", equalTo(10))
		.body("numItems", greaterThan(5))
		.body("numItems", lessThan(11))
		.body("numItems", greaterThanOrEqualTo(10))
		.body("numItems", lessThanOrEqualTo(10));
	}
	
	@Test
	public void testSoftAssertion() {
		given().queryParam("query", "ipod").queryParam("apiKey", APIKEY).queryParam("format", "json").when()
		.get("/search").then()
		.body("numItems", equalTo(10)
				,"numItems", greaterThan(15)
				,"numItems", lessThan(9)
				,"numItems", greaterThanOrEqualTo(10)
				,"numItems", lessThanOrEqualTo(10));
	}
}
