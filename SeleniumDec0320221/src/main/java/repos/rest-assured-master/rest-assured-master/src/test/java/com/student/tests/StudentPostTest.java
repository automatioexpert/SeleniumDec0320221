package com.student.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;

public class StudentPostTest extends TestBase {

	@Test
	public void createStudent() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("SQL");

		Student student = new Student();
		student.setFirstName("Nikhil");
		student.setLastName("Krishna");
		student.setEmail("test@test.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).when().body(student).post().then().statusCode(201);
	}

}
