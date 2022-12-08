package FunctionalTesting;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.util.Assert;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getRequestAutomation {

	@BeforeClass
	public void setUp() {

		RestAssured.baseURI = "https://reqres.in/api/users";
	}

	@Test
	public void getRequest()

	{
		ValidatableResponse getresponse = RestAssured.given().param("page", "2").when().get().then().log().all()
				.statusCode(200).assertThat();

	}

	@Test
	public void postRequest() {
		String jsonString = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}";
		ValidatableResponse postResponse = RestAssured.given().body(jsonString).
				when()
				.post()
				.then()
				.log()
				.all()
				.statusCode(201);
	}

}
