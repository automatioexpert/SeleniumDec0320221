package com.AllApiTests;

import com.RestApi.Payload.PayloadHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class TestPostUser {


private PayloadHelper payloadHelper;

@BeforeClass
    public void init(){
    payloadHelper = new PayloadHelper();
}

@Test

    public void testPostCreateUser(){

   String id = payloadHelper.createUser().jsonPath().getString("id");
    System.out.println(id);
    assertNotNull(id,"Person id is not empty");
    String FirstName =payloadHelper.createUser().jsonPath().getString("first_name");
    System.out.println(FirstName);
    String LastName =payloadHelper.createUser().jsonPath().getString("last_name");
    System.out.println(LastName);
    String Avatar =payloadHelper.createUser().jsonPath().getString("avatar");
    System.out.println(Avatar);


}

}
