package entities.users.endpoints;

import constant.UsersServiceHost;
import core.apiEngine.HttpMethod;
import core.apiEngine.IServiceEndpoint;
import core.apiEngine.Param;
import core.apiEngine.RequestBody;
import entities.users.UsersRequest;

import java.util.ArrayList;
import java.util.List;

public class UpdateUserEndPoint implements IServiceEndpoint {
    private UsersRequest usersRequest;
    private String userName;

    public UpdateUserEndPoint(UsersRequest usersRequest, String userName) {
        this.usersRequest = usersRequest;
        this.userName = userName;
    }

    @Override
    public String url() {
        return UsersServiceHost.UPDATE_USER;
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        List<Param> pathParams = new ArrayList<>();
        pathParams.add(new Param("username", userName));
        return pathParams;
    }

    @Override
    public List<Param> headers() {
        List<Param> headers = new ArrayList<>();
        headers.add(new Param("Content-Type", "application/json"));
        headers.add(new Param("accept", "application/json"));
        return headers;
    }

    @Override
    public RequestBody<UsersRequest> body() {
        return new RequestBody<>(usersRequest);
    }
}
