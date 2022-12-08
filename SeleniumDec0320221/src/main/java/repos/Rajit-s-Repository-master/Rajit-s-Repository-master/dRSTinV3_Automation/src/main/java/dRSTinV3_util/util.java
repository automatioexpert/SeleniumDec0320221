package dRSTinV3_util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class util {
	
	public static long IMPLICIT_WAIT = 50;
	
	public static long PAGE_LOAD_TIMEOUT = 50;
	
	
public static void screenshot( WebDriver driver, String screenshotname) {
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;     //TypeCasting Driver
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotname + ".png" ));
			
			System.out.println("Screenshots captured");
			
		} 
		
		catch (IOException e) {
			
			System.out.println("Screenshots couldnt be saved" + e.getMessage());
		}
		
		
		
		
	}


}
