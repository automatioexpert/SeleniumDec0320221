package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class Base {

	@AfterMethod
	public void Printstars() {
		System.out.println(
				"***************************************End of TestCase****************************************************");
	}

	// After complete execution send pdf report by email
	@AfterSuite(enabled = true)
	public void tearDown() {

		ActionKeywords.sendPDFReportByGMail("wfx.automationalert@gmail.com", "qrst@1234",
				"saurabh.mishra@worldfashionexchange.com", "PDF Report OF Automation ", "");
		/* @param from* @param pass* @param to* @param subject* @param body */
	}

}
