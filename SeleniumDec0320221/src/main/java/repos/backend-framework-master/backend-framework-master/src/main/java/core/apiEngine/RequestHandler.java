package core.apiEngine;

import core.utils.TestHelper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.security.*;
import java.util.*;

import static io.restassured.RestAssured.given;

public class RequestHandler {
    private final static Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private boolean urlEncodingEnabled = true;

    public <T> IRestResponse<T> processAPIRequest(Class<T> t, IServiceEndpoint iServiceEndpoint) {
        return new RestResponse<>(t, processRequest(iServiceEndpoint));
    }

    public Response processRequest(IServiceEndpoint iServiceEndpoint) {
        Response response = processIServiceEndpoint(iServiceEndpoint);
        String endpointName = iServiceEndpoint.getClass().getSimpleName().replaceAll("Endpoint", "");
        String noOfRetries = System.getProperty("noOfRetries");
        int retries = (noOfRetries == null || noOfRetries.isEmpty()) ? 0 : Integer.parseInt(noOfRetries);
        for (int i = 0; i < retries && isResponse5xx(response); i++) {
            logger.info(String.format("\n%s Response status code --- %d --> retrying again --> retry attempt %d", endpointName, response.getStatusCode(), i + 1), true);
            Reporter.log(String.format("\n%s Response Status Code --- %d --> Retrying again --> Retry no - %d", endpointName, response.getStatusCode(), i + 1), true);
            TestHelper.wait(2000);
            response = processIServiceEndpoint(iServiceEndpoint);
        }
        return response;
    }

    private Response processIServiceEndpoint(IServiceEndpoint iServiceEndpoint) {
        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.registerParser("application/grpc", Parser.JSON);
        RestAssured.registerParser("text/html", Parser.JSON);

        String url = iServiceEndpoint.url();
        HttpMethod httpMethod = iServiceEndpoint.httpMethod();
        RequestSpecification requestSpecification = formRequestSpecification(iServiceEndpoint);
        Response response = makeAPIRequestAsPerHTTPMethod(url, httpMethod, requestSpecification);

        return response;
    }


    private Response makeAPIRequestAsPerHTTPMethod(String url, HttpMethod httpMethod, RequestSpecification requestSpecification) {
        Response response = null;
        switch (httpMethod) {
            case GET:
                response = requestSpecification.get(url);
                break;
            case POST:
                response = requestSpecification.post(url);
                break;
            case PUT:
                response = requestSpecification.put(url);
                break;
            case PATCH:
                response = requestSpecification.patch(url);
                break;
            case DELETE:
                response = requestSpecification.delete(url);
        }

        return response;
    }

    private RequestSpecification formRequestSpecification(IServiceEndpoint iServiceEndpoint) {
        RestAssuredConfig config = RestAssured.config().encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        RestAssured.useRelaxedHTTPSValidation();
        List<String> sslConfig = iServiceEndpoint.sslConfig();
        if (sslConfig != null) {
            KeyStore keyStore;
            SSLSocketFactory clientAuthFactory = null;
            String keyStorePath = sslConfig.get(0);
            String password = sslConfig.get(1);
            try {
                keyStore = KeyStore.getInstance("jks");
                keyStore.load(new FileInputStream(keyStorePath), password.toCharArray());
                if (keyStore != null) {

                    try {
                        clientAuthFactory = new SSLSocketFactory(keyStore, password);
                    } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException |
                             UnrecoverableKeyException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception ex) {
                logger.info(">>>>>>>>> Error while loading keystore >>>>>>>>>");
                ex.printStackTrace();
            }
            config = config.sslConfig(new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames());
        }
        RequestSpecification request = given().config(config).filter(new RestAssuredRequestFilter());

        if (iServiceEndpoint.headers() != null) {
            iServiceEndpoint.headers().forEach(h -> request.header(h.getKey(), h.getValue()));
        }

        if (iServiceEndpoint.queryParameters() != null) {
            iServiceEndpoint.queryParameters().forEach(q -> request.queryParam(q.getKey(), q.getValue()));
        }

        if (iServiceEndpoint.pathParameters() != null) {
            iServiceEndpoint.pathParameters().forEach(p -> request.pathParam(p.getKey(), p.getValue()));
        }

        if (iServiceEndpoint.body() != null) request.body(iServiceEndpoint.body().getBodyString());

        if (!urlEncodingEnabled) request.urlEncodingEnabled(urlEncodingEnabled);

        Map<Object, Object> auth = iServiceEndpoint.auth();
        Object authType = auth.get("type");
        if (!authType.equals(AuthType.NONE)) {
            if (authType.equals(AuthType.BASIC)) {
                request.auth().basic(auth.get("username").toString(), auth.get("password").toString());
            } else if (authType.equals(AuthType.BASIC_PREEMPTIVE)) {
                request.auth().preemptive().basic(auth.get("username").toString(), auth.get("password").toString()).log().headers();
            }
        }

        if (iServiceEndpoint.formParam() != null)
            iServiceEndpoint.formParam().forEach(p -> request.formParam(p.getKey(), p.getValue()));

        return request;
    }


    private boolean isResponse5xx(Response response) {
        return (response.getStatusCode() >= 500) && (response.getStatusCode() < 505);
    }
}
