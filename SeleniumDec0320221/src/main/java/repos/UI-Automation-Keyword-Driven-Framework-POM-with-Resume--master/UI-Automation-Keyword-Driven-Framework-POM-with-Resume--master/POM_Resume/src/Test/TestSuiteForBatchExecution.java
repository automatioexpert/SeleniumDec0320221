package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestSuiteForBatchExecution extends Base {
	@Test(priority = 1, enabled = true)
	public void testSuite1() throws Exception {
		FilesUtils.ReadExcelSuite("AsmaraFATxnAR_PWN.xlsx", "Suite");
	}

	@Test(priority = 2, enabled = true)
	void TestSuite2() throws Exception {
		FilesUtils.ReadExcelSuite("Suite_SummaryOC_Production.xlsx", "Suite_SummaryOC_Production.");
	}

	@AfterMethod
	public void tearDown() {
		ActionKeywords.sendPDFReportByGMail("wfx.automationalert@gmail.com", "qrst@1234",
				"saurabh.mishra@worldfashionexchange.com", "Automation Report OF Automation ", "");
		/* @param from* @param pass* @param to* @param subject* @param body */
	}

}
