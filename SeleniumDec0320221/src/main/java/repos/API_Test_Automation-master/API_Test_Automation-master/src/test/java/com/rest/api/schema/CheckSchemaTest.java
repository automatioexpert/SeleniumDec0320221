/**
 * 
 */
package com.rest.api.schema;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

 

import java.io.File;

 

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

 

import org.testng.annotations.Test;

 

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
/**
 * @author anand acharya
 *
 */
public class CheckSchemaTest {
	@Test

    public void bookingSchemaTest() {

                    RestAssured.baseURI = "https://restful-booker.herokuapp.com";

                    given()

                    .contentType(ContentType.JSON)

                    .body(new File("C:\\Users\\T6415931\\Automation\\ApiTrainingNaveen\\src\\test\\java\\dataFiles\\bookings.json"))

                    .when()

                    .post("/booking")

                    .then()

                    .assertThat()

                    .statusCode(200)

                    .and()

                    .body(matchesJsonSchemaInClasspath("BookingsSchema.json"));

    }

   

    @Test

    public void get_user_API_Schema_Test() {

                    RestAssured.baseURI = "https://gorest.co.in";

                    given()

                    .contentType(ContentType.JSON)

                    .header("Authorization","Bearer _FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k")

                    .when()

                    .get("/public-api/users?first_name=Luz")

                    .then()

                    .assertThat()

                    .statusCode(200)

                    .and()

                    .body(matchesJsonSchemaInClasspath("getUserScehma.json"));

    }


}
