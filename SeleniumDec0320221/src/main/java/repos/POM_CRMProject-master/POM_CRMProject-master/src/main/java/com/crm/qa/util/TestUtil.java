/**
 * 
 */
package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

/**
 * @author anand acharya
 *
 */
public class TestUtil extends TestBase{

	public static long page_load_timeout = 30;
	public static long implicit_wait = 30;

	public static String testdata_sheet_path = System.getProperty("user.dir")+"/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName){
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
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "----" + sheet.getRow(0).getLastCellNum());
		
		for(int i=0; i < sheet.getLastRowNum(); i++){
			for(int k=0; k < sheet.getRow(0).getLastCellNum(); k++){
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
/*		if (osName.startsWith("Mac")) {
			FileUtils.copyFile(srcFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
		}
		else{*/
			FileUtils.copyFile(srcFile, new File(currentDir+"\\screenshots\\"+System.currentTimeMillis()+".png"));
		//}
	}
	
	
}
