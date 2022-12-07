/**
 * 
 */
package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.restassured.response.Response;

/**
 * @author anand acharya
 *
 */
public class GetImgurApiTest {

	Map<Object, Object> tokenMap;
	String accessToken;
	String username;
	String refreshToken;
	
	@BeforeMethod
	public void setUp() {
		tokenMap = Token.getToken();
		accessToken = tokenMap.get("access_token").toString();
		username = tokenMap.get("account_username").toString();
		refreshToken = tokenMap.get("refresh_token").toString();
	}
	
	@Test
	public void getUsernameBlockStatus(){
		Map<String,String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com/", "account/v1/"+username+"/block", authTokenMap, null, true);
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	}
	
	@Test
	public void postImageUploadApiTest(){
		
		Map<String, String> clientIdMap = Token.getClientId();
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("title", "test image");
		formMap.put("description", "this is a test image");
		
		Response response = RestClient.doPost("multipart", "https://api.imgur.com", "/3/upload", clientIdMap, null, true, formMap); //multipart for image upload
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	}
	
}
