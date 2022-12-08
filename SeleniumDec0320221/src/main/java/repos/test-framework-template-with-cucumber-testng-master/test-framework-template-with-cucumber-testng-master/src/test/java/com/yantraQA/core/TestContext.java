package com.yantraQA.core;

import com.yantraQA.config.CoreConfig;
import com.yantraQA.drivers.DriverFactory;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Scenario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

@Log4j2
@Data
@ScenarioScoped
public class TestContext{
    WebDriver driver;

    @Setter
    @Getter
    Scenario scenario;

    @Getter
    CoreConfig coreConfig = ConfigFactory.create(CoreConfig.class);;

    public void invokeDriver(){
        String browser = (System.getProperty("browser")==null) ? "chrome" : System.getProperty("browser");
        String execType = (System.getProperty("execType")==null) ? "local" : System.getProperty("execType");
        this.driver = DriverFactory.createInstance(browser,execType);
        this.driver.manage().timeouts().implicitlyWait(coreConfig.browserImplicitWaitTimeOut(), TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        log.debug("Chrome browser Opened.");
    }

    public void navigateBrowser(String url){
        this.driver.get(url);
        log.debug("browser navigated: " + url);
    }
    public void quitDriver(){
        this.driver.quit();
        log.debug("Driver quit success");
    }

}
