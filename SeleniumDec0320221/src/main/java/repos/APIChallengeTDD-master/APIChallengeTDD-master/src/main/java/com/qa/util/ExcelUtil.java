/**
 * 
 */
package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author anand acharya
 * program to read data from excel sheet
 */
public class ExcelUtil {
	
	static Workbook book;
	static Sheet sheet;
	static FileInputStream file = null;
	
	//Method to retrieve test data from an excel
	public static Object[][] readExcel(String sheetName, String sheetPath){
		
		try {
			file = new FileInputStream(sheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
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
}
