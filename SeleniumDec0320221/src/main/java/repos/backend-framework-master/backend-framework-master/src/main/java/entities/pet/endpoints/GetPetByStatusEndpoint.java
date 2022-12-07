package entities.pet.endpoints;

import constant.PetServiceHost;
import constant.PetStatus;
import core.apiEngine.HttpMethod;
import core.apiEngine.IServiceEndpoint;
import core.apiEngine.Param;
import core.apiEngine.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GetPetByStatusEndpoint implements IServiceEndpoint {
    private PetStatus petStatus;

    public GetPetByStatusEndpoint(PetStatus petStatus) {
        this.petStatus = petStatus;
    }

    @Override
    public String url() {
        return PetServiceHost.FIND_PET_BY_STATUS;
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        List<Param> queryParam = new ArrayList<>();
        queryParam.add(new Param("status", petStatus.name()));
        return queryParam;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
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
