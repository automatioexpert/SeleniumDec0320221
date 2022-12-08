package anhtester.com.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import anhtester.com.data.reqres.PostData;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPutRequests {

    Logger log = LogManager.getLogger(TestPutRequests.class);
    private static final String URL = "https://reqres.in";

    @DataProvider(name = "putData")
    public Iterator<Object[]> putData() {
        final List<Object[]> putData = new ArrayList<>();
        putData.add(new Object[]{2, "Michael", "QA Lead"});
        putData.add(new Object[]{958, "Yuan", "Project Architect"});
        return putData.iterator();
    }

    @Test(dataProvider = "putData")
    public void putRequestsTests(final int id, final String name, final String job) {

        final PostData postData = new PostData(name, job);
        final String response = given().contentType(ContentType.JSON)
                .body(postData)
                .when()
                .put(URL + "/api/users/" + id)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("name", equalTo(name))
                .and()
                .assertThat()
                .body("job", equalTo(job))
                .and()
                .extract()
                .response()
                .body()
                .asString();

        this.log.info(response);

    }
}