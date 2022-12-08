package crm.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import crm.baseclass.baseclass;

public class utility extends baseclass{
	
public static	ExtentTest logger;
public static	ExtentReports extent = new ExtentReports("D:\\Eclipse Projects\\CRM\\test-output\\CRM_Report.html");
//	ExtentTest logger = new ExtentTest();
	
	public utility() throws IOException {
		super();
		
	}


	public static void clickElement(WebElement we, String elementname,String Testname, String Step) throws Exception {
		
		logger = extent.startTest(Testname);
		
		we.click();
		logger.log(LogStatus.INFO, Step);
		Thread.sleep(3000);
		utility.screenshot(elementname);
		
	}
	
	
	public static void screenshot(String Filename) throws IOException {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("D:\\Eclipse Projects\\CRM\\screenshots" + Filename + ".png"));
		
		
		
	}

}
