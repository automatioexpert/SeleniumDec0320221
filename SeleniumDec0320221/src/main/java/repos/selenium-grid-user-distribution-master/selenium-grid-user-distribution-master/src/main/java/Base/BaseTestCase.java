package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class BaseTestCase extends DeviceManager {

    public static Logger log = Logger.getLogger(BaseTestCase.class.getName());
    private Device threadName;

    public BaseTestCase(String threadName) {
        super(Device.fromString(threadName));
    }

    public BaseTestCase(Device threadName) {
        super(threadName);
        this.threadName = threadName;

    }

    public void ScrollingDown() {
        log.info("scrolling down");
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void ScrollingUp() {
        log.info("scrolling up");
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("window.scrollTo( document.body.scrollHeight,0)");
    }

    public void clearCacheChrome() {
        log.info("clearing cache");
        getDriver().manage().deleteAllCookies();
        getDriver().get("chrome://settings/clearBrowserData");
        getDriver().findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }

    public WebElement getElement(By locator) {
        log.info("finding element by :" + locator.toString());
        return new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void setTimeout(long timeout) {
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void testCaseSetup() {
        setDriver();
        if (threadName != Device.MOBILECHROME) {
            getDriver().manage().window().maximize();
        }
        setTimeout(4000);
    }

    @AfterClass
    public void tearDown() {
        if (threadName == Device.REMOTECHROME || threadName == Device.CHROME) {
            clearCacheChrome();
        }
        log.info("closing browser");
        getDriver().quit();
    }


}
