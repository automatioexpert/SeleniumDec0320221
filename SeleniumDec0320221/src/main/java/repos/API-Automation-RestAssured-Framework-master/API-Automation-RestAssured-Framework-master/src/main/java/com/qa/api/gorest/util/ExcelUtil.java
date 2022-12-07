/**
 * 
 */
package com.qa.api.gorest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author anand acharya
 *
 */
public class ExcelUtil {

	public static Workbook book;
	public static Sheet sheet;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/java/com/qa/api/gorest/testdata/GoRestTestData.xlsx";
	
	public static Object[][] getTestData(String sheetName){
		
		try {
			FileInputStream ip = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//ignoring the headers
		for(int i=0; i < sheet.getLastRowNum(); i++){
			for(int k=0; k < sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
	}
	
}
