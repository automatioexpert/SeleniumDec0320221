/**
 * 
 */
package com.rest.api.authentications;

/**
 * @author anand acharya
 *
 */

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2APITest {

	@Test
	public void checkOAuth2_APITest(){
		
		RequestSpecification request = 
				RestAssured
				.given()
					.auth()
						.oauth2("dfgdfgsd6544555"); //from authorization bearer is not required, but from header it is requred
		Response response = request.post("http://coop.apps.symfonycasts.com/api/396/chickens-feed");
		
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	//1. Generate a token at the run time by using token api
	//2. String TokenId from the response
	//3. hit the next api with this token
	
	@Test
	public void getAuth2TokenApiTest(){
		//we need formparameter
		
		RequestSpecification request =
		RestAssured.given()
		 .formParam("client_id","NovAPIApp")
		 .formParam("client_secred", "sdfdssdfgdfgd5451")
		 .formParam("grant_type", "client_credentials");
		 
		 Response response = request.post("http://coop.apps.symfonycasts.com/token");
		
		 System.out.println(response.getStatusCode());
		 System.out.println(response.prettyPrint());
		 
		 String tokenId = response.jsonPath().getString("access_token");
		 System.out.println("API token id is: "+tokenId);
		 
		 //feed chicken APi
		 RequestSpecification request1 = 
					RestAssured
					.given()
						.auth()
							.oauth2(tokenId); //from authorization bearer is not required, but from header it is requred
			Response response1 = request1.post("http://coop.apps.symfonycasts.com/api/396/chickens-feed");
			
			System.out.println(response1.statusCode());
			System.out.println(response1.prettyPrint());
	}
	
}
