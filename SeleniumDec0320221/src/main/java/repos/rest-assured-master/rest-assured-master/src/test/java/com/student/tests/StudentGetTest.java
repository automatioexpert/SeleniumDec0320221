package com.student.tests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.student.base.TestBase;

import io.restassured.response.Response;

public class StudentGetTest extends TestBase{

	@Test
	public void getAllStudentInformationUsingAssertJ() {
		Response response = given().when().get("/list");
		assertThat(response.getStatusCode()).as("verify status code of GET request").isEqualTo(200);
	}
	
	@Test
	public void getAllStudentInformationUsingRestAssured() {
		given().when().get("/list").then().statusCode(200);
	}
	
	@Test
	public void getStudentInfo() {
		given().when().get("/1").then().statusCode(200);
	}
	
	@Test
	public void getStudentsFromCS() {
		given().when().get("/list?programme=Computer Science").then().statusCode(200);
	}
	
	@Test
	public void getTwoStudentsFromCSUsingParam() {
				given()
				.param("programme", "Computer Science")
				.param("limit", 2)
				.when()
				.get("/list")
				.then()
				.statusCode(200);
	}
}
