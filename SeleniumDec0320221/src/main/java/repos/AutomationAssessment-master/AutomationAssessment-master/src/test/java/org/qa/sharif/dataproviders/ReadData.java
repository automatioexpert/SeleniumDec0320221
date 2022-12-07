package org.qa.sharif.dataproviders;

import org.qa.sharif.commonutils.ExcelHelper;
import org.qa.sharif.environment.Environment;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;

public class ReadData extends ExcelHelper {

    public static String filePath = Environment.testDataFile;

    @DataProvider(name = "autoEmptyFileTest")
    public static Object[][] autoEmptyFileTest(Method m) {
        return getTableArray(filePath, "autoEmptyFileTest", m.getName());
    }

    @DataProvider(name = "CountryCurrencyUpdateTest")
    public static Object[][] CountryCurrencyUpdateTest(Method m) {
        return getTableArray(filePath, "CountryCurrencyUpdateTest", m.getName());
    }

    @DataProvider(name = "CurrencyLossTest")
    public static Object[][] CurrencyLossTest() {
        Object[][] data = new Object[][]{
                {"USD", String.valueOf(ThreadLocalRandom.current().nextDouble(50, 99))},
                {"USD", String.valueOf(ThreadLocalRandom.current().nextDouble(500, 999))},
                {"USD", String.valueOf(ThreadLocalRandom.current().nextDouble(5000, 9999))},
                {"EUR", String.valueOf(ThreadLocalRandom.current().nextDouble(50, 99))},
                {"EUR", String.valueOf(ThreadLocalRandom.current().nextDouble(500, 999))},
                {"EUR", String.valueOf(ThreadLocalRandom.current().nextDouble(5000, 9999))}
        };
        return data;
    }
}
