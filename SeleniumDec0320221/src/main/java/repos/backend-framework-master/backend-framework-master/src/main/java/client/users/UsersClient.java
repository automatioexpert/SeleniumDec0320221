package client.users;

import core.apiEngine.BaseClient;
import core.apiEngine.IRestResponse;
import core.apiEngine.RequestHandler;
import entities.users.*;
import entities.users.endpoints.CreateUserEndPoint;
import entities.users.endpoints.GetUserEndpoint;
import entities.users.endpoints.UpdateUserEndPoint;

import java.util.List;

public class UsersClient extends BaseClient {

    public IRestResponse<UsersResponse> createUser(List<UsersRequest> usersRequest) {
        CreateUserEndPoint createUserEndPoint = new CreateUserEndPoint(usersRequest);
        return new RequestHandler().processAPIRequest(UsersResponse.class, createUserEndPoint);
    }

    public IRestResponse<UsersResponse> updateUser(UsersRequest usersRequest, String userName) {
        UpdateUserEndPoint updateUserEndpoint = new UpdateUserEndPoint(usersRequest, userName);
        return new RequestHandler().processAPIRequest(UsersResponse.class, updateUserEndpoint);
    }

    public IRestResponse<GetUsersResponse> getUser(String userName) {
        GetUserEndpoint getUserEndpoint = new GetUserEndpoint(userName);
        return new RequestHandler().processAPIRequest(GetUsersResponse.class, getUserEndpoint);
    }
}
