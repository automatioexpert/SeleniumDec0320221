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

public class OAuth1APITest {

	@Test
	public void twitterStatusApi_OAuth1_Test(){
		
		RequestSpecification request = 
		RestAssured
		.given()
			.auth()
				.oauth("sdfdsd54545", "sdfsadfsdf1651", "dsfdsd", "dfssdgdgdf");
		
		Response response = request.post("https://api.twitter.com/1.1/statuses/update.json?status=This is tweet from rest assured");
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
}
