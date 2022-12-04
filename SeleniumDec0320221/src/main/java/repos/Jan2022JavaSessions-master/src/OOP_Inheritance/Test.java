package OOP_Inheritance;

public class Test {

	//compile time -- static
	public void m1() {

	}

	public void m1(int a) {

	}

	public void m1(int a, int b) {

	}

	public static void main(String[] args) {
		Test t = new Test();
		t.m1(10, 20);
		t.m1();
	}

}
