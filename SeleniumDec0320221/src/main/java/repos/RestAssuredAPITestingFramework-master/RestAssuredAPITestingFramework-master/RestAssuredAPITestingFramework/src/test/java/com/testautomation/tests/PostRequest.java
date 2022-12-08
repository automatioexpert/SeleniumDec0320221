package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured.*;

import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class PostRequest {

	@Test
	public void positiveTest() {

		// prepare json body
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "test1");
		jsonObject.put("job", "QA");

		// post call
		Response response = RestAssured.given().body(jsonObject.toString()).post("https://reqres.in/api/users");

		// response printing
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println("==============================");
		System.out.println(response.getBody().asString());
		System.out.println("==============================");
		System.out.println(response.getHeaders());

		// verified status code
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	@Test
	public void negativeTest() {

		// prepare json body
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "test1");
		jsonObject.put("job", "QA");

		// post call
		Response response = RestAssured.given().body(jsonObject.toString()).post("https://reqres.in/api/users");

		// response printing
		System.out.println(response.getStatusCode());
		System.out.println("==============================");
		System.out.println(response.getStatusLine());
		System.out.println("==============================");
		System.out.println(response.getBody().asString());
		System.out.println("==============================");
		System.out.println(response.getHeaders());

		// Incorrect response code validating
		Assert.assertEquals(response.getStatusCode(), 400);
	}

}
