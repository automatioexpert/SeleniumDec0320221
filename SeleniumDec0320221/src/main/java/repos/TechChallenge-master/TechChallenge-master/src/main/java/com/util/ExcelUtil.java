/**
 * 
 */
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.Testbase;

/**
 * @author anand acharya
 * *********************************** PURPOSE **************************************
 * Used for data driver framework using Apache POI libraries
 * To read data from excel file
 * To write data into excel file
 * To delete data in excel file
 */
public class ExcelUtil extends Testbase {

	static Workbook book;
	static Sheet sheet;
	static FileInputStream file = null;
	static FileOutputStream out = null;
	
	//Method to retrieve test data from an excel
	public static Object[][] readExcel(String sheetName, String sheetPath){
		try {
			book = WorkbookFactory.create(new File(sheetPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("number of rows is "+sheet.getLastRowNum());
		System.out.println("number of columns is "+sheet.getRow(0).getLastCellNum());
		//ignoring the headers
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	//method to write output data into excel
	public static void writeExcel(String sheetname, String dataToWrite, String sheetPath) throws IOException {	
		//Create an object of FileInputStream class to read excel file
		try {
			file = new FileInputStream(sheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Create an object of the workbook class
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//Read excel sheet by sheet name
		sheet = book.getSheet(sheetname);
		//Get the current count of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		//Get the first row from the sheet
		Row row = sheet.getRow(0);
		//Create a new row and append it at last of sheet
		Row newRow = sheet.createRow(rowCount+1);
		//Create a loop over the cell of newly created Row
		for(int j = 0; j < row.getLastCellNum(); j++){
			//Fill data in row
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite);
			}
		//Close input stream
		file.close();
		//Create an object of FileOutputStream class to create write data in excel file
		out = new FileOutputStream(sheetPath);
		//write data in the excel file
		book.write(out);
		//close output stream
		out.close();
	}
	
	//method to delete all rows in the excel except the first one
	public static void deleteRows(String sheetname, String sheetPath){
		//Create an object of FileInputStream class to read excel file
		try {
		file = new FileInputStream(sheetPath);
		//Create an object of the workbook class
		book = WorkbookFactory.create(file);
		//Read excel sheet by sheet name
		sheet = book.getSheet(sheetname);
		//System.out.println("Last row number is: "+sheet.getLastRowNum());
		//delete all rows except first one
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			int lastRowNum = sheet.getLastRowNum();
			if(lastRowNum !=0 && lastRowNum >0){
				int rowIndex = row.getRowNum();
	            Row removingRow = sheet.getRow(rowIndex);
	            if(removingRow != null){
	                sheet.removeRow(removingRow);
	                System.out.println("Deleting.... ");
	            }    
			}
		}
		//Close input stream
		file.close();
		//Create an object of FileOutputStream class to create write data in excel file
		out = new FileOutputStream(sheetPath);
		//write data in the excel file
		book.write(out);
		//close output stream
		out.close();
		}
		catch (Exception e) {}
	}	
}
