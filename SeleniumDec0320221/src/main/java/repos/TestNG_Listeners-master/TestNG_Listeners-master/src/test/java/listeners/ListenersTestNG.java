package listeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class ListenersTestNG implements ITestListener,IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		//iterate over every suite assigned for execution
		for (ISuite suite: suites) {

			String suiteName=suite.getName();
			Map<String, ISuiteResult> suiteResults=suite.getResults();
			for(ISuiteResult sr:suiteResults.values()) {
				ITestContext tc=sr.getTestContext();
				System.out.println("Passed Tests for suite '" +suiteName+ " ' is:" +tc.getPassedTests().getAllResults().size());
				System.out.println("Failed Tests for suite '" +suiteName+ " ' is:" +tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped Tests for suite '" +suiteName+ " ' is:" +tc.getSkippedTests().getAllResults().size());
			}
		}
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started " +result.getName() + " of class " + result.getTestClass());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Test Method " +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailureTest Method " +result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Test Method " +result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage " +result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart method started "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started " +context.getName());
	}

}
