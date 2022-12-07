package entities.pet.endpoints;

import constant.PetServiceHost;
import core.apiEngine.HttpMethod;
import core.apiEngine.IServiceEndpoint;
import core.apiEngine.Param;
import core.apiEngine.RequestBody;
import entities.pet.PetObj;

import java.util.ArrayList;
import java.util.List;

public class UpdatePetEndpoint implements IServiceEndpoint {
    private PetObj createPetRequest;

    public UpdatePetEndpoint(PetObj createPetRequest) {
        this.createPetRequest = createPetRequest;
    }

    @Override
    public String url() {
        return PetServiceHost.UPDATE_PET;
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
    public RequestBody<PetObj> body() {
        return new RequestBody<>(createPetRequest);
    }
}
