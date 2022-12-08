package com.student.loggingexamples;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.student.base.TestBase;

public class LoggingRequestValues extends TestBase {

	// Log all response headers
	@Test
	public void test001() {
		given().when().get("/1").then().log().headers().statusCode(200);
	}

	// Log all response status
	@Test
	public void test002() {
		given().param("programme", "Computer Science").param("limit", 2).when().get("/list").then().log().status()
				.statusCode(200);
	}

	// Log all response body when there is an error
	@Test
	public void test003() {
		given().param("programme", "Computer Science").param("limit", 2).when().get("/list").then().log().ifError()
				.statusCode(200);
	}
}
