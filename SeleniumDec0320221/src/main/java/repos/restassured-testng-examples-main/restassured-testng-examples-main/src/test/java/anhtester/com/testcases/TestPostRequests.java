package anhtester.com.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import anhtester.com.data.reqres.PostData;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPostRequests {

    Logger log = LogManager.getLogger(TestPostRequests.class);
    private static final String URL = "https://reqres.in";

    @DataProvider(name = "postData")
    public Iterator<Object[]> postData() {
        final List<Object[]> postData = new ArrayList<>();
        postData.add(new Object[]{"Rahul", "QA"});
        postData.add(new Object[]{"Jane", "Sr.Dev"});
        postData.add(new Object[]{"Albert", "Dev"});
        postData.add(new Object[]{"Johnny", "Project Manager"});
        return postData.iterator();
    }

    @Test(dataProvider = "postData")
    public void testPostRequests(final String name, final String job) {
        final PostData postData = new PostData(name, job);
        final String response = given().contentType(ContentType.JSON)
                .body(postData)
                .when()
                .post(URL + "/api/users")
                .then()
                .assertThat()
                .statusCode(201)
                .and()
                .assertThat()
                .body("name", equalTo(name))
                .and()
                .assertThat()
                .body("job", equalTo(job))
                .and()
                .assertThat()
                .body("id", notNullValue())
                .and()
                .extract()
                .response()
                .body()
                .asString();

        this.log.info(response);

    }
}