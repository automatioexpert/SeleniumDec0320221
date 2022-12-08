package com.AllApiTests;

import com.RestApi.Payload.PayloadHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDeleteUser {


    public PayloadHelper payloadHelper;

    @BeforeClass
    public void init(){

        payloadHelper = new PayloadHelper();



    }
    @Test
    public void DeleteUserTest(){

         payloadHelper.DeleteUser(2);
         System.out.println("User Deletion is Completed.");

}
}
