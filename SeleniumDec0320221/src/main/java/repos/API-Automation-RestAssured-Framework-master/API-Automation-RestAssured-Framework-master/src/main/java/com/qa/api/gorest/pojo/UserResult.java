/**
 * 
 */
package com.qa.api.gorest.pojo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @author anand acharya
 *use site jsonschema2pojo.org to understand java classes to create (for shortcut). copy paste the payload
 *google json to pojo online
 */
public class UserResult {

	@Test
	public void createUserWithFullJson(){
	String token = "hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G";
	
	Self sf = new Self("https://www.sf.com");
	Edit ed = new Edit("https://www.ed.com");
	Avatar av = new Avatar("https://www.av.com");
	Links ln = new Links(sf, ed, av);
	
	UserInfo uf = new UserInfo("toma", "petera", "male", "09-09-1989", "tom113peter@gmail.com", "9090909090", 
			"http://www.tom12.com", "test_address", "active", ln);
	
	//convert to json using jackson api
	String UserJsonPayload = TestUtil.getSerializedJSON(uf);
	//System.out.println(UserJsonPayload);
	
	Map<String, String> authTokenMap = new HashMap<String, String>();
	authTokenMap.put("Authorization", "Bearer "+token);
//	Response response = RestClient.doPost("JSON", "https://gorest.co.in", "/public-api/users", authTokenMap, null, true, UserJsonPayload);
//	
//	System.out.println(response.getStatusCode());
//	response.prettyPrint();
	
	RestAssured.baseURI = "https://gorest.co.in";
	given().log().all()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")
		.body(UserJsonPayload)
			.post("/public-api/users")
		.then()
		.assertThat()
		.statusCode(200);
	}
	
}
