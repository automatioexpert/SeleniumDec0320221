/**
 # * @author Rajat Verma
 # * https://www.linkedin.com/in/rajat-v-3b0685128/
 # * https://github.com/rajatt95
 # * https://rajatt95.github.io/
 # *
 # * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 # * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)

 # * Code Repository: https://github.com/rajatt95/TestAutomationFramework_UDEMY_OC_Web_Selenium_Java_V2

 # * Document(s): https://github.com/rajatt95/Documents

 # * Learnings from Tutor (Code Repository):
 # *    This course
 # *        https://github.com/stars/rajatt95/lists/udemy-oc-selenium
 # *    Other course(s):
 # *        https://github.com/stars/rajatt95/lists/udemy-omprakash-chavan
 # */

/***************************************************/
package com.learning.pom.api;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder {

	public static Response post(String endPoint, Headers headers,
								HashMap<String, Object> formParams, Cookies cookies) {

		return given(getRequestSpec()).
				headers(headers).
				formParams(formParams).
				cookies(cookies).
		when().
				post(endPoint).
		then().
				spec(getResponseSpec()).
				extract().
				response();
	}

	public static Response get(String endPoint, Cookies cookies) {

		return given(getRequestSpec()).
				cookies(cookies).
		when().
				get(endPoint).
		then().
				spec(getResponseSpec()).
				extract().
				response();
	}
}
