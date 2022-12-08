package Calculator_Winium.Calculator_Winium;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.calculatorautomation.ObjectRepo.CalculationsByCalculator;
import com.calculatorautomation.ObjectRepo.ObjectRepository;
import com.calculatorautomation.base.TestBase;

public class AppTest extends TestBase {

	ObjectRepository repo = new ObjectRepository();
	CalculationsByCalculator calc = new CalculationsByCalculator();

	@BeforeTest
	public void chooseSceintificCalculator() {
		Initialization();
		repo.chooseOption("Open Navigation").click();
		repo.chooseOption("Scientific Calculator").click();
	}

	@BeforeMethod
	public void clearResult() {
		repo.chooseOption("Clear entry").click();
	}

	@Test
	@Parameters({ "AddtionExpression" })
	public void addition(String AddtionExpression) {
		String result = calc.additon(AddtionExpression);
		System.out.println("Result of "+AddtionExpression+" is ::" +result);
		Assert.assertEquals(result, "160");
	}

	@Test
	@Parameters({ "DivisionExpression" })
	public void division(String DivisionExpression) {
		String result = calc.division(DivisionExpression);
		System.out.println("Result of "+DivisionExpression+" is ::" +result);
		Assert.assertEquals(result, "2");
	}

	@Test
	@Parameters({ "ModExpression" })
	public void mod(String ModExpression) {
		String result = calc.mod(ModExpression);
		System.out.println("Result of "+ModExpression+" is ::" +result);
		Assert.assertEquals(result, "4");
	}

	@Test
	@Parameters({ "ValueforSqaureRoot" })
	public void sqrt(String ValueforSqaureRoot) {
		String result = calc.sqr(ValueforSqaureRoot);
		System.out.println("Result of sqr(sqr(sqr("+ValueforSqaureRoot+"))) is ::" +result);
		Assert.assertEquals(result, "1.1892071150027210667174999705605");
	}

	@AfterTest
	public void tearDown() {
		repo.chooseOption("Close Calculator").click();
	}
}
