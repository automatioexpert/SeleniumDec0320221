package com.filter.logging.examples;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.student.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FilterExample extends TestBase {

	public static StringWriter requestWriter;
	public static PrintStream requestCapture;

	public static StringWriter responseWriter;
	public static PrintStream responseCapture;

	public static StringWriter errorWriter;
	public static PrintStream errorCapture;

	@BeforeTest
	public void beforeEachTest() {
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter));

		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter));

		errorWriter = new StringWriter();
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter));
	}

	@Test
	public void getStudent() {

		RestAssured.given().filter(new RequestLoggingFilter(requestCapture))
				.filter(new ResponseLoggingFilter(responseCapture)).when().get("/list");

		System.err.println("Request Details:\n" + requestWriter.toString());
		System.err.println("Response Details:\n" + responseWriter.toString());

		// this will log error details only if status code is between 400 and 500.
		// Note: get("/lists") does not exist
		RestAssured.given().filter(new ErrorLoggingFilter(errorCapture)).when().get("/lists");

		System.err.println("Error Details:\n" + responseWriter.toString().toUpperCase());
	}
}
