package com.testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class) //step - 1
public class TestParameterize {
	
	private String isoCode; //step - 2
	private String numCode;
	private int fdigit;
	private String name;
	
	public TestParameterize(String isoCode,String numCode,String fdigit,String name){
		this.isoCode = isoCode;
		this.numCode = numCode;
		this.fdigit = Integer.parseInt(fdigit); //step - 3
		this.name = name;
	}
	
	@Parameters
	public static Collection<Object[]> getData() { //step -4
		Object[][] expectedResult = new Object[7][4];
		
		expectedResult[0][0] = "AOA";
		expectedResult[0][1] = "973";
		expectedResult[0][2] = "2";
		expectedResult[0][3] = "Kwanza";

		expectedResult[1][0] = "XOF";
		expectedResult[1][1] = "952";
		expectedResult[1][2] = "0";
		expectedResult[1][3] = "CFA Franc BCEAO";

		expectedResult[2][0] = "XDR";
		expectedResult[2][1] = "960";
		expectedResult[2][2] = "-1";
		expectedResult[2][3] = "SDR (Special Drawing Right)";

		expectedResult[3][0] = "KWD";
		expectedResult[3][1] = "414";
		expectedResult[3][2] = "3";
		expectedResult[3][3] = "Kuwaiti Dinar";

		expectedResult[4][0] = "CLF";
		expectedResult[4][1] = "990";
		expectedResult[4][2] = "0";
		expectedResult[4][3] = "Unidad de Fomento";

		expectedResult[5][0] = "CHW";
		expectedResult[5][1] = "9148";
		expectedResult[5][2] = "2";
		expectedResult[5][3] = "WIR Franc";
		
		expectedResult[6][0] = "CHW";
		expectedResult[6][1] = "948";
		expectedResult[6][2] = "2";
		expectedResult[6][3] = "WIR Franc";
		
		return Arrays.asList(expectedResult);
	}
	
	@Test
	public void testIsoCode(){
		CodeProperties p = CodePropertiesLookup.getCodeProperties(isoCode);
		assertEquals(isoCode, p.getSymbol());
		assertEquals(numCode, p.getCurrencyCode());
		assertEquals(fdigit, p.getFractionDigits());
		assertEquals(name, p.getCurrencyName());
	}

}
