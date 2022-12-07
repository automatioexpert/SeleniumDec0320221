/**
 * 
 */
package httpClientAPIs;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * @author anand acharya
 *
 */
public class BasicAuthHandle {

	@Test
	public void basicAuthHandleTest() {

		CredentialsProvider creds = new BasicCredentialsProvider();
		
		creds.setCredentials(new AuthScope("httpbin.org", 80), 
				new UsernamePasswordCredentials("user", "passwd"));
		
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(creds).build();
		
		HttpGet getRequest = new HttpGet("http://httpbin.org/basic-auth/user/passwd");
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(getRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(response.getStatusLine().getStatusCode());
		
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
	
	}
}
