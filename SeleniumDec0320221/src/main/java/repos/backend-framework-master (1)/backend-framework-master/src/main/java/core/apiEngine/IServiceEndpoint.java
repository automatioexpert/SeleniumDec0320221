package core.apiEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface IServiceEndpoint {

    String url();

    /**
     * Define HTTP method type
     *
     * @return POST/GET/PUT/DELETE/PATCH
     */
    HttpMethod httpMethod();

    /**
     * Define service endpoint query params
     *
     * @return List of type params
     */
    List<Param> queryParameters();

    /**
     * Define service endpoint path params
     *
     * @return List of type params
     */
    List<Param> pathParameters();

    /**
     * Define service endpoint headers
     *
     * @return List of type params
     */
    List<Param> headers();

    /**
     * Define service endpoint body
     *
     * @return an intance of type RequestBody
     */
    RequestBody body();

    default Map<Object, Object> auth() {
        Map<Object, Object> auth = new HashMap();
        auth.put("type", AuthType.NONE);
        return auth;
    }

    default List<Param> formParam() {
        return null;
    }

    default List<String> sslConfig() {
        return null;
    }

}
