package org.qa.sharif.reporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.qa.sharif.driver.DriverProvider;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.qa.sharif.environment.Environment.screenshotDirectory;

public class ScreenShotTaker {

    public static String getScreenshot(String methodName) throws IOException {
        WebDriver driver = DriverProvider.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String filename = "\\" + methodName + UUID.randomUUID().toString() + ".png";
        FileUtils.copyFile(source, new File(screenshotDirectory + filename));
        return filename;
    }
}
