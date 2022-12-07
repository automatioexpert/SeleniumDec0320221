package testRunner;

import com.github.javafaker.Faker;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

import java.io.IOException;

public class TestRunner {
    User user;
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String pass = faker.internet().password();
    String mobile = faker.phoneNumber().phoneNumber();
    Integer randomNum = (int)(Math.random() * (9999 - 1000) + 9999);
    String nid = "19" + randomNum;
    String role = "Customer";
   @Test(priority = 3, description = "Login API with valid data")
   public void doLogin() throws IOException, ConfigurationException {
       User user=new User();
       user.callingLoginAPI("salman@grr.la","1234");
       String messageExpected="Login successfully";
       Assert.assertEquals(user.getMessage(),messageExpected);
   }
   @Test(priority = 2, description = "Login API with invalid password")
    public void wrongPass() throws IOException {
       user = new User();
       user.wrongPass("salman@grr.la", "123");
       String expectedMessage = "Password incorrect";
       String actualMessage = user.getMessage();
       Assert.assertTrue(actualMessage.contains(expectedMessage));
   }
    @Test(priority = 1, description = "Login API with invalid email")
    public void wrongEmail() throws IOException {
        user = new User();
        user.wrongEmail("salman.la", "1234");
        String expectedMessage = "User not found";
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test(priority = 4, description = "Showing all created user list")
    public void getUserList() throws IOException {
        user = new User();
        String id = user.callingUserList();
        System.out.println(id);
        Assert.assertEquals(id,String.valueOf(59));
    }
    @Test(priority = 5, description = "Calling User List API with wrong token")
    public void getUserListWithWrongToken() throws IOException {
        user = new User();
        user.userListWithWrongToken();
        String expectedMessage = "Token expired!";
        String actualMessage = user.getMessage();
        Assert.assertTrue(expectedMessage.contains(actualMessage));
    }
    @Test(priority = 6, description = "Calling User List API without token")
    public void getUserListWithoutToken() throws IOException {
        user = new User();
        user.userListWithoutToken();
        String expectedMessage = "No Token Found!";
        String actualMessage = user.getMessage();
        Assert.assertTrue(expectedMessage.contains(actualMessage));
    }
    @Test(priority = 10, description = "Successfully created new user")
    public void createNewUser() throws IOException, ConfigurationException {
      user = new User();
      user.createNewUser(name,email,pass,mobile,nid,role);
      String actualMessage = user.getMessage();
      Assert.assertTrue(actualMessage.contains("User created successfully"));
    }
    @Test(priority = 7, description = "Create new user without name")
    public void createNewUserWithoutOneField() throws IOException, ConfigurationException {
        user = new User();
        user.createNewUserWithoutOneField(email,pass,mobile,nid,role);
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("Field missing"));
    }
    @Test(priority = 8, description = "Create new user without token")
    public void createNewUserWithoutToken() throws IOException, ConfigurationException {
        user = new User();
        user.createNewUserWithoutToken(name,email,pass,mobile,nid,role);
        user.createNewUserWithoutToken(name,email,pass,mobile,nid,role);
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("No Token Found!"));
    }
    @Test(priority = 9, description = "Create new user without secret key")
    public void createNewUserWithoutKey() throws IOException, ConfigurationException {
        user = new User();
        user.createNewUserWithoutKey(name,email,pass,mobile,nid,role);
        user.createNewUserInvalidKey(name,email,pass,mobile,nid,role);
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("key validation failure!"));
    }
    @Test(priority = 11, description = "Search a user by id")
    public void searchUser() throws IOException, ConfigurationException {
        user = new User();
        user.searchUser();
    }
    @Test(priority = 12, description = "Search a user by invalid id")
    public void searchUserInvalidId() throws IOException, ConfigurationException {
        user = new User();
        user.searchUserInvalidId();
        String actualMessage = user.getMessage();
        Assert.assertEquals(actualMessage,null);
    }
    @Test(priority = 13, description = "Search a user by invalid secret key")
    public void searchUserInvalidKey() throws IOException, ConfigurationException {
        user = new User();
        user.searchUserInvalidKey();
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("key validation failure!"));
    }
    @Test(priority = 14, description = "Search a user with invalid token")
    public void searchUserInvalidToken() throws IOException, ConfigurationException {
        user = new User();
        user.searchUserInvalidToken();
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("No Token Found!"));
    }
    @Test(priority = 15, description = "Already created user")
    public void createExistUser() throws IOException {
       user = new User();
       user.createExistUser();
    }
    @Test(priority = 16, description = "Update user phone number")
    public void updatePhoneNumber() throws IOException, ConfigurationException {
        user = new User();
        user.updatePhoneNumber();
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("User updated successfully"));
    }
    @Test(priority = 17, description = "Delete a user by id")
    public void deleteUser() throws IOException, ConfigurationException {
        user = new User();
        user.deleteUser();
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("User deleted successfully"));
    }
    @Test(priority = 18, description = "Deleting a deleted user")
    public void alreadyDeletedUser() throws IOException, ConfigurationException {
        user = new User();
        user.alreadyDeletedUser();
        String actualMessage = user.getMessage();
        Assert.assertTrue(actualMessage.contains("User not found"));
    }
    @Test(priority = 19, description = "Searching a deleted user")
    public void searchDeletedUser() throws IOException, ConfigurationException {
        user = new User();
        user.searchDeletedUser();
        String actualMessage = user.getMessage();
        Assert.assertEquals(actualMessage,null);
    }

}
