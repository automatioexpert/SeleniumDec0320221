package com.testautomation.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.RestAssured;

public class SchemaValidation {

	@Test
	public void schemaValidationTest() {
		// add maven dependency <artifactId>json-schema-validator</artifactId>
		// use to convert json to json schema -
		// https://www.liquid-technologies.com/online-json-to-schema-converter

		//Given
		RestAssured
			.given()
				.baseUri("https://reqres.in/api/users?page=2")
				.contentType(ContentType.JSON)
		
		//When
		.when()
			.get()
		
		//Then
		.then()
			.assertThat()
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidationfile.json"));
	}

}
