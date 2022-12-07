package core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class TestHelper {

    public String randomDate() {
        int random = (int) (Math.random() * (1000 - 1)) + 1;
        return new SimpleDateFormat("ddMMyyHHmmssSSS").format(new Date()) + random;
    }

    public int randomNumber(int offset) {
        return (int) (Math.random() * (offset - 1)) + 1;
    }


    public static void wait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getRandomFileName(String prefix) {
        String s = new SimpleDateFormat("ddMMyyHHmmssSSS").format(new Date());
        return prefix + s;
    }

    public static String getDecodedUrl(String url) {
        String decode = "";
        try {
            decode = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return decode;

    }



    public static Object getResponseObject(String responseString, Class responseClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseString, responseClass);
    }



    public static String getRandomPhoneNumber() {
        String randValue = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rand = new Random();
        while (salt.length() < 8) {
            int index = (int) (rand.nextFloat() * randValue.length());
            salt.append(randValue.charAt(index));
        }
        String saltToString = String.format("+62812%s", salt.toString());
        return saltToString;
    }


    public static String getRandomUuid() {
        UUID uuid = UUID.randomUUID();
        String randomUuid = uuid.toString();

        return randomUuid;
    }

    public static boolean isURLReachable(String url) {
        HttpURLConnection connection = null;
        try {
            URL urlString = new URL(url);
            if (url.toLowerCase().contains("https"))
                connection = (HttpsURLConnection) urlString.openConnection();
            else
                connection = (HttpURLConnection) urlString.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            } else
                return false;
        } catch (IOException e) {
            return false;
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }

    public static JsonPath getJsonObject(Response response) {
        String responseString = response.asString();
        JsonPath jsonPath = new JsonPath(responseString);
        return jsonPath;
    }
}
