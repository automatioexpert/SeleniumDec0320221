/**
 * 
 */
package httpClientAPIs;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

//import io.restassured.path.json.JsonPath;

/**
 * @author anand acharya
 *
 */
public class GetUserAPI {
	
	@Test
	public void GetUserTest(){
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient =  HttpClientBuilder.create().build();
		
		//1. Create the Get request with url
		HttpGet getRequest = new HttpGet("https://gorest.co.in/public-api/users");
		
		//2. add headers
		getRequest.addHeader("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G");
		
		//3. execute the API:
		try {
			response = httpClient.execute(getRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//4. get the status code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//5. get the response body
		String responseBody = null;
		HttpEntity httpEntity = response.getEntity();
		try {
			responseBody = EntityUtils.toString(httpEntity);
			System.out.print(responseBody);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		//get json value using rest assured JsonPath
//		JsonPath js = new JsonPath(responseBody);
//		System.out.println(js.getString("_meta.success"));
		
		//get json value using jayway jsonpath api
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(responseBody);
		List<Boolean> result =  JsonPath.read(document, "$..success");
		System.out.println(result.get(0));
		Assert.assertTrue(result.get(0));
	}
}
