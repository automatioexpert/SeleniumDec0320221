package Reporter;

import org.testng.ITestContext;
import org.testng.ITestResult;

public interface TestReporter {

    void info(String logObject, Throwable t, boolean saveScreenshot);

    void warn(String logObject, Throwable t, boolean takeScreenshot);

    void error(String logObject, Throwable t);

    void pass(String logObject, Throwable t);

    void fail(String logObject, String message, Throwable t);

    void setTestSuiteHeader(String headerText);

    void setTestCaseHeader(String testCaseName);

    void finalizeTestResult(ITestResult testResult);

    void finalizeSuiteResult(ITestContext testContext);

}
