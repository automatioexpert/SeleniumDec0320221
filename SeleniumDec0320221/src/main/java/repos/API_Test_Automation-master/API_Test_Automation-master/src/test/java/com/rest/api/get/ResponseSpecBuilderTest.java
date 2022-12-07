/**
 * 
 */
package com.rest.api.get;

/**
 * @author anand acharya
 *
 */
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ResponseSpecBuilderTest {

	 //t1 t2 t3 t4 t5.... t100 -- 100 test cases. what can be common in all all test cases

    //status code

    //content type

    //header

   

    ResponseSpecBuilder res = new ResponseSpecBuilder();

    ResponseSpecification resSpec_200_OK = res.

                                    expectContentType(ContentType.JSON).

                                    expectStatusCode(200).

                                    expectHeader("Server", "nginx").

                                    build();

   

    ResponseSpecification resSpec_400_BAD_REQUEST = res.

                                    expectContentType(ContentType.JSON).

                                    expectStatusCode(400).

                                    expectHeader("Server", "nginx").

                                    build();

   

    ResponseSpecification resSpec_401_AUTH_FAILED = res.

                                    expectContentType(ContentType.JSON).

                                    expectStatusCode(401).

                                    expectHeader("Server", "nginx").

                                    build();

   

    @Test

    public void ResponseSpecTest() {

                    RestAssured.baseURI = "https://gorest.co.in";

                    given().log().all()

                    .header("Authorization","Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")

                    .when().log().all()

                                    .get("/public-api/users")

                    .then().log().all()

                                    .assertThat()

                                                    .spec(resSpec_200_OK);

    }

   

    @Test

    public void ResponseSpec_AuthFailed_Test() {

                    RestAssured.baseURI = "https://gorest.co.in";

                    given().log().all()

                    .header("Authorization","Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G4654")

                    .when().log().all()

                                    .get("/public-api/users")

                    .then().log().all()

                                    .assertThat()

                                                    .spec(resSpec_401_AUTH_FAILED);

    }
}
