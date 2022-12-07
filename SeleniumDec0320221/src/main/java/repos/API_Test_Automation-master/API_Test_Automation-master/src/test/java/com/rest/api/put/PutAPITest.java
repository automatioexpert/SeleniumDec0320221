/**
 * 
 */
package com.rest.api.put;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.post.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
/**
 * @author anand acharya
 *
 */
public class PutAPITest {

	//Create a user with post call

    //user info

    //update the info with put call

    //Assertion

    //1. other attributes should remain same

    //2. the attribute which has been changed, need to check

   

    @Test

    public void update_user_PUT_API_Test() {

    //1. Create a POST Request with Payload

    User user = new User("harshi","anand","female","02-02-1993","harshi1@gmail.com","+91-9898989780","http://www.harshi.com","al bashra dubai", "active");

   

    //Convert this POJO to JSON -- using JACKSON API - ObjectMapper class

    ObjectMapper mapper = new ObjectMapper();

    String userJson = null;

   

    try {

           userJson = mapper.writeValueAsString(user);

    } catch (JsonProcessingException e) {

           e.printStackTrace();

    }

   

    System.out.println("POST call in JSON is "+userJson);

   

    //write POST Call;

    RestAssured.baseURI = "https://gorest.co.in";

   

    String userId = given()

           .contentType(ContentType.JSON)

           .header("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")

           .body(userJson)

    .when()

           .post("/public-api/users")

    .then()

           .assertThat()

                  .contentType(ContentType.JSON)

                  .extract().path("result.id");

   

    System.out.println("user id is ::> "+userId);

   

    //Call the Put API

    //update the attribute using setter method

    user.setEmail("harshi93@gmail.com");

   

    //Convert this POJO to JSON -- using JACKSON API - ObjectMapper class     

    String updatedUserJson = null;   

    try {

           updatedUserJson = mapper.writeValueAsString(user);

           } catch (JsonProcessingException e) {

                  e.printStackTrace();

           }

   

    given()

           .contentType(ContentType.JSON)

           .header("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")

           .body(updatedUserJson)

    .when()

           .put("/public-api/users/"+userId)

    .then()

           .contentType(ContentType.JSON)

           .and()

                  .body("result.email",equalTo(user.getEmail()))

           .and()

                  .body("result.id", equalTo(userId))

           .and()

                  .body("result.first_name", equalTo(user.getfirst_name()));

                 

    }
}
