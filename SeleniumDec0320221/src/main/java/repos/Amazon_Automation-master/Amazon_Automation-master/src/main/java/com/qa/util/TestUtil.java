/**
 * 
 */
package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.base.TestBase;

/**
 * @author anand acharya
 *
 */
public class TestUtil extends TestBase {

	public static long page_load_timeout = 30;
	public static long implicit_wait = 30;
	
	public static String testdata_sheet_path = System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/CreateAccount.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetname){
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(testdata_sheet_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()-1][sheet.getRow(0).getLastCellNum()];
		
		System.out.println("number of rows is "+sheet.getLastRowNum());
		System.out.println("number of columns is "+sheet.getRow(0).getLastCellNum());

		
		for(int i=0; i<sheet.getLastRowNum()-1; i++){
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();	
			}
		}
		return data;
	}

}
