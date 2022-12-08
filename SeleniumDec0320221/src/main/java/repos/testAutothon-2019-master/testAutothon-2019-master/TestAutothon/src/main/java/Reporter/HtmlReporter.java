package Reporter;

import Base.DriverThreadLocal;
import Reporter.html.Html;
import Reporter.html.Table;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlReporter implements TestReporter {
    private static Logger logger = Logger.getLogger(HtmlReporter.class);
    private Html htmlLog = new Html();
    private Table htmlLogTable = new Table();
    private File testResultsFile;
    private String title;


    public HtmlReporter(String title) {
        String destFileName = "testHtmlReport_" + title + "_" + formatDate("MMddyyyy_HHmmss") + ".html";
        testResultsFile = Paths.get(System.getProperty("reportPath"), destFileName).toFile();
        testResultsFile = Paths.get(System.getProperty("reportPath"), destFileName).toFile();
        // Generate Html Log
        htmlLog.setTitle(title);
        htmlLog.setStyle("table { margin: 1em; border-collapse: collapse; }"
                + "td, th { padding: .3em; border: 1px #ccc solid; }" + "thead { background: #fc9; }"
                + "tr.fatal {color: red; width: 10% }" + "tr.error {color: red; width: 10% }"
                + "tr.warn {color: darkgoldenrod; width: 10% }" + "tr.info {color: blue; width: 10% }"
                + "tr.debug {color: blueviolet; width: 10% }" + "tr.trace {color: #999900; width: 10% }"
                + "tr.fail {color: darkred; width: 10% }" + "tr.pass {color: darkgreen; width: 10% }");
        htmlLog.add(htmlLogTable);
    }


    @Override
    public void info(String logObject, Throwable t, boolean saveScreenshot) {
        addStepRow(logObject, "info", saveScreenshot);
    }

    @Override
    public void warn(String logObject, Throwable t, boolean takeScreenshot) {
        logger.warn(logObject, t);
        addStepRow("[[WARNING]] " + logObject + "", "warn", takeScreenshot);

    }

    @Override
    public void error(String logObject, Throwable t) {
        logger.error(logObject, t);

    }

    @Override
    public void pass(String logObject, Throwable t) {
        logger.info("passed: "+logObject);
        addStepRow(logObject, "pass", false);
    }

    @Override
    public void fail(String logObject, String message, Throwable t) {
        addStepRow(logObject + message, "fail", true);
    }

    @Override
    public void setTestSuiteHeader(String headerText) {
        htmlLogTable.addTableHeader_movies(headerText);
       /* htmlLogTable.addTableHeader(getDateForReport()
                 + "<H3>" + headerText + "</H3>");*/
    }

    @Override
    public void setTestCaseHeader(String testCaseName) {
        htmlLogTable.addTableHeader(
                getDateForReport()
                        + "##" + "<H2>" + testCaseName + "</H2>");
    }

    @Override
    public void finalizeTestResult(ITestResult testResult) {
        logger.info("ENDING TEST - : ");
    }

    @Override
    public void finalizeSuiteResult(ITestContext testContext) {
        String msg = "ENDING SUITE - " + title;
        Thread.currentThread().setName(msg);
        generateHtmlLog();
        openHtmlTestResults();
        htmlLog = null;
    }

    public static String formatDate(String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(new Date());
    }

    private String getDateForReport() {
        return formatDate("MM/dd/yy HH:mm:ss");
    }

    public void addStepRow(String logObject, String cssClass, boolean takeScreenshot) {
        String curDate = getDateForReport();
        String escapedString = StringUtils.replace(StringEscapeUtils.escapeHtml3(logObject), "\n", "<br>");
        File screenshotFile = null;
        if (takeScreenshot)
            screenshotFile = DriverThreadLocal.takeScreenShot("screenshot_" + System.currentTimeMillis());
            if (screenshotFile != null)
                htmlLogTable.addTableRow(curDate + "##" + "<span style='float:left;'>" + escapedString
                        + "</span>" + "<span style='float:right;padding-left:10px;'>" + "<a href = '"
                        + screenshotFile.getName() + "'>" + "<img src='" + screenshotFile.getName()
                        + "'width = '100' border='1'>" + "</a>" + "</span>", cssClass);
            else htmlLogTable.addTableRow(curDate + "##" + escapedString, cssClass);
    }

    public void addStepRow_movies(String logObject, boolean takeScreenshot) {
        String curDate = getDateForReport();
        String escapedString = StringUtils.replace(StringEscapeUtils.escapeHtml3(logObject), "\n", "<br>");
        File screenshotFile = null;
        if (takeScreenshot)
            screenshotFile = DriverThreadLocal.takeScreenShot("screenshot_" + System.currentTimeMillis());
        if (screenshotFile != null)
            htmlLogTable.addTableRow(curDate + "##" + "<span style='float:left;'>" + escapedString
                    + "</span>" + "<span style='float:right;padding-left:10px;'>" + "<a href = '"
                    + screenshotFile.getName() + "'>" + "<img src='" + screenshotFile.getName()
                    + "'width = '100' border='1'>" + "</a>" + "</span>", "info");
        else htmlLogTable.addTableRow(curDate + "##" + escapedString, "info");
    }


    /**
     * Generate new html log report
     */
    private synchronized void generateHtmlLog() {
        // Set the html results name and folders
        try {
            if (htmlLog == null)
                throw new Exception("HTML LOG IS NULL");
            if (!testResultsFile.getParentFile().exists())
                Files.createDirectories(testResultsFile.getParentFile().toPath());
            Files.write(testResultsFile.toPath(), htmlLog.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception ioe) {
            logger.error("Unable to Save Html Test Results For, Because of Error:\n\n" + ioe.getMessage() + " RESULTS GENERATION FAILED");
        }
    }

    private void openHtmlTestResults() {
        if (!testResultsFile.exists()) {
            logger.info("Test Results File Does NOT Exist: " + testResultsFile + "TEST RESULTS NOT FOUND");
            return;
        }
        logger.info("Open Test Results: " + testResultsFile);
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try {
            // this doesn't support showing urls in the form of
            // "page.html#nameLink"
            if (os.contains("win"))
                rt.exec("rundll32 url.dll,FileProtocolHandler " + testResultsFile.getAbsolutePath());
            else if (os.contains("mac"))
                rt.exec("open " + testResultsFile);
            else if (os.contains("nix") || os.contains("nux")) {
                // Do a best guess on unix until we get a platform independent way
                // Build a list of browsers to try, in this order.
                String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror", "netscape", "opera", "links", "lynx"};
                // Build a command string which looks like
                // "browser1 "url" || browser2 "url" ||..."
                StringBuilder cmd = new StringBuilder();
                for (int i = 0; i < browsers.length; i++)
                    cmd.append(i == 0 ? "" : " || ").append(browsers[i]).append(" \"").append(testResultsFile).append("\" ");
                rt.exec(new String[]{"sh", "-c", cmd.toString()});
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
