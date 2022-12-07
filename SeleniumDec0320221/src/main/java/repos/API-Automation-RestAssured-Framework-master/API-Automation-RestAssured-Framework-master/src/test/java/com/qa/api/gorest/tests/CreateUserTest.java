/**
 * 
 */
package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

/**
 * @author anand acharya
 *
 */
@Epic("create user go rest api feature implementation.....")
@Feature("create user api feature....")
public class CreateUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G";
	
	@DataProvider
	public Object[][] getUserData(){
		Object userData[][] = ExcelUtil.getTestData("userdata");
		return userData;
	}
	
	@Description("create a user api test...verify create user from post call....")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "getUserData")
	public void createUserAPIPOSTTest(String firstname, String lastname, String gender, String dob, String email, 
			String phonenumber, String website, String address, String status){
//		User user = new User("andy","downunder","male","01-01-1990","andydownunder@gmail.com","+61-040411425","https://www.downunder.com",
//				"test address Sydney","active");
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorizarion", "Bearer "+token);
		
		User user = new User(firstname, lastname, gender, dob, email, phonenumber, website, address, status);
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null, true, user); //to get obj we need to create pojo class
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println("================================================");
	}
}
