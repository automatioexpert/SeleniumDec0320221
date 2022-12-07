package client.pet;

import constant.PetStatus;
import core.apiEngine.BaseClient;
import core.apiEngine.IRestResponse;
import core.apiEngine.RequestHandler;
import entities.pet.PetObj;
import entities.pet.endpoints.CreatePetEndpoint;
import entities.pet.endpoints.GetPetByStatusEndpoint;
import entities.pet.endpoints.UpdatePetEndpoint;
import io.restassured.response.Response;

import java.util.List;

public class PetClient extends BaseClient {

    public IRestResponse<PetObj> createPet(PetObj petRequest) {
        CreatePetEndpoint createPetEndpoint = new CreatePetEndpoint(petRequest);
        return new RequestHandler().processAPIRequest(PetObj.class, createPetEndpoint);
    }

    public IRestResponse<PetObj> updatePet(PetObj petRequest) {
        UpdatePetEndpoint updatePetEndpoint = new UpdatePetEndpoint(petRequest);
        return new RequestHandler().processAPIRequest(PetObj.class, updatePetEndpoint);
    }

    public Response searchPetByStatus(PetStatus status) {
        GetPetByStatusEndpoint getPetByStatusEndpoint = new GetPetByStatusEndpoint(status);
        return new RequestHandler().processRequest(getPetByStatusEndpoint);
    }
}
