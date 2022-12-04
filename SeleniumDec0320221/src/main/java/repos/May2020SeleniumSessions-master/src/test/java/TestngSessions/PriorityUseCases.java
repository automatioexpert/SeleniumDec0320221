package TestngSessions;

import org.testng.annotations.Test;

public class PriorityUseCases {

	@Test()
	public void btest1() {
		System.out.println("test 1");
	}

	@Test()
	public void atest2() {
		System.out.println("test 2");
	}

	@Test()
	public void ctest3() {
		System.out.println("test 3");
	}

	@Test(priority=1)
	public void test4() {
		System.out.println("test 4");
	}

	@Test(priority=1)
	public void test5() {
		System.out.println("test 5");
	}

	@Test(priority=1)
	public void test6() {
		System.out.println("test 6");
	}

}
