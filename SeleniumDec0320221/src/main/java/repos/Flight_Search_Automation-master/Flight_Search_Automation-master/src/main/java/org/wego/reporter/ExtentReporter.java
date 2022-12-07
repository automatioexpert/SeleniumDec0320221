package org.wego.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.wego.utility.Environment;


public class ExtentReporter {

    public static ExtentReports extentReports;

    public static ExtentReports getReportObject() {

        if (extentReports == null) {
            return createReportObject();
        } else return extentReports;
    }

    public static ExtentReports createReportObject() {
        String path = Environment.extentReportDirectory;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("WeGo Flight Search Automation Report");
        sparkReporter.config().setDocumentTitle("Test Result");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimelineEnabled(true);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

}
