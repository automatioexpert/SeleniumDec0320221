package Test;

import org.testng.annotations.Test;


public class ExecuteTest extends Base {
	/**
	 * @parm parm1=ExcelName ,parm2=Sheet Name ,parm3=Config_xmlname ,parm4=Object.properties File
	 */
	@Test

	void TestCase() throws Exception {
		FilesUtils.ReadExcel("DATA.xlsx", "Login", "PWN_Config.xml","LoginPg");
	}

}

