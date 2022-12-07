package testSuite;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import core.utils.TestHelper;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static io.restassured.config.SSLConfig.sslConfig;

public class BaseTest {

    TestHelper testHelper;
    Faker faker;
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation());
        this.testHelper = new TestHelper();
        this.faker = new Faker();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(Method method, ITestContext context) throws JsonProcessingException {


    }

    @AfterMethod(alwaysRun = true)
    public void release(Method testMethod){
    }

}
