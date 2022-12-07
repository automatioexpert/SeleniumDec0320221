package core.apiEngine;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseClient {
    protected Response call(IServiceEndpoint endpoint) {
        return new RequestHandler().processRequest(endpoint);
    }


    protected Response post(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json");

        return specification.post(url);
    }

    protected Response get(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json");

        return specification.get(url);
    }

    protected Response delete(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json");

        return specification.delete(url);
    }

    protected Response put(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json");

        return specification.put(url);
    }

    protected Response patch(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json");

        return specification.patch(url);
    }
}
