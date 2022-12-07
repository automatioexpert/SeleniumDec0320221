package excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelDataConfig(String excelPath){
		try{
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetnumber,int row, int column) throws Exception{
		sheet = wb.getSheetAt(sheetnumber);
		DataFormatter formatter = new DataFormatter();
		Cell cell = sheet.getRow(row).getCell(column);
		String data = formatter.formatCellValue(cell);
		return data;
	}
	
	public int getRows(int sheetnumber){
		sheet = wb.getSheetAt(sheetnumber);
		int rowcount = sheet.getLastRowNum(); //rowcount = 2
		//rowcount = rowcount+1; //add this statement if the excel data has header column
		return rowcount;
	}
	
	public void wbclose() throws Exception{
		wb.close();
	}
	
}
