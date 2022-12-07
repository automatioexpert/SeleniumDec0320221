/**
 * 
 */
package com.rest.api.get;

/**
 * @author anand acharya
 *
 */
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import xmlUtil.XmlParser;

public class GETBDDAPI {

	//REST ASSURED BDD
	/*given()
	when()
	then()
	and()*/
	
	@Test
	public void getAPICircuitTest_1(){
		given().log().all()
		.when().log().all()
		.get("http://ergast.com/api/f1/2017/circuits.json")
		.then().log().all()
			.assertThat()
			.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
	}
	
	@Test
	public void getAPICircuitTest_2(){
		Response response = 
		given().log().all()
		.when().log().all()
		.get("http://ergast.com/api/f1/2017/circuits.json");
		
		int statusCode = response.getStatusCode();
		System.out.println("status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void getAPICircuitTest_contentLength(){
		//multiple assertions example
		RestAssured.baseURI = "http://ergast.com";
		given().log().all()
		.when().log().all()
			.get("/api/f1/2017/circuits.json")
		.then().log().all()
			.assertThat()
				.statusCode(200)
		.and()
			.contentType(ContentType.JSON)
		.and()
			.header("Content-Length", equalTo("4551")); //equalTo coming from hamcrest
	}
	
	@Test
	public void getJsonAPI_VerifyMD5Value(){
		String paramValue = "test";
		String expectedMd5Value = "fddfsgfdg45545";
		
		given().log().all()
			.param("text", paramValue) //query parameter
			//.param 
		.when().log().all()
			.get("http://md5.jsontest.com") //http://md5.jsontest.com?text=test
		.then().log().all()
			.assertThat()
				.body("md5", equalTo(expectedMd5Value));
	}
	
	//2017 = 20 circuits
	//2016 - 21
	//1966 - 9
	
	@DataProvider(name="getCircuitYearData")    //return type of data type is 2 dimesnional object array
	public Object[][] getCircuitYearInfo(){
		return new Object[][]{
			{"2017",20},
			{"2016",21},
			{"1966",9},
		};
	}
	
	@Test(dataProvider="getCircuitYearData")
	public void numberOfCircuitsYearTest(String seasonYear, int circuitNumber){
		given().log().all()
			.pathParam("raceSeason", seasonYear)
		.when().log().all()
			.get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
		.then().log().all()
			.assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(circuitNumber)) ; //reponse will be a collection so hasSize method used
	}
	
	@Test
	public void getUserResponseXml_Test(){
	RestAssured.baseURI = "https://gorest.co.in";
	Response response = given().log().all()
	.contentType("application/json")
	.header("Authorization","Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")
	.header("Accept","application/xml")
	.when().log().all()
	.get("/public-api/users?last_name=Kuhn&first_name=Alvina");

	System.out.println(response.getStatusCode());
	/* System.out.println(response.prettyPrint());

	//getting xml values using XmlPath from restAssured
	XmlPath xmlPath = response.xmlPath();
	String sucessValue = xmlPath.get("response._meta.success");
	System.out.println("successs value is "+sucessValue);
	Assert.assertEquals(sucessValue, "true");
	*/
	String reponseXmlString = response.prettyPrint();
	XmlParser xp = new XmlParser(reponseXmlString);

	String value = xp.getTextContent("//response//_meta/success");
	System.out.println("success value is "+value);
	Assert.assertEquals(value, "true");

	// String id = xp.getTextContent("//result//id");
	// System.out.println("user id value is : "+id);
	//
	}
	
	@Test
	public void novusGetOrderid() {
	//RestAssured.baseURI = "https://novus-rest-staging.it.tpgtelecom.com.au";
	Response response = given().log().all()
	.auth()
	.preemptive()
	.basic("anand.acharya@iinet", "Pass1234")
	.when().log().all()
	.get("https://novus-rest-staging.it.tpgtelecom.com.au/r6-rest-api/rest/customers/1182990745/orders");

	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());
	}
}
