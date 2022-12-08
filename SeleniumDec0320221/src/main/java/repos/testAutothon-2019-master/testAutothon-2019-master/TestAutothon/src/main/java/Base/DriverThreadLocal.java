package Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverThreadLocal extends InheritableThreadLocal<WebDriver> {
    
    private static DriverThreadLocal instance = new DriverThreadLocal();

    public static WebDriver getDriver() {
        return instance.get();
    }

    public static void setDriver(WebDriver driver) {
        instance.set(driver);
    }

    public static File takeScreenShot(String baseFileName){

        Path reportScreenshotFile = Paths.get(System.getProperty("reportPath"), baseFileName + ".png");
        try {
        byte[] scrshot=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            Files.write(reportScreenshotFile, scrshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reportScreenshotFile.toFile();
    }
}
