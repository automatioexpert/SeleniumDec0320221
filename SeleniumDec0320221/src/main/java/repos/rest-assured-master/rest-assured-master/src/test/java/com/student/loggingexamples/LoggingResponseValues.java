package com.student.loggingexamples;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class LoggingResponseValues extends TestBase {

	// Log all request headers
	@Test
	public void test001() {
		given().log().headers().when().get("/1").then().statusCode(200);
	}

	// Log all request parameters
	@Test
	public void test002() {
		given().param("programme", "Computer Science").param("limit", 2).log().params().when().get("/list").then()
				.statusCode(200);
	}

	// Log the request body
	@Test
	public void test003() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("SQL");

		Student student = new Student();
		student.setFirstName("Nikhil");
		student.setLastName("Krishna");
		student.setEmail("test@test.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).log().body().when().body(student).post().then().statusCode(201);
	}

	// Log all the details
	@Test
	public void test004() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");

		Student student = new Student();
		student.setFirstName("A");
		student.setLastName("B");
		student.setEmail("C@b.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).log().all().when().body(student).post().then().statusCode(201);
	}

	// Log only if validation fails
	@Test
	public void test005() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");

		Student student = new Student();
		student.setFirstName("A");
		student.setLastName("B");
		student.setEmail("C@b.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).log().ifValidationFails().when().body(student).post().then()
				.statusCode(201);
	}
}
