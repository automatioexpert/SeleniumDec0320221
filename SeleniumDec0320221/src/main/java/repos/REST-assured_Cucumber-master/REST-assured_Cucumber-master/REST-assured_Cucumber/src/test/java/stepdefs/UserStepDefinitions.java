package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Then("The status code is (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@Then("I print all the logs on Console")
	public void print_allLogs()
	{
		response.then().log().all();
	}
	
	@And("Response includes the following in any order")
	public void response_contains_in_any_order(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
				//json.body(field.getKey(), hasItems(field.getValue()));   //This can also be used
			}
		}
	}
	
	@Given("I set Headers and Parameters for request")
	public void set_hearders_parameters(DataTable dt)
	{
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			if(StringUtils.isNumeric(list.get(i).get("VALUE"))){
				request=given().param(list.get(i).get("KEY"), Integer.parseInt(list.get(i).get("VALUE")));
			}
			else{
				given().param(list.get(i).get("KEY"), list.get(i).get("VALUE")); 
			}
		}
	}
	
	@Given("User hit the webservice (.*)")
	public void user_hit_the_webservice(String WebServiceURL){
		response = request.when().get(WebServiceURL);
		System.out.println("response: " + response.prettyPrint());
	}
	
	@Then("I convert response in String Format")
	public String get_response_string(String WebServiceURL)
	{
		String	ResponseString = response.toString();
		return ResponseString;
	}
	
	@And("I get cookies")
	public void get_cookies()
	{
		Map<String,String> cookies = response.getCookies();
		for(Map.Entry<String,String> entry:cookies.entrySet())
		{
			System.out.println(entry.getKey()+": "+entry.getValue());	
		}
	}
			
}
		