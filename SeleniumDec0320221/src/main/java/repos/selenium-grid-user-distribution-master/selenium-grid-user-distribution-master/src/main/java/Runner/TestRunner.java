package Runner;

import Base.Device;
import TestCase.CovidTestCase;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;


public class TestRunner {
    private static Logger log = Logger.getLogger(TestRunner.class.getName());


    @Factory(dataProvider = "testFactory")
    public Object[] InitFactorysetUP(String thread) throws SecurityException, IllegalArgumentException {
        Device device = Device.fromString(thread);
        log.info("running thread for -> " + device);
        return new Object[]{new CovidTestCase(device)};
    }


    @DataProvider(name = "testFactory", parallel = true)
    public static Iterator<Object[]> testFactory(ITestContext testContext) {
        if (testContext != null)
            System.getProperties().putAll(testContext.getCurrentXmlTest().getAllParameters());
        List<Object[]> data = new ArrayList<>();
        int threadCount = Integer.parseInt(String.valueOf(System.getProperty("totalThreads")));
        String[] browserNames = System.getProperty("threadsName","1").split(",");
        int percentageSum = Arrays.stream(browserNames).map(ele -> ((String) ele).replaceAll(".*:", "")).mapToInt(Integer::parseInt).reduce(0, Integer::sum);

        if (percentageSum > 100) {
            throw new InvalidParameterException("sum of total percentage distribution should be 100 %");
        }

        Arrays.stream(browserNames).forEach(i -> {
            int distribution = Integer.parseInt(i.replaceAll(".*:", ""));
            int noOfthreads = Math.round(threadCount * distribution / 100);
            String browserName = i.replaceAll(":.*", "");
            for (int j = 0; j < noOfthreads; j++) {
                data.add(new Object[]{browserName});
            }
        });
        return data.iterator();
    }
}
