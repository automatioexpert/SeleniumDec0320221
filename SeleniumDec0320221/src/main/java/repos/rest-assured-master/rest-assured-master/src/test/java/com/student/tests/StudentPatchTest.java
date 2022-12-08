package com.student.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;

public class StudentPatchTest extends TestBase {

	@Test
	public void updateStudent() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");

		Student student = new Student();
		student.setFirstName("Megha");
		student.setLastName("Joseph");
		student.setEmail("newtest@test.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).when().body(student).patch("/101").then().statusCode(200);
	}
}
