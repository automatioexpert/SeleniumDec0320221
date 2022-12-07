package com.LW.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LWFilelibrary {
	

	/**
	 * this method is used to read the data from property file		
	 * @param key
	 * @return the data from property file
	 * @throws IOException
	 */
	
	public String getPropertyData(String key) throws IOException {
		
	FileInputStream fis=new FileInputStream("C:\\Users\\Active37\\git\\lawyer-wangu-Mavens\\LawyerWanguMavan\\src\\test\\resources\\Data\\commondata.properties1");
	
	Properties p=new Properties();
	
	
	p.load(fis);
	
	String data = p.getProperty(key);
	
	return data;
	}

	/**
	* this method is used to read the data from excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return excel data from excel sheet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */

	public String getExcelData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("/LawyerWanguMavan/src/test/resources/Data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
	    return data;
	}
	
	/**
	 * to write the data back to excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Exception
	 */
	
	public void setExcelData(String sheetname,int row,int cell,String data) throws Exception {
		FileInputStream fis =new FileInputStream("/Users/activemac03/eclipse-workspace/Maven/src/test/resources/data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(data);;
		FileOutputStream fos=new FileOutputStream("/Users/activemac03/eclipse-workspace/Maven/src/test/resources/data/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		}

		
		
	

}
