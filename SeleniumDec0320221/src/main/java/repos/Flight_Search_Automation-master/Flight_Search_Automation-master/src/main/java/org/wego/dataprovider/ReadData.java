package org.wego.dataprovider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class ReadData extends ExcelHelper {
    public static final String flightSearchRegressionFile = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\Flight_Search_Regression.xlsx";

    @DataProvider(name = "flightSearch")
    public static Object[][] flightSearchTestData(Method m) {
        return getDataFromExcel(flightSearchRegressionFile, "Flight_Search", m.getName());
    }

}
