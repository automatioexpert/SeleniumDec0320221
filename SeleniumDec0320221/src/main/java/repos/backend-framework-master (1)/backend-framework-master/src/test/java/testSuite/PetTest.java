package testSuite;

import client.pet.PetClient;
import constant.PetStatus;
import core.apiEngine.IRestResponse;
import entities.pet.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PetTest extends BaseTest {
    private PetClient petClient;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        this.petClient = new PetClient();
    }

    private IRestResponse<PetObj> createRandomUser() {
        PetObj petRequestBody = new PetRequestBuilder()
                .id((long) faker.number().randomDigit())
                .name(faker.name().name())
                .status(PetStatus.AVAILABLE.name())
                .category(new Category(faker.number().randomDigit(), faker.name().firstName()))
                .tags(List.of(new Tag(faker.number().randomDigit(), faker.name().firstName())))
                .photoUrls(List.of(faker.internet().domainName())).build();
        return petClient.createPet(petRequestBody);
    }

    @Test(groups = {"PET"})
    public void createPetTest() {
        IRestResponse<PetObj> response = createRandomUser();
        response.assertHttpStatusToBe(HttpStatus.SC_OK);
    }

    @Test(groups = {"PET"})
    public void upDatePetTest() {
        String updatedName = "updatedName";
        IRestResponse<PetObj> createPetResponse = createRandomUser();
        createPetResponse.assertHttpStatusToBe(HttpStatus.SC_OK);

        PetObj petResponse = createPetResponse.getBody();
        petResponse.setName(updatedName);
        IRestResponse<PetObj> updatePetResponse = petClient.updatePet(petResponse);

        updatePetResponse.assertHttpStatusToBe(HttpStatus.SC_OK);
        Assert.assertEquals(updatePetResponse.getBody().getName(), updatedName, "name is not updated.");
    }

    @Test(groups = {"PET", "P0", "SMOKE"})
    public void petServiceE2ETest() {
        //create Pet
        String updatedName = "updated_" + faker.name().name();
        IRestResponse<PetObj> createPetResponse = createRandomUser();
        createPetResponse.assertHttpStatusToBe(HttpStatus.SC_OK);
        PetObj petResponse = createPetResponse.getBody();
        // update pet name & status
        petResponse.setStatus(PetStatus.SOLD.name());
        petResponse.setName(updatedName);
        IRestResponse<PetObj> updatePetResponse = petClient.updatePet(petResponse);
        updatePetResponse.assertHttpStatusToBe(HttpStatus.SC_OK);
        //get the updated record & verify
        List<PetObj> searchPetByStatusResponse = List.of(petClient.searchPetByStatus(PetStatus.SOLD).as(PetObj[].class));
        List<PetObj> result = searchPetByStatusResponse.stream().filter(ele -> ele.getName().equals(updatedName) && ele.getStatus().equals(PetStatus.SOLD.name())).collect(Collectors.toList());
        result.forEach(System.out::println);
        assert result.size() <= 1 : "updated data is found.";
    }
}

