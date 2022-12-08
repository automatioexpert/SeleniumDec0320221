package com.RestApi.Payload;

import com.RestApi.Pojo.PojoModel;
import com.RestApi.Utils.ConfigManager;
import com.RestApi.constants.EndPoints;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class PayloadHelper {


    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");

   // private static final String PORT = ConfigManager.getInstance().getString("port");


    public PayloadHelper(){
        RestAssured.baseURI=BASE_URL;
       // RestAssured.port=Integer.parseInt(PORT);
    }

    public  List<PojoModel> getAllUsers(){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_USERS)
                .andReturn();

        Type type = new TypeReference<List<PojoModel>>(){}.getType();

        List<PojoModel> UserList =  response.as(type);
        return UserList;
    }

    public Response createUser(){

        PojoModel pojoModel = new PojoModel();
        pojoModel.setId(10);
        pojoModel.setFirstName("Ajay");
        pojoModel.setLastName("Prakash");
        pojoModel.setEmail("Ajayp@yahoo.com");
        pojoModel.setAvatar("https://reqres.in/");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(pojoModel)
                .post(EndPoints.POST_USER_DATA)
                .andReturn();

        assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED,"Created");
        return response;

    }
    public Response UpdateUser(){

        PojoModel pojoModel = new PojoModel();
        pojoModel.setId(2);
        pojoModel.setFirstName("Rajesh");
        pojoModel.setLastName("Sharma");
        pojoModel.setEmail("Ajayp@yahoo.com");
        pojoModel.setAvatar("https://reqres.in/");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(pojoModel)
                .post(EndPoints.PATCH_USER_UPDATE)
                .andReturn();

        assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED,"Updated");
        return response;

    }

    public Response DeleteUser(Integer id){



         Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                 .queryParam("id",id)


                .when()
                 .delete(EndPoints.DELETE_USER)
                 .andReturn();
         assertTrue(response.getStatusCode()==  HttpStatus.SC_NO_CONTENT);
         return response;
    }

}
