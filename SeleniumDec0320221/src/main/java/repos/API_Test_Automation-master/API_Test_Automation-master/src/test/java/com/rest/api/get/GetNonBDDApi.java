/**
 * 
 */
package com.rest.api.get;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Element;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import xmlUtil.XmlParser;

/**
 * @author anand acharya
 *
 */
public class GetNonBDDApi {

	// prepare the request
	// hit the API
	// get the response
	// fetch values from the response

	@Test
	public void getUser_Non_Bdd_Test() {

		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G");
		Response response = request.get("/public-api/users");
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
	}

	@Test
	public void getUser_Non_Bdd_WithQueryParams_Test() {
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G");
		request.queryParam("first_name", "Margie");
		request.queryParam("gender", "female");
		Response response = request.get("/public-api/users");
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
		JsonPath js = response.jsonPath();
		// System.out.println(js.getString("_meta"));
		System.out.println(js.getString("_meta.success"));
		Assert.assertEquals(js.getString("_meta.success"), "true");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Server"), "nginx");

	}

	@Test
	public void getUser_Non_Bdd_HashMap_QueryParams_Test() { // hashmap is
																// collection
																// which stores
																// data in key
																// value pair

		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G");
		Map<String, String> params = new HashMap<String, String>();
		// hashmap is not thread safe ie non synchrnoized ie multiple users can
		// hot at same time
		// hashmap is implementing Map interface
		params.put("first_name", "John");
		params.put("gender", "male");
		request.queryParams(params);
		Response response = request.get("/public-api/users");

		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
	}
	
	@Test
	public void getOrderStatus_Non_BDD_novus() {
	RestAssured.baseURI = "https://novus-rest-staging.it.tpgtelecom.com.au";
	RequestSpecification request = RestAssured.given();
	request.auth().basic("anand.acharya@iinet", "Pass1234");

	Response response = request.get("/r6-rest-api/rest/customers/1182990745/orders");
	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());

	String responseXmlString = response.prettyPrint();
	StringBuilder sb = new StringBuilder(responseXmlString);
	sb.insert(7, ">");
	responseXmlString = sb.toString();

	XmlParser xp = new XmlParser(responseXmlString);

	List<Element> itemsList = xp.getElements("//orderStatusKey[contains(text(),'CANCELLED')]//..//id");
	System.out.println(itemsList.size());

	for(int i=0; i < itemsList.size(); i++) {
	System.out.println(itemsList.get(i).getTextContent());
	}	
 }
	
	@Test
	public void get_post_cancel_order_in_novus(){
//		RestAssured.baseURI = "https://novus-rest-staging.it.tpgtelecom.com.au";
//		RequestSpecification request = RestAssured.given();
//		request.auth().basic("anand.acharya@iinet", "Pass1234");
//
//		Response response = request.get("/r6-rest-api/rest/customers/1182990745/orders");
//		System.out.println(response.getStatusCode());
//		System.out.println(response.prettyPrint());
//
//		String responseXmlString = response.prettyPrint();
//		StringBuilder sb = new StringBuilder(responseXmlString);
//		sb.insert(7, ">");
//		responseXmlString = sb.toString();
		String orderId = null;
		try {
			String responseXmlString = new String(Files.readAllBytes(Paths.get("D:\\Selemuinn\\APITrainingNaveen\\src\\test\\java\\xmlUtil\\sample.xml"))); 
		
		XmlParser xp = new XmlParser(responseXmlString);

		List<Element> itemsList = xp.getElements("//orderStatusKey[contains(text(),'CANCELLED')]//..//id");
		System.out.println(itemsList.size());

		for(int i=0; i < itemsList.size(); i++) {
		System.out.println(itemsList.get(i).getTextContent());
		orderId = itemsList.get(i).getTextContent();
		}
		
		RequestSpecification request1 = RestAssured.given();
		request1.body("{\"billingAccountId\" : \"1183008257\", \"orderId\": \""+orderId+"\"}");
		System.out.println("{\"billingAccountId\" : \"1183008257\", \"orderId\": \""+orderId+"\"}");
		request1.post("https://novus-ui-staging.it.tpgtelecom.com.au/novus-ui/iinet/api/v1/customermanagement/customers/1183008257/orders/"+orderId+"/cancel");
		System.out.println("https://novus-ui-staging.it.tpgtelecom.com.au/novus-ui/iinet/api/v1/customermanagement/customers/1183008257/orders/"+orderId+"/cancel");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
