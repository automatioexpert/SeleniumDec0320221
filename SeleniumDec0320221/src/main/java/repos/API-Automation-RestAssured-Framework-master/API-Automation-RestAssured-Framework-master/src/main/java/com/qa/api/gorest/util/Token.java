/**
 * 
 */
package com.qa.api.gorest.util;


/**
 * @author anand acharya
 *
 */

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class Token {

	public static Map<Object, Object> appTokenMap; //will contain both autho and client
	public static Map<String, String> tokenMap = new HashMap<String, String>();
	public static String clientId = "47042fb01139426";
	
	public static Map<Object, Object> getToken(){
		
		Map<String, String> formParams = new HashMap<String, String>();
		formParams.put("refresh_token", "ddef0246a0320d5496ca344e71dc2d6b8b3bddfd");
		formParams.put("client_id", "47042fb01139426");
		formParams.put("client_secret", "1f4234434e3748f56c4e34a9113ada79759c388c");
		formParams.put("grant_type", "refresh_token");
		
		//post call with form data
		JsonPath tokenJson = 
		given()
		.formParams(formParams)
			.when()
				.post("https://api.imgur.com/oauth2/token")
					.then()
						.extract().jsonPath();
		
		System.out.println(tokenJson.getMap("")); //will return entire json respnse body
		
		appTokenMap = tokenJson.getMap("");
		return appTokenMap;
	}
	
	public static Map<String, String> getAuthToken(){
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("Auth token ==> "+authToken);
		tokenMap.put("Authorization", "Bearer "+authToken);
		return tokenMap;
	}
	
	public static Map<String, String> getClientId(){
		System.out.println("Client Id ==> "+clientId);
		tokenMap.put("Authorization", "Client-ID "+clientId);
		return tokenMap;
	}
	
}
