package MyWebDriverPrograms;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithExcelSheet {

	public static void main(String[] args) throws IOException {
		// Apache POI jars available in the project
	    // 	xls, xlsx
		// HSSF - xls
		// XSSF - xlsx
		String filepath = "E:\\Test_Data.xlsx";
		FileInputStream File = new FileInputStream(filepath);
		// Create a workbook
		XSSFWorkbook wb=new XSSFWorkbook(File);
		//Create and Navigate to the required sheet, Sheet1 - 0, Sheet2 - 1, Sheet3 - 2 so on..
		XSSFSheet ws=wb.getSheetAt(0);
		//Get the row count
		int rowcount=ws.getLastRowNum()+1;
		System.out.println("Total number of rows are:" +rowcount);
		int columncount=ws.getRow(0).getLastCellNum();
		System.out.println("Total number of columns are :" +columncount);
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow row=ws.getRow(i);
			for(int j=0; j < columncount; j++)
			{
				XSSFCell column=row.getCell(j);
				String Value=column.getStringCellValue();
				System.out.println("Value from Excel:" +Value);
				if(Value.equalsIgnoreCase("Blue"))
				{
					System.out.println("Test case is Passed");
				}
				else 
					System.out.println("Test case is Failed");
				
			}
				
				
		}
		
		wb.close();
		
	} 

 
}