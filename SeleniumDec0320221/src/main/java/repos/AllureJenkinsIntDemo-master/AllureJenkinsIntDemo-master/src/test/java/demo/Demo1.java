/**
 * 
 */
package demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import ru.yandex.qatools.allure.annotations.Parameter;
import org.testng.annotations.Test;



/**
 * @author Gladson Antony
 *
 */
public class Demo1 
{
	@DataProvider(name="RestIsOnThis")
	public Object[][] RestIsOnThis()
	{
		return new Object[][]{ { "1", "9", "10"},
			{ "2", "8", "10"}, 
			{ "3", "7", "10"}, 
			{ "4", "6", "10"}, 
			{ "5", "5", "10"}, 
			{ "6", "4", "12"}, 
			{ "7", "3", "14"}, 
			{ "8", "2", "13"}, 
			{ "9", "1", "15"}, 
			{ "10", "0", "11"}, 
			};		
	}
	
	@Test(dataProvider="RestIsOnThis")
	public void test1(@Parameter("Variable 1")String a, @Parameter("Variable 2")String b, @Parameter("Variable 3")String c)
	{
		System.out.println("a -> " +a+", b -> "+b+", c -> "+c);		
		int i = Integer.parseInt(a);
		int j = Integer.parseInt(b);
		int k = Integer.parseInt(c);
		
		Assert.assertEquals(i+j, k);		
	}
}
