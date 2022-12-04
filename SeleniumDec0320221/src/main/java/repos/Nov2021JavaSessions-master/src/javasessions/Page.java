package javasessions;

public class Page {

	public void m1() {
		System.out.println("m1");
		m2();
	}

	public void m2() {
		System.out.println("m2");
		m3();
	}

	public void m3() {
		System.out.println("m3");
		Page.t2();
		Page.t3();
	}

	public static void t1() {
		System.out.println("t1");
		t2();
		Page p2 = new Page();
		p2.m1();
	}

	public static void t2() {
		System.out.println("t2");
		t3();
	}

	public static void t3() {
		System.out.println("t3");

	}

	public static void main(String[] args) {
		Page p1 = new Page();
		p1.m1();
		Page.t1();
		System.out.println("hello" + null);
	}

}
