package com.student.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.student.base.TestBase;

public class StudentDeleteTest extends TestBase{

	@Test
	public void deleteStudent() {
		given().when().delete("/101").then().statusCode(204);
	}
}
