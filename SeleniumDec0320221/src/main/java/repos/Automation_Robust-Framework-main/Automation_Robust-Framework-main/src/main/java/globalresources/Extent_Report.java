package globalresources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report {
	public static ExtentReports getReportobj() {
	ExtentReports extent;
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	
	reporter.config().setReportName("webautomation");
	reporter.config().setDocumentTitle("test_results");
	extent=new ExtentReports();
	ExtentTest test=extent.createTest("initialdemo");
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester","Srilekha");
	return extent;

}
}