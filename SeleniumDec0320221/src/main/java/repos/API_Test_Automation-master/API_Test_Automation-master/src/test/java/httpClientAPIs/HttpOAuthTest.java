/**
 * 
 */
package httpClientAPIs;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * @author anand acharya
 *
 */
public class HttpOAuthTest {

	public static void twitterApiOAuthTest() {

		String consumerKey = "dfgdfgdfgdfgd";
		String consumerSecret = "shfjshfsjhfkhsjksndfjksdnf";
		String accessToken = "ahfsdhfkjsdhfahflkksfsfsdfsdf";
		String accessTokenSecret = "sdgfksngksngkjsnjedhdgdgg";

		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
		consumer.setTokenWithSecret(accessToken, accessTokenSecret);

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost postRequest = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=Anand");

		try {
			consumer.sign(postRequest);

		} catch (OAuthMessageSignerException e) {
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			e.printStackTrace();
		}

		CloseableHttpResponse response = null;

		try {
			response = httpClient.execute(postRequest);
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

		System.out.println(responseBody);

		// get the tweeet info:
		HttpGet getRequst = new HttpGet("https://api.twitter.com/1.1/statuses/show.json?id=1202261078392131584");
		try {
			consumer.sign(getRequst);
		} catch (OAuthMessageSignerException e) {
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			e.printStackTrace();
		}

		try {
			response = httpClient.execute(getRequst);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(response.getStatusLine().getStatusCode());

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

	}

	public static void main(String[] args) {
		twitterApiOAuthTest();
	}
		
}
