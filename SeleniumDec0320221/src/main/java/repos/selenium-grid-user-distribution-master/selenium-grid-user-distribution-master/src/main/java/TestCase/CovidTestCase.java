package TestCase;

import Base.BaseTestCase;
import Base.Device;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CovidTestCase extends BaseTestCase {
    private static Logger log = Logger.getLogger(CovidTestCase.class.getName());


    public CovidTestCase(Device thread) {
        super(thread);
    }

    @Test
    public void test() throws InterruptedException {
        log.info("navigating to : https://www.covid2019stats.net");
        getDriver().navigate().to("https://www.covid2019stats.net");
        for (int i = 0; i < 10; i++) {
            scrollingPage();
        }
        log.info("clicking on graph button");
        getElement(By.xpath("//*[@id='coronaTable']/tbody/tr[1]//a[contains(@class,'see_graph')]")).click();
    }

    private void scrollingPage() throws InterruptedException {
        ScrollingDown();
        Thread.sleep(2000);
        ScrollingUp();
        Thread.sleep(2000);
    }

}
