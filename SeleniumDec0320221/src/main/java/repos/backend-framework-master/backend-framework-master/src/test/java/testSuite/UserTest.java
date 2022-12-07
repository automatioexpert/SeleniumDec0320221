package testSuite;

import client.users.UsersClient;
import core.apiEngine.IRestResponse;
import entities.users.GetUsersResponse;
import entities.users.UsersRequest;
import entities.users.UsersResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;


public class UserTest extends BaseTest {

    private UsersClient usersClient;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        this.usersClient = new UsersClient();
    }

    @Test(groups = {"USERS", "P0", "SMOKE"})
    public void userServiceHappyPathTest(ITestContext testContext) {
        //create User
        String userName = faker.name().username();
        Integer id = testHelper.randomNumber(10);
        UsersRequest userRequest = UsersRequest.builder().id(id).username(userName).firstName(faker.name().firstName()).lastName(faker.name().lastName()).email(String.format("%s.%s@dummy.com", faker.name().firstName(), faker.name().lastName())).phone(faker.phoneNumber().cellPhone()).password(faker.name().username()).build();
        List<UsersRequest> userRequestList = List.of(userRequest);
        IRestResponse<UsersResponse> createUserResponse = usersClient.createUser(userRequestList);
        createUserResponse.assertHttpStatusToBe(HttpStatus.SC_OK);

        //verify if user is created
        IRestResponse<GetUsersResponse> getUserResponse = usersClient.getUser(userName);
        getUserResponse.assertHttpStatusToBe(HttpStatus.SC_OK);
        GetUsersResponse getUsersResponse = getUserResponse.getBody();
        Assert.assertEquals(getUsersResponse.getUsername(), userName, String.format("useName  %s is not matching.", userName));
        Assert.assertEquals(getUsersResponse.getId(), id, String.format("id  %s is not matching.", id));

        //update the same user
        String updatedFirstname = "updatedFirstname";
        userRequest.setFirstName(updatedFirstname);
        IRestResponse<UsersResponse> updateUserResponse = usersClient.updateUser(userRequest, userName);
        updateUserResponse.assertHttpStatusToBe(HttpStatus.SC_OK);

        //verify user details got updated
        getUserResponse = usersClient.getUser(userName);
        getUserResponse.assertHttpStatusToBe(HttpStatus.SC_OK);
        getUsersResponse = getUserResponse.getBody();
        Assert.assertEquals(getUsersResponse.getUsername(), userName, String.format("useName  %s is not matching.", userName));
        Assert.assertEquals(getUsersResponse.getId(), id, String.format("id  %s is not matching.", id));
        Assert.assertEquals(getUsersResponse.getFirstName(), updatedFirstname, String.format("id  %s is not matching.", updatedFirstname));
    }

    @Test(groups = {"USERS"})
    public void createUserTest(ITestContext testContext) {
        String userName = faker.name().username();
        testContext.setAttribute("userName", userName);
        UsersRequest userRequest = UsersRequest.builder().id(testHelper.randomNumber(10)).username(userName).firstName(faker.name().firstName()).lastName(faker.name().lastName()).email(String.format("%s.%s@dummy.com", faker.name().firstName(), faker.name().lastName())).phone(faker.phoneNumber().cellPhone()).password(faker.name().username()).build();
        List<UsersRequest> userRequestList = List.of(userRequest);
        IRestResponse<UsersResponse> response = usersClient.createUser(userRequestList);
        response.assertHttpStatusToBe(HttpStatus.SC_OK);
        Assert.assertEquals(response.getBody().getMessage(), "ok", "user was not created getting wrong message.");
    }

    @Test(groups = {"USERS"})
    public void updateUserTest(ITestContext testContext) {
        String userName = faker.name().username();
        UsersRequest userRequest = UsersRequest.builder().id(testHelper.randomNumber(10)).username(userName).firstName(faker.name().firstName()).lastName(faker.name().lastName()).email(String.format("%s.%s@dummy.com", faker.name().firstName(), faker.name().lastName())).phone(faker.phoneNumber().cellPhone()).password(faker.name().username()).build();
        List<UsersRequest> userRequestList = List.of(userRequest);
        IRestResponse<UsersResponse> createUserResponse = usersClient.createUser(userRequestList);
        createUserResponse.assertHttpStatusToBe(HttpStatus.SC_OK);

        userRequest.setFirstName("updatedFirstname");
        IRestResponse<UsersResponse> updateUserResponse = usersClient.updateUser(userRequest, userName);
        updateUserResponse.assertHttpStatusToBe(HttpStatus.SC_OK);
    }

    @Test(groups = {"USERS"})
    public void getUserTest(ITestContext testContext) {
        String userName = faker.name().username();
        Integer id = testHelper.randomNumber(10);
        UsersRequest userRequest = UsersRequest.builder().id(id).username(userName).firstName(faker.name().firstName()).lastName(faker.name().lastName()).email(String.format("%s.%s@dummy.com", faker.name().firstName(), faker.name().lastName())).phone(faker.phoneNumber().cellPhone()).password(faker.name().username()).build();
        List<UsersRequest> userRequestList = List.of(userRequest);
        IRestResponse<UsersResponse> createUserResponse = usersClient.createUser(userRequestList);
        createUserResponse.assertHttpStatusToBe(HttpStatus.SC_OK);

        IRestResponse<GetUsersResponse> getUserResponse = usersClient.getUser(userName);
        getUserResponse.assertHttpStatusToBe(HttpStatus.SC_ACCEPTED);
        GetUsersResponse getUsersResponse = getUserResponse.getBody();
        Assert.assertEquals(getUsersResponse.getUsername(), userName, String.format("useName  %s is not matching.", userName));
        Assert.assertEquals(getUsersResponse.getId(), id, String.format("id  %s is not matching.", id));
    }
}
