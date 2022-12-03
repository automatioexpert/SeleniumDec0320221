package javasessions;

public class MethodChaining {

	public void m1() {
		System.out.println("m1 method");
		m2();
		MethodChaining.t2();
		t3();
	}

	public void m2() {
		System.out.println("m2 method");
		m3();
	}

	public void m3() {
		System.out.println("m3 method");
		m4();
	}

	public void m4() {
		System.out.println("m4 method");
		// m1();
	}

	public static void t1() {
		System.out.println("t1 method");
		t2();
		MethodChaining o1 = new MethodChaining();
		o1.m1();
	}

	public static void t2() {
		System.out.println("t2 method");
		t3();
	}

	public static void t3() {
		System.out.println("t3 method");

	}

	public static void main(String[] args) {

		MethodChaining obj = new MethodChaining();
		obj.m1();
		
		MethodChaining.t1();

	}

}
