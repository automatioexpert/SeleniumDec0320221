package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DeviceManager {
    private static Logger log = Logger.getLogger(DeviceManager.class.getName());

    private Device threadName;
    public WebDriver driver;


    DeviceManager(Device threadName) {
        this.threadName = threadName;
    }

    public WebDriver getDriver() {
        this.driver = DriverThreadLocal.getDriver();
        return this.driver;
    }

    public void setDriver(Device threadName) {
        try {
            this.threadName = threadName;
            DriverThreadLocal.setDriver(this.threadName.setDriver());
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void setDriver() {
        try {
            DriverThreadLocal.setDriver(this.threadName.setDriver());
            this.driver = DriverThreadLocal.getDriver();
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void resetDriver() {
        this.driver = null;
    }
}

