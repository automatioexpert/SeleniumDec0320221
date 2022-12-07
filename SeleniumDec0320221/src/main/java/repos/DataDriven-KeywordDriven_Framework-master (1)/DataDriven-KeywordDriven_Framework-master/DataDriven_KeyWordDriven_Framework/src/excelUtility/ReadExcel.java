/**
 * 
 */
package excelUtility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author anand acharya
 * Program to read excel data using Apache POI libraries
 */
public class ReadExcel {

	//declare static variables so that it can instantiated using class name from other class
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	//method to read excel for a given location and sheet number
	public static void excelreader(String excelpath, int sheetnum)
	{
		try 
		{
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetnum);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//method to return the number of rows in the excelsheet 
	public static int getSheetRows()
	{
		int rowcount = sheet.getLastRowNum();
		rowcount = rowcount+1; //add 1 to ignore header count
		return rowcount;
	}
	
	//method to return the cell value on the excel sheet
	public static String getSheetdata(int rownum, int cellnum)
	{
		String data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
}
