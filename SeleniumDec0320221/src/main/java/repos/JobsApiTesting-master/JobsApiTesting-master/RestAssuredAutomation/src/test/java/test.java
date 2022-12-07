import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utils.ExcelUtils;

public class test {
	
	public static void main(String[] args) {
		try {
			getProgramLmsData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getProgramLmsData() throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook("./Data/LmsExcel.xlsx");
		System.out.println("workbook:"+workbook.getNumberOfSheets());
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		System.out.println("sheet:"+sheet.getLastRowNum());
        //int rowCount= ExcelUtils.getRowCount(sheet);
        //int cellcount=ExcelUtils.getCellCount();
        //System.out.println("Row Count:"+ExcelUtils.getRowCount());
        //System.out.println("cell Count:"+cellcount);
        //get all rows in the sheet
       
        // Ensure if file exist or not
       
	}
}
