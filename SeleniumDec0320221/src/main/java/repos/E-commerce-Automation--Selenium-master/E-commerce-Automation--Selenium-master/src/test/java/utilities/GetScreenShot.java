package utilities;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class GetScreenShot {
	public static String capture(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		java.io.File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\screenshots\\"+screenShotName +".png";
		java.io.File destination = new java.io.File(dest);
		FileUtils.copyFile(sourceFile, destination);
		return dest;
	}
}
