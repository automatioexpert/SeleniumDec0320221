package utils;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Getter
@Setter
public class Utils {

    public static int generateRandomNumber(int min, int max) {

        int number = (int) Math.floor(Math.random() * (max - min) + min);
        return number;
    }


    private String firstname;
    private String lastname;
    private String employeeId;

    public void generateRandomData() {
        Faker faker = new Faker();
        setFirstname(faker.name().firstName());
        setLastname(faker.name().lastName());
    }

    public void saveJsonList(String username, String password, String employeeId) throws IOException, ParseException {
        String fileName = "./src/test/resources/employee.json";
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject userObject = new JSONObject();
        userObject.put("userName", username);
        userObject.put("password", password);
        userObject.put("employeeId", employeeId);

        jsonArray.add(userObject);

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Saved Your Data");

    }


    public static List readJsondata(String fileName) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray;

    }


    public static void waitForElement(WebDriver driver, WebElement element, int TIME_SECOND) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_SECOND));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void doScroll(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
