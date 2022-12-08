package anhtester.com.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.github.javafaker.Faker;
import anhtester.com.data.restfulbooker.UserData;
import org.testng.annotations.Test;

public class PostRequestBuilderExample extends SetupConfig {

    @Test
    public void postTestUsingBuilderPattern() {
        UserData userData = userDataBuilder();
        given().body(userData)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .and()
                .assertThat()
                .body("name", equalTo(userData.getName()))
                .body("job", equalTo(userData.getJob()));

    }

    private UserData userDataBuilder() {
        Faker faker = Faker.instance();
        return UserData.builder()
                .name(faker.name()
                        .firstName())
                .job(faker.company()
                        .profession())
                .build();
    }

}