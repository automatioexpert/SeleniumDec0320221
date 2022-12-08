package Auth_Tests;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.RandomString;
import io.restassured.response.Response;

public class AuthFlow_Test {
	
	
	String body = null;
	String token = null;
	String UserToken = null;
	RandomString rs = new RandomString();
	
	
	Properties prop = new Properties();
	
	@BeforeMethod
	public void steup() throws Exception{
	FileInputStream ip = new FileInputStream("./src/main/java/Config/config.properties");
	prop.load(ip);
	
	}
	
@Test(priority = 1, description = "Verify that the client admin registration can be performed successfully.",enabled = true)
	
	public void ClientRegistrationValidation() throws Exception {
		try {

			System.out.println("Connect uri>>>>>> " + prop.getProperty("URI") + "/registerclients");
		JSONObject jobj = new JSONObject();
		
		jobj.put("clientname", rs.getAlphaNumericString(5));
		jobj.put("hostname", "localhost1");
		jobj.put("clientcontact_no", "033");
		jobj.put("clientcontact_email", "asmaka@gmail.com");
		jobj.put("username", "Asma");
		jobj.put("loginid", rs.getAlphaNumericString(5));
		jobj.put("emailid", "abc@gmail.com");
		
		

		
		  
		  Response resp =  given().
			body(jobj.toJSONString()).

			contentType("application/json").
			
		  	when().
				post(prop.getProperty("URI") + "/registerclients").
		 then().statusCode(200).log().all().using().extract().response();
		  
		
	 	 body = resp.getBody().asString();
		System.out.println("Client Registration Response body>>>>>>>> " + body);
		
		}catch(Exception e) {
			
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
		
		
	//	}
		 
		
	}
	
	
	@Test(priority = 2, description = "Verify that the user is able to generate the token" , enabled = true)
	public void gettokenvalidation() {
		
		JSONObject obj = new JSONObject();

	Response resp= 	given().body(body).contentType("application/json").
					when().post(prop.getProperty("URI") +"/gettoken").
					then().statusCode(200).using().extract().response();
	
	token= resp.jsonPath().get("access_token");
	System.out.println("Bearer Token  is >>>>>>> " + token);

	}
	
	
	@Test(priority=3, description= "Verify that the client admin user is able to register new user successfully.",enabled =true)
	public void usercreation() {
		
		JSONObject obj = new JSONObject();
		String loginidforusercreation = rs.getAlphaNumericString(5); 
		System.out.println("Log in id for user creation is >>>>>>>>  "+ loginidforusercreation);
		obj.put("loginid", loginidforusercreation);
		obj.put("username", "testinguser213");
		obj.put("emailid", "bca@abc");
		obj.put("Contact_No", "453373");
	 Response resp1 = given().
			 			body(obj.toJSONString()).
			 			contentType("application/json").
			 			headers("Authorization" , "bearer" + token).
			 			
			 		  when().
			 		  	post(prop.getProperty("URI") +"/registerusers").
			 		  	
			 		  then().
			 		  	statusCode(200).using().extract().response();
	 
	  UserToken = resp1.jsonPath().get("token");
	 
	 System.out.println("The User token generated >>>>>> " + UserToken);
	 
	 
	}
	
	@Test(priority=4,enabled = true, description = "Verify that the newly created user doesnt have any group in it.")
	public void UserGroupDetails() {
		
		
		Response resp1 = given().
	 			
				header("usertoken" , UserToken).
	 			headers("Authorization" , "bearer" + token).
	 			
	 			
	 		  when().
	 		  	post(prop.getProperty("URI") +"/getgroupdetails").
	 		  	
	 		  then().
	 		  	statusCode(442).using().extract().response();
		
		String bodyofGroup = resp1.jsonPath().get("errormsg");
		System.out.println("User Group Response>>>>>>>>>>>> " + bodyofGroup);
		
		Assert.assertEquals("No data found.", bodyofGroup);

	}
	
	@Test(priority = 5, enabled = true, description = "Verify that if an user has dashboard groups it is displayed in response")
	public void DashboardGroupResponseValidation() {
		
		Response resp2 = given().
							header("usertoken" , prop.getProperty("UserToken")).
							headers("Authorization" , "bearer" + prop.getProperty("BearerToken")).
						when().
							post(prop.getProperty("URI") +"/getgroupdetails").
							then().
	  						statusCode(200).using().extract().response();
		
		String bodydetails = resp2.getBody().asString();
		
		System.out.println("Boddetails are >>>>>>>> " + bodydetails);
		
		boolean status = bodydetails.contains("grouplist");
		
		System.out.println("Status is>>>>>>>> " + status);
		Assert.assertTrue(status);
		
		
		
	}
	
	

}
