package api_jobs;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.ExcelUtils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restAssured.BaseClass;

public class Jobs_GET{
		
	    @Test
		public void getAllJobs(){
			
	    	//Specify base URI
	    	RestAssured.baseURI = AppConfig.BASE_URL_JOBS;
	    	
			RequestSpecification httpRequest = RestAssured.given(); //Request object
			 
			//Response object
			Response response = httpRequest.request(Method.GET, "/Jobs");
			
			String responseBody = response.body().asString();
			System.out.println("Response Body: " +responseBody);
			//status code validation
			int statuscode = response.getStatusCode();
			System.out.println("Response Status code:"+statuscode);
			Assert.assertEquals(statuscode, 200);
			Assert.assertEquals(responseBody.contains("Sr. SDET"),true);
			assertThat("Json Schema",responseBody.replaceAll("NaN", "0"),JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
			System.out.println("JSON Schema validation passed");	
		}
	   
	}
	

