package Test;

public class ExecuteSuite {
	
	static String SuiteExcelName="data.xlsx";
	static String SuiteExcelSheetName="Suite";
	public static void main(String[] args) throws Exception {
		FilesUtils.ReadExcelSuite(SuiteExcelName, SuiteExcelSheetName);
	}
}
 class ResumeSuite {

	public static void main(String[] args) throws Exception {
		FilesUtils.ResumeReadExcelSuite(ExecuteSuite.SuiteExcelName, ExecuteSuite.SuiteExcelName);
	}

}