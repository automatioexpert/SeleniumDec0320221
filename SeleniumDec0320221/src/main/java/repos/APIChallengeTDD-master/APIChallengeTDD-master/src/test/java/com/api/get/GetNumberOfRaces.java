/**
 * 
 */
package com.api.get;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author anand acharya
 * code to test the api (TestNg + Java + RestAssured + Data driven approach)
 */
public class GetNumberOfRaces {

	/*** Providing data in the method ***/
	@DataProvider(name="getCircuitYearData")  
	public Object[][] getCircuitYearInfo(){
		return new Object[][]{
			{2017, 20},
			{2016, 21},
			{1966, 9},
			{1950, 8},
		};
	}
	
	/*** Test to call the API and retrieve the response and verify it using BDD approach ***/ 
	@Test(dataProvider="getCircuitYearData")
	public void numberOfCircuitsYearTest(int seasonYear, int circuitNumber){
		given().log().all()
			.pathParam("raceSeason", seasonYear)
		.when().log().all()
			.get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
		.then().log().all()
			.assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(circuitNumber));
	}
	
	/*** Fetching data from the excel file ***/
	@DataProvider(name="getCircuitYearDataExcel")
	public Object[][] getCircuitYearInfoExcel(){
		Object[][] circuitdata = ExcelUtil.readExcel("circuits", 
				System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/TestData.xlsx");
		return circuitdata;
	}
	
	/*** Test to call the API and retrieve the JSON response and verify it using non-BDD approach ***/ 
	@Test(dataProvider="getCircuitYearDataExcel")
	public void numberOfCircuitsYearWithJSONTest(Object seasonYear, Object circuitNumber){
		RestAssured.baseURI = "http://ergast.com";
		RequestSpecification request = RestAssured.given().log().all();
		request.pathParam("raceSeason", seasonYear).log().all();
		Response response = request.get("api/f1/{raceSeason}/circuits.json");
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath js = response.jsonPath();
		Assert.assertEquals(js.getString("MRData.total"), circuitNumber);
	}
	
	/*** Test to call the API and retrieve the XML response and verify it using non-BDD approach ***/ 
	@Test(dataProvider="getCircuitYearDataExcel")
	public void numberOfCircuitsYearWithXMLTest(Object seasonYear, Object circuitNumber){
		RestAssured.baseURI = "http://ergast.com";
		RequestSpecification request = RestAssured.given().log().all();
		request.pathParam("raceSeason", seasonYear).log().all();
		Response response = request.get("api/f1/{raceSeason}/circuits");
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		XmlPath xp = response.xmlPath();
		Assert.assertEquals(xp.getString("MRData.@total"), circuitNumber);
	}
	
}
