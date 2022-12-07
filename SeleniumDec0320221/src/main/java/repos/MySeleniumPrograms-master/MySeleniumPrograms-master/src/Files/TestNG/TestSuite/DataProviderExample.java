package Files.TestNG.TestSuite;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	@DataProvider
	public Object[][] TestData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "Test1";
		data[0][1] = "Test2";

		data[1][0] = "Test3";
		data[1][1] = "Test4";

		return data;
	}

	@DataProvider
	public Object[][] TestSample() {

		Object[][] data = new Object[3][3];

		data[0][0] = "ABC";
		data[0][1] = 20;
		data[0][2] = 30;

		data[1][0] = "XYZ";
		data[1][1] = 50;
		data[1][2] = 60;

		data[2][0] = "efg";
		data[2][1] = 80;
		data[2][2] = 90;

		return data;
	}

	@Test(dataProvider = "TestSample")
	public void testA(String A1, int A2, int A3) {
		System.out.println("A1:" + A1);
		System.out.println("A2:" + A2);
		System.out.println("A3:" + A3);
	}

	@Test(dataProvider = "TestData")
	public void test(String s1, String s2) {
		System.out.println("s1:" + s1);
		System.out.println("s2:" + s2);

	}

}
