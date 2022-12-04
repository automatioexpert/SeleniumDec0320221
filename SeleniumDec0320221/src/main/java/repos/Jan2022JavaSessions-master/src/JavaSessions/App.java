package JavaSessions;

public class App {

	public void t1() {
		System.out.println("t1 method");
		t2();
	}

	public void t2() {
		System.out.println("t2 method");
		t3();
	}

	public void t3() {
		System.out.println("t3 method");
		// t1();//StackOverflowError
	}

	public static void m1() {
		System.out.println("m1");
		m2();
	}

	public static void m2() {
		System.out.println("m2");
		m3();
	}

	public static void m3() {
		System.out.println("m3");
		m1();//StackOverflowError
	}

	public static void main(String[] args) {
		App obj = new App();
		obj.t1();
		App.m1();
	}

}
