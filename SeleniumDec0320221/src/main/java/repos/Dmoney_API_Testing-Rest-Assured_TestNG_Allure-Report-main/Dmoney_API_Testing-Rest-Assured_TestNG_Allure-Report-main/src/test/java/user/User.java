package user;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.NewUserModel;
import model.CreateUserWithoutDataModel;
import model.LoginUser;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;
import utils.Util;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class User extends Setup {

    public User() throws IOException {
        initConfig();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    public void callingLoginAPI(String email, String password) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        LoginUser loginUser = new LoginUser(email, password);
        Response res =
                given().contentType("application/json")
                .body(loginUser)
                .when().post("/user/login")
                .then().assertThat().statusCode(200).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String token = jsonpath.get("token");
        String message = jsonpath.get("message");
        setMessage(message);
        Util.setEnvVariable("TOKEN",token);
    }
    public void wrongPass(String email, String pass) {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        LoginUser loginUser = new LoginUser(email,pass);
        Response res =
                given().contentType("application/json")
                .body(loginUser)
                .when().post("/user/login")
                .then().assertThat().statusCode(401).extract().response();
        JsonPath jsonpath = res.jsonPath();
        String message = jsonpath.get("message");
        setMessage(message);
    }
    public void wrongEmail(String email, String pass) {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        LoginUser loginUser = new LoginUser(email,pass);
        Response res =
                given().contentType("application/json")
                        .body(loginUser)
                        .when().post("/user/login")
                        .then().assertThat().statusCode(404).extract().response();
        JsonPath jsonpath = res.jsonPath();
        String message = jsonpath.get("message");
        setMessage(message);
    }
    public String callingUserList() {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .when().get("/user/list")
                        .then().assertThat().statusCode(200).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String id = jsonpath.get("users[0].id").toString();
        return id;
    }
    public void userListWithWrongToken() {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization","1234")
                        .when().get("/user/list")
                        .then().assertThat().statusCode(403).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String message = jsonpath.get("error.message").toString();
        setMessage(message);
    }
    public void userListWithoutToken() {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization"," ")
                        .when().get("/user/list")
                        .then().assertThat().statusCode(401).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String message = jsonpath.get("error.message").toString();
        setMessage(message);
    }
    public void createNewUser(String name, String email, String pass, String mobile, String nid, String role) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        NewUserModel newUserModel = new NewUserModel(name,email,pass,mobile,nid,role);
        Response res =
                given().contentType("application/json")
                .header("Authorization",prop.getProperty("TOKEN"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey") )
                .body(newUserModel)
                .when().post("/user/create")
                .then().assertThat().statusCode(201).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("message").toString();
        setMessage(actualMessage);
        String id = jsonpath.get("user.id").toString();
        Util.setEnvVariable("id",id);
        System.out.println(actualMessage);
    }

    public void createNewUserWithoutOneField(String email, String pass, String mobile, String nid, String role) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        CreateUserWithoutDataModel missingField = new CreateUserWithoutDataModel(email,pass,mobile,nid,role);
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey") )
                        .body(missingField)
                        .when().post("/user/create")
                        .then().assertThat().statusCode(500).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void createNewUserWithoutToken(String name, String email, String pass, String mobile, String nid, String role) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        NewUserModel newUserModel = new NewUserModel(name,email,pass,mobile,nid,role);
        Response res =
                given().contentType("application/json")
                        .header("Authorization","")
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey") )
                        .body(newUserModel)
                        .when().post("/user/create")
                        .then().assertThat().statusCode(401).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("error.message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void createNewUserInvalidToken(String name, String email, String pass, String mobile, String nid, String role) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        NewUserModel newUserModel = new NewUserModel(name,email,pass,mobile,nid,role);
        Response res =
                given().contentType("application/json")
                        .header("Authorization","token")
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey") )
                        .body(newUserModel)
                        .when().post("/user/create")
                        .then().assertThat().statusCode(401).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("error.message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void createNewUserWithoutKey(String name, String email, String pass, String mobile, String nid, String role) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        NewUserModel newUserModel = new NewUserModel(name,email,pass,mobile,nid,role);
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY","" )
                        .body(newUserModel)
                        .when().post("/user/create")
                        .then().assertThat().statusCode(401).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("error.message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void createNewUserInvalidKey(String name, String email, String pass, String mobile, String nid, String role) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        NewUserModel newUserModel = new NewUserModel(name,email,pass,mobile,nid,role);
        Response res =
                given().contentType("application/json")
                        .header("Authorization","token")
                        .header("X-AUTH-SECRET-KEY","key" )
                        .body(newUserModel)
                        .when().post("/user/create")
                        .then().assertThat().statusCode(401).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("error.message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void searchUser() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey"))
                        .when().get("/user/search?id=" + prop.getProperty("id"))
                        .then().assertThat().statusCode(200).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualId = jsonpath.get("user.id").toString();
        Assert.assertEquals(actualId,prop.getProperty("id"));
        System.out.println(actualId);
    }
    public void searchUserInvalidId() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey"))
                        .when().get("/user/search?id=" + "as")
                        .then().assertThat().statusCode(200).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String user = jsonpath.get("user.id");
        setMessage(user);
        System.out.println(jsonpath.get("user.id") == null);
    }
    public void searchUserInvalidKey() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY", "key")
                        .when().get("/user/search?id=" + prop.getProperty("id"))
                        .then().assertThat().statusCode(401).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("error.message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void searchUserInvalidToken() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization","")
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("pwKey"))
                        .when().get("/user/search?id=" + prop.getProperty("id"))
                        .then().assertThat().statusCode(401).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("error.message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void createExistUser() {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("pwKey"))
                        .body(" {\n" +
                                "    \"id\": 2098,\n" +
                                "    \"name\": \"Herman Cronin\",\n" +
                                "    \"email\": \"Gilbert.Parker@yahoo.com\",\n" +
                                "    \"password\": \"trd1GA8xeCqPE_3\",\n" +
                                "    \"phone_number\": \"01510634863\",\n" +
                                "    \"nid\": \"196810634863\",\n" +
                                "    \"role\": \"Customer\"\n" +
                                "}")
                        .when().post("/user/create")
                        .then().assertThat().statusCode(208).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String message = jsonpath.get("message").toString();
        Assert.assertTrue(message.contains("User already exists"));
        System.out.println(message);
    }
    public void updatePhoneNumber() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey"))
                        .body(" {\n" +
                                "    \"phone_number\": \"01510616050\"\n" +
                                "}")
                        .when().patch("/user/update/" + prop.getProperty("id"))
                        .then().assertThat().statusCode(200).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void deleteUser() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey"))
                        .when().delete("/user/delete/" + prop.getProperty("id"))
                        .then().assertThat().statusCode(200).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void alreadyDeletedUser() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey"))
                        .when().delete("/user/delete/" + prop.getProperty("id"))
                        .then().assertThat().statusCode(404).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String actualMessage = jsonpath.get("message").toString();
        setMessage(actualMessage);
        System.out.println(actualMessage);
    }
    public void searchDeletedUser() {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response res =
                given().contentType("application/json")
                        .header("Authorization",prop.getProperty("TOKEN"))
                        .header("X-AUTH-SECRET-KEY",prop.getProperty("pwKey"))
                        .when().get("/user/search?id=" + prop.getProperty("id"))
                        .then().assertThat().statusCode(200).extract().response();

        JsonPath jsonpath = res.jsonPath();
        String message = jsonpath.get("user");
        setMessage(message);
        System.out.println(message);
    }


    }
