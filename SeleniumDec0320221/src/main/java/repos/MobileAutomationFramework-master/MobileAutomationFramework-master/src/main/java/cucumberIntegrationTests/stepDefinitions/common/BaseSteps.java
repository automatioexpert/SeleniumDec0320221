package cucumberIntegrationTests.stepDefinitions.common;

import cucumberIntegrationTests.CreateSessionCucumber;
import cucumberIntegrationTests.screens.android.AndroidLoginScreen;
import cucumberIntegrationTests.screens.iOS.IOSLoginScreen;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    CreateSessionCucumber createSessionCucumber;
    WebDriver driver;
    String platform;
    AndroidLoginScreen androidLoginScreen;
    IOSLoginScreen iosLoginScreen;


    @Given("^User has slideshare \"([^\"]*)\" app$")
    public void userHasSlideshareApp(String invokeDriver) throws Exception {

        platform = invokeDriver;
        createSessionCucumber = new CreateSessionCucumber();
        createSessionCucumber.createDriver(invokeDriver, BaseSteps.class.getDeclaredMethod("userHasSlideshareApp",String.class));
        driver = createSessionCucumber.getWebDriver();

        if (invokeDriver.equalsIgnoreCase("android")) {
            androidLoginScreen = new AndroidLoginScreen(driver);
        } else if (invokeDriver.equalsIgnoreCase("iOS")) {
            iosLoginScreen = new IOSLoginScreen(driver);
        }
    }

}
