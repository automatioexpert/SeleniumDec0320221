package api_jobs;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import static org.junit.Assert.assertThat;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Jobs_PUT {
	
	
	
	@Test(dataProvider = "getJobData")
	public void updateJob(String jobId, String jobTitle) {
		
		//Specify Base URI
		RestAssured.baseURI = AppConfig.BASE_URL_JOBS;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestparams = new JSONObject();

		//Add header to request body stating it is JSON
		httpRequest.header("Content-Type","application/json");
		//Add JSON to the request body
		httpRequest.body(requestparams.toJSONString());
		
		//PUT request
		Response response = httpRequest.queryParams("Job Id", jobId, "Job Title", jobTitle).put("/Jobs");
		//Response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:" +responseBody);
		Assert.assertEquals(responseBody.contains(jobId), true);
		Assert.assertEquals(responseBody.contains(jobTitle), true);
		
		int statuscode = response.getStatusCode();
		System.out.println("Status Code:" +statuscode);
		Assert.assertEquals(statuscode, 200,"Job not updated succesfully");
		
		assertThat("Json Schema",(responseBody.replaceAll("NaN","0").toString()),JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		System.out.println("JSON Schema validation passed");			
	}
	
	@DataProvider(name="getJobData")
	String [][] getJobData() throws IOException{
		
		String jobData[][] = ExcelUtils.getJobData("./Data/TestData.xlsx", "Update");
		return jobData;
		}

}
