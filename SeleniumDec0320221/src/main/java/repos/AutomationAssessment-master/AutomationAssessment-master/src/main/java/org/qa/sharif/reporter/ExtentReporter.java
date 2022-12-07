package org.qa.sharif.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.qa.sharif.environment.Environment;

public class ExtentReporter {

    public static ExtentReports extentReports;

    public static ExtentReports getReportObject() {

        if(extentReports==null) {
            return createReportObject();
        } else return extentReports;
    }

    public static ExtentReports createReportObject(){
        String path = Environment.extentReportDirectory;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Currency Calculator Test");
        sparkReporter.config().setDocumentTitle("Test Result");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimelineEnabled(true);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

}
