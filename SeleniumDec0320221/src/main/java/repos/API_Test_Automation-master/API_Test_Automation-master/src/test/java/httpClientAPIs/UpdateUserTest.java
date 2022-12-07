/**
 * 
 */
package httpClientAPIs;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.rest.api.post.User;

/**
 * @author anand acharya
 *
 */
public class UpdateUserTest {

		// create a user -- POST
		// get the user id from the response
		// use the update api and append the user id in url
		// update the pojo with any data
		// hit the put call api
		// get the response from the put api

		@Test
		public void updateUserTest() {

			// create a user -- POST

			CloseableHttpResponse response = null;
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			// 1. create a post request woth URL:
			HttpPost postRequest = new HttpPost("https://gorest.co.in/public-api/users");

			// 2. add headers:
			postRequest.addHeader("Authorization", "Bearer _FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
			postRequest.setHeader("Content-Type", "application/json");
			postRequest.addHeader("accept", "application/json");

			long random = System.currentTimeMillis();
			
			// 3. convert pojo to json string using jackson api (serialization):
			User user = new User("umang", "sharma", "male", "01-01-1990", "umang"+random+"@gmail.com", "99999090",
					"http://www.umang.com", "test address", "active");

			// convert Java pojo to json -- Serialization -- JACKSON API
			ObjectMapper mapper = new ObjectMapper();
			String userJson = null;
			try {
				userJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			System.out.println(userJson);

			StringEntity userEntity = null;
			try {
				userEntity = new StringEntity(userJson);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			// 4. add the json body to the request:
			postRequest.setEntity(userEntity);

			// 5. hit the API/execute the API:

			try {
				response = httpClient.execute(postRequest);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// 6. get the status code:
			System.out.println(response.getStatusLine().getStatusCode());
			// Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

			// 7. get the response body:
			HttpEntity httpEntity = response.getEntity();
			String responseBody = null;
			try {
				responseBody = EntityUtils.toString(httpEntity);
				System.out.println(responseBody);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// ****************************end of post call ********************

			// get the id from the post response:

			Object document = Configuration.defaultConfiguration().jsonProvider().parse(responseBody);
			List<String> result = JsonPath.read(document, "$..id");
			System.out.println("user id is: ==> " + result.get(0));

			String userId = result.get(0);

			// ****************************starting of PUT call ********************

			String putUrl = "https://gorest.co.in/public-api/users/" + userId;

			HttpPut putRequest = new HttpPut(putUrl);

			// add headers:
			putRequest.addHeader("Authorization", "Bearer _FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
			putRequest.setHeader("Content-Type", "application/json");
			putRequest.addHeader("accept", "application/json");

			// update the data/info:
			user.setStatus("inactive");

			// convert Java pojo to json -- Serialization -- JACKSON API
			mapper = new ObjectMapper();
			userJson = null;
			try {
				userJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			System.out.println(userJson);

			userEntity = null;
			try {
				userEntity = new StringEntity(userJson);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			// 4. add the json body to the request:
			putRequest.setEntity(userEntity);

			// 5. hit the API/execute the API:

			try {
				response = httpClient.execute(putRequest);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// 6. get the status code:
			System.out.println(response.getStatusLine().getStatusCode());
			// Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

			// 7. get the response body:
			httpEntity = response.getEntity();
			responseBody = null;
			try {
				responseBody = EntityUtils.toString(httpEntity);
				System.out.println(responseBody);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// get the statuc from the post response:

			document = Configuration.defaultConfiguration().jsonProvider().parse(responseBody);
			result = JsonPath.read(document, "$..status");
			System.out.println("current user status is: ==> " + result.get(0));
			
			String updatedUserStatus = result.get(0);
			
			Assert.assertEquals(updatedUserStatus, user.getStatus());
			

		}
}
