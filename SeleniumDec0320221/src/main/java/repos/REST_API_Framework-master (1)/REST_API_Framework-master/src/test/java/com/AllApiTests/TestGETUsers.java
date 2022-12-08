package com.AllApiTests;

import com.RestApi.Payload.PayloadHelper;
import com.RestApi.Pojo.PojoModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestGETUsers {

    private PayloadHelper payloadHelper;

    @BeforeClass
    public void inti(){
        payloadHelper = new PayloadHelper();
    }

    @Test
    public void testGetAllUsers(){

        List<PojoModel> UserList = payloadHelper.getAllUsers();
        assertNotNull(UserList.toString(),"User List is not empty.");
        assertFalse(UserList.isEmpty(),"User List is not empty.");

    }

}
