/**
 * 
 */
package com.rest.api.post;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

 

import java.io.File;

 

import org.testng.Assert;

import org.testng.annotations.Test;

 

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
/**
 * @author anand acharya
 *
 */
public class PostBDDApi {

	 @Test

     public void tokenPostBDDAPI_JSONSTRING_Test() {

                     RestAssured.baseURI = "https://restful-booker.herokuapp.com";

                     given().log().all()

                                     .contentType(ContentType.JSON)

                                     .body("{\"username\" : \"admin\",\"password\" : \"password123\"}") //not a good practice to pass body

                     .when().log().all()

                                     .post("/auth") //service url

                     .then().log().all()

                                     .assertThat()

                                                     .statusCode(200);

     }

    

     @Test

     public void tokenPostBDDAPI_FILE_TEST() {

                     RestAssured.baseURI = "https://restful-booker.herokuapp.com";

                    

                     String tokenId = given().log().all()

                                     .contentType(ContentType.JSON)

                                     .body(new File("C:\\Users\\T6415931\\Automation\\ApiTrainingNaveen\\src\\test\\java\\dataFiles\\credentials.json"))

                     .when().log().all()

                                     .post("/auth") //service url

                     .then().log().all()

                                     .extract().path("token");  //to extract anything from the response body

                    

                     System.out.println("Token id is "+tokenId);

                     Assert.assertNotNull(tokenId);

     }

    

     @Test

     public void createUser_Post_API_JSONStringTest() {

                     RestAssured.baseURI = "https://gorest.co.in";

//                 Double random = Math.random();

//                 String random1 = random.toString();

                     given().log().all()

                                     .contentType(ContentType.JSON)

                                     .header("Authorization", "Bearer hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G")

                                     .body("{\r\n" +

                                                                     "              \"first_name\" : \"Anand\",\r\n" +

                                                                     "              \"last_name\" : \"Acharya\",\r\n" +

                                                                     "              \"gender\" : \"male\",\r\n" +

                                                                     "              \"dob\" : \"2000-01-12\",\r\n" +

                                                                     "              \"email\" : \"dummy@gmail.com\",\r\n" +

                                                                     "              \"phone\" : \"00-61-0475045456\",\r\n" +

                                                                     "              \"website\" : \"http://www.xyz.com\",\r\n" +

                                                                     "              \"address\" : \"20 dewana street, lovebird\",\r\n" +

                                                                     "              \"status\" : \"active\"\r\n" +

                                                                     "}")

                     .when().log().all()

                                     .post("/public-api/users")

                     .then().log().all()

                                     .assertThat()

                                                     .body("_meta.success", equalTo(true));

     }
}
