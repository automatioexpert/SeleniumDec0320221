package api_jobs;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import Utils.ExcelUtils;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Jobs_POST {
	
	
	@Test(dataProvider = "getJobData")
	public void createJob(String jobId, String jobTitle, String jobLocation, String jobCompanyName, String jobType, String jobPostedTime, String jobDescription) {
		
		//Specify Base URI
		RestAssured.baseURI = AppConfig.BASE_URL_JOBS;
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("Job Id", jobId);
		requestparams.put("Job Title", jobTitle );
		requestparams.put("Job Location", jobLocation);
		requestparams.put("Job Company Name", jobCompanyName);
		requestparams.put("Job Type",jobType);
		requestparams.put("Job Posted time",jobPostedTime);
		requestparams.put("Job Description",jobDescription);
		//Add header to request body stating it is JSON
		httpRequest.header("Content-Type","application/json");
		//Add JSON to the request body
		httpRequest.body(requestparams.toJSONString());
		//POST request
		Response response = httpRequest.request(Method.POST, "/Jobs");
		
		//Response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " +responseBody);
	      
		System.out.println("job title:" +responseBody.contains(jobTitle));
		
		//Assertions to check if response body contains request body fields
		Assert.assertEquals(responseBody.contains(jobTitle), true);	
		Assert.assertEquals(responseBody.contains(jobLocation), true);
		Assert.assertEquals(responseBody.contains(jobCompanyName), true);
		Assert.assertEquals(responseBody.contains(jobType), true);
		Assert.assertEquals(responseBody.contains(jobPostedTime), true);
		Assert.assertEquals(responseBody.contains(jobDescription), true);
		
		//Fetch the status code from response and assert if it is equal to 200 ok
		int statuscode = response.getStatusCode();
		System.out.println("Status Code:" +statuscode);
		Assert.assertEquals(statuscode, 200);
		
		assertThat("Json Schema",responseBody.replaceAll("NaN", "0"),JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		System.out.println("JSON Schema validation passed");	
		
	}
	@DataProvider(name="getJobData")
	public String [][] getJobData() throws IOException{
		
		String jobData[][] = ExcelUtils.getJobData("./Data/TestData.xlsx", "Create");
		return jobData;
		}
	}
