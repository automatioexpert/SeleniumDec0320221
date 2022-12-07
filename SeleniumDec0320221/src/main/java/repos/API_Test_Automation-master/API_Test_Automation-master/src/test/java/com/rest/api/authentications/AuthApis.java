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
import io.restassured.authentication.FormAuthConfig;

public class AuthApis {

	//basic auth:
	//username/password
	
    //basic
    //preemptive --> tell server that the credentials are correct and no need of any other verification from server side
    //digest
    //form
    //Oauth1
    //Oauth2
	
	@Test
	public void basic_auth_Preemptive_API_Test(){
		given().log().all()
		.auth()
		.preemptive()
			.basic("admin", "admin")
		.when().log().all()
			.get("http.//the-internet-herokuapp.com/basic_auth")
		.then().log().all()
			.assertThat()
				.statusCode(200);
	}
	
	 @Test

     public void basic_auth_API_Test(){

     given().log().all()

     .auth()

                     .basic("admin", "admin")

                                     .when().log().all()

                                                     .get("http.//the-internet-herokuapp.com/basic_auth")

                                     .then().log().all()

                                                     .assertThat()

                                                                     .statusCode(200);

     }

    

     @Test

     public void basic_auth_digest_API_Test(){

     given().log().all()

     .auth()

                     .digest("admin", "admin") //with send the username and password in the form of hashing for more secured connection to the server

                                     .when().log().all()

                                                     .get("http.//the-internet-herokuapp.com/basic_auth")

                                     .then().log().all()

                                                     .assertThat()

                                                                     .statusCode(200);

     }

    

     @Test

     public void basic_auth_form_API_Test(){

     given().log().all()

     .auth()

                     .form("admin","admin",new FormAuthConfig("https://classic.crmpro.com/system/authenticate.cfm","username","password"))

                                     .when().log().all()

                                                     .get("https://classic.crmpro.com/system/authenticate.cfm")

                                     .then().log().all()

                                                     .assertThat()

                                                                     .statusCode(200);

     }
	
	//OAuth2.0
	//if you are using
	//1. with header: append your token with Bearer
	//2. with OAuth2.0 method: then no need to add Bearer, just pass the token value
	@Test
	public void OAuth1_API_Test(){
		given().log().all()
			.auth()
				.oauth2("hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")
		.when().log().all()
			.get("https://gorest.co.in/public-api/users")
		.then().log().all()
			.assertThat()
				.statusCode(200);
	}
	
	@Test
	public void OAuth_API_Test_WithAuthHeader(){
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
			.contentType("application/json")
			.header("Authorization","Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")
		.when().log().all()
			.get("/public-api/users?first_name=Elva")
		.then().log().all()
			.statusCode(200)
			.and()
			.header("Server", "nginx");
	}
	
	@Test
	public void OAuth_API_WithTwoQueryParams_API_Test(){
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
			.contentType("application/json")
			.header("Authorization","Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")
			.queryParam("first_name", "John") //same as param
			.queryParam("gender", "female")
		.when()
			.get("/public-api/users")
		.then()
			.statusCode(200)
			.and()
			.header("Server", "nginx");
	}
	
	
}
