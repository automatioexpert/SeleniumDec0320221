package org.wego.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import static org.wego.utility.Environment.screenshotDirectory;

public class DriverHelper extends DriverProvider {

    public static void moveToChildWindow() {

        WebDriver driver = getDriver();
        String MainWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String ChildWindow : windowHandles) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                break;
            }
        }
    }

    public static String getScreenshot(String methodName) throws IOException {
        WebDriver driver = DriverProvider.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String filename = "\\" + methodName + UUID.randomUUID() + ".png";
        FileUtils.copyFile(source, new File(screenshotDirectory + filename));
        return filename;
    }
}
