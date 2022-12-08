package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {

    public WebDriver driver;

    @BeforeTest
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

//    public void screenShot(ITestResult result) {
//
//        if (ITestResult.FAILURE == result.getStatus()) {
//            try {
//                Utils utils = new Utils();
//                utils.takeScreenShot(driver);
//            } catch (Exception e) {
//                System.out.println(e.toString());
//            }
//        }
//    }


    @AfterTest
    public void quitBrowser(){
        driver.close();
    }

}
