package entities.users.endpoints;

import constant.UsersServiceHost;
import core.apiEngine.HttpMethod;
import core.apiEngine.IServiceEndpoint;
import core.apiEngine.Param;
import core.apiEngine.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GetUserEndpoint implements IServiceEndpoint {
    private String userName;

    public GetUserEndpoint(String userName) {
        this.userName = userName;
    }

    @Override
    public String url() {
        return UsersServiceHost.GET_USER;
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        List<Param> pathParam = new ArrayList<>();
        pathParam.add(new Param("username", this.userName));
        return pathParam;
    }

    @Override
    public List<Param> headers() {
        List<Param> headers = new ArrayList<>();
        headers.add(new Param("Content-Type", "application/json"));
        headers.add(new Param("accept", "application/json"));
        return headers;
    }

    @Override
    public RequestBody body() {
        return null;
    }
}
