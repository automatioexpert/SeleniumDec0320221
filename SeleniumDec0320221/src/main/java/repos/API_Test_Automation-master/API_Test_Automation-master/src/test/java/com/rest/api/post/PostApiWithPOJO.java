/**
 * 
 */
package com.rest.api.post;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
/**
 * @author anand acharya
 *
 */
public class PostApiWithPOJO {

	  //create a user

    //POST - URL

    //JSON BODY -->

    //USER JAVA CLASS (POJO) --> JSON Object

    //Encapsulation --> private variables --> public(getter and setter methods)

    //POJO -- Plain old Java Object -- Java Class --> private variables --> public(getter and setter methods)

   

    @Test

    public void createUser_with_POJO_Test() {
    	//create a user

        //POST - URL

        //JSON BODY -->

        //USER JAVA CLASS (POJO) --> JSON Object

        //Encapsulation --> private variables --> public(getter and setter methods)

        //POJO -- Plain old Java Object -- Java Class --> private variables --> public(getter and setter methods)


               User user = new User("anand1","achary1","male","02-05-1984","andyforualways@gmail.com","+61-470391500","https://www.abdec.com","7 Findlay Ave NSW 2069","active");

              

               //convert pojo to json -- Serialization -- JACKSON API

  

               ObjectMapper mapper = new ObjectMapper(); //import from jackson
               String userJson = null;
               try {
                      userJson = mapper.writeValueAsString(user);
               } catch (JsonProcessingException e) {
                      e.printStackTrace();
               }

               System.out.println(userJson );

              

               RestAssured.baseURI = "https://gorest.co.in";

               given().log().all()

               .contentType(ContentType.JSON)

               .header("Authorization","Bearer _FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k")

               .body(userJson)

               .when().log().all()

               .post("/public-api/users")

               .then().log().all()

               .assertThat()

               .contentType(ContentType.JSON)

               .and()

               .body("result.first_name",equalTo(user.getfirst_name()))

               .body("result.last_name",equalTo(user.getlast_name()))

               .body("result.status",equalTo(user.getStatus()));

        }
 
}
