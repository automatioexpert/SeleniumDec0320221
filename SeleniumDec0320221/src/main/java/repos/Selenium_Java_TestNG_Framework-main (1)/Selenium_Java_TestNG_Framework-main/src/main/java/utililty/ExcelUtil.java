package utililty;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtil extends ReadProperties {
	
	@DataProvider(name = "excelData")
    public String excelDataProvider() throws Exception {
        // We are creating an object from the excel sheet data by calling a method that
        // reads data from the excel stored locally in our system
		
		int i=0;
		String path = ReadProperties.getData("excelpath");
		String sheetname="sheet1";
		int rowval=1;
        String arrObj = getExcelData(path,sheetname,rowval,i++);
        return arrObj;
    }
 
    // This method handles the excel - opens it and reads the data from the
    // respective cells using a for-loop & returns it in the form of a string array
   
	public static String getExcelData(String path,String sheet, int row,int cell) 
	{ String value = null;
	   Workbook wk;
	try {
		wk = WorkbookFactory.create(new FileInputStream(path));
		value =  wk.getSheet(sheet).getRow(row).getCell(cell).toString();
	} catch (Exception e) 
	{
		
		e.printStackTrace();
	}
	   
	return value;
		
	}
	
	
	
}
