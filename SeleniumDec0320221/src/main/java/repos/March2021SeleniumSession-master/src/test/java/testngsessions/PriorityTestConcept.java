package testngsessions;

import org.testng.annotations.Test;

public class PriorityTestConcept {
	
	
	@Test(priority = 1, enabled = false)
	public void a_test() {
		System.out.println("a test");
	}
	
	@Test(priority = 1)
	public void b_test() {
		System.out.println("b test");
	}
	
	@Test(priority = 1)
	public void c_test() {
		System.out.println("c test");
	}
	
	@Test
	public void d_test() {
		System.out.println("d test");
	}
	
	@Test(enabled = true)
	public void e_test() {
		System.out.println("e test");
	}
	
	@Test(enabled = false)
	public void f_test() {
		System.out.println("f test");
	}
	
	
	

}
