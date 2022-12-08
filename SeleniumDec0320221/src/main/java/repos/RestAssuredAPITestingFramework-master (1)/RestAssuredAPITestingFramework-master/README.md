# RestAssuredAPITestingFramework
Rest Assured API Testing Framework

## Step1: Use below 2 maven dependency, one for rest assured request and another for deeper verifications of response body 

      <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>4.4.0</version>
        <scope>test</scope>
      </dependency>

      <dependency>
        <groupId>com.jayway.jsonpath</groupId>
        <artifactId>json-path</artifactId>
        <version>2.6.0</version>
      </dependency>

## Step3: Get call url

      RestAssured.get("https://reqres.in/api/users?page=2");
      Assert.assertEquals(response.getStatusCode(), 200);

## Step4: Post call details
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("name", "test1");
      jsonObject.put("job", "QA");

      Response response = RestAssured.given().body(jsonObject.toString()).post("https://reqres.in/api/users");
      Assert.assertEquals(response.getStatusCode(), 201);
      
## Step5: Put call details
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("name", "test1");
      jsonObject.put("job", "QAQA");

      Response response = RestAssured.given()
          .body(jsonObject.toString())
          .put("https://reqres.in/api/users/2");
          
    Assert.assertEquals(response.getStatusCode(), 200);
    
## Step6: Patch request details
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("name", "test1");
      jsonObject.put("job", "QAQA");

      Response response = RestAssured.given()
          .body(jsonObject.toString())
          .patch("https://reqres.in/api/users");
      Assert.assertEquals(response.getStatusCode(), 200);
      
      
## Step7: Delete request details
      JSONObject jsonObj=new JSONObject();

      Response response = RestAssured.given()
          .body(jsonObj.toString())
          .delete("https://reqres.in/api/users/2");
      Assert.assertEquals(response.getStatusCode(), 204);

## End...!!!

#ENJOY!!!

          
          
          
