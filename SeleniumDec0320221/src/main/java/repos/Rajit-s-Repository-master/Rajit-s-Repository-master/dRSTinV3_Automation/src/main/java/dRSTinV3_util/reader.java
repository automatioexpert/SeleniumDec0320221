package dRSTinV3_util;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class reader {
	
	static Xls_Reader reader;
	
	//	public static void main(String[] args) throws Exception {
			
			
			
			
			public static ArrayList<Object[]> getdata() {
				
				
				
				ArrayList<Object[]> ar = new ArrayList<Object[]>();
				
				reader = new Xls_Reader("Y:\\eclipse workspace\\dRSTinV3_Automation"
						+ "\\Test Data\\Excel Data for dRSTin.xlsx");
				
				for (int rowNum = 2;rowNum<= 2;rowNum++)
				{
					
					String Field = reader.getCellData("Sheet1", "Field Value", rowNum);
					String Operator = reader.getCellData("Sheet1", "Operator", rowNum);
					String Value = reader.getCellData("Sheet1", "Value", rowNum);
					
					Object obj[] = {Field , Operator,Value};
					
					
					
					ar.add(obj);
					
					
			
			}
				
				return ar;
			
			}
			
			
			
				
				
				public static ArrayList<Object[]> getDBDetails() {
					
					
					
					ArrayList<Object[]> arforDB = new ArrayList<Object[]>();
					
					reader = new Xls_Reader("D:\\Git Repository\\Rajit-s-Repository\\dRSTinV3_Automation"
							+ "\\Test Data\\Excel Data for dRSTin.xlsx");
					
					for (int rowNum = 2;rowNum<= 2;rowNum++)
					{
						String DatasetName = reader.getCellData("DatabaseuploadDetails", "DatasetName", rowNum);
						String HostName = reader.getCellData("DatabaseuploadDetails", "HostName", rowNum);
						String DriverName = reader.getCellData("DatabaseuploadDetails", "DriverName", rowNum);
						String DBName = reader.getCellData("DatabaseuploadDetails", "DBName", rowNum);
						String Username = reader.getCellData("DatabaseuploadDetails", "Username", rowNum);
						String Password = reader.getCellData("DatabaseuploadDetails", "Password", rowNum);
						
						
						
						Object obj1[] = {DatasetName,HostName , DriverName,DBName,Username,Password};
						
						
						
						arforDB.add(obj1);
						
						
				
				}
					
					return arforDB;
				
				}
				
				
				
			}

