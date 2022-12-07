import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import api_jobs.AppConfig;

public class JSONSchemaValidator {
	
	@Test
	public void getAllJobs() {
		//Response response = RestAssured.get();
		given()
		  .when().get(AppConfig.BASE_URL_JOBS+ "/Jobs")
		  .then()
		  .log()
		  .body().statusCode(200);
		
	}

}
