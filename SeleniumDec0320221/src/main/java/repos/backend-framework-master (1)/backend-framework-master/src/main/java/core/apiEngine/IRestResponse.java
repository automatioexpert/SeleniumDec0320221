package core.apiEngine;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public interface IRestResponse<T> {
    public T getBody();

    public String getContent();

    public int getStatusCode();

    public boolean isSuccessful();

    public String getStatusDescription();

    public Response getResponse();

    public Exception getException();

    public default void assertHttpStatusToBe(int httpStatusCode) {
        assertEquals(getStatusCode(), httpStatusCode, "HTTP Status code is not matching");
    }
}
