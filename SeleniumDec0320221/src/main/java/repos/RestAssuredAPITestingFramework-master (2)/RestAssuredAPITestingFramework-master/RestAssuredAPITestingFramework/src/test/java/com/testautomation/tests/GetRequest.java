package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;

import  io.restassured.RestAssured.*;

import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class GetRequest {

	@Test
	public void positiveTest() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println("==============================");
		System.out.println(response.getBody().asString());
		System.out.println("==============================");
		System.out.println(response.getHeaders());
		
		//verified status code
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//verified status line
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");

		//asserted 7 from json response body
		JSONArray obj=JsonPath.read(response.getBody().asString(),"$.data..id");
		Assert.assertEquals(obj.get(0), 7);

		//asserted email id from json response body

		JSONArray obj2=JsonPath.read(response.getBody().asString(),"$.data..email");
		Assert.assertTrue("michael.lawson@reqres.in".equalsIgnoreCase(obj2.get(0).toString()));


	}

	@Test
	public void negativeTest() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println("==============================");
		System.out.println(response.getStatusLine());
		System.out.println("==============================");
		System.out.println(response.getBody().asString());
		System.out.println("==============================");
		System.out.println(response.getHeaders());
		Assert.assertEquals(response.getStatusCode(), 400);
	}

}
