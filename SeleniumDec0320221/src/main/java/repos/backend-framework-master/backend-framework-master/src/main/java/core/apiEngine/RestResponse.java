package core.apiEngine;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class RestResponse<T> implements IRestResponse<T> {
    private final static Logger logger = LoggerFactory.getLogger(RestResponse.class);

    private T data;
    private Response response;
    private Exception e;

    public RestResponse(Class<T> t, Response response) {
        this.response = response;
        try {
            this.data = t.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            logger.warn(e.getMessage());
            throw new RuntimeException("There should be a default constructor in the Response POJO");
        }
    }

    public String getContent() {
        return response.getBody().asString();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public boolean isSuccessful() {
        int code = response.getStatusCode();
        return code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205;
    }

    public String getStatusDescription() {
        return response.getStatusLine();
    }

    public Response getResponse() {
        return response;
    }


    public T getBody() {
        try {
            data = (T) response.getBody().as(data.getClass());
        } catch (Exception e) {
            this.e = e;
            logger.warn(e.getMessage());
        }
        return data;
    }

    public Exception getException() {
        return e;
    }

}