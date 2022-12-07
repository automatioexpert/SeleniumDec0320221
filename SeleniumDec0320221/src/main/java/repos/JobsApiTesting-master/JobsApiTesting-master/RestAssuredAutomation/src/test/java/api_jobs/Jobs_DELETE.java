package api_jobs;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Jobs_DELETE {
	
	@Test(dataProvider = "getJobData")
	public void deleteJob(String JobId) {
		
		//Specify Base URI
		RestAssured.baseURI = AppConfig.BASE_URL_JOBS;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestparams = new JSONObject();
		
		//Add header to request body stating it is JSON
		httpRequest.header("Content-Type","application/json");
		//Add JSON to the request body
		httpRequest.body(requestparams.toJSONString());
		//DELETE request
		Response response = httpRequest.queryParam("Job Id",JobId).delete("/Jobs");
		
		//Response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:" +responseBody);
		int statuscode = response.getStatusCode();
		System.out.println("Status Code:" +statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	
	@DataProvider(name="getJobData")
	String [][] getJobData() throws IOException{
		
		String jobData[][] = ExcelUtils.getJobData("./Data/TestData.xlsx", "Sheet3");
		return jobData;
		}

}
