package Base;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import static io.restassured.RestAssured.*;

public class Constant {

    public static final String TWITTER_ENDPOINT="https://api.twitter.com/1.1/search/tweets.json";
    public static final String OAUTH="OAuth oauth_consumer_key=\"3QHsalYXMeQchpOhwZWc2HfrC\",oauth_token=\"1121272893663584256-RoLkgcGZs7caL56l4YrCu9QZBVbmfD\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1556169937\",oauth_nonce=\"z7fyV9pdBwd\",oauth_version=\"1.0\",oauth_signature=\"qTHTOHbIV%2BCPp7nRs%2BWVWkS%2Fdqw%3D'";
    public static final String PAGE_NAME="stepin_forum";
}
