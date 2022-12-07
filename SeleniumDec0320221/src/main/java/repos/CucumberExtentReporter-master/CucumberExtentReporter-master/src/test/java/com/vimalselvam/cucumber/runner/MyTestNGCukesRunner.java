package com.vimalselvam.cucumber.runner;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import java.io.File;

@CucumberOptions(
        features = {"src/test/resources/features/MySecondFeature.feature"},
        glue = {"com.vimalselvam.cucumber.stepdefinitions"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
)
public class MyTestNGCukesRunner extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
