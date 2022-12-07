/**
 * 
 */
package com.qa.api.gorest.restclient;

import java.io.File;
import java.util.Map;

import com.qa.api.gorest.util.TestUtil;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is having all http methods which will call the apis and having generic methods for getting the response
 * and fetch values from the response
 * @author anand acharya
 *
 */
public class RestClient {
	
	//HTTP Methods: GET POST PUT DELETE
	
	/**
	 * This method is used to call GET API
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @return this method is returning reponse from the GET call
	 */
	
	//its a utility so using static and can be called using class name
	public static Response doGet(String contentType, String baseURI, String basePath, 
			Map<String, String> token, Map<String, String> paramsMap, boolean log){  //use hashmap for query parameters as there could be many
		if(setBaseURI(baseURI)){
			RequestSpecification request = createRequest(contentType, token, paramsMap, log);
			return getResponse("GET", request, basePath);
		}
		return null;
	}
	
	/**
	 * This method is used to call POST API
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @param obj
	 * @return this method is returning reponse from the POST call
	 */
	
	@Step("post call with {0} , {1}, {2}, {3}, {4}")
	public static Response doPost(String contentType, String baseURI, String basePath, 
			Map<String, String> token, Map<String, String> paramsMap, boolean log, Object obj){  //use hashmap for query parameters as there could be many
		if(setBaseURI(baseURI)){
			RequestSpecification request = createRequest(contentType, token, paramsMap, log);
			addRequestPayload(request, obj);
			return getResponse("POST", request, basePath);
		}
		return null;
	}
	
	private static void addRequestPayload(RequestSpecification request, Object obj){
		if(obj instanceof Map){
			request.formParams((Map<String, String>)obj);
		} else {
			String jsonPayload = TestUtil.getSerializedJSON(obj);
			request.body(jsonPayload);
		}
	}
	
	private static boolean setBaseURI(String baseURI){
		
		if(baseURI==null || baseURI.isEmpty()){
			System.out.println("Please pass the correct base URI");
			return false;
		}
		try{
			RestAssured.baseURI = baseURI;
			return true;
		} catch(Exception e){
			System.out.print("some exception occured while assigning the base URI with Rest Assured...");
			return false;
		}
	}
	
	//method to create request
	private static RequestSpecification createRequest(String contentType, Map<String, String> token, Map<String, String> paramsMap, boolean log ){
		
		RequestSpecification request; //response of given() is requestspecification
		if(log){
			request = RestAssured.given().log().all();
		}else{
			request = RestAssured.given();
		}
		
		if(token.size()>0){
			//request.header("Authorization", "Bearer "+token);
			request.headers(token);
		}
		
		if(!(paramsMap==null)){
			request.queryParams(paramsMap);
		}
		
		if(contentType!=null){
			if(contentType.equalsIgnoreCase("JSON")){
				request.contentType(ContentType.JSON);
			}
			else if(contentType.equalsIgnoreCase("XML")){
				request.contentType(ContentType.XML);
			}
			else if(contentType.equalsIgnoreCase("TEXT")){
				request.contentType(ContentType.TEXT);
			}
			else if(contentType.equalsIgnoreCase("multipart")){
				request.multiPart("image",new File("C:\\Users\\anand acharya\\Desktop\\TPG.png"));
			}
		}
		return request;
	}
	
	//methods to hit the api
	private static Response getResponse(String httpMethod, RequestSpecification request, String basePath){
		return executeAPI(httpMethod, request, basePath);
	}
	
	private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath){
		Response response = null;
		switch(httpMethod){
		case "GET":
			response = request.get(basePath);
			break;
		case "POST":
			response = request.post(basePath);
			break;
		case "PUT":
			response = request.put(basePath);
			break;
		case "DELETE":
			response = request.delete(basePath);
			break;
			
		default:
			System.out.println("Please pass the correct httpmethod...");
			break;
		}
		return response;
	}
}
