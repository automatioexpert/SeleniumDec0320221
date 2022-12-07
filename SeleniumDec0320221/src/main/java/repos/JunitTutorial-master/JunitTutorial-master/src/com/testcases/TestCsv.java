package com.testcases;

import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csvreader.CsvReader;
import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

public class TestCsv extends Assert {
	
	private static CsvReader reader = null;
	private static CsvReader count = null;
	private static String isoCode[] = null;
	private static String numCode[] = null;
	private static String expected[][] = null;
	
	private  static String getPath() {
		URL loc = TestCsv.class.getClassLoader().getResource("./");
		String path = loc.getPath();
		path = path.replaceAll("bin", "src");
		path = path + "com" + System.getProperty("file.separator") + "resources" + System.getProperty("file.separator") + "data.csv";
		return path;
	}
	
	private static int getRow(CsvReader r) {
		int i = 0;
		try {
			while(r.readRecord()){
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	private static void setData(CsvReader r){
		int row = getRow(r);
		isoCode = new String[row];
		numCode = new String[row];
		expected = new String[row][4];
		
		int i = 0;
		
		try {
			while(reader.readRecord()){
				isoCode[i] = reader.get(0);
				numCode[i] = reader.get(1);
				expected[i][0] = reader.get(0);
				expected[i][1] = reader.get(1);
				expected[i][2] = reader.get(2);
				expected[i][3] = reader.get(3);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*for(int k = 0; k < expected.length; k++){
			System.out.println(isoCode[k]);
			System.out.println(numCode[k]);
			System.out.println(expected[k][0] + expected[k][1] + expected[k][2] + expected[k][3]);
		}*/
	}
	
	@BeforeClass
	public static void setUp() {
		try {
			reader = new CsvReader(getPath());
			count = new CsvReader(getPath());
			reader.setSkipEmptyRecords(true);
			reader.setComment('#');
			reader.setUseComments(true);
			setData(count);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testIsoCode(){
		for(int i = 0; i < isoCode.length; i++){
			CodeProperties p = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			assertEquals(expected[i][0], p.getSymbol());
			assertEquals(expected[i][1], p.getCurrencyCode());
			assertEquals(Integer.parseInt((expected[i][2])), p.getFractionDigits());
			assertEquals(expected[i][3], p.getCurrencyName());
		}
	}
	
	@Test
	public void testNumCode(){
		
		for(int i = 0; i < numCode.length; i++){
			CodeProperties p = CodePropertiesLookup.getCodeProperties(numCode[i]);
			assertEquals(expected[i][0], p.getSymbol());
			assertEquals(expected[i][1], p.getCurrencyCode());
			assertEquals(Integer.parseInt((expected[i][2])), p.getFractionDigits());
			assertEquals(expected[i][3], p.getCurrencyName());
		}
		
	}
	
	@AfterClass
	public static void cleanUp() {
		if(reader != null){
			reader.close();
			reader = null;
		}
	}
	

}
