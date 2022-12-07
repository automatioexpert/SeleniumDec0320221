package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static String getCellData(int rownum, int colnum) throws IOException {
					
			XSSFWorkbook workbook = new XSSFWorkbook("./Data/TestData.xlsx");
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			String data;
			try {
				XSSFRow row = sheet.getRow(rownum);
				System.out.println("row" +row.getCell(colnum));
				XSSFCell cell = row.getCell(colnum);
				DataFormatter formatter = new DataFormatter();
				String value = formatter.formatCellValue(cell);
				return value;
			}
			catch (Exception exp) {
				data="";
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				exp.printStackTrace();
			}
			return data;
	}
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fileInput = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return rowcount;
		
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rowcount) throws IOException {
		
		fileInput = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowcount);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return cellcount;
		
	}
	
public static String getCellData(String xlfile, String xlsheet, int rowcount, int colnum) throws IOException {
		
		fileInput = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowcount);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e) {
			data = "";
		}
		
		workbook.close();
		fileInput.close();
		return data;
		
	}
	
	public static String[][] getJobData(String xlfile, String xlsheet) throws IOException{

	        //Create an object of FileInputStream class to read excel file
	        fileInput = new FileInputStream(xlfile);

	        //creating workbook instance that refers to .xls file
	        workbook=new XSSFWorkbook(fileInput);

	        //creating a Sheet object
			workbook = new XSSFWorkbook(xlfile);
			sheet = workbook.getSheet(xlsheet);
	        
	        //get all rows in the sheet
	        int rowCount= ExcelUtils.getRowCount(xlfile, xlsheet);
	        int cellcount=ExcelUtils.getCellCount(xlfile, xlsheet,1);
	        
	        String jobData[][] = new String[rowCount][cellcount];
	        
	        for(int i=1;i<=rowCount;i++) {
	        	for (int j=0;j<cellcount;j++) {
	        		jobData[i-1][j]= ExcelUtils.getCellData(xlfile,xlsheet, i, j);
	        	}
	        }
		
		return(jobData);
	}
}
