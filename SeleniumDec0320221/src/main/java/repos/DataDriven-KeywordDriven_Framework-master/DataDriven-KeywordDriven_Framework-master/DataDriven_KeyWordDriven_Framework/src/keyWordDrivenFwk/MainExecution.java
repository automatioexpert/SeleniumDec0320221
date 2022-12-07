/**
 * 
 */
package keyWordDrivenFwk;

import excelUtility.ReadExcel;

/**
 * @author anand acharya
 * Main class to start the execution
 */
public class MainExecution {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String excelpath = System.getProperty("user.dir")+"/excelData/keyword_data.xlsx";
		ReadExcel.excelreader(excelpath, 0);
		int rowcount = ReadExcel.getSheetRows();
		
		//read each row in the sheet
		for (int i=0; i<rowcount; i++)
		{
			String keyword = ReadExcel.getSheetdata(i, 2);
			
			if(keyword.equalsIgnoreCase("browser"))
			{
				Actionkeywords.openbrowser();
			}
			
			if(keyword.equalsIgnoreCase("site"))
			{
				Actionkeywords.openurl();
			}
			
			if(keyword.equalsIgnoreCase("credentials"))
			{
				Actionkeywords.entercredentials();
			}
			
			if(keyword.equalsIgnoreCase("login"))
			{
				Actionkeywords.clicklogin();
			}
		}
		
	}

}
