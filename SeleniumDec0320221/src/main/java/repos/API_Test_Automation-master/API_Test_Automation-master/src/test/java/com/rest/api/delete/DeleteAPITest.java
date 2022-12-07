/**
 * 
 */
package com.rest.api.delete;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/**
 * @author anand acharya
 *
 */
public class DeleteAPITest {

    @Test

    public void delete_user_API_test() {

                   

                    //post --> delete --> get -- assignment

                   

                    RestAssured.baseURI = "https://gorest.co.in";

                    given().log().all()

                                    .headers("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")

                    .when().log().all()

                                    .delete("/public-api/users/1645")

                    .then().log().all()

                                    .assertThat().contentType(ContentType.JSON)

                                    .and()

                                                    .body("result", equalTo(null));

    }
}
