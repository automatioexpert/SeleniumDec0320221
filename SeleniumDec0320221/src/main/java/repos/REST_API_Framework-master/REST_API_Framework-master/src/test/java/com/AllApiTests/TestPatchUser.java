package com.AllApiTests;

import com.RestApi.Payload.PayloadHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPatchUser {


    private PayloadHelper payloadHelper;

    @BeforeClass
    public void init(){

        payloadHelper = new PayloadHelper();
    }

    @Test
    public void testPatch(){

        String id = payloadHelper.UpdateUser().jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id,"Person id is not empty");
        String FirstName =payloadHelper.UpdateUser().jsonPath().getString("first_name");
        System.out.println(FirstName);
        String LastName =payloadHelper.UpdateUser().jsonPath().getString("last_name");
        System.out.println(LastName);
        String Email =payloadHelper.UpdateUser().jsonPath().getString("email");
        System.out.println(Email);
        String Avatar =payloadHelper.UpdateUser().jsonPath().getString("avatar");
        System.out.println(Avatar);
    }
}
