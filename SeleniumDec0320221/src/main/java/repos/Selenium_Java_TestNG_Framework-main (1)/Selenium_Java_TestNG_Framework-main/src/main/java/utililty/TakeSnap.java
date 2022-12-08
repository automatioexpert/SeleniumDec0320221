package utililty;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.testBase;

public class TakeSnap extends testBase  {
	
	
	public static String capturescreen(String name)
	{
		TakesScreenshot takescreenshot = (TakesScreenshot) getDriver();
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("Screenshot/"+name);
        try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}        
                     
        return destination.getAbsolutePath();
	
	}

}
