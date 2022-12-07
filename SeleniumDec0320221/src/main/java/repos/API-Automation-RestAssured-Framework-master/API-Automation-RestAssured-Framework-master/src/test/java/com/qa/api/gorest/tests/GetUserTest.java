/**
 * 
 */
package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;


/**
 * @author anand acharya
 *
 */
@Epic("Epic-101: get user go rest api feature implmentation")
@Feature("US - 1009: get user api feature")
public class GetUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G";
	
	@Description("get all users lists api tests...verify all user list from get all...")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority=1)
	public void getAllUserListAPITest(){
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorizarion", "Bearer "+token);
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Description("get all users lists api tests with params...verify all user list from get all...")
	@Severity(SeverityLevel.NORMAL)
	@Test (priority=2)
	public void getUserWithQueryParamsAPITest(){
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorizarion", "Bearer "+token);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("first_name", "John");
		params.put("gender", "male");
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
}
